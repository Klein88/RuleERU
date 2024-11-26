package zjc.edu.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.VerifiedInputEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import zjc.edu.R;
import zjc.edu.model.TransResultBean;
import zjc.edu.service.imp.TestServiceImp;
import zjc.edu.service.main.TestService;
import zjc.edu.util.MyScrollView;
import zjc.edu.util.Search_QA;
import zjc.edu.util.SpinnerStateManager;
import zjc.edu.view.activity.Learn.LearndeclareActivity;
import zjc.edu.view.activity.Learn.Search_Result;
import zjc.edu.view.activity.Learn.train_laws;
import zjc.edu.view.activity.Learn.train_main;
import zjc.edu.view.activity.Learn.train_market;
import zjc.edu.view.activity.Learn.train_other;


public class LearnFragment extends Fragment {
    Search_QA search = new Search_QA();
    private LinearLayout linearLayout;
    private View learn_fragment;
    private Button shenbao;
    private Button shichang;
    private Button qita;
    private Button fagui;
    private Button translate;
    private EditText from;
    private EditText to;
    private int to_data;
    private int from_data;
    private Spinner spinnerfrom;
    private Spinner spinnerto;
    private String input;
    private String value;
    String la_from;
    String la_to;
    EditText editText;
    ImageView imageView;


    public LearnFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        learn_fragment=inflater.inflate(R.layout.fragment_learn, container, false);
        //绑定控件
        shenbao=learn_fragment.findViewById(R.id.shenbao);
        from=learn_fragment.findViewById(R.id.ed_content1);
        to=learn_fragment.findViewById(R.id.ed_content2);
        translate=learn_fragment.findViewById(R.id.btn_translate);
        spinnerfrom=learn_fragment.findViewById(R.id.sp1);
        spinnerto=learn_fragment.findViewById(R.id.sp2);
        editText=learn_fragment.findViewById(R.id.train_search);
        imageView=learn_fragment.findViewById(R.id.train_searchimg);
        linearLayout=learn_fragment.findViewById(R.id.train_mainlinear);
        shichang=learn_fragment.findViewById(R.id.shichang);
        qita=learn_fragment.findViewById(R.id.qita);
        fagui=learn_fragment.findViewById(R.id.fagui);
        //spinner
        spinnerfrom.setSelection(SpinnerStateManager.getInstance().getLastSelectedPosition_from());
        spinnerto.setSelection(SpinnerStateManager.getInstance().getLastSelectedPosition_to());
        //
        shenbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LearndeclareActivity.class);
                startActivity(intent);
            }
        });
        shichang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), train_market.class);
                startActivity(intent);
            }
        });
        qita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), train_other.class);
                startActivity(intent);
            }
        });
        fagui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), train_laws.class);
                startActivity(intent);
            }
        });
        //翻译
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] spinnerOptions = getResources().getStringArray(R.array.translate);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, spinnerOptions);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerfrom.setAdapter(adapter);
                //得到Spinner选项
                spinnerfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        from_data=position;
                        if (SpinnerStateManager.getInstance().getLastSelectedPosition_from() != position) {
                            // 处理选择项的逻辑

                            // 更新上一次选择的位置
                            SpinnerStateManager.getInstance().setLastSelectedPosition_from(position);
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO
                    }
                });
                spinnerto.setAdapter(adapter);
                spinnerto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        to_data=position;
                        if (SpinnerStateManager.getInstance().getLastSelectedPosition_to() != position) {
                            // 处理选择项的逻辑

                            // 更新上一次选择的位置
                            SpinnerStateManager.getInstance().setLastSelectedPosition_to(position);
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // TODO
                    }
                });
                input=from.getText().toString();
                initTranslate(input,from_data,to_data);
            }
        });
        //跳转到搜索结果
        imageView.setOnClickListener(v -> {
            Intent search = new Intent(getActivity(), Search_Result.class);
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
        //返回视图
        return learn_fragment;
    }
    public void showtranslateBack(List<TransResultBean> json){
        value= json.get(0).getDst();
        to.setText(value);
    }
    public void initTranslate(String a,int from,int to){
        TestService testService=new TestServiceImp(LearnFragment.this);
        testService.fanyi(a,from,to);
    }
    //根据随机生成的参数，生成自定义控件
    private void Show_QA(int j){
        LinearLayout linearLayout1 = new LinearLayout(getContext());
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        TextView textView = new TextView(getContext());
        ImageView imageView = new ImageView(getContext());
        MyScrollView myscrollView = new MyScrollView(getContext());
        TextView textView1 = new TextView(getContext());
        LinearLayout.LayoutParams param_linear1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams param_linear2 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        param_linear1.height = 500;
        param_linear1.setMargins(0,30,0,0);
        param_linear2.height = 150;
        linearLayout1.setLayoutParams(param_linear1);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.setPadding(10,10,10,10);
        linearLayout1.setBackground(getResources().getDrawable(R.drawable.frame_gray2));
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
        imageView.setBackground(getResources().getDrawable(R.drawable.quest));
        imageView.setLayoutParams(layoutParams1);
        textView.setText(search.list_q.get(j));
        textView.setTextSize(16);
        textView.setMaxEms(17);
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textView1.setText(search.list_a.get(j));
        myscrollView.setBackground(getResources().getDrawable(R.drawable.frame_white));
        myscrollView.addView(textView1);
        myscrollView.setLayoutParams(layoutParams2);
        linearLayout2.addView(imageView);
        linearLayout2.addView(textView);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout1.addView(myscrollView);
        textView.setGravity(Gravity.CENTER);
    }
}