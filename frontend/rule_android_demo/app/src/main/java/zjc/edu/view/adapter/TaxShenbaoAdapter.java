package zjc.edu.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.util.List;

import zjc.edu.R;
import zjc.edu.model.VAT.TaxDeclaration;
import zjc.edu.util.DateConverter;
import zjc.edu.view.activity.Tax.DeclareVATActivity;
import zjc.edu.view.activity.Tax.ShenBaoTaxActivity;

public class TaxShenbaoAdapter extends RecyclerView.Adapter<TaxShenbaoAdapter.TaxShenbaoViewHolder> {
    private Context mContext;
    private List<TaxDeclaration> data;

    public TaxShenbaoAdapter(ShenBaoTaxActivity shenBaoTaxActivity, List<TaxDeclaration> data){
        this.mContext=shenBaoTaxActivity;
        this.data=data;
    }

    @Override
    public TaxShenbaoAdapter.TaxShenbaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaxShenbaoViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_shenbaovat_style,parent,false));
    }

    @Override
    public void onBindViewHolder(TaxShenbaoAdapter.TaxShenbaoViewHolder holder, int position) {
        TaxDeclaration item=data.get(position);
        holder.declare_cname.setText(String.valueOf(item.getCompanyname()));
        holder.declare_cprogress.setText("英国");
        holder.declare_ctype.setText(String.valueOf(item.getVatnumber()));
        String daishenbao=null;
        try {
            daishenbao=DateConverter.extractDate(item.getTaxnumbereffectivedate().toString()) + " --- " + DateConverter.extractDate(item.getLastdeclarationdate().toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        holder.wait_date.setText(daishenbao);
        String enddate=null;
        try {
            enddate= DateConverter.extractDate(item.getLastreporteddate().toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        holder.end_date.setText(enddate);
        holder.wait_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=v.getContext();
                Intent intent=new Intent(context, DeclareVATActivity.class);
                intent.putExtra("vatnumber",item.getVatnumber().toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class TaxShenbaoViewHolder extends RecyclerView.ViewHolder{
        private TextView declare_cprogress;
        private TextView declare_cname;

        private TextView declare_ctype;
        private TextView wait_date;
        private TextView end_date;
        private Button wait_submit;

        public TaxShenbaoViewHolder(@NonNull View itemView) {
            super(itemView);
            declare_cname=itemView.findViewById(R.id.declare_cname);
            declare_cprogress=itemView.findViewById(R.id.declare_cprogress);
            declare_ctype=itemView.findViewById(R.id.declare_ctype);
            wait_date=itemView.findViewById(R.id.wait_date);
            end_date=itemView.findViewById(R.id.end_date);
            wait_submit=itemView.findViewById(R.id.wait_submit);
        }
    }
}
