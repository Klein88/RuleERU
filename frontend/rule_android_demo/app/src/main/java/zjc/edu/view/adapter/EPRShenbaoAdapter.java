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

import java.util.List;

import zjc.edu.R;
import zjc.edu.model.EPR.EPRDeclaration;
import zjc.edu.model.VAT.TaxDeclaration;
import zjc.edu.view.activity.EPR.EPRDeclareActivity;
import zjc.edu.view.activity.EPR.EPRDeclareDataActivity;
import zjc.edu.view.activity.EPR.ShenBaoEPRActivity;
import zjc.edu.view.activity.Tax.DeclareVATActivity;
import zjc.edu.view.activity.Tax.ShenBaoTaxActivity;

public class EPRShenbaoAdapter extends RecyclerView.Adapter<EPRShenbaoAdapter.EPRShenbaoViewHolder> {
    private Context mContext;
    private List<EPRDeclaration> data;

    public EPRShenbaoAdapter(ShenBaoEPRActivity shenBaoeprActivity, List<EPRDeclaration> data){
        this.mContext=shenBaoeprActivity;
        this.data=data;
    }

    @Override
    public EPRShenbaoAdapter.EPRShenbaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EPRShenbaoViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_shenbaoepr_style,parent,false));
    }

    @Override
    public void onBindViewHolder(EPRShenbaoAdapter.EPRShenbaoViewHolder holder, int position) {
        EPRDeclaration item=data.get(position);
        holder.declare_cname.setText(String.valueOf(item.getCompanyname()));
        holder.declare_cprogress.setText("英国");
        holder.declare_ctype.setText(String.valueOf(item.getRegistrationnumber()));
        holder.wait_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=v.getContext();
                Intent intent=new Intent(context, EPRDeclareActivity.class);
                intent.putExtra("Rgnumber",item.getRegistrationnumber().toString());
                context.startActivity(intent);
            }
        });
        holder.end_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=v.getContext();
                Intent intent=new Intent(context, EPRDeclareDataActivity.class);
                intent.putExtra("id",String.valueOf(item.getEprdeclarationid()));
                intent.putExtra("Rgnumber",item.getRegistrationnumber().toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class EPRShenbaoViewHolder extends RecyclerView.ViewHolder{
        private TextView declare_cprogress;
        private TextView declare_cname;

        private TextView declare_ctype;
        private TextView wait_date;
        private TextView end_date;
        private Button wait_submit;
        private Button end_submit;

        public EPRShenbaoViewHolder(@NonNull View itemView) {
            super(itemView);
            declare_cname=itemView.findViewById(R.id.declare_cname);
            declare_cprogress=itemView.findViewById(R.id.declare_cprogress);
            declare_ctype=itemView.findViewById(R.id.declare_ctype);
            wait_date=itemView.findViewById(R.id.wait_date);
            end_date=itemView.findViewById(R.id.end_date);
            wait_submit=itemView.findViewById(R.id.wait_submit);
            end_submit=itemView.findViewById(R.id.end_submit);
        }
    }
}
