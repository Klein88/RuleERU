package zjc.edu.service.imp;

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
import zjc.edu.model.Login;
import zjc.edu.model.VAT.TaxServiceResponse;
import zjc.edu.service.main.LoginService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.activity.LoginActivity;

public class LoginServiceImp implements LoginService {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private Login response1;
    private LoginActivity loginActivity;
    public LoginServiceImp(LoginActivity loginActivity){
        this.loginActivity=loginActivity;
    }
    private void parseJSONtoLogin(String responseData){
        try{
            JSONObject jsonObject=new JSONObject(responseData);
            Gson gson=new Gson();
            response1 = gson.fromJson(jsonObject.toString(), Login.class);// Gson 反序列化
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Login(String a) {
        String LoginURL= MyHttpUtil.host +"/user/login";
        RequestBody body =RequestBody.create(JSON,a.toString());
        MyHttpUtil.sendOkhttpPostRequest(LoginURL, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                parseJSONtoLogin(res);
                loginActivity.Loginback(response1.getCode());
            }
        });
    }

    @Override
    public void Register(String a) {
        String RegisterURL=MyHttpUtil.host + "/user/register";
        RequestBody body =RequestBody.create(JSON,a.toString());
        MyHttpUtil.sendOkhttpPostRequest(RegisterURL, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("Register",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("Register",response.toString());
            }
        });
    }
}
