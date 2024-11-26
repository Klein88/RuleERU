package zjc.edu.service.imp.EPR;

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
import zjc.edu.model.EPR.EPRServiceResponse;
import zjc.edu.service.main.EPR.EPRserviceService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.activity.EPR.EnvironmentActivity;
import zjc.edu.view.fragment.HomeFragment;

public class EPRserviceServiceImp implements EPRserviceService {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private EPRServiceResponse responseAllEPR;
    private EnvironmentActivity environmentActivity;
    private HomeFragment homeFragment;
    public EPRserviceServiceImp(EnvironmentActivity environmentActivity){this.environmentActivity=environmentActivity;}
    public EPRserviceServiceImp(HomeFragment homeFragment){
        this.homeFragment=homeFragment;
    }
    private void parseJSONtoEPRServiceList(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Gson gson=new Gson();
            responseAllEPR = gson.fromJson(jsonObject1.toString(), EPRServiceResponse.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void findAllEPRService() {
        String findAllEPRServiceURL= MyHttpUtil.host + "/Eprservice/pageList";
        findAllEPRServiceURL +="?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllEPRServiceURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    String res=response.body().string();
                    parseJSONtoEPRServiceList(res);
                    environmentActivity.showFindAllBack(responseAllEPR.records);
            }
        });
    }

    @Override
    public void findAllMainEPRService() {
        String findAllEPRServiceURL= MyHttpUtil.host + "/Eprservice/pageList";
        findAllEPRServiceURL +="?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllEPRServiceURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                parseJSONtoEPRServiceList(res);
                if (responseAllEPR !=null){
                    homeFragment.showFindAllBack(responseAllEPR.records);
                }

            }
        });
    }

    @Override
    public void AddEPRService(String epr) {
        String AddEPRServiceURL=MyHttpUtil.host + "/Eprservice/add";
        RequestBody body =RequestBody.create(JSON,epr.toString());
        MyHttpUtil.sendOkhttpPostRequest(AddEPRServiceURL, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("AddEPRService","上传EPR服务失败："+e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("AddEPRService","上传EPR服务成功:"+response.toString());
            }
        });
    }
}
