package bingoyo.com.mangalfabs.viewholder;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.materialize.holder.StringHolder;
import com.mikepenz.materialize.util.UIUtils;

import java.io.Serializable;
import java.util.List;

import bingoyo.com.mangalfabs.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductCategory extends AbstractItem<ProductCategory, ProductCategory.ViewHolder> implements Serializable {

    public String name;

    public ProductCategory withName(String Name) {
        this.name = Name;
        return this;
    }

//    public ProductCategory withName(@StringRes int NameRes) {
//        this.name = new StringHolder(NameRes);
//        return this;
//    }

    //The unique ID for this type of item
    @Override
    public int getType() {
        return R.id.product_category;
    }

    //The layout to be used for this type of item
    @Override
    public int getLayoutRes() {
        return R.layout.row_product_category_item;
    }

    @Override
    public ViewHolder getViewHolder(@NonNull View v) {
        return new ViewHolder(v);
    }

    /**
     * our ViewHolder
     */
    protected static class ViewHolder extends FastAdapter.ViewHolder<ProductCategory> {
        @BindView(R.id.category_name)
        TextView name;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        public void bindView(ProductCategory item, List<Object> payloads) {
//            StringHolder.applyTo(item.name, name);
            name.setText(item.name);
        }

        @Override
        public void unbindView(ProductCategory item) {
            name.setText(null);
        }
    }
}