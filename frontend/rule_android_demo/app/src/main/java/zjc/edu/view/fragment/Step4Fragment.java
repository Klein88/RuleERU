package zjc.edu.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Response;
import zjc.edu.R;
import zjc.edu.model.VAT.SharedTaxViewModel;
import zjc.edu.service.main.VAT.TaxDeclarationService;
import zjc.edu.service.imp.VAT.TaxDeclarationServiceImp;
import zjc.edu.view.activity.Tax.TaxActivity;

public class Step4Fragment extends Fragment {
    private SharedTaxViewModel sharedTaxViewModel;
    private View fragment_step4;
    private Button tijiao;
    private RadioGroup radioGroup_shop;
    private EditText shop_name;
    private EditText shop_link;
    private EditText shop_address;
    private EditText backcompany_address;
    private EditText shop_business;
    String selectedOptionText_shop;
    public Step4Fragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment_step4= inflater.inflate(R.layout.fragment_step_4, container, false);
        //共享数据模型
        sharedTaxViewModel=new ViewModelProvider(requireActivity()).get(SharedTaxViewModel.class);
//        View vat_step1 = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_step_1, null);
//        View vat_step2 = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_step_2,null);
//        View vat_step3 = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_step_3,null);
//        String effectiveDate= String.valueOf(vat_step1.findViewById(R.id.effective));
//        Log.i("effect",effectiveDate);
        //控件绑定
        tijiao=fragment_step4.findViewById(R.id.tijiao);
        radioGroup_shop=fragment_step4.findViewById(R.id.rg_shop);
        shop_name=fragment_step4.findViewById(R.id.shop_name);
        shop_link=fragment_step4.findViewById(R.id.shop_link);
        shop_address=fragment_step4.findViewById(R.id.shop_address);
        backcompany_address=fragment_step4.findViewById(R.id.backcompany_address);
        shop_business=fragment_step4.findViewById(R.id.shop_business);

        //调用视图
        View vat_step1 = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_step_1, null);
        EditText tax = vat_step1.findViewById(R.id.tax);
        TextView effective = vat_step1.findViewById(R.id.effective);

        //查询RadioButton选中的店铺类型
        radioGroup_shop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedRadioButtonId = radioGroup_shop.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = fragment_step4.findViewById(selectedRadioButtonId);
                    selectedOptionText_shop = selectedRadioButton.getText().toString();
                    sharedTaxViewModel.setMainsalesplatform(selectedOptionText_shop);
                }
            }
        });
        //共享数据
        sharedTaxViewModel.setShopname(String.valueOf(shop_name.getText()));
        sharedTaxViewModel.setInformationlink(String.valueOf(shop_link.getText()));
        sharedTaxViewModel.setShopbackendselleraddress(String.valueOf(shop_address.getText()));
        sharedTaxViewModel.setShopbackendcompanyname(String.valueOf(backcompany_address.getText()));
        sharedTaxViewModel.setMainbusinessscope(String.valueOf(shop_business.getText()));

        //按钮实现
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                JSONObject jsonObject=new JSONObject();
//                try {
//                    jsonObject.put("vatnumber","VAT456789");
//                    jsonObject.put("taxrate",0.20);
//                    jsonObject.put("companyname","123");
//                    jsonObject.put("vatcertificate",sharedTaxViewModel.getVatcertificate());
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
                Intent intent=new Intent(getContext(),TaxActivity.class);
                startActivity(intent);
                JSONObject jsonData = new JSONObject();
//                try {
//                    jsonData.put("vatnumber",tax.getText().toString());
//                    jsonData.put("taxrate",sharedTaxViewModel.getTaxrate());
//                    jsonData.put("taxnumbereffectivedate",sharedTaxViewModel.getTaxnumbereffectivedate());
//                    jsonData.put("lastdeclarationdate",sharedTaxViewModel.getLastdeclarationdate());
//                    jsonData.put("gatewayid",sharedTaxViewModel.getGatewayid());
//                    jsonData.put("gatewaypassword",sharedTaxViewModel.getGatewaypassword());
//                    jsonData.put("lastreporteddate",sharedTaxViewModel.getLastreporteddate());
//                    jsonData.put("mtdusername",sharedTaxViewModel.getMtdusername());
//                    jsonData.put("mtdpassword",sharedTaxViewModel.getMtdpassword());
////                    jsonData.put("vatcertificate",sharedTaxViewModel.getVatcertificate());
////                    jsonData.put("vatdeclarationdocument",sharedTaxViewModel.getVatdeclarationdocument());
////                    jsonData.put("proxycommitmentdocument",sharedTaxViewModel.getProxycommitmentdocument());
//                    jsonData.put("companyregistrationlocation",sharedTaxViewModel.getCompanyregistrationlocation());
//                    jsonData.put("companyname",sharedTaxViewModel.getCompanyname());
////                    jsonData.put("companyregistrationproof",sharedTaxViewModel.getCompanyregistrationproof());
//                    jsonData.put("businesslicensenumber",sharedTaxViewModel.getBusinesslicensenumber());
//                    jsonData.put("companyestablishmentdate",sharedTaxViewModel.getCompanyestablishmentdate());
//                    jsonData.put("companyoperationaladdress",sharedTaxViewModel.getCompanyoperationaladdress());
//                    jsonData.put("postalcode",sharedTaxViewModel.getPostalcode());
//                    jsonData.put("companyphonenumber",sharedTaxViewModel.getCompanyphonenumber());
//                    jsonData.put("companycontactemail",sharedTaxViewModel.getCompanycontactemail());
////                    jsonData.put("idcardfront",sharedTaxViewModel.getIdcardfront());
////                    jsonData.put("idcardback",sharedTaxViewModel.getIdcardback());
//                    jsonData.put("legalrepresentativename",sharedTaxViewModel.getLegalrepresentativename());
////                    jsonData.put("signature",sharedTaxViewModel.getSignature());
//                    jsonData.put("mainsalesplatform",selectedOptionText_shop);
//                    jsonData.put("shopname",shop_name.getText().toString());
//                    jsonData.put("informationlink",shop_link.getText().toString());
//                    jsonData.put("shopbackendselleraddress",shop_address.getText().toString());
//                    jsonData.put("shopbackendcompanyname",backcompany_address.getText().toString());
//                    jsonData.put("mainsalesplatform",shop_business.getText().toString());
//                    Log.i("jsondata123",jsonData.toString())
//;                }catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                initAddTax(jsonData.toString());

            }
        });
        //返回视图
        return fragment_step4;
    }

    public void showAddTaxdeclarationCallback(Response response) {

    }

    public void initAddTax(String value){
        TaxDeclarationService taxDeclarationService=new TaxDeclarationServiceImp(this);
        taxDeclarationService.addTaxdeclaration(value);
    }
}
