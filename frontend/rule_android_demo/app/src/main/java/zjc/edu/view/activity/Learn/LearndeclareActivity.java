package zjc.edu.view.activity.Learn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import lombok.experimental.Tolerate;
import zjc.edu.R;
import zjc.edu.view.activity.EPR.ShenBaoEPRActivity;
import zjc.edu.view.activity.MainActivity;

public class LearndeclareActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button vat_encyclopedia_btn3;
    private Button vat_encyclopedia_btn4;
    private Button vat_encyclopedia_btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learndeclare);
        //绑定控件
        toolbar=findViewById(R.id.Tl_learndeclare);
        vat_encyclopedia_btn3=findViewById(R.id.vat_encyclopedia_btn3);
        vat_encyclopedia_btn4=findViewById(R.id.vat_encyclopedia_btn4);
        vat_encyclopedia_btn5=findViewById(R.id.vat_encyclopedia_btn5);
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        vat_encyclopedia_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LearndeclareActivity.this,LearnVATIntroduceActivity.class);
                startActivity(intent);
            }
        });
        vat_encyclopedia_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LearndeclareActivity.this,LearnEPRIntroduceActivity.class);
                startActivity(intent);
            }
        });
        vat_encyclopedia_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LearndeclareActivity.this,LearnComplianceIntroduceActivity.class);
                startActivity(intent);
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
}