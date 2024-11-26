package zjc.edu.view.activity;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import zjc.edu.R;
import zjc.edu.model.DateViewModel;
import zjc.edu.service.imp.ComplianceApplicationServiceImp;
import zjc.edu.service.main.ComplianceApplicationService;
import zjc.edu.util.DateConverter;

public class ConsumptionActivity_Edit extends AppCompatActivity {

    private Toolbar toolbar;
    private Button tijiao;
    private EditText doc_manufacturer;
    private EditText doc_address;
    private  EditText doc_authorization;
    private EditText doc_id;
    private EditText doc_type;
    private EditText doc_liability;
    private EditText doc_means;
    private EditText doc_institution;
    private EditText doc_standard;
    private EditText Signer_name;
    private TextView doc_date;
    private EditText doc_supplement;
    private EditText doc_importer;
    private EditText doc_translation;
    private Button doc_btn;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumption_edit);
        //绑定控件
        toolbar = findViewById(R.id.Tl_con);
        tijiao=findViewById(R.id.doc_submit);
        doc_manufacturer=findViewById(R.id.doc_manufacturer);
        doc_address=findViewById(R.id.doc_address);
        doc_authorization=findViewById(R.id.doc_authorization);
        doc_id=findViewById(R.id.doc_id);
        doc_type=findViewById(R.id.doc_type);
        doc_liability=findViewById(R.id.doc_liability);
        doc_means=findViewById(R.id.doc_means);
        doc_institution=findViewById(R.id.doc_institution);
        doc_standard=findViewById(R.id.doc_standard);
        Signer_name=findViewById(R.id.Signer_name);
        doc_date=findViewById(R.id.doc_date);
        doc_supplement=findViewById(R.id.doc_supplement);
        doc_importer=findViewById(R.id.doc_importer);
        doc_translation=findViewById(R.id.doc_translation);
        doc_btn=findViewById(R.id.doc_btn);
        imageView1=findViewById(R.id.doc_identify);
        imageView2=findViewById(R.id.Signer_image);
        imageView3=findViewById(R.id.doc_product);
        imageView1.setOnClickListener(v -> {
            openGallery(1);
        });
        imageView2.setOnClickListener(v -> {
            openGallery(2);
        });
        imageView3.setOnClickListener(v -> {
            openGallery(3);
        });
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //日历选择
        doc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        //提交按钮事件
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        int intid = 0;
        try {
            intid=Integer.parseInt(id);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        int finalIntid = intid;
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String riqi=null;
                try {
                    riqi= DateConverter.convertStringToFormattedDate(doc_date.getText().toString());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("manufacturername",doc_manufacturer.getText().toString());
                    jsonObject.put("businessaddress",doc_address.getText().toString());
                    jsonObject.put("authorizedrepresentative",doc_authorization.getText().toString());
                    jsonObject.put("productserialnumber",doc_id.getText().toString());
                    jsonObject.put("modelortypeidentification",doc_type.getText().toString());
                    jsonObject.put("responsibilitystatement",doc_liability.getText().toString());
                    jsonObject.put("productidentification",doc_means.getText().toString());
                    jsonObject.put("notifiedbodydetails",doc_institution.getText().toString());
                    jsonObject.put("legislationandstandards",doc_standard.getText().toString());
                    jsonObject.put("signatoryname",Signer_name.getText().toString());
                    jsonObject.put("declarationdate",riqi);
                    jsonObject.put("supplementaryinformation",doc_supplement.getText().toString());
                    jsonObject.put("importerresponsibility",doc_importer.getText().toString());
                    jsonObject.put("translationrequirement",doc_translation.getText().toString());
//                    jsonObject.put("signatorysignature",);
//                    jsonObject.put("productimage",);
                    jsonObject.put("applicationid",finalIntid);
                }catch (JSONException e){
                    e.printStackTrace();
                }
//                initadd(jsonObject.toString());
                Intent intent1=new Intent(ConsumptionActivity_Edit.this,ConsumptionActivity.class);
                startActivity(intent1);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent = new Intent(this, ConsumptionActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //日期选择
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                ConsumptionActivity_Edit.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // 处理用户选择的日期
                        String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                        doc_date.setText(selectedDate);
                    }
                },
                year, month, day
        );

        datePickerDialog.show();
    }
    //数据保存
    // 添加方法
    public void initadd(String a){
        ComplianceApplicationService complianceApplicationService=new ComplianceApplicationServiceImp(ConsumptionActivity_Edit.this);
        complianceApplicationService.addEU(a);
    }
    private void openGallery(int type) {
        Intent gallery = new Intent(Intent.ACTION_PICK);
        gallery.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(gallery, type);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bitmap bitmap;
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //上传图片到对应组件
            switch (requestCode){
                case 1:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView1);
                    break;
                case 2:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView2);
                    break;
                case 3:
                    Glide.with(this).load(data.getData()).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView3);
                    break;
                default:
                    break;
            }
        }

    }
}