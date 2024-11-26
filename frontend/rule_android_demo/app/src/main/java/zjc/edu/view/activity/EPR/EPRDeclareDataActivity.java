package zjc.edu.view.activity.EPR;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import zjc.edu.R;
import zjc.edu.model.EPR.EPRDeclaration;
import zjc.edu.model.EPR.PackagingSummaryDeclaration;
import zjc.edu.model.VAT.TaxPayment;
import zjc.edu.service.imp.EPR.EPRDeclarationServiceImp;
import zjc.edu.service.imp.EPR.PackageSummaryServiceImp;
import zjc.edu.service.main.EPR.EPRDeclarationService;
import zjc.edu.service.main.EPR.PackageSummaryService;

public class EPRDeclareDataActivity extends AppCompatActivity {
    private int lenth;
    private int k=0;
    private int j;
    private String column1;
    private String column2;
    private String column3;
    String value;
    String valueRg;
    private Toolbar toolbar;
    private EditText eprdeclare_id;
    private EditText eprdeclare_year;
    private EditText eprdeclare_brand;
    EPRDeclaration data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eprdeclare_data);
        //绑定控件
        toolbar=findViewById(R.id.Tleprshenbao_data);
        eprdeclare_id=findViewById(R.id.eprdeclare_id);
        eprdeclare_year=findViewById(R.id.eprdeclare_year);
        eprdeclare_brand=findViewById(R.id.eprdeclare_brand);
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //得到数据
        Intent intent=getIntent();
        value=intent.getStringExtra("id");
        valueRg=intent.getStringExtra("Rgnumber");
        Log.i("valueid",value);
        initFind(value);
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
    //数据注入回调
    public void showFindByIDBack(PackagingSummaryDeclaration[] json){
           List<PackagingSummaryDeclaration> PackDatatList = new ArrayList<>();
           if (json != null) {
               for (PackagingSummaryDeclaration packagingSummaryDeclaration : json) {
                   PackDatatList.add(packagingSummaryDeclaration);
               }
           }
           if (PackDatatList != null && PackDatatList.size() > 0){
               PackagingSummaryDeclaration a=PackDatatList.get(0);
               eprdeclare_id.setText(a.getRegistrationcode());
               eprdeclare_year.setText(String.valueOf(a.getDeclarationyear()));
               eprdeclare_brand.setText(String.valueOf(a.getBrandname()));
               lenth=PackDatatList.size();
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       for (int h=1;h<=lenth;h++){
                           k++;
                           TableLayout tableLayout = findViewById(R.id.tb_layout);
                           TableRow tableRow = new TableRow(getApplicationContext());
                           tableLayout.addView(tableRow);
                           PackagingSummaryDeclaration item=PackDatatList.get(h-1);
                           column1=item.getPackagingmaterial().toString();
                           column2=String.valueOf(item.getPredeclaredweight());
                           column3=String.valueOf(item.getActualpackagingweight());
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
                       }
                   }
               });
           } else {
           EPRDeclarationService eprDeclarationService=new EPRDeclarationServiceImp(EPRDeclareDataActivity.this);
           eprDeclarationService.findEPRDeclaretionByRgNumbernew(valueRg);
       }
    }
    //数据注入
    public void initFind(String a){
        PackageSummaryService packageSummaryService=new PackageSummaryServiceImp(EPRDeclareDataActivity.this);
        packageSummaryService.findPackageSummaryByID(a);
    }
    public void showFindByRgNumberBack(EPRDeclaration Json){
        this.data=Json;
        eprdeclare_id.setText(data.getRegistrationnumber().toString());
        eprdeclare_brand.setText(data.getBrandenglishname().toString());
    }
}