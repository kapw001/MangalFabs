package bingoyo.com.mangalfabs.authenticate;


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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends BaseCallBackFragement {


    Unbinder unbinder;
    @BindView(R.id.email)
    TextInputLayout email;
    @BindView(R.id.mobile)
    TextInputLayout mobile;
    @BindView(R.id.password)
    TextInputLayout password;
    @BindView(R.id.sign_up)
    Button signUp;
    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.back)
    ImageView back;

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


//    @OnClick({R.id.sign_up, R.id.login, R.id.back})
//    public void onClick(View v) {
//
//        switch (v.getId()) {
//
//            case R.id.sign_up:
//
//                break;
//
//            case R.id.login:
//
//                if (callAuthFragment != null) callAuthFragment.loginFragment();
//
//                break;
//
//            case R.id.back:
//
//                getActivity().onBackPressed();
//
//                break;
//
//        }
//
//    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.sign_up, R.id.login, R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sign_up:
                break;
            case R.id.login:
                if (callAuthFragment != null) callAuthFragment.loginFragment();
                break;
            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }
}
