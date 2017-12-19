package com.smart.smartsport.activity;


import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.smart.smartsport.R;
import com.smart.smartsport.activity.BaseActivity;
import com.smart.smartsport.fragment.DisFragment;
import com.smart.smartsport.fragment.SmartFragment;
import com.smart.smartsport.fragment.SocietyFragment;


public class MainActivity extends BaseActivity {

    private BottomNavigationView navigation;
    private Fragment[] fragments;
    private int lastshowFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void configViews() {
        Fragment disFragment = new DisFragment();
        Fragment smartFragment = new SmartFragment();
        Fragment societyFragment = new SocietyFragment();
        fragments = new Fragment[]{disFragment, smartFragment, societyFragment};
        lastshowFragment = 0;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, disFragment)
                .show(disFragment)
                .commit();
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.dis:
                    if (lastshowFragment != 0) {
                        switchFragment(lastshowFragment, 0);
                        lastshowFragment = 0;
                    }
                    return true;
                case R.id.smart:
                    if (lastshowFragment != 1) {
                        switchFragment(lastshowFragment, 1);
                        lastshowFragment = 1;
                    }
                    return true;
                case R.id.circles_of_society:
                    if (lastshowFragment != 2) {
                        switchFragment(lastshowFragment, 2);
                        lastshowFragment = 2;
                    }
                    return true;
            }
            return false;
        }
    };

    private void switchFragment(int lastIndex, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastIndex]);
        if (!fragments[index].isAdded()) {
            transaction.add(R.id.fragment_container, fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }


    @Override
    public void initData() {

    }

}
