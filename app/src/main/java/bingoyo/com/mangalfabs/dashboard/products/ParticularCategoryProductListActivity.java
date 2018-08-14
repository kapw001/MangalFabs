package bingoyo.com.mangalfabs.dashboard.products;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bingoyo.com.mangalfabs.R;
import bingoyo.com.mangalfabs.Utility;
import bingoyo.com.mangalfabs.dashboard.imgeslideview.FullScreenWitSlideActivity;
import bingoyo.com.mangalfabs.recyclerHelper.ItemOffsetDecoration;
import bingoyo.com.mangalfabs.viewholder.Product;
import bingoyo.com.mangalfabs.viewholder.ProductCategory;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ParticularCategoryProductListActivity extends AppCompatActivity {

    @BindView(R.id.productListView)
    RecyclerView productListView;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular_category_product_list);
        ButterKnife.bind(this);

        String s = "Products";

        Intent intent = getIntent();

        if (intent != null) {

            if (intent.hasExtra("category")) {

                ProductCategory category = (ProductCategory) intent.getSerializableExtra("category");

                s = category.name;

            }

        }

        title.setText(s);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle(s);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        }

        initView();
    }


    private void initView() {

        int mNoOfColumns = Utility.calculateNoOfColumns(this);
        productListView.setLayoutManager(new GridLayoutManager(this, 2));

        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        productListView.addItemDecoration(itemDecoration);

//        productListView.addItemDecoration(new EqualSpacingItemDecoration(0, EqualSpacingItemDecoration.GRID));

        //create the ItemAdapter holding your Items
        final ItemAdapter<Product> itemAdapter = new ItemAdapter<Product>();
        //create the managing FastAdapter, by passing in the itemAdapter
        FastAdapter fastAdapter = FastAdapter.with(itemAdapter);

        //set our adapters to the RecyclerView
        productListView.setAdapter(fastAdapter);

        //set the items to your ItemAdapter

        final List<String> list = Arrays.asList(getResources().getStringArray(R.array.images));

        final List<Product> productCategories = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            Product category = new Product().withImgNo(list.get(i)).withDesignNo("D.No. 2698");

            productCategories.add(category);
        }

        itemAdapter.add(productCategories);


        fastAdapter.withOnClickListener(new OnClickListener() {
            @Override
            public boolean onClick(@Nullable View v, IAdapter adapter, IItem item, int position) {

                final String[] list = getResources().getStringArray(R.array.images);


                List<Product> productList = itemAdapter.getAdapterItems();

                Intent intent = new Intent(getApplicationContext(), FullScreenWitSlideActivity.class);

                intent.putExtra("position", position);
                intent.putExtra("image", list);
                intent.putExtra("productList", (Serializable) productList);

                startActivity(intent);
                return false;
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {


            onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {

        onBackPressed();
    }
}
