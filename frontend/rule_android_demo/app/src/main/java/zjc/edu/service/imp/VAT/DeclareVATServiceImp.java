package zjc.edu.service.imp.VAT;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import zjc.edu.service.main.VAT.DeclareVATService;
import zjc.edu.util.MyHttpUtil;
import zjc.edu.view.activity.Tax.DeclareVATActivity;

public class DeclareVATServiceImp implements DeclareVATService {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private DeclareVATActivity declareVATActivity;
    public DeclareVATServiceImp(DeclareVATActivity declareVATActivity){
        this.declareVATActivity=declareVATActivity;
    }

    @Override
    public void addTaxPayment(String value) {
        String addTaxPaymentURL= MyHttpUtil.host + "/Taxpayment/add";
        RequestBody body =RequestBody.create(JSON,value.toString());
        Log.i("addTaxPayment","数据"+body.toString());
        MyHttpUtil.sendOkhttpPostRequest(addTaxPaymentURL, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("addTaxPayment","上传数据失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("addTaxPayment","上传成功"+response.toString());
            }
        });
    }
}
