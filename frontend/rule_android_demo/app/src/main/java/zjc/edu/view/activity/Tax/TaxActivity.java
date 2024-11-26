package zjc.edu.view.activity.Tax;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import zjc.edu.R;
import zjc.edu.model.VAT.SharedVATViewModel;
import zjc.edu.model.VAT.TaxService;
import zjc.edu.service.main.VAT.TaxserviceService;
import zjc.edu.service.imp.VAT.TaxserviceServiceImp;
import zjc.edu.view.activity.MainActivity;
import zjc.edu.view.adapter.TaxAdapter;

public class TaxActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageButton add;
    private Button shenbao;
    private Button jiaoshui;
    private Button tuishui;
    private RecyclerView TaxrecyclerView;
    private SharedVATViewModel sharedVATViewModel;
    private TaxAdapter taxAdapter;
    private String selectedValue;
    private String selectedOptionText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);
        //绑定控件
        TaxrecyclerView=findViewById(R.id.recycleview_tax);
        toolbar = findViewById(R.id.Tl_1);
        add=findViewById(R.id.addButton);
        shenbao=findViewById(R.id.btn_shenbao);
        jiaoshui=findViewById(R.id.btn_jiaoshui);
        tuishui=findViewById(R.id.btn_tuishui);
        //顶栏按钮
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        sharedVATViewModel=new ViewModelProvider(this).get(SharedVATViewModel.class);
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //加号按钮 增加taxservice
        add.setOnClickListener(v -> {
            choosePictureDialog();
        });
        //申报功能
        shenbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TaxActivity.this, ShenBaoTaxActivity.class);
                startActivity(intent);
            }
        });
        //退税功能
        tuishui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TaxActivity.this, TaxRefundActivity.class);
                startActivity(intent);
            }
        });
        //缴税功能
        jiaoshui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TaxActivity.this, TaxPaymentActivity.class);
                startActivity(intent);
            }
        });
        TaxrecyclerView.setLayoutManager(new LinearLayoutManager(TaxActivity.this));
        initTaxServiceData();
//        initfind();
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showAllTaxServiceCallback(TaxService[] taxServiceFromJson){
        List<TaxService> taxServiceList = new ArrayList<>();
        if (taxServiceFromJson != null) {
            for (TaxService taxService : taxServiceFromJson) {
                taxServiceList.add(taxService);
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在主线程中更新UI
                taxAdapter=new TaxAdapter(TaxActivity.this,taxServiceList);
                TaxrecyclerView.setAdapter(taxAdapter);
                taxAdapter.notifyDataSetChanged();
            }
        });
    }


    public void initTaxServiceData(){
        TaxserviceService taxserviceService=new TaxserviceServiceImp(this);
        taxserviceService.findAllTaxService();
    }
    public void initadd(String value){
        TaxserviceService taxserviceService=new TaxserviceServiceImp(this);
        taxserviceService.addTaxService(value);
        initTaxServiceData();
    }
    public void initfind(){
        TaxserviceService taxserviceService=new TaxserviceServiceImp(this);
        taxserviceService.findTaxServicByvatnumber("VAT123");
    }
    private void choosePictureDialog() {
        View View = LayoutInflater.from(this).inflate(R.layout.activity_vat_add, null);
        AlertDialog selectDialog = new AlertDialog.Builder(this).setView(View).setCancelable(false).create();
        selectDialog.show();
        Window window = selectDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        Objects.requireNonNull(selectDialog.getWindow()).setBackgroundDrawableResource(R.color.transparent);
        EditText vatadd_cname=View.findViewById(R.id.vatadd_cname);
        RadioGroup radioGroup_vat=View.findViewById(R.id.radiogroup_vat);
        TextView vatadd_country=View.findViewById(R.id.vatadd_country);
        TextView vatadd_rate=View.findViewById(R.id.vatadd_rate);
        Spinner taxratespinner=View.findViewById(R.id.vatadd_spinner);
        EditText vatadd_tax=View.findViewById(R.id.vatadd_tax);
        //得到Spinner选项
        taxratespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedValue=((String)taxratespinner.getSelectedItem());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO
            }
        });
        //查询RadioButton选中的国家
        radioGroup_vat.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedRadioButtonId = radioGroup_vat.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = View.findViewById(radioGroup_vat.getCheckedRadioButtonId());
                    //得到radiobutton的text属性
                    selectedOptionText = selectedRadioButton.getText().toString();
                    sharedVATViewModel.setCountry(selectedOptionText);
                    Log.i("radioselect",selectedOptionText);
                    //给第二步骤中vatadd_country设置text
                    selectedRadioButton.setOnClickListener(v -> {
                        vatadd_country.setText(selectedOptionText);
                    });
                }
            }
        });
        //关闭界面按钮点击事件
        ImageButton imageButton = View.findViewById(R.id.vatdialog_close);
        imageButton.setOnClickListener(v -> {
            selectDialog.dismiss();
        });
        //提交按钮点击事件
        Button button = View.findViewById(R.id.vatadd_btn);
        button.setOnClickListener(v -> {
            float floatValue=Float.parseFloat(selectedValue);
            sharedVATViewModel.setTaxrate(floatValue);
            sharedVATViewModel.setCompanyname(vatadd_cname.getText().toString());
            sharedVATViewModel.setVatnumber(vatadd_tax.getText().toString());
            sharedVATViewModel.setServiceprogress("未提交资料");
            sharedVATViewModel.setTaxtype("季度申报");
            sharedVATViewModel.setServicetype("目的国");
            sharedVATViewModel.getServicesummit(0);
            JSONObject jsonData = new JSONObject();
            try {
                jsonData.put("companyname",vatadd_cname.getText().toString());
                jsonData.put("vatnumber",vatadd_tax.getText().toString());
                jsonData.put("taxrate",floatValue);
                jsonData.put("serviceprogress","未提交资料");
                jsonData.put("taxtype","季度申报");
                jsonData.put("servicetype","目的国");
                jsonData.put("servicesummit",0);
                jsonData.put("country",selectedOptionText);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            initadd(jsonData.toString());
            selectDialog.dismiss();
            Toast.makeText(this,"提交成功",Toast.LENGTH_LONG).show();
        });
    }
    public TaxService findbyvatnumberBack(TaxService taxService){
        String data=taxService.getVatnumber().toString();
        Log.i("findby",data);
        return null;

    }
}