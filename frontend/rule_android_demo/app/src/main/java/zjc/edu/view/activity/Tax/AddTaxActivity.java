package zjc.edu.view.activity.Tax;

import static zjc.edu.R.*;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import zjc.edu.R;
import zjc.edu.model.VAT.SharedTaxViewModel;
import zjc.edu.view.fragment.Step1Fragment;
import zjc.edu.view.fragment.StepsPagerAdapter;

public class AddTaxActivity extends AppCompatActivity {
    private SharedTaxViewModel sharedTaxViewModel;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Step1Fragment fragment_step1;
    String vatnumber;
    float taxrate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_add_tax);
        sharedTaxViewModel=new ViewModelProvider(this).get(SharedTaxViewModel.class);
        Intent intent=getIntent();
        vatnumber=intent.getStringExtra("vatnumber");
        taxrate=intent.getFloatExtra("taxrate",0);
        sharedTaxViewModel.setTaxrate(taxrate);
        toolbar=findViewById(R.id.Tladd);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        tabLayout=findViewById(id.tb_1);
        viewPager=findViewById(id.Vp);
        StepsPagerAdapter adapter = new StepsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

//        getSupportFragmentManager().beginTransaction().add(R.id.)
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent = new Intent(this, TaxActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        Step1Fragment step1Fragment = (Step1Fragment) getSupportFragmentManager().findFragmentById(R.id.); // Use your actual fragment container ID
//        if (step1Fragment != null) {
//            step1Fragment.handleActivityResult(requestCode, resultCode, data);
//        }
//    }

}