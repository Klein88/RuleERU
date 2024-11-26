package zjc.edu.service.imp;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import zjc.edu.model.FoodResponse;
import zjc.edu.model.HuaxuepinResponse;
import zjc.edu.model.JixieResponse;
import zjc.edu.model.VAT.TaxServiceResponse;
import zjc.edu.model.YuancailiaoResponse;
import zjc.edu.service.main.DataService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.fragment.DataFragment;

public class DataServiceImp implements DataService {
    private DataFragment dataFragment;
    private YuancailiaoResponse response1;
    private JixieResponse response2;
    private HuaxuepinResponse response3;
    private FoodResponse response4;
    public DataServiceImp(DataFragment dataFragment){
        this.dataFragment=dataFragment;
    }
    private void parseJSONtoYuancailiao(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Gson gson=new Gson();
            response1 = gson.fromJson(jsonObject1.toString(), YuancailiaoResponse.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void parseJSONtoJixie(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Gson gson=new Gson();
            response2 = gson.fromJson(jsonObject1.toString(), JixieResponse.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void parseJSONtoHuaxuepin(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Gson gson=new Gson();
            response3 = gson.fromJson(jsonObject1.toString(), HuaxuepinResponse.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void parseJSONtoFood(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Gson gson=new Gson();
            response4 = gson.fromJson(jsonObject1.toString(), FoodResponse.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void findyuancailiao(int a) {
        String findAllTaxServiceURL= MyHttpUtil.host + "/Importbyyuancailiao/pageList";
        findAllTaxServiceURL +="?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllTaxServiceURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("zjc", "Web 接口服务连接失败，请确保主机 IP 地址是否正确，然后 打开 Tomcat 服务器，或者其他错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ResponseBody1=response.body().string();
                parseJSONtoYuancailiao(ResponseBody1);
                dataFragment.showYuancailiaoBack(response1.records,a);
            }
        });
    }

    @Override
    public void findjixie(int a) {
        String findAllTaxServiceURL= MyHttpUtil.host + "/Importbyjixie/pageList";
        findAllTaxServiceURL +="?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllTaxServiceURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("zjc", "Web 接口服务连接失败，请确保主机 IP 地址是否正确，然后 打开 Tomcat 服务器，或者其他错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ResponseBody2=response.body().string();
                parseJSONtoJixie(ResponseBody2);
                dataFragment.showJixieBack(response2.records,a);
            }
        });
    }

    @Override
    public void findhuaxuepin(int a) {
        String findAllTaxServiceURL= MyHttpUtil.host + "/Importbyhuaxuepin/pageList";
        findAllTaxServiceURL +="?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllTaxServiceURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("zjc", "Web 接口服务连接失败，请确保主机 IP 地址是否正确，然后 打开 Tomcat 服务器，或者其他错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ResponseBody3=response.body().string();
                parseJSONtoHuaxuepin(ResponseBody3);
                dataFragment.showHuaxuepinBack(response3.records,a);
            }
        });
    }

    @Override
    public void findfood(int a) {
        String findAllTaxServiceURL= MyHttpUtil.host + "/Importbyfood/pageList";
        findAllTaxServiceURL +="?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllTaxServiceURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("zjc", "Web 接口服务连接失败，请确保主机 IP 地址是否正确，然后 打开 Tomcat 服务器，或者其他错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ResponseBody4=response.body().string();
                parseJSONtoFood(ResponseBody4);
                dataFragment.showFoodBack(response4.records,a);
            }
        });
    }
}
