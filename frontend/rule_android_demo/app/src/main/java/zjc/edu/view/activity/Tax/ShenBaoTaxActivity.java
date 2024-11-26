package zjc.edu.view.activity.Tax;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import zjc.edu.R;
import zjc.edu.model.VAT.TaxDeclaration;
import zjc.edu.service.main.VAT.TaxDeclarationService;
import zjc.edu.service.imp.VAT.TaxDeclarationServiceImp;
import zjc.edu.view.adapter.TaxShenbaoAdapter;

public class ShenBaoTaxActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView ShenbaorecyclerView;
    private TaxShenbaoAdapter taxShenbaoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shen_bao_tax);
        //绑定控件
        ShenbaorecyclerView=findViewById(R.id.ry_shenbao);
        toolbar=findViewById(R.id.Tlshenbao);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ShenbaorecyclerView.setLayoutManager(new LinearLayoutManager(ShenBaoTaxActivity.this));
        initShenbaoData();

    }
    //回到上一个activity的intent事件
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

    public void initShenbaoData(){
        TaxDeclarationService taxDeclarationService=new TaxDeclarationServiceImp(this);
        taxDeclarationService.findAllTaxdeclaration();
    }
    //
    public void showAllTaxdeclarationCallback(TaxDeclaration[] taxdeclarationFromJson){
        List<TaxDeclaration> taxDeclarationList = new ArrayList<>();
        if (taxdeclarationFromJson != null) {
            for (TaxDeclaration taxDeclaration : taxdeclarationFromJson) {
                taxDeclarationList.add(taxDeclaration);
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在主线程中更新UI
                taxShenbaoAdapter=new TaxShenbaoAdapter(ShenBaoTaxActivity.this,taxDeclarationList);
                ShenbaorecyclerView.setAdapter(taxShenbaoAdapter);
                taxShenbaoAdapter.notifyDataSetChanged();
            }
        });

    }
}
