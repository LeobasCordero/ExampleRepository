package leo.com.example.viewpagerexample;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import butterknife.Bind;
import butterknife.ButterKnife;
import leo.com.example.viewpagerexample.Constants.Constant;
import leo.com.example.viewpagerexample.adapter.MyFragmentPagerAdapter;
import leo.com.example.viewpagerexample.fragment.ButtonFragment;
import leo.com.example.viewpagerexample.fragment.ListFragment;


/**
 * Actividad Inicial con ViewPage
 */
public class MainActivity extends FragmentActivity {

    @Bind(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        this.setContentView(R.layout.activity_main);

        // Creacion del adapter con fragments
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager());

        adapter.addFragment(new ListFragment());
        adapter.addFragment(new ButtonFragment());

        ButterKnife.bind(this);
        pager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

        // Regresa a la pagina previa
        if (this.pager.getCurrentItem() == Constant.ZERO_VALUE)
            super.onBackPressed();
        else
            this.pager.setCurrentItem(this.pager.getCurrentItem() - Constant.ONE_VALUE);

    }

}
