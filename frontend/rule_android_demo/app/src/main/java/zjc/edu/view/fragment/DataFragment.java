package zjc.edu.view.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import zjc.edu.R;
import zjc.edu.model.EPR.EPRService;
import zjc.edu.model.Food;
import zjc.edu.model.Huaxuepin;
import zjc.edu.model.Jixie;
import zjc.edu.model.Yuancailiao;
import zjc.edu.service.imp.DataServiceImp;
import zjc.edu.service.main.DataService;

public class DataFragment extends Fragment {
    private View Fragment_Data;
//    LineChart lineChart;
    private Spinner spinner1;
    private Spinner spinner2;
    private FrameLayout chartContainer;
    private TextView sp1;
    private TextView xiaoshou;
    private TextView shichang;
    private TextView jianyi;



    public DataFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Fragment_Data= inflater.inflate(R.layout.fragment_data, container, false);
//        lineChart =Fragment_Data.findViewById(R.id.lineChart);
        chartContainer=Fragment_Data.findViewById(R.id.chartContainer);
        spinner1=Fragment_Data.findViewById(R.id.spinner1);
        spinner2=Fragment_Data.findViewById(R.id.spinner2);
        sp1=Fragment_Data.findViewById(R.id.sp1);
        xiaoshou=Fragment_Data.findViewById(R.id.text_xiaoshou);
        shichang=Fragment_Data.findViewById(R.id.text_shichang);
        jianyi=Fragment_Data.findViewById(R.id.jianyi);
        // 设置图表类型的适配器和选项监听器
        ArrayAdapter<CharSequence> chartTypeAdapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.form,
                android.R.layout.simple_spinner_item
        );
        chartTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(chartTypeAdapter);

// 设置市场类型的适配器和选项监听器
        ArrayAdapter<CharSequence> marketTypeAdapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.shichang,
                android.R.layout.simple_spinner_item
        );
        marketTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(marketTypeAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sp1.setText(spinner2.getSelectedItem().toString()+"\n(亿欧元/月份)");
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return Fragment_Data;
    }
    public void initYuancailiao(int a){
        DataService dataService=new DataServiceImp(DataFragment.this);
        dataService.findyuancailiao(a);
    }
    public void showYuancailiaoBack(Yuancailiao[] json1,int a){
        List<Yuancailiao> YclList = new ArrayList<>();
        if (json1 != null) {
            for (Yuancailiao yuancailiao : json1) {
                YclList.add(yuancailiao);
            }
        }
        List<Entry> entries1 = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Yuancailiao item=YclList.get(i-1);
            float j = 0;
            try {
                j=Float.parseFloat(item.getImportamount());
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
            entries1.add(new Entry(i,j));
        }
        List<BarEntry> entries2 = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Yuancailiao item=YclList.get(i-1);
            float j = 0;
            try {
                j=Float.parseFloat(item.getImportamount());
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
            entries2.add(new BarEntry(i,j));
        }
        ArrayList<String> xAxisLabels = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Yuancailiao item=YclList.get(i-1);
            xAxisLabels.add(item.getDate());
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (a==0){
                    LineChart lineChart = createLineChart(entries1,xAxisLabels);
                    showChart(lineChart);
                }else {
                    BarChart barChart=createBarChart(entries2,xAxisLabels);
                    showChart(barChart);
                }
                double c=0;
                double zonge=224813.1;
                String value1 = null;
                String value2 = null;
                try {
                    Double d=Double.parseDouble(YclList.get(YclList.size()-1).getImportamount());
                    c=d-Double.parseDouble(YclList.get(YclList.size()-2).getImportamount());
                    c=c/Double.parseDouble(YclList.get(YclList.size()-2).getImportamount());
                    DecimalFormat decimalFormat = new DecimalFormat("#.######");
                    value1=decimalFormat.format(c);
                    value2=decimalFormat.format(d/zonge);
                }catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                xiaoshou.setText(value1+"%");
                shichang.setText(value2+"%");
                if (c>0.1){
                    jianyi.setText("此产品销售情况良好");
                }else if (c>0){
                    jianyi.setText("此产品起伏波动不大");
                }else {
                    jianyi.setText("此产品根据数据而言不太值得购买，请慎重考虑");
                }
            }
        });
    }
    public void initHuaxuepin(int a){
        DataService dataService=new DataServiceImp(DataFragment.this);
        dataService.findhuaxuepin(a);
    }
    public void showHuaxuepinBack(Huaxuepin[] json3,int a){
        List<Huaxuepin> YclList = new ArrayList<>();
        if (json3 != null) {
            for (Huaxuepin huaxuepin : json3) {
                YclList.add(huaxuepin);
            }
        }
        List<Entry> entries1 = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Huaxuepin item=YclList.get(i-1);
            float j = 0;
            try {
                j=Float.parseFloat(item.getImportamount());
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
            entries1.add(new Entry(i,j));
        }
        List<BarEntry> entries2 = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Huaxuepin item=YclList.get(i-1);
            float j = 0;
            try {
                j=Float.parseFloat(item.getImportamount());
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
            entries2.add(new BarEntry(i,j));
        }
        ArrayList<String> xAxisLabels = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Huaxuepin item=YclList.get(i-1);
            xAxisLabels.add(item.getDate());
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (a==0){
                    LineChart lineChart = createLineChart(entries1,xAxisLabels);
                    showChart(lineChart);
                }else {
                    BarChart barChart=createBarChart(entries2,xAxisLabels);
                    showChart(barChart);
                }
                double c=0;
                double zonge=224813.1;
                String value1 = null;
                String value2 = null;
                try {
                    Double d=Double.parseDouble(YclList.get(YclList.size()-1).getImportamount());
                    c=d-Double.parseDouble(YclList.get(YclList.size()-2).getImportamount());
                    c=c/Double.parseDouble(YclList.get(YclList.size()-2).getImportamount());
                    DecimalFormat decimalFormat = new DecimalFormat("#.######");
                    value1=decimalFormat.format(c);
                    value2=decimalFormat.format(d/zonge);
                }catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                xiaoshou.setText(value1+"%");
                shichang.setText(value2+"%");
                if (c>0.1){
                    jianyi.setText("此产品销售情况良好");
                }else if (c>0){
                    jianyi.setText("此产品起伏波动不大");
                }else {
                    jianyi.setText("此产品根据数据而言不太值得购买，请慎重考虑");
                }
            }
        });
    }
    public void initJixie(int a){
        DataService dataService=new DataServiceImp(DataFragment.this);
        dataService.findjixie(a);
    }
    public void showJixieBack(Jixie[] json2,int a){
        List<Jixie> YclList = new ArrayList<>();
        if (json2 != null) {
            for (Jixie jixie : json2) {
                YclList.add(jixie);
            }
        }
        List<Entry> entries1 = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Jixie item=YclList.get(i-1);
            float j = 0;
            try {
                j=Float.parseFloat(item.getImportamount());
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
            entries1.add(new Entry(i,j));
        }
        List<BarEntry> entries2 = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Jixie item=YclList.get(i-1);
            float j = 0;
            try {
                j=Float.parseFloat(item.getImportamount());
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
            entries2.add(new BarEntry(i,j));
        }
        ArrayList<String> xAxisLabels = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Jixie item=YclList.get(i-1);
            xAxisLabels.add(item.getDate());
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (a==0){
                    LineChart lineChart = createLineChart(entries1,xAxisLabels);
                    showChart(lineChart);
                }else {
                    BarChart barChart=createBarChart(entries2,xAxisLabels);
                    showChart(barChart);
                }
                double c=0;
                double zonge=224813.1;
                String value1 = null;
                String value2 = null;
                try {
                    Double d=Double.parseDouble(YclList.get(YclList.size()-1).getImportamount());
                    c=d-Double.parseDouble(YclList.get(YclList.size()-2).getImportamount());
                    c=c/Double.parseDouble(YclList.get(YclList.size()-2).getImportamount());
                    DecimalFormat decimalFormat = new DecimalFormat("#.######");
                    value1=decimalFormat.format(c);
                    value2=decimalFormat.format(d/zonge);
                }catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                xiaoshou.setText(value1+"%");
                shichang.setText(value2+"%");
                if (c>0.1){
                    jianyi.setText("此产品销售情况良好");
                }else if (c>0){
                    jianyi.setText("此产品起伏波动不大");
                }else {
                    jianyi.setText("此产品根据数据而言不太值得购买，请慎重考虑");
                }
            }
        });
    }
    public void initfood(int a){
        DataService dataService=new DataServiceImp(DataFragment.this);
        dataService.findfood(a);
    }
    public void showFoodBack(Food[] json4,int a){
        List<Food> YclList = new ArrayList<>();
        if (json4 != null) {
            for (Food food : json4) {
                YclList.add(food);
            }
        }
        List<Entry> entries1 = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Food item=YclList.get(i-1);
            float j = 0;
            try {
                j=Float.parseFloat(item.getImportamount());
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
            entries1.add(new Entry(i,j));
        }
        List<BarEntry> entries2 = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Food item=YclList.get(i-1);
            float j = 0;
            try {
                j=Float.parseFloat(item.getImportamount());
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
            entries2.add(new BarEntry(i,j));
        }
        ArrayList<String> xAxisLabels = new ArrayList<>();
        for (int i=1;i<=YclList.size();i++){
            Food item=YclList.get(i-1);
            xAxisLabels.add(item.getDate());
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (a==0){
                    LineChart lineChart = createLineChart(entries1,xAxisLabels);
                    showChart(lineChart);
                }else {
                    BarChart barChart=createBarChart(entries2,xAxisLabels);
                    showChart(barChart);
                }
                double c=0;
                double zonge=224813.1;
                String value1 = null;
                String value2 = null;
                try {
                    Double d=Double.parseDouble(YclList.get(YclList.size()-1).getImportamount());
                    c=d-Double.parseDouble(YclList.get(YclList.size()-2).getImportamount());
                    c=c/Double.parseDouble(YclList.get(YclList.size()-2).getImportamount());
                    DecimalFormat decimalFormat = new DecimalFormat("#.######");
                    value1=decimalFormat.format(c);
                    value2=decimalFormat.format(d/zonge);
                }catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                xiaoshou.setText(value1+"%");
                shichang.setText(value2+"%");
                if (c>0.1){
                    jianyi.setText("此产品销售情况良好");
                }else if (c>0){
                    jianyi.setText("此产品起伏波动不大");
                } else {
                    jianyi.setText("此产品根据数据而言不太值得购买，请慎重考虑");
                }
            }
        });
    }
    public void update(){
        String selectedChartType = spinner1.getSelectedItem().toString();
        String selectedMarketType = spinner2.getSelectedItem().toString();
        if (selectedChartType.equals("折线图") && selectedMarketType.equals("化学品及相关产品")) {
            initHuaxuepin(0);
        } else if (selectedChartType.equals("柱状图") && selectedMarketType.equals("化学品及相关产品")) {
            initHuaxuepin(1);
        }else if (selectedChartType.equals("折线图") && selectedMarketType.equals("食品、饮食、烟草")) {
            initfood(0);
        }else if (selectedChartType.equals("柱状图") && selectedMarketType.equals("食品、饮食、烟草")) {
            initfood(1);
        }else if (selectedChartType.equals("折线图") && selectedMarketType.equals("机械及制造产品")) {
            initJixie(0);
        }else if (selectedChartType.equals("柱状图") && selectedMarketType.equals("机械及制造产品")) {
            initJixie(1);
        }else if (selectedChartType.equals("折线图") && selectedMarketType.equals("原材料")) {
            initYuancailiao(0);
        }else if (selectedChartType.equals("柱状图") && selectedMarketType.equals("原材料")) {
            initYuancailiao(1);
        }
    }

    // 生成折线图的方法
    private LineChart createLineChart(List<Entry> entries,ArrayList<String> xAxisLabels) {
        // 创建折线图对象
        LineChart lineChart = new LineChart(getContext());

        // 设置折线图的一些属性
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);

        // 设置 X 轴
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setLabelRotationAngle(90f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLabels));

        // 添加折线数据
        LineDataSet dataSet =new LineDataSet(entries, "");
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.getDescription().setEnabled(false);
        lineChart.setVisibleXRange(0, 6);
        lineChart.setDragEnabled(true); // 启用滑动
        dataSet.setValueTextSize(10f);
        dataSet.setColor(getResources().getColor(R.color.red));
        dataSet.setValueTextColor(getResources().getColor(R.color.black));
        lineChart.getDescription().setEnabled(false);


        // 刷新图表
        lineChart.invalidate();

        return lineChart;
    }

    private BarChart createBarChart(List<BarEntry> entries, ArrayList<String> xAxisLabels) {
        BarChart barChart=new BarChart(getContext());
        BarDataSet dataSet = new BarDataSet(entries, " ");
        dataSet.setColor(getResources().getColor(R.color.blue)); // Set the color of the bars

        // Create BarData and set it to the chart
        BarData barData = new BarData(dataSet);
        barChart.setData(barData);

        // Customize XAxis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setLabelRotationAngle(90f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLabels));
        barChart.getDescription().setEnabled(false);
        barChart.invalidate();
        return barChart;
    }
    private void showChart(View chartView) {

        // 移除之前添加的图表
        chartContainer.removeAllViews();

        // 将新生成的图表添加到 chartContainer 中
        chartContainer.addView(chartView);
    }

}