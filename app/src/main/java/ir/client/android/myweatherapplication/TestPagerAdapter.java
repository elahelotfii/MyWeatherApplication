package ir.client.android.myweatherapplication;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TestPagerAdapter extends FragmentPagerAdapter {
    public TestPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TestFragment();
            case 1:
                return new FragmentRecycle();
            case 2:
                return new UpdateFragment();
                default:
                    return new TestFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "City name";
            case 1:
                return "Daily weather forecast";
            case 2:
                return "Future weather forecast";
                default:
                    return "Unkown page";
        }
    }
}
