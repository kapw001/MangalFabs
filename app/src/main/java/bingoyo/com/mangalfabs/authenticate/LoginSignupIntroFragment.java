package bingoyo.com.mangalfabs.authenticate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import bingoyo.com.mangalfabs.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginSignupIntroFragment extends BaseCallBackFragement {


    @BindView(R.id.login)
    Button login;
    @BindView(R.id.signup)
    TextView signup;
    Unbinder unbinder;
    @BindView(R.id.sign_up)
    Button signUp;

    public LoginSignupIntroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_signup_intro, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @OnClick({R.id.login, R.id.signup,R.id.sign_up})
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.login:

                if (callAuthFragment != null) callAuthFragment.loginFragment();

                break;

            case R.id.signup:

                if (callAuthFragment != null) callAuthFragment.signupFragment();

                break;

            case R.id.sign_up:

                if (callAuthFragment != null) callAuthFragment.signupFragment();

                break;
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
