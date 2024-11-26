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
import zjc.edu.model.EPR.PackagingSummaryDeclaration;
import zjc.edu.model.EPR.PackagingSummaryDeclarationResponse;
import zjc.edu.service.main.EPR.PackageSummaryService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.activity.EPR.EPRDeclareActivity;
import zjc.edu.view.activity.EPR.EPRDeclareDataActivity;

public class PackageSummaryServiceImp implements PackageSummaryService {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private EPRDeclareActivity eprDeclareActivity;
    private EPRDeclareDataActivity declareDataActivity;
    private PackagingSummaryDeclarationResponse response_pack=null;
    public PackageSummaryServiceImp(EPRDeclareActivity eprDeclareActivity){
        this.eprDeclareActivity=eprDeclareActivity;
    }
    public PackageSummaryServiceImp(EPRDeclareDataActivity declareDataActivity){
        this.declareDataActivity=declareDataActivity;
    }

    private void parseJSONtoPackagingSummaryFindID(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            Gson gson=new Gson();
            response_pack = gson.fromJson(jsonObject.toString(), PackagingSummaryDeclarationResponse.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPackageSummary(String value) {
        String addPackageSummaryURL=MyHttpUtil.host + "/Packagingsummarydeclaration/add";
        RequestBody body =RequestBody.create(JSON,value.toString());
        MyHttpUtil.sendOkhttpPostRequest(addPackageSummaryURL,body , new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("addPackageSummary","上传失败:"+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("addPackageSummary","上传成功:"+response.toString());
            }
        });
    }

    @Override
    public void findPackageSummaryByID(String ID) {
        Log.i("PackageSummary",ID);
        String findPackageSummaryByIDURL=MyHttpUtil.host +"/Packagingsummarydeclaration/find?eprdeclarationid="+ID;
        MyHttpUtil.sendOkhttpGetRequest(findPackageSummaryByIDURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                Log.i("PackageSummary",res);
                parseJSONtoPackagingSummaryFindID(res);
                Log.i("PackageSummary",response_pack.toString());
                Log.i("PackageSummary",response_pack.getData().toString());
                declareDataActivity.showFindByIDBack(response_pack.getData());
            }
        });
    }
}
