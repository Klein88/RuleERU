package zjc.edu.service.imp;

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
import zjc.edu.model.ComplianceApplicationResponse;
import zjc.edu.model.VAT.TaxServiceResponse;
import zjc.edu.service.main.ComplianceApplicationService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.activity.ConsumptionActivity;
import zjc.edu.view.activity.ConsumptionActivity_Edit;

public class ComplianceApplicationServiceImp implements ComplianceApplicationService {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private ConsumptionActivity consumptionActivity;
    private ConsumptionActivity_Edit consumptionActivity_edit;
    private ComplianceApplicationResponse responsenew;
    public ComplianceApplicationServiceImp(ConsumptionActivity consumptionActivity){
        this.consumptionActivity=consumptionActivity;
    }
    public ComplianceApplicationServiceImp(ConsumptionActivity_Edit consumptionActivity_edit){
        this.consumptionActivity_edit=consumptionActivity_edit;
    }
    private void parseJSONtoComplianceApplicationList(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Gson gson=new Gson();
            responsenew = gson.fromJson(jsonObject1.toString(), ComplianceApplicationResponse.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void addComplianceApplication(String a) {
        String addComplianceApplicationURL = MyHttpUtil.host + "/Complianceapplication/add";
        RequestBody body =RequestBody.create(JSON,a.toString());
        MyHttpUtil.sendOkhttpPostRequest(addComplianceApplicationURL, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("addCompliance","上传合规申报失败："+e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("addCompliance","上传合规申报成功："+response.toString());
            }
        });
    }

    @Override
    public void addEU(String a) {
        String addEUURL=MyHttpUtil.host + "/Eudeclarationofconformity/add";
        RequestBody body =RequestBody.create(JSON,a.toString());
        MyHttpUtil.sendOkhttpPostRequest(addEUURL, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("addEU","上传合规内容失败："+e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("addEU","上传合规内容成功："+response.toString());
            }
        });
    }

    @Override
    public void FindAllComplianceApplication() {
        String FindAllComplianceApplicationURL=MyHttpUtil.host + "/Complianceapplication/pageList";
        FindAllComplianceApplicationURL+= "?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(FindAllComplianceApplicationURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                parseJSONtoComplianceApplicationList(res);
                consumptionActivity.showfindAllBack(responsenew.records);
            }
        });
    }
}
