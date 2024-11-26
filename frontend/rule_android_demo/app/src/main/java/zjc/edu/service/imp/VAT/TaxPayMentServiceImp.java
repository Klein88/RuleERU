package zjc.edu.service.imp.VAT;

import static zjc.edu.service.imp.VAT.TaxDeclarationServiceImp.JSON;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.RequestBody;
import okhttp3.Response;
import zjc.edu.model.VAT.TaxPaymentList;
import zjc.edu.model.VAT.TaxPaymentResponse;
import zjc.edu.service.main.VAT.TaxPayMentService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.activity.Tax.TaxPaymentActivity;
import zjc.edu.view.activity.Tax.TaxPaymentActivity_Edit;

public class TaxPayMentServiceImp implements TaxPayMentService {
    private TaxPaymentResponse taxpayresponse;
    private TaxPaymentActivity taxPaymentActivity;
    private TaxPaymentList responsefindbycompanyname;
    private TaxPaymentActivity_Edit taxPaymentActivityEdit;


    public TaxPayMentServiceImp(TaxPaymentActivity_Edit taxPaymentActivityEdit){
        this.taxPaymentActivityEdit=taxPaymentActivityEdit;
    }
    public TaxPayMentServiceImp(TaxPaymentActivity taxPaymentActivity){
        this.taxPaymentActivity=taxPaymentActivity;
    }


    private void parseJSONtoTaxPaymentBycompanyname(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            Gson gson=new Gson();
            responsefindbycompanyname=gson.fromJson(jsonObject.toString(), TaxPaymentList.class);
            Log.i("responsefind",responsefindbycompanyname.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseJSONtoTaxPaymentList(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Log.i("Response Data",jsonObject1.toString());
            Gson gson=new Gson();
            taxpayresponse = gson.fromJson(jsonObject1.toString(), TaxPaymentResponse.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void findAllTaxPayMent() {
        String findAllTaxPayMentURL=MyHttpUtil.host + "/Taxpayment/pageList";
        findAllTaxPayMentURL += "?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllTaxPayMentURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                parseJSONtoTaxPaymentList(res);
                taxPaymentActivity.showFindAllBack(taxpayresponse.records);
            }
        });
    }

    @Override
    public void findTaxPaymentBycompanyname(String companyname) {
        String findTaxPaymentBycompanynameURL= MyHttpUtil.host + "/Taxpayment/findbycompanyname?companyname="+ companyname;
        MyHttpUtil.sendOkhttpGetRequest(findTaxPaymentBycompanynameURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ResponseBody=response.body().string();
                Log.i("responsefind123",ResponseBody);
                parseJSONtoTaxPaymentBycompanyname(ResponseBody);
                Log.i("responsefind",responsefindbycompanyname.toString());
                taxPaymentActivityEdit.findbycompanynameBack(responsefindbycompanyname.getData());
            }
        });
    }

    @Override
    public void updateTaxPayment(String value) {
        String updateTaxPaymentURL = MyHttpUtil.host + "/Taxpayment/update";
        RequestBody body =RequestBody.create(JSON,value.toString());
        MyHttpUtil.sendOkhttpPostRequest(updateTaxPaymentURL, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("updatetaxpayment","上传数据失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("updatetaxpayment","上传成功"+response.toString());
            }
        });
    }


}
