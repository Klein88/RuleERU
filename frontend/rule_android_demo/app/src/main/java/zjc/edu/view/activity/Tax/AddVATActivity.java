package zjc.edu.view.activity.Tax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import zjc.edu.R;

public class AddVATActivity extends AppCompatActivity {
    private Spinner taxratespinner;
    private EditText vatadd_cname;
    private RadioGroup radioGroup_vat;
    private String selectedOptionText;
    private TextView vatadd_country;
    private EditText vatadd_tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vat_add);
        //绑定控件
        vatadd_tax=findViewById(R.id.vatadd_tax);
        vatadd_cname=findViewById(R.id.vatadd_cname);
        vatadd_country=findViewById(R.id.vatadd_country);
        radioGroup_vat=findViewById(R.id.radiogroup_vat);
        taxratespinner = findViewById(R.id.vatadd_spinner);
        //Spinner初始默认选择为第一个选项
        taxratespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"111",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO
            }
        });

        //得到Spinner选项
        String selectedValue = (String) taxratespinner.getSelectedItem();
        Log.i("selectvalue",selectedValue);
        //查询RadioButton选中的国家
        radioGroup_vat.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedRadioButtonId = radioGroup_vat.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    //得到radiobutton的text属性
                    selectedOptionText = selectedRadioButton.getText().toString();
                    //给第二步骤中vatadd_country设置text
                    vatadd_country.setText(selectedOptionText);
                    Log.i("radioselect",selectedOptionText);
                }
            }
        });
    }
}