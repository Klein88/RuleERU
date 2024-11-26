package zjc.edu.view.activity.EPR;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import org.json.JSONException;
import org.json.JSONObject;

import zjc.edu.R;
import zjc.edu.model.EPR.EPRDeclaration;
import zjc.edu.model.EPR.PackagingSummaryDeclaration;
import zjc.edu.service.imp.EPR.EPRDeclarationServiceImp;
import zjc.edu.service.imp.EPR.PackageSummaryServiceImp;
import zjc.edu.service.main.EPR.EPRDeclarationService;
import zjc.edu.service.main.EPR.PackageSummaryService;

import java.util.Objects;

public class EPRDeclareActivity extends AppCompatActivity {
    private int j;
    private int k;
    String sum="";
//    private ActivityEprDeclareBinding binding;
    private String column1;
    private String column2;
    private String column3;
    EPRDeclaration data;
    private EditText eprdeclare_id;
    private EditText eprdeclare_brand;
    private EditText eprdeclare_year;
    private String value_rg;
    private Toolbar Tleprshenbao;
    private PackagingSummaryDeclaration[] packagingSummaryDeclaration=new PackagingSummaryDeclaration[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epr_declare);
//        binding=ActivityEprDeclareBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
        //绑定控件
        ImageButton epradd = findViewById(R.id.eprdeclare_addrow);
        Button eprdeclare = findViewById(R.id.eprdeclare_btn);
        eprdeclare_id=findViewById(R.id.eprdeclare_id);
        eprdeclare_brand=findViewById(R.id.eprdeclare_brand);
        Tleprshenbao=findViewById(R.id.Tleprshenbao);
        eprdeclare_year=findViewById(R.id.eprdeclare_year);
        //得到上一个界面传递的RgNumber
        Intent intent=getIntent();
        value_rg=intent.getStringExtra("Rgnumber");
        initfindbyrgnumber(value_rg);
        //toolbar
        setSupportActionBar(Tleprshenbao);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //增加表格数据按钮事件
        epradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog();
            }
        });
        //提交按钮事件
        eprdeclare.setOnClickListener(v -> {
            int year=0;
            try {
                year= Integer.parseInt(eprdeclare_year.getText().toString());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            int finalYear = year;
            for (int i=0;i<k;i++){
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("registrationcode",packagingSummaryDeclaration[i].getRegistrationcode());
                    jsonObject.put("declarationyear", finalYear);
                    jsonObject.put("brandname",packagingSummaryDeclaration[i].getBrandname());
                    jsonObject.put("declarationdataserialnumber",i+1);
                    jsonObject.put("packagingmaterial",packagingSummaryDeclaration[i].getPackagingmaterial());
                    jsonObject.put("predeclaredweight",packagingSummaryDeclaration[i].getPredeclaredweight());
                    jsonObject.put("actualpackagingweight",packagingSummaryDeclaration[i].getActualpackagingweight());
                    jsonObject.put("eprdeclarationid",data.getEprdeclarationid());
                    initadd(jsonObject.toString());
                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Intent intent1=new Intent(this,ShenBaoEPRActivity.class);
            startActivity(intent1);
        });
    }
    //toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(this, ShenBaoEPRActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //add按钮弹窗
    private void Dialog() {
        View View = LayoutInflater.from(this).inflate(R.layout.eprdeclare_addrow, null);
        AlertDialog EPRAddDialog = new AlertDialog.Builder(this).setView(View).setCancelable(false).create();
        EPRAddDialog.show();
        Objects.requireNonNull(EPRAddDialog.getWindow()).setBackgroundDrawableResource(R.color.transparent);
        ImageButton imageButton = View.findViewById(R.id.epr_close);
        EditText editText1 = View.findViewById(R.id.epr_material);
        EditText editText2 = View.findViewById(R.id.epr_estimate);
        EditText editText3 = View.findViewById(R.id.epr_actual);
        Button button = View.findViewById(R.id.eprdeclare_addbtn);
        button.setOnClickListener(v -> {
            k++;
            column1=editText1.getText().toString();
            column2=editText2.getText().toString();
            column3=editText3.getText().toString();
            float floatcolumn2=0;
            float floatcolumn3=0;
            try {
                floatcolumn2 = Float.parseFloat(column2);
                floatcolumn3= Float.parseFloat(column3);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            packagingSummaryDeclaration[k-1]=new PackagingSummaryDeclaration();
            packagingSummaryDeclaration[k-1].setBrandname(eprdeclare_brand.getText().toString());
            packagingSummaryDeclaration[k-1].setRegistrationcode(eprdeclare_id.getText().toString());
            packagingSummaryDeclaration[k-1].setPackagingmaterial(column1);
            packagingSummaryDeclaration[k-1].setPredeclaredweight(floatcolumn2);
            packagingSummaryDeclaration[k-1].setActualpackagingweight(floatcolumn3);
            TableLayout tableLayout = findViewById(R.id.tb_layout);
            TableRow tableRow = new TableRow(getApplicationContext());
            tableLayout.addView(tableRow);
            for(int i=1;i<=4;i++){
                j++;
                TextView textView = new TextView(getApplicationContext());
                textView.setId(j);
                textView.setBackgroundColor(Color.argb(255,255,255,255));
                switch (i){
                    case 1:
                        textView.setText(String.valueOf(k));
                        textView.setHeight(100);
                        textView.setGravity(Gravity.CENTER_VERTICAL);
                        TableRow.LayoutParams layoutParams1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                        layoutParams1.setMargins(5,0,2,5);//4个参数按顺序分别是左上右下
                        textView.setLayoutParams(layoutParams1);
                        tableRow.addView(textView);
                        break;
                    case 2:
                        textView.setText(column1);
                        textView.setHeight(100);
                        textView.setGravity(Gravity.CENTER_VERTICAL);
                        TableRow.LayoutParams layoutParams2 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                        layoutParams2.setMargins(2,0,2,5);//4个参数按顺序分别是左上右下
                        textView.setLayoutParams(layoutParams2);
                        tableRow.addView(textView);
                        break;
                    case 3:
                        textView.setText(column2);
                        textView.setHeight(100);
                        textView.setGravity(Gravity.CENTER_VERTICAL);
                        TableRow.LayoutParams layoutParams3 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                        layoutParams3.setMargins(2,0,2,5);//4个参数按顺序分别是左上右下
                        textView.setLayoutParams(layoutParams3);
                        tableRow.addView(textView);
                        break;
                    case 4:
                        textView.setText(column3);
                        textView.setHeight(100);
                        textView.setGravity(Gravity.CENTER_VERTICAL);
                        TableRow.LayoutParams layoutParams4 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                        layoutParams4.setMargins(2,0,5,5);//4个参数按顺序分别是左上右下
                        textView.setLayoutParams(layoutParams4);
                        tableRow.addView(textView);
                        break;
                    default:
                        break;
                }
            }
            EPRAddDialog.dismiss();
        });
        imageButton.setOnClickListener(v -> {
            EPRAddDialog.dismiss();
        });
    }
    //注入findby
    public void initfindbyrgnumber(String a){
        EPRDeclarationService eprDeclarationService=new EPRDeclarationServiceImp(EPRDeclareActivity.this);
        eprDeclarationService.findEPRDeclaretionByRgNumber(a);
    }
    //findby 回调
    public void showFindByRgNumberBack(EPRDeclaration Json){
         this.data=Json;
        eprdeclare_id.setText(data.getRegistrationnumber().toString());
        eprdeclare_brand.setText(data.getBrandenglishname().toString());
    }
    //add方法
    public void initadd(String a){
        PackageSummaryService packageSummaryService=new PackageSummaryServiceImp(EPRDeclareActivity.this);
        packageSummaryService.addPackageSummary(a);
    }
}