package zjc.edu.service.imp;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import zjc.edu.model.TranslateResult;
import zjc.edu.model.WorkOrderResponse;
import zjc.edu.service.main.TestService;
import zjc.edu.util.MD5Utils;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.fragment.LearnFragment;

public class TestServiceImp implements TestService {
    private LearnFragment learnFragment;
    private TranslateResult response_translate;
    String la_from;
    String la_to;
    public TestServiceImp(LearnFragment learnFragment){
        this.learnFragment=learnFragment;
    }

    private void parseJSONtoTranslate(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            Gson gson=new Gson();
            response_translate = gson.fromJson(jsonObject.toString(), TranslateResult.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String stringToMD5(String string) {
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) {
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }

    @Override
    public void fanyi(String a,int from,int to) {
        Log.i("translate","a:"+a+"from: "+from+"to: " +to);
        String fanyiURL="http://api.fanyi.baidu.com/api/trans/vip/translate";
//        String sign=stringToMD5("20231114001879531"+a+"143566028812345678");
//        String sign=stringToMD5("?appid=" + "20231114001879531" + "&q=" + a + "&from=" + from + "&to=" + to + "&salt=" + "1435660288");
        switch (from){
            case 0:
                la_from="zh";
                break;
            case 1:
                la_from="en";
                break;
            case 2:
                la_from="de";
                break;
            case 3:
                la_from="fra";
                break;
            case 4:
                la_from="it";
                break;
        }
        switch (to){
            case 0:
                la_to="zh";
                break;
            case 1:
                la_to="en";
                break;
            case 2:
                la_to="de";
                break;
            case 3:
                la_to="fra";
                break;
            case 4:
                la_to="it";
                break;
        }

//        if (from == "中文"){
//            la_from="zh";
//        }else if (from == "英语"){
//            la_from="en";
//        }else if (from == "德语"){
//            la_from="de";
//        }else if (from == "法语"){
//            la_from="fra";
//        }else{
//            la_from="it";
//        };
//        if (to == "中文"){
//            la_to="zh";
//        }else if (to == "英语"){
//            la_to="en";
//        }else if (to == "德语"){
//            la_to="de";
//        }else if (to == "法语"){
//            la_to="fra";
//        }else{
//            la_to="it";
//        };
        String signnew= MD5Utils.cell32("20231114001879531" + a + "1435660288"+ "wiDtWdpQD1nwPoW9T199");
        String sign=signnew.toLowerCase();
        fanyiURL += "?appid=" + "20231114001879531" + "&q=" + a + "&from=" + la_from + "&to=" + la_to + "&salt=" + "1435660288" + "&sign=" + sign;
        Log.i("translate",fanyiURL);
        MyHttpUtil.sendOkhttpGetRequest(fanyiURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("translate",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                Log.i("translate",res);
                parseJSONtoTranslate(res);
                Log.i("translate",response_translate.toString());
                learnFragment.showtranslateBack(response_translate.getTrans_result());
            }
        });
    }
}
