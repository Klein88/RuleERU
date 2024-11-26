package zjc.edu.view.activity.Tax;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import zjc.edu.R;
import zjc.edu.model.VAT.TaxPayment;
import zjc.edu.service.main.VAT.TaxPayMentService;
import zjc.edu.service.imp.VAT.TaxPayMentServiceImp;

public class TaxPaymentActivity_Edit extends AppCompatActivity {
    private Toolbar toolbar;
    String valuepayment;
    private TaxPayment data;
    private TextView taxpayment_cname;
    private TextView taxpayment_count;
    private TextView taxpayment_taxid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_tax_edit);
        //绑定控件
        toolbar=findViewById(R.id.Tljiaoshui_edit);
        taxpayment_cname=findViewById(R.id.taxpayment_cname);
        taxpayment_count=findViewById(R.id.taxpayment_count);
        taxpayment_taxid=findViewById(R.id.taxpayment_taxid);
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //得到数据
        Intent intent=getIntent();
        valuepayment=intent.getStringExtra("companyname");
        initfindcompanyname(valuepayment);
    }

    //回到上一个activity的intent事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent = new Intent(this, TaxPaymentActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void initfindcompanyname(String a){
        TaxPayMentService taxPayMentService=new TaxPayMentServiceImp(this);
        taxPayMentService.findTaxPaymentBycompanyname(a);
    }
    public void findbycompanynameBack(TaxPayment[] json){
        this.data=json[0];
        taxpayment_cname.setText(data.getCompanyname().toString());
        taxpayment_count.setText(String.valueOf(data.getAmountdue()));
        taxpayment_taxid.setText(data.getVatnumber().toString());
    }
}