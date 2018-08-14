package bingoyo.com.mangalfabs.dashboard.contactus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import bingoyo.com.mangalfabs.R;
import bingoyo.com.mangalfabs.dashboard.contactus.sendmessage.SendMessageFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactusActivity extends AppCompatActivity {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.send_message)
    FloatingActionButton sendMessage;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.action_bar_title)
    TextView actionBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        ButterKnife.bind(this);
//        getSupportActionBar().setTitle("Contact us");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Picasso.get().load("http://www.mangalfabs.com/images/contact.jpg").fit().into(img);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.send_message, R.id.back})
    public void onViewClicked(View v) {

        switch (v.getId()) {

            case R.id.back:

                onBackPressed();
                break;

            case R.id.send_message:

                SendMessageFragment sendMessageFragment = new SendMessageFragment();

                sendMessageFragment.show(getSupportFragmentManager(), "Send_Message");


                break;
        }


    }

}
