package zjc.edu.view.activity.EPR;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import zjc.edu.R;
import zjc.edu.model.EPR.EPRDeclaration;
import zjc.edu.model.VAT.TaxService;
import zjc.edu.service.imp.EPR.EPRDeclarationServiceImp;
import zjc.edu.service.main.EPR.EPRDeclarationService;
import zjc.edu.view.activity.MainActivity;
import zjc.edu.view.activity.Tax.TaxActivity;
import zjc.edu.view.adapter.EPRShenbaoAdapter;
import zjc.edu.view.adapter.TaxAdapter;

public class ShenBaoEPRActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView ry_epr_shenbao;
    private EPRShenbaoAdapter eprShenbaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shen_bao_epractivity);
        //绑定控件
        toolbar=findViewById(R.id.Tl_EPR_shenbao);
        ry_epr_shenbao=findViewById(R.id.ry_epr_shenbao);
        //recyclerview
        ry_epr_shenbao.setLayoutManager(new LinearLayoutManager(ShenBaoEPRActivity.this));
        initFindAll();
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    //toobar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent intent = new Intent(this, EnvironmentActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //回调findall方法
    public void showFindAllBack(EPRDeclaration[] json){
        List<EPRDeclaration> eprDeclarationsList = new ArrayList<>();
        if (json != null) {
            for (EPRDeclaration eprDeclaration : json) {
                eprDeclarationsList.add(eprDeclaration);
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                eprShenbaoAdapter=new EPRShenbaoAdapter(ShenBaoEPRActivity.this,eprDeclarationsList);
                ry_epr_shenbao.setAdapter(eprShenbaoAdapter);
                eprShenbaoAdapter.notifyDataSetChanged();
            }
        });
    }
    //载入数据
    public void initFindAll(){
        EPRDeclarationService eprDeclarationService=new EPRDeclarationServiceImp(ShenBaoEPRActivity.this);
        eprDeclarationService.findAllEPRDeclaration();
    }

}