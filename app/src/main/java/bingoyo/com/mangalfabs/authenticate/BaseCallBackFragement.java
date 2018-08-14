package bingoyo.com.mangalfabs.authenticate;

import android.content.Context;
import android.support.v4.app.Fragment;

public class BaseCallBackFragement extends Fragment {

    protected CallAuthFragment callAuthFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callAuthFragment = (CallAuthFragment) context;
    }
}
