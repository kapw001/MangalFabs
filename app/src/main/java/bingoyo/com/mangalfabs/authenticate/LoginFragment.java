package bingoyo.com.mangalfabs.authenticate;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import bingoyo.com.mangalfabs.R;
import bingoyo.com.mangalfabs.dashboard.admin.AdminDashBoardActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseCallBackFragement {


    Unbinder unbinder;
    @BindView(R.id.email)
    TextInputLayout email;
    @BindView(R.id.mobile)
    TextInputLayout mobile;
    @BindView(R.id.password)
    TextInputLayout password;
    @BindView(R.id.sign_in)
    Button signIn;
    @BindView(R.id.sign_up)
    TextView signUp;
    @BindView(R.id.back)
    ImageView back;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


//    @OnClick({R.id.login, R.id.signup, R.id.back})
//    public void onClick(View v) {
//
//        switch (v.getId()) {
//
//            case R.id.login:
//
//                startActivity(new Intent(getContext(), AdminDashBoardActivity.class));
//
//                break;
//
//            case R.id.signup:
//
//                if (callAuthFragment != null) callAuthFragment.signupFragment();
//
//                break;
//
//            case R.id.back:
//
//
//                getActivity().onBackPressed();
//
//                break;
//
//
//        }
//
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.sign_in, R.id.sign_up, R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sign_in:
                startActivity(new Intent(getContext(), AdminDashBoardActivity.class));
                break;
            case R.id.sign_up:
                if (callAuthFragment != null) callAuthFragment.signupFragment();
                break;
            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }
}
