package zjc.edu.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import zjc.edu.R;
import zjc.edu.view.fragment.DataFragment;
import zjc.edu.view.fragment.HomeFragment;
import zjc.edu.view.fragment.LearnFragment;
import zjc.edu.view.fragment.MineFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private int selectedItemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.Bnv);

        // 设置底部导航栏的监听器
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            // 保存当前选中项的索引
            selectedItemId = itemId;

            // 处理 Fragment 切换逻辑
            if (itemId == R.id.nav_home) {
                loadFragment(new HomeFragment());
                return true;
            } else if (itemId == R.id.nav_learn) {
                loadFragment(new LearnFragment());
                return true;
            } else if (itemId == R.id.nav_data) {
                loadFragment(new DataFragment());
                return true;
            } else if (itemId == R.id.nav_mine) {
                loadFragment(new MineFragment());
                return true;
            }

            return false;
        });

        // 如果之前保存过选中项的索引，还原到该索引
        if (savedInstanceState != null) {
            selectedItemId = savedInstanceState.getInt("selectedItemId", R.id.nav_home);
            bottomNavigationView.setSelectedItemId(selectedItemId);
        } else {
            // 默认加载第一个 Fragment
            loadFragment(new HomeFragment());
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        // 保存当前选中项的索引
        outState.putInt("selectedItemId", selectedItemId);
        super.onSaveInstanceState(outState);
    }

    private void loadFragment(Fragment fragment) {
        // 使用 FragmentTransaction 切换 Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Fl, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}