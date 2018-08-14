package bingoyo.com.mangalfabs.dashboard.addproduct;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidbuts.multispinnerfilter.KeyPairBoolData;
import com.androidbuts.multispinnerfilter.MultiSpinnerSearch;
import com.androidbuts.multispinnerfilter.SpinnerListener;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bingoyo.com.mangalfabs.R;
import bingoyo.com.mangalfabs.dashboard.category.addcategory.AddCategoryFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddProductActivity extends AppCompatActivity {

    private static final String TAG = "AddProductActivity";
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.take)
    Button take;
    @BindView(R.id.category)
    MultiSpinnerSearch category;
    @BindView(R.id.design_no)
    TextInputLayout designNo;
    @BindView(R.id.width)
    TextInputLayout width;
    @BindView(R.id.stock)
    TextInputLayout stock;
    @BindView(R.id.add_category)
    ImageButton addCategory;
    @BindView(R.id.addCategory)
    FloatingActionButton fabAddCategory;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.save)
    ImageView save;
    @BindView(R.id.cancel)
    ImageView cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ButterKnife.bind(this);

//        if (getSupportActionBar() != null) {
//
//            getSupportActionBar().setTitle("Add Product");
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//
//        }

        initView();
    }


    private void initView() {

        final List<String> list = Arrays.asList(getResources().getStringArray(R.array.category));

        final List<KeyPairBoolData> listArray0 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(list.get(i));
            h.setSelected(false);
            listArray0.add(h);
        }


        category.setItems(listArray0, -1, new SpinnerListener() {

            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i(TAG, i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                    }
                }
            }
        });

    }


    @OnClick(R.id.take)
    public void onViewClicked() {

//         start picker to get image for cropping and then use the image in cropping activity
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .setMinCropResultSize(800, 800)
                .setMaxCropResultSize(800, 800)
                .start(this);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();

                image.setImageURI(resultUri);
                image.setVisibility(View.VISIBLE);

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }


    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.save_cancel_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if (item.getItemId() == android.R.id.home || item.getItemId() == R.id.cancel) {
//
//
//            onBackPressed();
//
//        } else if (item.getItemId() == R.id.save) {
//
//            Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
//
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @OnClick({R.id.add_category, R.id.addCategory, R.id.back, R.id.save, R.id.cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_category:
                showAddCategory();
                break;
            case R.id.addCategory:
                showAddCategory();
                break;

            case R.id.back:
                onBackPressed();
                break;
            case R.id.save:

                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

                break;
            case R.id.cancel:
                onBackPressed();
                break;
        }
    }


    private void showAddCategory() {


        AddCategoryFragment fragment = new AddCategoryFragment();
//        fragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
//        fragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen);

        fragment.show(getSupportFragmentManager(), "Add_Category");


    }

}
