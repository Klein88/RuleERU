package zjc.edu.view.activity.Learn;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Random;

import zjc.edu.R;
import zjc.edu.util.MyScrollView;
import zjc.edu.util.Search_QA;


public class train_main extends AppCompatActivity {
    Search_QA search = new Search_QA();
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_main);
        EditText editText=findViewById(R.id.train_search);
        ImageView imageView=findViewById(R.id.train_searchimg);
        imageView.setOnClickListener(v -> {
            Intent search = new Intent(train_main.this,Search_Result.class);
            search.putExtra("data",editText.getText().toString());
            startActivity(search);
        });
        //初始化数据
        search.Data();
        //利用哈希集合使随机数不重复
        HashSet<Integer> set = new HashSet<>();
        Random ra = new Random();
        do {
            int r = ra.nextInt(37);
            set.add(r);
        } while (set.size()<6);
        for (int i : set){
            Show_QA(i);
        }
    }
    //根据随机生成的参数，生成自定义控件
    private void Show_QA(int j){
        linearLayout=findViewById(R.id.train_mainlinear);
        LinearLayout linearLayout1 = new LinearLayout(getApplicationContext());
        LinearLayout linearLayout2 = new LinearLayout(getApplicationContext());
        TextView textView = new TextView(getApplicationContext());
        ImageView imageView = new ImageView(getApplicationContext());
        MyScrollView myscrollView = new MyScrollView(getApplicationContext());
        TextView textView1 = new TextView(getApplicationContext());
        LinearLayout.LayoutParams param_linear1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams param_linear2 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        param_linear1.height = 500;
        param_linear1.setMargins(0,30,0,0);
        param_linear2.height = 150;
        linearLayout1.setLayoutParams(param_linear1);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.setPadding(10,10,10,10);
        linearLayout1.setBackground(getDrawable(R.drawable.frame_gray2));
        linearLayout.addView(linearLayout1);
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout2.setLayoutParams(param_linear2);
        linearLayout2.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout1.addView(linearLayout2);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams1.setMargins(40,0,0,0);
        layoutParams2.setMargins(40,20,40,10);
        layoutParams2.height = 280;
        imageView.setBackground(getDrawable(R.drawable.quest));
        imageView.setLayoutParams(layoutParams1);
        textView.setText(search.list_q.get(j));
        textView.setTextSize(16);
        textView.setMaxEms(17);
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textView1.setText(search.list_a.get(j));
        myscrollView.setBackground(getDrawable(R.drawable.frame_white));
        myscrollView.addView(textView1);
        myscrollView.setLayoutParams(layoutParams2);
        linearLayout2.addView(imageView);
        linearLayout2.addView(textView);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout1.addView(myscrollView);
        textView.setGravity(Gravity.CENTER);
    }
}
