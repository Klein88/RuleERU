package zjc.edu.view.activity.EPR;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import zjc.edu.R;
import zjc.edu.model.EPR.EPRService;
import zjc.edu.model.EPR.SharedEPRViewModel;
import zjc.edu.service.main.EPR.EPRserviceService;
import zjc.edu.service.imp.EPR.EPRserviceServiceImp;
import zjc.edu.view.activity.MainActivity;
import zjc.edu.view.adapter.EPRAdapter;

public class EnvironmentActivity extends AppCompatActivity {
    private String selectedOptionText;
    private SharedEPRViewModel sharedEPRViewModel;
    private EPRAdapter eprAdapter;
    private RecyclerView recyclerView_epr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment);
        Toolbar toolbar = findViewById(R.id.Tl_4);
        ImageButton add = findViewById(R.id.addButton);
        Button declare = findViewById(R.id.EPR_declare);
        Button pay = findViewById(R.id.EPR_Payment);
        recyclerView_epr=findViewById(R.id.recycleview_epr);
        //recyclerview
        recyclerView_epr.setLayoutManager(new LinearLayoutManager(EnvironmentActivity.this));
        initFindAll();
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //申报功能
        declare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EnvironmentActivity.this, ShenBaoEPRActivity.class);
                startActivity(intent);
            }
        });
        //缴费功能
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EnvironmentActivity.this,EPRPaymentActivity.class);
                startActivity(intent);
            }
        });
        //加号按钮 增加eprservice
        add.setOnClickListener(v -> {
            Dialog();
        });
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
    private void Dialog() {
        View View = LayoutInflater.from(this).inflate(R.layout.activity_epr_add, null);
        AlertDialog selectDialog = new AlertDialog.Builder(this).setView(View).setCancelable(false).create();
        selectDialog.show();
        Window window = selectDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        Objects.requireNonNull(selectDialog.getWindow()).setBackgroundDrawableResource(R.color.transparent);
        EditText epradd_cname=View.findViewById(R.id.epradd_cname);
        EditText epradd_cregister=View.findViewById(R.id.epradd_cregister);
        TextView epradd_ctype=View.findViewById(R.id.epradd_ctype);
        EditText epradd_count=View.findViewById(R.id.epradd_count);
        RadioGroup radiogroup_epr=View.findViewById(R.id.radiogroup_epr);
        //查询RadioButton选中的国家
        radiogroup_epr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedRadioButtonId = radiogroup_epr.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = View.findViewById(radiogroup_epr.getCheckedRadioButtonId());
                    //得到radiobutton的text属性
                    selectedOptionText = selectedRadioButton.getText().toString();
                    Log.i("radioselect",selectedOptionText);
                }
            }
        });
        //关闭界面按钮点击事件
        ImageButton imageButton = View.findViewById(R.id.vatdialog_close);
        imageButton.setOnClickListener(v -> {
            selectDialog.dismiss();
        });
        //提交按钮点击事件
        Button button = View.findViewById(R.id.epradd_btn);
        button.setOnClickListener(v -> {
            JSONObject jsonData = new JSONObject();
            try {
                jsonData.put("companyname",epradd_cname.getText().toString());
                jsonData.put("registrationnumber",epradd_cregister.getText().toString());
                jsonData.put("servicetype",epradd_ctype.getText().toString());
                jsonData.put("servicesummit",Integer.parseInt(epradd_count.getText().toString()));
                jsonData.put("country",selectedOptionText);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            initAddService(jsonData.toString());
            selectDialog.dismiss();
            Toast.makeText(this,"提交成功",Toast.LENGTH_LONG).show();
        });
    }

    public void initFindAll(){
        EPRserviceService epRserviceService=new EPRserviceServiceImp(this);
        epRserviceService.findAllEPRService();
    }

    public void showFindAllBack(EPRService[] JsonFromEPR){
        List<EPRService> EprServiceList = new ArrayList<>();
        if (JsonFromEPR != null) {
            for (EPRService eprService : JsonFromEPR) {
                EprServiceList.add(eprService);
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                eprAdapter=new EPRAdapter(EnvironmentActivity.this,EprServiceList);
                recyclerView_epr.setAdapter(eprAdapter);
                eprAdapter.notifyDataSetChanged();
            }
        });
    }
    public void initAddService(String json){
        EPRserviceService epRserviceService=new EPRserviceServiceImp(this);
        epRserviceService.AddEPRService(json);
    }
}