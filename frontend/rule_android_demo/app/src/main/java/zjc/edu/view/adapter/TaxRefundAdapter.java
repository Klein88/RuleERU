package zjc.edu.view.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

import zjc.edu.R;
import zjc.edu.model.VAT.Taxrefund;
import zjc.edu.service.main.VAT.TaxRefundService;
import zjc.edu.service.imp.VAT.TaxRefundServiceImp;
import zjc.edu.util.DateConverter;

public class TaxRefundAdapter extends RecyclerView.Adapter<TaxRefundAdapter.TaxRefundViewHolder> {
    private Context mContent;
    private List<Taxrefund> data;
    public TaxRefundAdapter(Context mContent,List<Taxrefund> data){
        this.mContent=mContent;
        this.data=data;
    }
    @Override
    public TaxRefundAdapter.TaxRefundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaxRefundViewHolder(LayoutInflater.from(mContent).inflate(R.layout.layout_taxrefund_style,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaxRefundAdapter.TaxRefundViewHolder holder, int position) {
        Taxrefund item=data.get(position);
        holder.vatrefound_vatnumber_date.setText(String.valueOf(item.getVatnumber()));
        String timedate=null;
        try {
            timedate= DateConverter.extractDate(item.getDeclarationdate().toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        holder.taxrefoud_time_data.setText(timedate);
        holder.vat_cprogress.setText(String.valueOf(item.getRefundamount()));
        holder.vat_crate.setText(String.valueOf(item.getDeclarationtype()));
        if (item.getOperation() == 1){
            holder.vat_ctype.setText("未退税");
        }else {
            holder.vat_ctype.setText("已退税");
        }
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog(1,v.getContext(),item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class TaxRefundViewHolder extends RecyclerView.ViewHolder{
            private TextView vatrefound_vatnumber_date;
            private TextView taxrefoud_time_data;
            private TextView vat_cprogress;
            private TextView vat_crate;
            private TextView vat_ctype;
            private Button edit;

        public TaxRefundViewHolder(@NonNull View itemView) {
            super(itemView);
            vatrefound_vatnumber_date=itemView.findViewById(R.id.vatrefound_vatnumber_date);
            taxrefoud_time_data=itemView.findViewById(R.id.taxrefoud_time_data);
            vat_cprogress=itemView.findViewById(R.id.vat_cprogress);
            vat_crate=itemView.findViewById(R.id.vat_crate);
            vat_ctype=itemView.findViewById(R.id.vat_ctype);
            edit=itemView.findViewById(R.id.edit);
        }
    }
    private void Dialog(int type,Context b,Taxrefund data) {
        View chooseTypeView = LayoutInflater.from(b).inflate(R.layout.dialog_choose, null);
        AlertDialog selectDialog = new AlertDialog.Builder(b).setView(chooseTypeView).setCancelable(false).create();
        selectDialog.show();
        Objects.requireNonNull(selectDialog.getWindow()).setBackgroundDrawableResource(R.color.transparent);
        TextView confirm = chooseTypeView.findViewById(R.id.confirm);
        TextView cancel = chooseTypeView.findViewById(R.id.cancel);
        confirm.setOnClickListener(v-> {
            TaxRefundService taxRefundService=new TaxRefundServiceImp(this);
            JSONObject jsonData = new JSONObject();
            try {
                jsonData.put("taxrefundid",String.valueOf(data.getTaxrefundid()));
                jsonData.put("country",data.getCountry().toString());
                jsonData.put("vatnumber",data.getVatnumber().toString());
                jsonData.put("declarationtype",data.getDeclarationtype().toString());
                jsonData.put("declarationcycle",data.getDeclarationcycle().toString());
                jsonData.put("declarationdate",data.getDeclarationdate().toString());
                jsonData.put("refundamount",String.valueOf(data.getRefundamount()));
                jsonData.put("operation",2);
            }catch (JSONException e){
                e.printStackTrace();
            }
            taxRefundService.updateTaxrefund(jsonData.toString());
            selectDialog.dismiss();
            Toast.makeText(b,"退税成功",Toast.LENGTH_LONG).show();
        });
        cancel.setOnClickListener(v -> {
            selectDialog.dismiss();
        });
    }
}
