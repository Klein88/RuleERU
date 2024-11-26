package zjc.edu.service.imp;

import static zjc.edu.service.imp.LoginServiceImp.JSON;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.RequestBody;
import okhttp3.Response;
import zjc.edu.model.WorkOrderResponse;
import zjc.edu.service.main.WorkOrderService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.activity.WordOrderActivity;

public class WorkOrderServiceImp implements WorkOrderService {
    private WorkOrderResponse response1;
    //Json解析
    private void parseJSONtoWorkOrderList(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Log.i("Response Data",jsonObject1.toString());
            Gson gson=new Gson();
            response1 = gson.fromJson(jsonObject1.toString(), WorkOrderResponse.class);// Gson 反序列化
            Log.i("zjcdayin", String.valueOf(response1.records));
            Log.i("zjcdayin", String.valueOf(response1.records.length)); // 打印 recoreds 的 size 来校验是否获取成功
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private WordOrderActivity wordOrderActivity;
    public WorkOrderServiceImp(WordOrderActivity wordOrderActivity){
        this.wordOrderActivity=wordOrderActivity;
    }

    @Override
    public void findAllWorkorder() {
        // 构造 findAllWorkorder 的 tomcat 服务请求 URL
        String findAllWorkorderURL = MyHttpUtil.host + "/Workorder/pageList";
        // 从第 1 页开始，每页 10 条记录
        findAllWorkorderURL += "?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllWorkorderURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("zjc", "Web 接口服务连接失败，请确保主机 IP 地址是否正确，然后 打开 Tomcat 服务器，或者其他错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ResponseBody=response.body().string();
                Log.i("zjc", ResponseBody);
                parseJSONtoWorkOrderList(ResponseBody);
                if(response1 == null){
                    Log.i("kong","空");
                }else{
                    Log.i("kong",response1.toString());
                    wordOrderActivity.showAllWorkOrderCallback(response1.records);
                }
            }
        });
    }

    @Override
    public void AddWorkOrder(String a) {
        String URl=MyHttpUtil.host +"/Workorder/add";
        RequestBody body =RequestBody.create(JSON,a.toString());
        MyHttpUtil.sendOkhttpPostRequest(URl, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }


}
