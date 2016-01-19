package leo.com.example.viewpagerexample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Adaptador para ViewPage
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    /**
     * Constructor
     *
     * @param fm interface para interactuar con los fragmentos dentro de
     *           la Activity
     */
    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<Fragment>();
    }

    /**
     * Agrega un nuevo fragmento a la lista
     *
     * @param fragment nuevo fragmento
     */
    public void addFragment(Fragment fragment) {
        this.fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int arg0) {
        return this.fragments.get(arg0);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

}
