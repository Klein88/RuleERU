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
import zjc.edu.model.VAT.TaxPayment;
import zjc.edu.service.main.VAT.TaxPayMentService;
import zjc.edu.service.imp.VAT.TaxPayMentServiceImp;
import zjc.edu.view.adapter.TaxPaymentAdapter;

public class TaxPaymentActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView_payment;
    private TaxPaymentAdapter taxPaymentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_tax);
        //绑定控件
        toolbar=findViewById(R.id.Tljiaoshui);
        recyclerView_payment=findViewById(R.id.ry_payment);
        //RecyclerView
        recyclerView_payment.setLayoutManager(new LinearLayoutManager(TaxPaymentActivity.this));
        initFindAll();
        //toolbar
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
    //findAll回调
    public void showFindAllBack(TaxPayment[] TaxPatmentFromJson){
        List<TaxPayment> taxpaymentList = new ArrayList<>();
        if (TaxPatmentFromJson != null) {
            for (TaxPayment taxPayment : TaxPatmentFromJson) {
                taxpaymentList.add(taxPayment);
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在主线程中更新UI
                taxPaymentAdapter=new TaxPaymentAdapter(TaxPaymentActivity.this,taxpaymentList);
                recyclerView_payment.setAdapter(taxPaymentAdapter);
                taxPaymentAdapter.notifyDataSetChanged();
            }
        });
    }
    //findAll调用
    public void initFindAll(){
        TaxPayMentService taxPayMentService=new TaxPayMentServiceImp(this);
        taxPayMentService.findAllTaxPayMent();
    }
}