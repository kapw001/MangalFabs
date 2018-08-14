package bingoyo.com.mangalfabs.dashboard.imgeslideview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.chrisbanes.photoview.OnScaleChangedListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import bingoyo.com.mangalfabs.R;
import bingoyo.com.mangalfabs.viewholder.Product;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FullScreenWitSlideActivity_Backup extends AppCompatActivity {

    @BindView(R.id.product_width)
    TextView productWidth;
    @BindView(R.id.stock)
    TextView stock;
    @BindView(R.id.details)
    LinearLayout details;
    @BindView(R.id.back)
    ImageView back;

    private boolean isTouched = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slide);

        ButterKnife.bind(this);

        int position = getIntent().getIntExtra("position", 0);

        String[] imageUrl = getIntent().getStringArrayExtra("image");
        List<Product> productList = (List<Product>) getIntent().getSerializableExtra("productList");


        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ImagePagerAdapter adapter = new ImagePagerAdapter(productList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }


    @OnClick(R.id.back)
    public void onClick(View view) {

        onBackPressed();
    }


    private class ImagePagerAdapter extends PagerAdapter {
//        private int[] mImages = new int[] {
//                R.drawable.chiang_mai,
//                R.drawable.himeji,
//                R.drawable.petronas_twin_tower,
//                R.drawable.ulm
//        };

        private List<Product> productList;

        private ImagePagerAdapter(List<Product> productList) {
            this.productList = productList;
        }

        @Override
        public int getCount() {
            return productList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Context context = FullScreenWitSlideActivity_Backup.this;

            View view = LayoutInflater.from(context).inflate(R.layout.fullscreenimage, null);

            final PhotoView imageView = (PhotoView) view.findViewById(R.id.photoImage);
            final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
            progressBar.setVisibility(View.VISIBLE);
//            int padding = 0;
//            imageView.setPadding(padding, padding, padding, padding);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setImageResource(mImages[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (isTouched) {
                        details.setVisibility(View.GONE);
                        back.setVisibility(View.GONE);
                    } else {
                        back.setVisibility(View.VISIBLE);
                        details.setVisibility(View.VISIBLE);
                    }

                    isTouched = !isTouched;

                }
            });

            imageView.setOnScaleChangeListener(new OnScaleChangedListener() {
                @Override
                public void onScaleChange(float scaleFactor, float focusX, float focusY) {
                    isTouched = true;
                }
            });


            if (productList.size() > 0) {

                final Product product = productList.get(position);

                Random random = new Random();

                int n = random.nextInt(500);

                stock.setText(n + "");


                new Thread(new Runnable() {
                    @Override
                    public void run() {


                        Bitmap firstImage = null;
                        Bitmap secondImage = null;
                        try {
                            firstImage = Picasso.get().load(product.imgUrl).get();
                            secondImage = Picasso.get().load(R.drawable.scale).get();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        final Bitmap finalFirstImage = firstImage;
                        final Bitmap finalSecondImage = secondImage;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Bitmap mergedImages = createSingleImageFromMultipleImages(finalFirstImage, finalSecondImage);


//                                Uri uri = getImageUri(getApplicationContext(), mergedImages);

//                                Picasso.get().load(uri).resize(0, 500).centerCrop().into(imageView);

                                imageView.setImageBitmap(mergedImages);
                                imageView.setVisibility(View.VISIBLE);
                                progressBar.setVisibility(View.GONE);
                            }
                        });


                    }
                }).start();

//                Picasso.get().load(product.imgUrl).resize(0, 500).centerCrop().error(R.mipmap.ic_launcher).into(imageView, new Callback() {
//                    @Override
//                    public void onSuccess() {
//                        imageView.setVisibility(View.VISIBLE);
//                        progressBar.setVisibility(View.GONE);
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        imageView.setVisibility(View.VISIBLE);
//                        progressBar.setVisibility(View.GONE);
//                    }
//                });
            } else {
                Picasso.get().load(R.mipmap.ic_launcher).into(imageView);
                imageView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }

            ((ViewPager) container).addView(view, 0);
            return view;
        }


//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            Context context = FullScreenWitSlideActivity.this;
//
//
//            PhotoView imageView = new PhotoView(context);
//            int padding = 0;
//            imageView.setPadding(padding, padding, padding, padding);
////            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
////            imageView.setImageResource(mImages[position]);
//
//            if (imageUrl[position].length() > 0)
//                Picasso.get().load(imageUrl[position]).resize(0, 500).centerCrop().placeholder(R.drawable.progress_animation).into(imageView);
//            else
//                Picasso.get().load(R.drawable.not_found).into(imageView);
//
//            ((ViewPager) container).addView(imageView, 0);
//            return imageView;
//        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }
    }

    private Bitmap createSingleImageFromMultipleImages(Bitmap firstImage, Bitmap secondImage) {
        Bitmap result = Bitmap.createBitmap(secondImage.getWidth(), firstImage.getHeight() + secondImage.getHeight(), firstImage.getConfig());
        Bitmap resized = Bitmap.createScaledBitmap(firstImage, secondImage.getWidth(), firstImage.getHeight(), true);

        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(resized, 0f, 0f, null);
        canvas.drawBitmap(secondImage, 0f, firstImage.getHeight(), null);
        return result;
    }

//    public Uri getImageUri(Context inContext, Bitmap inImage) {
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
//        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
//        return Uri.parse(path);
//    }


}

