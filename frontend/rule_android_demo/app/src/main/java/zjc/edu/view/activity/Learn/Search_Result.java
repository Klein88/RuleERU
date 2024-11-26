package zjc.edu.view.activity.Learn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import zjc.edu.service.main.FilterListener;
import zjc.edu.R;
import zjc.edu.util.MyScrollView;
import zjc.edu.util.Search_QA;
import zjc.edu.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class Search_Result extends AppCompatActivity implements Filterable {
    Search_QA search = new Search_QA();
    private List<String> list = search.list_q;
    private Toolbar toolbar;
    List<String> AnswerList = new ArrayList<String>();
    private MyFilter filter = null;// 创建MyFilter对象
    private FilterListener listener = null;// 接口对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        toolbar=findViewById(R.id.search_titlebar);
        Intent intent = getIntent();
        //获取传递的值
        String str = intent.getStringExtra("data");
        //设置值
        toolbar.setTitle(str+"的搜索结果");
        search.Data();
        getFilter().filter(str);
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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
    @Override
    public Filter getFilter() {
        // 如果MyFilter对象为空，那么重写创建一个
        if (filter == null) {
            filter = new MyFilter(list);
        }
        return filter;
    }
    class MyFilter extends Filter {

        // 创建集合保存原始数据
        private List<String> original = new ArrayList<String>();

        public MyFilter(List<String> list) {
            this.original = list;
        }

        /**
         * 该方法返回搜索过滤后的数据
         */
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // 创建FilterResults对象
            FilterResults results = new FilterResults();
            // 创建集合保存过滤后的数据
            List<String> mList = new ArrayList<String>();
            // 遍历原始数据集合，根据搜索的规则过滤数据
            for(String s: original){
                // 这里就是过滤规则的具体实现【规则有很多，大家可以自己决定怎么实现】
                if(s.trim().toLowerCase().contains(constraint.toString().trim().toLowerCase())){
                    // 规则匹配的话就往集合中添加该数据
                    mList.add(s);
                    AnswerList.add(search.list_a.get(original.indexOf(s)));
                }
            }
            results.values = mList;
            results.count = mList.size();

            // 返回FilterResults对象
            return results;
        }

        /**
         * 该方法用来刷新用户界面，根据过滤后的数据重新展示列表
         */
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // 获取过滤后的数据
            list = (List<String>) results.values;
            // 如果接口对象不为空，那么调用接口中的方法获取过滤后的数据，具体的实现在new这个接口的时候重写的方法里执行
            if(listener != null){
                listener.getFilterData(list);
            }
            for (int i=0;i<AnswerList.size();i++){
                Result_QA(i);
                Log.i("记录:",Integer.toString(AnswerList.size()));
            }
        }
    }
    private void Result_QA(int j){
        LinearLayout linearLayout=findViewById(R.id.search_resultlinear);
        LinearLayout linearLayout1 = new LinearLayout(getApplicationContext());
        LinearLayout linearLayout2 = new LinearLayout(getApplicationContext());
        TextView textView = new TextView(getApplicationContext());
        ImageView imageView = new ImageView(getApplicationContext());
        MyScrollView myscrollView = new MyScrollView(getApplicationContext());
        TextView textView1 = new TextView(getApplicationContext());
        LinearLayout.LayoutParams param_linear1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams param_linear2 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        param_linear1.height = 500;
        param_linear1.setMargins(40,30,40,0);
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
        textView.setText(list.get(j));
        textView.setTextSize(16);
        textView.setMaxEms(17);
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textView1.setText(AnswerList.get(j));
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