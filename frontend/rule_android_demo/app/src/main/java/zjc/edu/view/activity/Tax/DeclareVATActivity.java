package zjc.edu.view.activity.Tax;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import zjc.edu.R;
import zjc.edu.model.VAT.TaxService;
import zjc.edu.service.main.VAT.DeclareVATService;
import zjc.edu.service.main.VAT.TaxserviceService;
import zjc.edu.service.imp.VAT.DeclareVATServiceImp;
import zjc.edu.service.imp.VAT.TaxserviceServiceImp;

public class DeclareVATActivity extends AppCompatActivity {
    private Toolbar toolbar;
    String vatvalue;
    TaxService data;
    TextView country;
    EditText vatid;
    TextView cycle;
    TextView now;
    TextView end;
    TextView rate;
    float money;
    Button btn_jisuan;
    String companyName;
    String declarationtype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_declare_vat);
        //绑定控件
        toolbar=findViewById(R.id.Tl_declarevat);
        country = findViewById(R.id.declare_country);
        vatid = findViewById(R.id.declare_vatid);
        now = findViewById(R.id.declare_now);
        end = findViewById(R.id.declare_end);
        cycle = findViewById(R.id.declare_cycle);
        rate = findViewById(R.id.declare_rate);
        TextView OMP = findViewById(R.id.OMP);
        TextView omp = findViewById(R.id.omp);
        EditText money1 = findViewById(R.id.declare_money1);
        EditText money2 = findViewById(R.id.declare_money2);
        ConstraintLayout OMP_Cons = findViewById(R.id.OMP_Cons);
        ConstraintLayout omp_Cons = findViewById(R.id.omp_Cons);
        CheckBox checkbox1 = findViewById(R.id.declare_check1);
        CheckBox checkbox2 = findViewById(R.id.declare_check2);
        String[] bool = new String[2];
        Arrays.fill(bool,"0");
        btn_jisuan=findViewById(R.id.btn_jisuan);
        //得到传递数据
        Intent intent=getIntent();
        vatvalue=intent.getStringExtra("vatnumber");
        initfind(vatvalue);
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //分别对两个checkbox控件进行监听
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //设置控件的显示与隐藏
                if(isChecked){
                    OMP.setVisibility(View.VISIBLE);
                    OMP_Cons.setVisibility(View.VISIBLE);
                    bool[0] ="1";
                }else {
                    OMP.setVisibility(View.GONE);
                    OMP_Cons.setVisibility(View.GONE);
                }
            }
        });
        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //设置控件的显示与隐藏
                if (isChecked){
                    omp.setVisibility(View.VISIBLE);
                    omp_Cons.setVisibility(View.VISIBLE);
                    bool[1]="1";
                }else {
                    omp.setVisibility(View.GONE);
                    omp_Cons.setVisibility(View.GONE);
                }
            }
        });

        btn_jisuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bool[0] == "1"){
                    String m1=money1.getText().toString();
                    String rat=rate.getText().toString();
                    float max = 0;
                    try {
                        float fm1 = Float.parseFloat(m1);
                        float frat = Float.parseFloat(rat);
                        max=fm1 * frat/100;
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
//                    String dateString = "2023-11-06"; // 你的日期字符串
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                    Date date = null;// 指定日期格式
//                    try {
//                        date = dateFormat.parse(dateString); // 使用 parse 方法将字符串转换为日期
//                        // 现在，'date' 就是你的日期对象
//                    } catch (ParseException e) {
//                        e.printStackTrace(); // 如果解析失败，将会抛出 ParseException 异常
//                        // 在这里你可以处理异常，例如显示错误消息或执行其他逻辑
//                    }
                    JSONObject jsonData = new JSONObject();
                    try {
                        jsonData.put("taxpaymentid",null);
                        jsonData.put("companyname",companyName);
                        jsonData.put("country",country.getText().toString());
                        jsonData.put("vatnumber",vatid.getText().toString());
                        jsonData.put("declarationtype",declarationtype);
                        jsonData.put("amountdue",max);
                        jsonData.put("currency","GBP");
                        jsonData.put("declarationcycle",declarationtype);
//                        jsonData.put("declarationperiod",date);
//                        jsonData.put("duedate","2023-12-31");
                        jsonData.put("paymentstatus",1);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                    Log.i("jsondata123",jsonData.toString());
                    init(jsonData.toString());
                }else if (bool[1] == "1"){
                    String m2=money2.getText().toString();
                    String rat=rate.getText().toString();
                    float max = 0;
                    try {
                        float fm2 = Float.parseFloat(m2);
                        float frat = Float.parseFloat(rat);
                        max=fm2 * frat/100;
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    JSONObject jsonData = new JSONObject();
                    try {
                        jsonData.put("taxpaymentid",null);
                        jsonData.put("companyname",companyName);
                        jsonData.put("country",country.getText().toString());
                        jsonData.put("vatnumber",vatid.getText().toString());
                        jsonData.put("declarationtype",declarationtype);
                        jsonData.put("amountdue",max);
                        jsonData.put("currency","GBP");
                        jsonData.put("declarationcycle",declarationtype);
//                        jsonData.put("declarationperiod","2023-9-23");
//                        jsonData.put("duedate","2023-12-31");
                        jsonData.put("paymentstatus",1);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                    Log.i("jsondata123",jsonData.toString());
                    init(jsonData.toString());
                }
                Intent intent = new Intent(DeclareVATActivity.this, ShenBaoTaxActivity.class);
                startActivity(intent);
            }
        });

    }
    //toolbar方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent = new Intent(this, ShenBaoTaxActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //数据放入
    public void initfind(String s){
        TaxserviceService taxserviceService=new TaxserviceServiceImp(this);
        taxserviceService.findTaxServicByvatnumber(s);
    }
    //得到find数据
    public void findbyvatnumberBack(TaxService Json){
        this.data=Json;
        country.setText(data.getCountry().toString());
        vatid.setText(data.getVatnumber().toString());
        rate.setText(String.valueOf(data.getTaxrate()));
        cycle.setText(data.getServicetype().toString());
        companyName=data.getCompanyname().toString();
        declarationtype=data.getTaxtype().toString();
    }
    //计算功能
    public void init(String a){
        DeclareVATService declareVATService=new DeclareVATServiceImp(this);
        declareVATService.addTaxPayment(a);
        Log.i("jsondata123",a);
    }
}
