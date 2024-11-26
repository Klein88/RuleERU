package zjc.edu.view.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import zjc.edu.R;
import zjc.edu.model.ComplianceApplication;
import zjc.edu.model.WorkOrders;
import zjc.edu.service.imp.ComplianceApplicationServiceImp;
import zjc.edu.service.main.ComplianceApplicationService;
import zjc.edu.util.DateConverter;
import zjc.edu.view.adapter.ComplianceApplicationAdapter;
import zjc.edu.view.adapter.WorkOrderAdapter;

public class ConsumptionActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private String selectedValue;
    private ImageButton addButton;
    private RecyclerView  recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumption);
        //绑定控件
        toolbar = findViewById(R.id.Tl_1);
        addButton=findViewById(R.id.addButton);
        recyclerView=findViewById(R.id.ry_con);
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initfindall();
        //添加按钮
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog();
            }
        });
    }
    //toolbar
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

    private void Dialog() {
        View View = LayoutInflater.from(this).inflate(R.layout.activity_compliance_add, null);
        AlertDialog Dialog = new AlertDialog.Builder(this).setView(View).setCancelable(false).create();
        Dialog.show();
        Window window = Dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        Objects.requireNonNull(Dialog.getWindow()).setBackgroundDrawableResource(R.color.transparent);
        EditText compliance_cname=View.findViewById(R.id.compliance_cname);
        EditText CNname=View.findViewById(R.id.CNname);
        EditText ENname=View.findViewById(R.id.ENname);
        EditText compliance_date=View.findViewById(R.id.compliance_date);
//        TextView logo=View.findViewById(R.id.logo);
        Spinner compliance_spinner=View.findViewById(R.id.compliance_spinner);
        //得到Spinner选项
        compliance_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedValue=((String)compliance_spinner.getSelectedItem());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO
            }
        });
        //提交按钮
        Button button=View.findViewById(R.id.conadd_btn);
        button.setOnClickListener(v->{
            String date = null;
            try {
                date= DateConverter.convertStringToFormattedDate(compliance_date.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject=new JSONObject();
            try {
                jsonObject.put("filetype",selectedValue);
                jsonObject.put("companyname",compliance_cname.getText().toString());
                jsonObject.put("productchinesename",CNname.getText().toString());
                jsonObject.put("productenglishname",ENname.getText().toString());
//                jsonObject.put("trademark",logo.getText().toString());
                jsonObject.put("applicationdate",date);
            }catch (JSONException e){
                e.printStackTrace();
            }
            Log.i("addCompliance",jsonObject.toString());
            initadd(jsonObject.toString());
            Dialog.dismiss();
            Toast.makeText(this,"添加成功",Toast.LENGTH_LONG).show();
        });
        //关闭界面按钮点击事件
        ImageButton imageButton = View.findViewById(R.id.vatdialog_close);
        imageButton.setOnClickListener(v -> {
            Dialog.dismiss();
        });
    }
    public void initadd(String a){
        ComplianceApplicationService complianceApplicationService=new ComplianceApplicationServiceImp(ConsumptionActivity.this);
        complianceApplicationService.addComplianceApplication(a);
    }
    public void initfindall(){
        ComplianceApplicationService complianceApplicationService=new ComplianceApplicationServiceImp(ConsumptionActivity.this);
        complianceApplicationService.FindAllComplianceApplication();
    }
    public void showfindAllBack(ComplianceApplication[] json){
        List<ComplianceApplication> complianceApplications = new ArrayList<>();
        if (json != null) {
            for (ComplianceApplication complianceApplication : json) {
                complianceApplications.add(complianceApplication);
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在主线程中更新UI
                ComplianceApplicationAdapter complianceApplicationAdapter=new ComplianceApplicationAdapter(ConsumptionActivity.this,complianceApplications);
                recyclerView.setAdapter(complianceApplicationAdapter);
                complianceApplicationAdapter.notifyDataSetChanged();
            }
        });
    }

}