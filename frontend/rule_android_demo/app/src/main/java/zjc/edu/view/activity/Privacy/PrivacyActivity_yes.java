package zjc.edu.view.activity.Privacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zjc.edu.R;

public class PrivacyActivity_yes extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_yes);
        button=findViewById(R.id.btn_yes1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PrivacyActivity_yes.this,PrivacyActivity.class);
                startActivity(intent);
            }
        });
    }
}