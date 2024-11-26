package zjc.edu.view.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class StepEprAdapter extends FragmentPagerAdapter {
    public StepEprAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new EPR_Step_1();
            case 1:
                return new EPR_Step_2();
            case 2:
                return new EPR_Step_3();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // 返回每个选项卡的标题
        switch (position) {
            case 0:
                return "步骤一";
            case 1:
                return "步骤二";
            case 2:
                return "步骤三";
            default:
                return null;
        }
    }
}
