package zjc.edu.view.activity;



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
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import zjc.edu.R;
import zjc.edu.model.WorkOrders;
import zjc.edu.service.main.WorkOrderService;
import zjc.edu.service.imp.WorkOrderServiceImp;
import zjc.edu.util.DateConverter;
import zjc.edu.view.adapter.WorkOrderAdapter;

public class WordOrderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_order);
        btn=findViewById(R.id.add_workorder);
        //标题
        toolbar = findViewById(R.id.Tl_1);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //工单列表
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogshow();
            }
        });
        recyclerView=findViewById(R.id.Rv_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(WordOrderActivity.this));
        initWorkOrderData();

    }

    public void initWorkOrderData(){
        WorkOrderService workOrderService=new WorkOrderServiceImp(this);
        workOrderService.findAllWorkorder();
    }




    //回界面按钮启用
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





    public void showAllWorkOrderCallback(WorkOrders[] workOrderFromJson){
        Log.i("callback123",workOrderFromJson.toString());
        List<WorkOrders> workOrderList = new ArrayList<>();
        if (workOrderFromJson != null) {
            for (WorkOrders workOrder : workOrderFromJson) {
                workOrderList.add(workOrder);
            }
        }
        Log.i("callback123",String.valueOf(workOrderList));
        Log.i("date123",String.valueOf(workOrderList.get(0).getWorkorderid()));
        Log.i("date123",String.valueOf(workOrderList.get(0).getStatus()));
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在主线程中更新UI
                WorkOrderAdapter workOrderAdapter=new WorkOrderAdapter(WordOrderActivity.this,workOrderList);
                recyclerView.setAdapter(workOrderAdapter);
                workOrderAdapter.notifyDataSetChanged();
            }
        });

//        WorkOrderAdapter workOrderAdapter=new WorkOrderAdapter(this,workOrderList);
//        recyclerView.setAdapter(workOrderAdapter);
//        workOrderAdapter.notifyDataSetChanged();
    }
    public void dialogshow(){
        View View = LayoutInflater.from(this).inflate(R.layout.dialog_ask, null);
        AlertDialog selectDialog = new AlertDialog.Builder(this).setView(View).setCancelable(false).create();
        selectDialog.show();
        Window window = selectDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        Objects.requireNonNull(selectDialog.getWindow()).setBackgroundDrawableResource(R.color.transparent);
        EditText question=View.findViewById(R.id.question);
        Button add=View.findViewById(R.id.add);
        //关闭界面按钮点击事件
        ImageButton imageButton = View.findViewById(R.id.close);
        imageButton.setOnClickListener(v -> {
            selectDialog.dismiss();
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                // 获取当前日期
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1; // 月份从0开始，所以要加1
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                String today=year + "-" + month + "-" + day;
                String UTCtoday=null;
                try {
                    UTCtoday=DateConverter.convertStringToFormattedDate(today);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("userid",1);
                    jsonObject.put("status","处理中");
                    jsonObject.put("workordertheme",question.getText());
                    jsonObject.put("creationdate",UTCtoday);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                initadd(jsonObject.toString());
                selectDialog.dismiss();
                Toast.makeText(WordOrderActivity.this,"添加成功",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void initadd(String a){
        WorkOrderService workOrderService=new WorkOrderServiceImp(this);
        workOrderService.AddWorkOrder(a);
    }

}