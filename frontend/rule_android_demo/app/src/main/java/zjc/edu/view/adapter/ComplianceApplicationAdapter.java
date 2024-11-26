package zjc.edu.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.util.List;

import zjc.edu.R;
import zjc.edu.model.ComplianceApplication;
import zjc.edu.util.DateConverter;
import zjc.edu.view.activity.ConsumptionActivity_Edit;

public class ComplianceApplicationAdapter extends RecyclerView.Adapter<ComplianceApplicationAdapter.ComplianceApplicationViewHolder> {

    private Context mContext;
    private List<ComplianceApplication> data;
    public ComplianceApplicationAdapter(Context mContext,List<ComplianceApplication> data){
        this.mContext=mContext;
        this.data=data;
    }

    @Override
    public ComplianceApplicationAdapter.ComplianceApplicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ComplianceApplicationAdapter.ComplianceApplicationViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_compliance_style,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ComplianceApplicationAdapter.ComplianceApplicationViewHolder holder, int position) {
        ComplianceApplication item=data.get(position);
        holder.compliancestyle_cname.setText(String.valueOf(item.getCompanyname()));
        holder.compliancestyle_doctype.setText(String.valueOf(item.getFiletype()));
        holder.compliancestyle_CNname.setText(String.valueOf(item.getProductchinesename()));
        holder.compliancestyle_ENname.setText(String.valueOf(item.getProductenglishname()));
        String riqi= null;
        try {
            riqi=DateConverter.extractDate(item.getApplicationdate().toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        holder.compliancestyle_date.setText(riqi);
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=v.getContext();
                Intent intent=new Intent(context, ConsumptionActivity_Edit.class);
                intent.putExtra("id",String.valueOf(item.getApplicationid()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class ComplianceApplicationViewHolder extends RecyclerView.ViewHolder{
        private TextView compliancestyle_cname;
        private TextView compliancestyle_doctype;
        private TextView compliancestyle_CNname;
        private TextView compliancestyle_ENname;
        private TextView compliancestyle_date;
        private ImageButton edit;
        public ComplianceApplicationViewHolder(@NonNull View itemView) {
            super(itemView);
            compliancestyle_cname=itemView.findViewById(R.id.compliancestyle_cname);
            compliancestyle_doctype=itemView.findViewById(R.id.compliancestyle_doctype);
            compliancestyle_CNname=itemView.findViewById(R.id.compliancestyle_CNname);
            compliancestyle_ENname=itemView.findViewById(R.id.compliancestyle_ENname);
            compliancestyle_date=itemView.findViewById(R.id.compliancestyle_date);
            edit=itemView.findViewById(R.id.edit);
        }
    }
}
