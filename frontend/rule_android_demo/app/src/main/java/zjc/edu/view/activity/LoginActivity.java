package zjc.edu.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import zjc.edu.R;
import zjc.edu.service.imp.LoginServiceImp;
import zjc.edu.service.main.LoginService;

public class LoginActivity extends AppCompatActivity {
    private EditText password;
    private EditText username;
    private Button login;
    private Button register;
    String username_data;
    String password_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //绑定控件
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);
        //登录
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username_data=username.getText().toString();
                password_data=password.getText().toString();
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("username",username_data);
                    jsonObject.put("password",password_data);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                initLogin(jsonObject.toString());
            }
        });
        //注册
    }
    public void initLogin(String a){
        LoginService loginService=new LoginServiceImp(LoginActivity.this);
        loginService.Login(a);
    }
    public void Loginback(int value){
        if (value == 20000){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}