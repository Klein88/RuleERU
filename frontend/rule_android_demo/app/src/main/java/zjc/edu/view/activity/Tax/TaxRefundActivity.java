package zjc.edu.view.activity.Tax;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import zjc.edu.R;
import zjc.edu.model.VAT.Taxrefund;
import zjc.edu.service.main.VAT.TaxRefundService;
import zjc.edu.service.imp.VAT.TaxRefundServiceImp;
import zjc.edu.view.adapter.TaxRefundAdapter;

public class TaxRefundActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView_taxrefund;
    private TaxRefundAdapter taxRefundAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxrefund_tax);
        //绑定控件
        toolbar=findViewById(R.id.Tltuishui);
        recyclerView_taxrefund=findViewById(R.id.ry_tuishui);
        //RecyclerView
        recyclerView_taxrefund.setLayoutManager(new LinearLayoutManager(TaxRefundActivity.this));
        initFindAll();
        //顶栏跳回上一个activity
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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
    //findAll方法回调
    public void showfindAllBack(Taxrefund[] taxrefundFromJson){
        List<Taxrefund> taxrefundList = new ArrayList<>();
        if (taxrefundFromJson != null) {
            for (Taxrefund taxrefund : taxrefundFromJson) {
                taxrefundList.add(taxrefund);
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在主线程中更新UI
                taxRefundAdapter=new TaxRefundAdapter(TaxRefundActivity.this,taxrefundList);
                recyclerView_taxrefund.setAdapter(taxRefundAdapter);
                taxRefundAdapter.notifyDataSetChanged();
            }
        });
    }
    //注入数据
    public void initFindAll(){
        TaxRefundService taxRefundService=new TaxRefundServiceImp(this);
        taxRefundService.findAllTaxRefund();
    }
}