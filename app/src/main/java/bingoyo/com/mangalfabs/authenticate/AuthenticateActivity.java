package bingoyo.com.mangalfabs.authenticate;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bingoyo.com.mangalfabs.R;

public class AuthenticateActivity extends AppCompatActivity implements CallAuthFragment {

    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate);

        infoFragment();
    }

    @Override
    public void infoFragment() {

        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.continer, new LoginSignupIntroFragment());

        fragmentTransaction.commit();


    }

    @Override
    public void loginFragment() {

        popUpFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.left_enter, R.anim.right_out,R.anim.left_enter, R.anim.right_out);
        fragmentTransaction.replace(R.id.continer, new LoginFragment()).addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void signupFragment() {

        popUpFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.left_enter, R.anim.right_out,R.anim.left_enter, R.anim.right_out);
        fragmentTransaction.replace(R.id.continer, new SignupFragment()).addToBackStack(null);
        fragmentTransaction.commit();

    }


    @Override
    public void onBackPressed() {


        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {

            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }

    }


    private void popUpFragment() {

//        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
//
//            getSupportFragmentManager().popBackStack();
//        }

    }
}
