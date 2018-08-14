package bingoyo.com.mangalfabs.viewholder;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.materialize.holder.StringHolder;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import bingoyo.com.mangalfabs.R;
import bingoyo.com.mangalfabs.Utility;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.constraint.Constraints.TAG;

public class Product extends AbstractItem<Product, Product.ViewHolder> implements Serializable {

    public String designNo;
    public String imgUrl;

    public Product withDesignNo(String designNo) {
        this.designNo = designNo;
        return this;
    }

    public Product withImgNo(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }


//    public Product withDesignNo(@StringRes int DesignRes) {
//        this.designNo = DesignRes;
//        return this;
//    }

    //The unique ID for this type of item
    @Override
    public int getType() {
        return R.id.product_root;
    }

    //The layout to be used for this type of item
    @Override
    public int getLayoutRes() {
        return R.layout.row_product_item;
    }

    @Override
    public ViewHolder getViewHolder(@NonNull View v) {
        return new ViewHolder(v);
    }

    /**
     * our ViewHolder
     */
    protected static class ViewHolder extends FastAdapter.ViewHolder<Product> {
        @BindView(R.id.design_no)
        TextView name;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.scale_img)
        ImageView scale_img;

        @BindView(R.id.layout)
        LinearLayout linearLayout;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        public void bindView(Product item, List<Object> payloads) {
//            StringHolder.applyTo(item.designNo, name);
            name.setText(item.designNo);


            DisplayMetrics display = itemView.getContext().getResources().getDisplayMetrics();

//            int width = display.widthPixels; // ((display.getWidth()*20)/100)
            int width = ((display.widthPixels * 25) / 100);
            int height = ((display.heightPixels * 32) / 160);//display.getHeight();//


//            itemView.getWidth();
////
//            img.getLayoutParams().height = itemView.getWidth();
//            img.getLayoutParams().width = itemView.getWidth();

//            Log.e(TAG, "bindView: " + width + " h " + height + "   " + Utility.convertDpToPx(1));

            Picasso.get().load(item.imgUrl).resize(width, width).into(img);
//            Picasso.get().load(R.drawable.scale).resize(0,Utility.convertDpToPx(30)).centerCrop().into(scale_img);
//            Picasso.get().load(R.drawable.scale).resize(width, Utility.convertDpToPx(15)).into(scale_img);
//            Picasso.get().load(R.drawable.scale).fit().centerInside().into(scale_img);

        }

        @Override
        public void unbindView(Product item) {
            name.setText(null);
        }
    }
}