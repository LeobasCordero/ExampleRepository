package leo.com.example.viewpagerexample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import leo.com.example.viewpagerexample.Constants.Constant;
import leo.com.example.viewpagerexample.R;
import leo.com.example.viewpagerexample.custom.CustomView;

/**
 * Fragmento con Boton Redondo
 */
public class ButtonFragment extends Fragment {

    @Bind(R.id.customView)
    CustomView custom;

    int x = Constant.ZERO_VALUE;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.circular_button_layout, container, false);

        ButterKnife.bind(this, v);

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                custom.setCircleText(String.valueOf(x));
            }
        });

        return v;
    }

}
