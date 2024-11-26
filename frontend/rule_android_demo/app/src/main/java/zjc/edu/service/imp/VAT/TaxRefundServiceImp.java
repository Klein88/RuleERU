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
import zjc.edu.model.VAT.Taxrefund;
import zjc.edu.model.VAT.TaxrefundResponse;
import zjc.edu.service.main.VAT.TaxRefundService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.activity.Tax.TaxRefundActivity;
import zjc.edu.view.adapter.TaxRefundAdapter;

public class TaxRefundServiceImp implements TaxRefundService {
    private TaxrefundResponse responsefund;
    private TaxRefundActivity taxRefundActivity;
    private Taxrefund responsefind;
    private TaxRefundAdapter taxRefundAdapter;
    private void parseJSONtoTaxRefundList(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Log.i("Response Data",jsonObject1.toString());
            Gson gson=new Gson();
            responsefund = gson.fromJson(jsonObject1.toString(), TaxrefundResponse.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void parseJSONtoTaxRefundFindByVatNumber(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Log.i("response2.jsonob",jsonObject.toString());
            Gson gson=new Gson();
//            Type type=new TypeToken<TaxServiceResponse2<TaxService>>(){}.getType();
//            Log.i("response2.type",type.toString());
//            Log.i("response2.json",jsonObject.toString());
            responsefind=gson.fromJson(jsonObject1.toString(), Taxrefund.class);
//            response2.getResult();
//            response2 = gson.fromJson(jsonObject.toString(), TaxServiceResponse2.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public TaxRefundServiceImp(TaxRefundActivity taxRefundActivity){
        this.taxRefundActivity=taxRefundActivity;
    }
    public TaxRefundServiceImp(TaxRefundAdapter taxRefundAdapter){
        this.taxRefundAdapter=taxRefundAdapter;
    }

    @Override
    public void findAllTaxRefund() {
        String findAllTaxRefundURL = MyHttpUtil.host + "/Taxrefund/pageList";
        findAllTaxRefundURL += "?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllTaxRefundURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String Res=response.body().string();
                parseJSONtoTaxRefundList(Res);
                taxRefundActivity.showfindAllBack(responsefund.records);
            }
        });
    }

    @Override
    public void findTaxRefundByvatnumber(String vatnumber) {
        String findAllTaxRefundByvatnumberURL= MyHttpUtil.host + "/Taxrefund/findbyvatnumber?vatnumber="+ vatnumber;
        MyHttpUtil.sendOkhttpGetRequest(findAllTaxRefundByvatnumberURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ResponseBody=response.body().string();
                parseJSONtoTaxRefundFindByVatNumber(ResponseBody);


            }
        });
    }

    @Override
    public void updateTaxrefund(String value) {
        String updateTaxRefundURL = MyHttpUtil.host + "/Taxrefund/update";
        RequestBody body =RequestBody.create(JSON,value.toString());
        MyHttpUtil.sendOkhttpPostRequest(updateTaxRefundURL, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("updatetaxrefund","上传数据失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("updatetaxrefund","上传成功"+response.toString());
            }
        });
    }
}
