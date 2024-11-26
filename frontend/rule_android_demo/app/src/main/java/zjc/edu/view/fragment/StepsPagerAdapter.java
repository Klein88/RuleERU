package zjc.edu.view.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class StepsPagerAdapter extends FragmentPagerAdapter {

    public StepsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Step1Fragment();
            case 1:
                return new Step2Fragment();
            case 2:
                return new Step3Fragment();
            case 3:
                return new Step4Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
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
            case 3:
                return "步骤四";
            default:
                return null;
        }
    }
}
