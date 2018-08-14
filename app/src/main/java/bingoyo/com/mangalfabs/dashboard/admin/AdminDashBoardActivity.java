package bingoyo.com.mangalfabs.dashboard.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import bingoyo.com.mangalfabs.R;
import bingoyo.com.mangalfabs.dashboard.about.AboutActivity;
import bingoyo.com.mangalfabs.dashboard.addproduct.AddProductActivity;
import bingoyo.com.mangalfabs.dashboard.category.CategoryListActivity;
import bingoyo.com.mangalfabs.dashboard.contactus.ContactusActivity;
import bingoyo.com.mangalfabs.dashboard.products.ProductCategoryListActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdminDashBoardActivity extends AppCompatActivity {


    @BindView(R.id.dash_add_order)
    CardView dashAddOrder;
    @BindView(R.id.dash_add_product)
    CardView dashAddProduct;
    @BindView(R.id.dash_category)
    CardView dashCategory;
    @BindView(R.id.dash_news)
    CardView dashNews;
    @BindView(R.id.dash_about)
    CardView dashAbout;
    @BindView(R.id.dash_contact_us)
    CardView dashContactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash_board);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.dash_add_order, R.id.dash_add_product, R.id.dash_category, R.id.dash_news, R.id.dash_about, R.id.dash_contact_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dash_add_order:

                startActivity(new Intent(this, ProductCategoryListActivity.class));

                break;

            case R.id.dash_contact_us:
                startActivity(new Intent(this, AboutActivity.class));
//                startActivity(new Intent(this, ContactusActivity.class));

                break;
            case R.id.dash_add_product:

                startActivity(new Intent(this, AddProductActivity.class));

                break;
            case R.id.dash_category:

                startActivity(new Intent(this, CategoryListActivity.class));

                break;
            case R.id.dash_news:
                break;
            case R.id.dash_about:

                startActivity(new Intent(this, AboutActivity.class));

                break;
        }
    }

}
