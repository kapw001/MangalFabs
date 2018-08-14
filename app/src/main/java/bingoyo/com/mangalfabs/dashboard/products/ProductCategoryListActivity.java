package bingoyo.com.mangalfabs.dashboard.products;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bingoyo.com.mangalfabs.R;
import bingoyo.com.mangalfabs.Utility;
import bingoyo.com.mangalfabs.recyclerHelper.EqualSpacingItemDecoration;
import bingoyo.com.mangalfabs.recyclerHelper.ItemOffsetDecoration;
import bingoyo.com.mangalfabs.viewholder.ProductCategory;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductCategoryListActivity extends AppCompatActivity {

    private static final String TAG = "ProductCategoryList";
    @BindView(R.id.productCategoryListView)
    RecyclerView productCategoryListView;

    //create the ItemAdapter holding your Items
    ItemAdapter<ProductCategory> itemAdapter = new ItemAdapter<ProductCategory>();
    //create the managing FastAdapter, by passing in the itemAdapter
    FastAdapter fastAdapter = FastAdapter.with(itemAdapter);
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.searchview)
    SearchView searchview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_category_list);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Product category");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        initView();
    }


    private void initView() {

        int mNoOfColumns = Utility.calculateNoOfColumns(this);
        Log.e(TAG, "initView: " + mNoOfColumns);
        productCategoryListView.setLayoutManager(new GridLayoutManager(this, 2));

//        productCategoryListView.addItemDecoration(new EqualSpacingItemDecoration(16, EqualSpacingItemDecoration.GRID));
        productCategoryListView.addItemDecoration(new ItemOffsetDecoration(this,R.dimen.item_offset));

//        //create the ItemAdapter holding your Items
//        ItemAdapter<ProductCategory> itemAdapter = new ItemAdapter<ProductCategory>();
//        //create the managing FastAdapter, by passing in the itemAdapter
//        FastAdapter fastAdapter = FastAdapter.with(itemAdapter);

        //set our adapters to the RecyclerView
        productCategoryListView.setAdapter(fastAdapter);

        //set the items to your ItemAdapter

        final List<String> list = Arrays.asList(getResources().getStringArray(R.array.category));

        final List<ProductCategory> productCategories = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            ProductCategory category = new ProductCategory().withName(list.get(i));

            productCategories.add(category);
        }

        itemAdapter.add(productCategories);


        fastAdapter.withOnClickListener(new OnClickListener<ProductCategory>() {
            @Override
            public boolean onClick(@Nullable View v, IAdapter<ProductCategory> adapter, ProductCategory item, int position) {


                Intent intent = new Intent(getApplicationContext(), ParticularCategoryProductListActivity.class);

                intent.putExtra("category", (Serializable) item);

                startActivity(intent);


                return false;
            }

        });


        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchview.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                itemAdapter.filter(newText);

                itemAdapter.getItemFilter().withFilterPredicate(new IItemAdapter.Predicate<ProductCategory>() {
                    @Override
                    public boolean filter(ProductCategory item, CharSequence constraint) {
                        return item.name.toLowerCase().startsWith(String.valueOf(constraint).toLowerCase());
                    }
                });


                return false;
            }
        });


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search_view_menu_item, menu);
//        MenuItem searchViewItem = menu.findItem(R.id.action_search);
//        final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);
//        searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                searchViewAndroidActionBar.clearFocus();
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                itemAdapter.filter(newText);
//
//                itemAdapter.getItemFilter().withFilterPredicate(new IItemAdapter.Predicate<ProductCategory>() {
//                    @Override
//                    public boolean filter(ProductCategory item, CharSequence constraint) {
//                        return item.name.toLowerCase().startsWith(String.valueOf(constraint).toLowerCase());
//                    }
//                });
//
//
//                return false;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if (item.getItemId() == android.R.id.home) {
//
//
//            onBackPressed();
//
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @OnClick(R.id.back)
    public void onViewClicked() {

        onBackPressed();
    }
}
