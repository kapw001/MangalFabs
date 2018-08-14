package bingoyo.com.mangalfabs.dashboard.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import bingoyo.com.mangalfabs.R;
import bingoyo.com.mangalfabs.dashboard.about.AboutActivity;
import bingoyo.com.mangalfabs.dashboard.category.CategoryListActivity;
import bingoyo.com.mangalfabs.dashboard.contactus.ContactusActivity;
import bingoyo.com.mangalfabs.dashboard.products.ProductCategoryListActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserDashboardActivity extends AppCompatActivity {


    @BindView(R.id.dash_product)
    CardView dashProduct;
    @BindView(R.id.dash_category)
    CardView dashCategory;
    @BindView(R.id.dash_about_us)
    CardView dashAboutUs;
    @BindView(R.id.dash_contact)
    CardView dashContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.dash_product, R.id.dash_category, R.id.dash_about_us, R.id.dash_contact})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dash_product:
                startActivity(new Intent(this, ProductCategoryListActivity.class));
                break;
            case R.id.dash_category:
                startActivity(new Intent(this, CategoryListActivity.class));
                break;
            case R.id.dash_about_us:
                startActivity(new Intent(this, AboutActivity.class));
                break;
            case R.id.dash_contact:
                startActivity(new Intent(this, ContactusActivity.class));
                break;
        }
    }
}
