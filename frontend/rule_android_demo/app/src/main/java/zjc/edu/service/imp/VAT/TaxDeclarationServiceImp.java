package zjc.edu.service.imp.VAT;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import zjc.edu.model.VAT.TaxDeclarationResponse;
import zjc.edu.service.main.VAT.TaxDeclarationService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.activity.Tax.ShenBaoTaxActivity;
import zjc.edu.view.fragment.Step4Fragment;

public class TaxDeclarationServiceImp implements TaxDeclarationService {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private Step4Fragment step4Fragment;
    private TaxDeclarationResponse response3;
    private ShenBaoTaxActivity shenBaoTaxActivity;

    private void parseJSONtoTaxDeclarationList(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Log.i("Response Data",jsonObject1.toString());
            Gson gson=new Gson();
            response3 = gson.fromJson(jsonObject1.toString(), TaxDeclarationResponse.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    public TaxDeclarationServiceImp(Step4Fragment step4Fragment){
        this.step4Fragment=step4Fragment;
    }
    public TaxDeclarationServiceImp(ShenBaoTaxActivity shenBaoTaxActivity){
        this.shenBaoTaxActivity=shenBaoTaxActivity;
    }



    @Override
    public void addTaxdeclaration(String taxDeclaration) {
        String addTaxdeclarationURL= MyHttpUtil.host + "/Taxdeclaration/add";
        RequestBody body =RequestBody.create(JSON,taxDeclaration.toString());
        MyHttpUtil.sendOkhttpPostRequest(addTaxdeclarationURL, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("addTaxdeclaration","上传数据失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("addTaxdeclaration","上传成功"+response.toString());
            }
        });
    }

    @Override
    public void findAllTaxdeclaration() {
        String findAllTaxdeclarationURL=MyHttpUtil.host + "/Taxdeclaration/pageList";
        findAllTaxdeclarationURL +="?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllTaxdeclarationURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String Res=response.body().string();
                Log.i("TaxDeclaration",Res);
                parseJSONtoTaxDeclarationList(Res);
                shenBaoTaxActivity.showAllTaxdeclarationCallback(response3.records);
            }
        });
    }

    @Override
    public void findTaxDeclarationByVatNumber(String vatnumber) {
        String findTaxDeclarationByVatNumberURL=MyHttpUtil.host + "/Taxdeclaration/find2";
    }


}
