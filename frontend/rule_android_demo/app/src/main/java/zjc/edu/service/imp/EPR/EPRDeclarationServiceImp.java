package zjc.edu.service.imp.EPR;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import zjc.edu.model.EPR.EPRDeclaration;
import zjc.edu.model.EPR.EPRDeclarationList;
import zjc.edu.model.EPR.EPRDeclarationResponse;
import zjc.edu.model.VAT.TaxPaymentList;
import zjc.edu.model.VAT.TaxServiceResponse;
import zjc.edu.service.main.EPR.EPRDeclarationService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.activity.EPR.EPRDeclareActivity;
import zjc.edu.view.activity.EPR.EPRDeclareDataActivity;
import zjc.edu.view.activity.EPR.ShenBaoEPRActivity;

public class EPRDeclarationServiceImp implements EPRDeclarationService {
    private EPRDeclareActivity eprDeclareActivity;
    private ShenBaoEPRActivity shenBaoEPRActivity;
    private EPRDeclarationResponse EPRresponse;
    private EPRDeclaration resByRgNumber;
    private EPRDeclareDataActivity declareDataActivity;
    public EPRDeclarationServiceImp(ShenBaoEPRActivity shenBaoEPRActivity){
        this.shenBaoEPRActivity=shenBaoEPRActivity;
    }
    public EPRDeclarationServiceImp(EPRDeclareActivity eprDeclareActivity){
        this.eprDeclareActivity=eprDeclareActivity;
    }
    public EPRDeclarationServiceImp(EPRDeclareDataActivity declareDataActivity){
        this.declareDataActivity=declareDataActivity;
    }

    private void parseJSONtoEPRDeclaretionByRgNumber(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data");
            Log.i("RgNumber","json1:"+jsonObject1.toString());
            Gson gson=new Gson();
            resByRgNumber=gson.fromJson(jsonObject1.toString(), EPRDeclaration.class);
            Log.i("RgNumber","res:"+resByRgNumber.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void parseJSONtoEPRDeclarationList(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            JSONObject jsonObject1=jsonObject.getJSONObject("data");
            Gson gson=new Gson();
            EPRresponse = gson.fromJson(jsonObject1.toString(), EPRDeclarationResponse.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void findAllEPRDeclaration() {
        String findAllEPRDeclarationURL= MyHttpUtil.host + "/Eprdeclaration1/pageList";
        findAllEPRDeclarationURL +="?pageNum=" + 1 + "&pageSize=" + 10;
        MyHttpUtil.sendOkhttpGetRequest(findAllEPRDeclarationURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                parseJSONtoEPRDeclarationList(res);
                shenBaoEPRActivity.showFindAllBack(EPRresponse.records);
            }
        });
    }

    @Override
    public void findEPRDeclaretionByRgNumber(String RgNumber) {
        String findEPRDeclaretionByRgNumberURL= MyHttpUtil.host + "/Eprdeclaration1/findbyid?registrationnumber=" +RgNumber;
        Log.i("RgNumber",RgNumber);
        MyHttpUtil.sendOkhttpGetRequest(findEPRDeclaretionByRgNumberURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                Log.i("RgNumber",res);
                parseJSONtoEPRDeclaretionByRgNumber(res);
                eprDeclareActivity.showFindByRgNumberBack(resByRgNumber);
            }
        });
    }
    @Override
    public void findEPRDeclaretionByRgNumbernew(String RgNumber) {
        String findEPRDeclaretionByRgNumberURL= MyHttpUtil.host + "/Eprdeclaration1/findbyid?registrationnumber=" +RgNumber;
        Log.i("RgNumber",RgNumber);
        MyHttpUtil.sendOkhttpGetRequest(findEPRDeclaretionByRgNumberURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                Log.i("RgNumber",res);
                parseJSONtoEPRDeclaretionByRgNumber(res);
                declareDataActivity.showFindByRgNumberBack(resByRgNumber);
            }
        });
    }
}
