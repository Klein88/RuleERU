package zjc.edu.service.imp.VAT;

import static zjc.edu.service.imp.VAT.TaxDeclarationServiceImp.JSON;

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
import zjc.edu.model.VAT.TaxService;
import zjc.edu.model.VAT.TaxServiceResponse;
import zjc.edu.service.main.VAT.TaxserviceService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.activity.Tax.DeclareVATActivity;
import zjc.edu.view.activity.Tax.TaxActivity;
import zjc.edu.view.fragment.HomeFragment;

public class TaxserviceServiceImp implements TaxserviceService {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private TaxServiceResponse response1;
//    private TaxServiceResponse2<TaxService> response2;
    private TaxService response2;
    private TaxActivity taxActivity;
    private DeclareVATActivity declareVATActivity;
    private HomeFragment homeFragment;

    private void parseJSONtoTaxServiceList(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            Log.i("response1",jsonObject.toString());
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Log.i("Response Data",jsonObject1.toString());
            Gson gson=new Gson();
            response1 = gson.fromJson(jsonObject1.toString(), TaxServiceResponse.class);// Gson 反序列化
            Log.i("response1dayin", String.valueOf(response1.records));
            Log.i("response1dayin", String.valueOf(response1.records.length)); // 打印 recoreds 的 size 来校验是否获取成功
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseJSONtoTaxServiceFindByVatNumber(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data"); // 取出 Response 里的 data 部分
            Log.i("response2.jsonob",jsonObject.toString());
            Gson gson=new Gson();
//            Type type=new TypeToken<TaxServiceResponse2<TaxService>>(){}.getType();
//            Log.i("response2.type",type.toString());
//            Log.i("response2.json",jsonObject.toString());
            response2=gson.fromJson(jsonObject1.toString(), TaxService.class);
            Log.i("response2.gson",response2.toString());
//            response2.getResult();
//            response2 = gson.fromJson(jsonObject.toString(), TaxServiceResponse2.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public TaxserviceServiceImp(TaxActivity taxActivity){
        this.taxActivity=taxActivity;
    }
    public TaxserviceServiceImp(DeclareVATActivity declareVATActivity){
        this.declareVATActivity=declareVATActivity;
    }
    public TaxserviceServiceImp(HomeFragment homeFragment){
        this.homeFragment=homeFragment;
    }

    @Override
    public void findAllTaxService() {
        String findAllTaxServiceURL= MyHttpUtil.host + "/Taxservice/pageList";
        findAllTaxServiceURL +="?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllTaxServiceURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("zjc", "Web 接口服务连接失败，请确保主机 IP 地址是否正确，然后 打开 Tomcat 服务器，或者其他错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ResponseBody1=response.body().string();
                Log.i("response1.body", ResponseBody1);
                parseJSONtoTaxServiceList(ResponseBody1);
                if(response1 == null){
                    Log.i("kong","空");
                }else{
                    taxActivity.showAllTaxServiceCallback(response1.records);
                }
            }
        });
    }

    @Override
    public void findAllMainTaxService() {
        String findAllTaxServiceURL= MyHttpUtil.host + "/Taxservice/pageList";
        findAllTaxServiceURL +="?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllTaxServiceURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("zjc", "Web 接口服务连接失败，请确保主机 IP 地址是否正确，然后 打开 Tomcat 服务器，或者其他错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ResponseBody1=response.body().string();
                parseJSONtoTaxServiceList(ResponseBody1);
                if(response1 == null){
                    Log.i("kong","空");
                }else{
                    homeFragment.showAllTaxServiceCallback(response1.records);
                }

            }
        });
    }

    @Override
    public void findTaxServicByvatnumber(String vatnumber){
        String findAllTaxServiceByvatnumberURL= MyHttpUtil.host + "/Taxservice/findbyvatnumber?vatnumber="+ vatnumber;
        MyHttpUtil.sendOkhttpGetRequest(findAllTaxServiceByvatnumberURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String ResponseBody=response.body().string();
                parseJSONtoTaxServiceFindByVatNumber(ResponseBody);
                Log.i("response2shiabi",ResponseBody);
                if (response2 == null){
                    Log.i("response2meiyou","response2.getRecord().toString()");
                }else {
                    Log.i("response2you",response2.toString());
                    declareVATActivity.findbyvatnumberBack(response2);
                }
            }
        });
    }

    @Override
    public void addTaxService(String value) {
        String addTaxServiceURL = MyHttpUtil.host + "/Taxservice/add";
        RequestBody body =RequestBody.create(JSON,value.toString());
        MyHttpUtil.sendOkhttpPostRequest(addTaxServiceURL, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("addTaxService","上传数据失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("addTaxdeclaration","上传成功"+response.toString());
            }
        });
    }




}
