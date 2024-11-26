package zjc.edu.view.activity.Privacy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import java.util.Objects;

import zjc.edu.R;
import zjc.edu.view.activity.MainActivity;

public class PrivacyActivity extends AppCompatActivity {
    private Button privacy_1;
    private Toolbar toolbar;
    private CardView cardView;
    private ImageButton img_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        //绑定控件
        privacy_1=findViewById(R.id.privacy_1);
        toolbar=findViewById(R.id.Tl_privacy);
        cardView=findViewById(R.id.card_click);
        img_1=findViewById(R.id.img_1);
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        privacy_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogshow();
            }
        });
        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PrivacyActivity.this,PrivacyActivity_1.class);
                startActivity(intent);
            }
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
    public void Dialogshow(){
        View View = LayoutInflater.from(this).inflate(R.layout.dialog_privacy, null);
        AlertDialog selectDialog = new AlertDialog.Builder(this).setView(View).setCancelable(false).create();
        selectDialog.show();
        Window window = selectDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        Objects.requireNonNull(selectDialog.getWindow()).setBackgroundDrawableResource(R.color.transparent);
        //关闭界面按钮点击事件
        ImageButton imageButton = View.findViewById(R.id.vatdialog_close);
        imageButton.setOnClickListener(v -> {
            selectDialog.dismiss();
        });
    }
}