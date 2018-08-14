package bingoyo.com.mangalfabs.dashboard.category;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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
import bingoyo.com.mangalfabs.dashboard.category.addcategory.AddCategoryFragment;
import bingoyo.com.mangalfabs.dashboard.products.ParticularCategoryProductListActivity;
import bingoyo.com.mangalfabs.recyclerHelper.EqualSpacingItemDecoration;
import bingoyo.com.mangalfabs.recyclerHelper.ItemOffsetDecoration;
import bingoyo.com.mangalfabs.viewholder.ProductCategory;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryListActivity extends AppCompatActivity {

    private static final String TAG = "CategoryListActivity";
    @BindView(R.id.categoryListView)
    RecyclerView categoryListView;
    @BindView(R.id.addCategory)
    FloatingActionButton addCategory;
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
        setContentView(R.layout.activity_category_list);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Categorys");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        initView();

    }


    private void initView() {

        int mNoOfColumns = Utility.calculateNoOfColumns(this);
        Log.e(TAG, "initView: " + mNoOfColumns);
        categoryListView.setLayoutManager(new GridLayoutManager(this, 2));

//        categoryListView.addItemDecoration(new EqualSpacingItemDecoration(16, EqualSpacingItemDecoration.GRID));
        categoryListView.addItemDecoration(new ItemOffsetDecoration(this, R.dimen.item_offset));

//        //create the ItemAdapter holding your Items
//        ItemAdapter<ProductCategory> itemAdapter = new ItemAdapter<ProductCategory>();
//        //create the managing FastAdapter, by passing in the itemAdapter
//        FastAdapter fastAdapter = FastAdapter.with(itemAdapter);

        //set our adapters to the RecyclerView
        categoryListView.setAdapter(fastAdapter);

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

    @OnClick({R.id.addCategory, R.id.back})
    public void onViewClicked(View view) {

        switch (view.getId()) {


            case R.id.back:
                onBackPressed();
                break;

            case R.id.addCategory:
                AddCategoryFragment fragment = new AddCategoryFragment();
//        fragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
//        fragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar_Fullscreen);

                fragment.show(getSupportFragmentManager(), "Add_Category");


                break;


        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view_menu_item, menu);
        MenuItem searchViewItem = menu.findItem(R.id.action_search);
        final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchViewAndroidActionBar.clearFocus();
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
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {


            onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }


}
