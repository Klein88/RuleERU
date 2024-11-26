package zjc.edu.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zjc.edu.R;
import zjc.edu.model.EPR.EPRService;
import zjc.edu.model.VAT.TaxService;
import zjc.edu.service.imp.EPR.EPRserviceServiceImp;
import zjc.edu.service.imp.VAT.TaxserviceServiceImp;
import zjc.edu.service.main.EPR.EPRserviceService;
import zjc.edu.service.main.VAT.TaxserviceService;
import zjc.edu.view.activity.ConsumptionActivity;
import zjc.edu.view.activity.EPR.EnvironmentActivity;
import zjc.edu.view.activity.Privacy.PrivacyActivity;
import zjc.edu.view.activity.Tax.TaxActivity;
import zjc.edu.view.adapter.EPRAdapter;
import zjc.edu.view.adapter.TaxAdapter;


public class HomeFragment extends Fragment {
    private ImageButton IM_SS;
    private ImageButton IM_HJ;
    private ImageButton IM_XF;
    private ImageButton IM_GD;
    private View fragment_home;
    private TextView tijiao_vat;
    private TextView zhuce_vat;
    private TextView shenbao_vat;
    int vat_tijiao=0;
    int vat_zhuce=0;
    int vat_shenbao=0;
    private TextView tijiao_epr;
    private TextView shenbao_epr;
    private TextView zhuce_epr;
    int epr_tijiao=0;
    int epr_zhuce=0;
    int epr_shenbao=0;
    private LinearLayout linearLayout_tijiao;
    private ConstraintLayout constraintLayout_tijiao;
    private LinearLayout linearLayout_shenbao;
    private ConstraintLayout constraintLayout_shenbao;
    private LinearLayout linearLayout_zhuce;
    private ConstraintLayout constraintLayout_zhuce;



    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragment_home= inflater.inflate(R.layout.fragment_home, container, false);
        IM_SS=fragment_home.findViewById(R.id.IB_SS);
        IM_HJ=fragment_home.findViewById(R.id.IB_HJ);
        IM_GD=fragment_home.findViewById(R.id.IB_GD);
        IM_XF=fragment_home.findViewById(R.id.IB_XF);
        tijiao_vat=fragment_home.findViewById(R.id.tijiao_vat);
        zhuce_vat=fragment_home.findViewById(R.id.zhuce_vat);
        shenbao_vat=fragment_home.findViewById(R.id.shenbao_vat);
        tijiao_epr=fragment_home.findViewById(R.id.tijiao_epr);
        zhuce_epr=fragment_home.findViewById(R.id.zhuce_epr);
        shenbao_epr=fragment_home.findViewById(R.id.shenbao_epr);
        linearLayout_tijiao=fragment_home.findViewById(R.id.linear1);
        constraintLayout_tijiao=fragment_home.findViewById(R.id.content1);
        linearLayout_shenbao=fragment_home.findViewById(R.id.linear2);
        constraintLayout_shenbao=fragment_home.findViewById(R.id.content2);
        linearLayout_zhuce=fragment_home.findViewById(R.id.linear3);
        constraintLayout_zhuce=fragment_home.findViewById(R.id.content3);
        linearLayout_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (constraintLayout_tijiao.getVisibility() == View.GONE){
                    constraintLayout_tijiao.setVisibility(View.VISIBLE);
                }else {
                    constraintLayout_tijiao.setVisibility(View.GONE);
                }
            }
        });
        linearLayout_shenbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (constraintLayout_shenbao.getVisibility() == View.GONE){
                    constraintLayout_shenbao.setVisibility(View.VISIBLE);
                }else {
                    constraintLayout_shenbao.setVisibility(View.GONE);
                }
            }
        });
        linearLayout_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (constraintLayout_zhuce.getVisibility() == View.GONE){
                    constraintLayout_zhuce.setVisibility(View.VISIBLE);
                }else {
                    constraintLayout_zhuce.setVisibility(View.GONE);
                }
            }
        });
        IM_SS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), TaxActivity.class);
                startActivity(intent);
            }
        });
        IM_HJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), EnvironmentActivity.class);
                startActivity(intent);
            }
        });
        IM_GD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), PrivacyActivity.class);
                startActivity(intent);
            }
        });
        IM_XF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ConsumptionActivity.class);
                startActivity(intent);
            }
        });
        initfindAllVAT();
        initfindAllEPR();
        return fragment_home;
    }
    public void initfindAllVAT(){
        TaxserviceService taxserviceService=new TaxserviceServiceImp(HomeFragment.this);
        taxserviceService.findAllMainTaxService();
    }
    public void showAllTaxServiceCallback(TaxService[] taxServiceFromJson){
        List<TaxService> taxServiceList = new ArrayList<>();
        if (taxServiceFromJson != null) {
            for (TaxService taxService : taxServiceFromJson) {
                taxServiceList.add(taxService);
            }
        }
        for (int i=0;i<taxServiceList.size();i++){
            TaxService item=taxServiceList.get(i);
            if ("待申报".equals(item.getServiceprogress())){
                vat_shenbao++;
            }else if ("注册中".equals(item.getServiceprogress())){
                vat_zhuce++;
            }else {
                vat_tijiao++;
            }
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tijiao_vat.setText(String.valueOf(vat_tijiao));
                zhuce_vat.setText(String.valueOf(vat_zhuce));
                shenbao_vat.setText(String.valueOf(vat_shenbao));
            }
        });
    }
    public void initfindAllEPR(){
        EPRserviceService epRserviceService=new EPRserviceServiceImp(HomeFragment.this);
        epRserviceService.findAllMainEPRService();
    }

    public void showFindAllBack(EPRService[] JsonFromEPR){
        List<EPRService> EprServiceList = new ArrayList<>();
        if (JsonFromEPR != null) {
            for (EPRService eprService : JsonFromEPR) {
                EprServiceList.add(eprService);
            }
        }
        for (int i=0;i<EprServiceList.size();i++){
            EPRService item=EprServiceList.get(i);
            if ("待申报".equals(item.getServicetype())){
                epr_shenbao++;
            }else if ("注册中".equals(item.getServicetype())){
                epr_zhuce++;
            }else {
                epr_tijiao++;
            }
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tijiao_epr.setText(String.valueOf(epr_tijiao));
                shenbao_epr.setText(String.valueOf(epr_shenbao));
                zhuce_epr.setText(String.valueOf(epr_zhuce));
            }
        });
    }
}