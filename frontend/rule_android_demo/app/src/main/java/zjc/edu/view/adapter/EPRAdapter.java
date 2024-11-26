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

import java.util.List;

import zjc.edu.R;
import zjc.edu.model.EPR.EPRService;
import zjc.edu.view.activity.EPR.AddEPRActivity;

public class EPRAdapter extends RecyclerView.Adapter<EPRAdapter.EPRViewHolder> {
    private Context mContext;
    private List<EPRService> data;
    public EPRAdapter(Context mContext,List<EPRService> data){
        this.data=data;
        this.mContext=mContext;
    }
    @Override
    public EPRAdapter.EPRViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EPRAdapter.EPRViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_epr_style,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull EPRAdapter.EPRViewHolder holder, int position) {
        EPRService item=data.get(position);
        holder.epr_cname.setText(String.valueOf(item.getCompanyname()));
        holder.epr_ctype.setText(String.valueOf(item.getServicetype()));
        holder.vat_crate.setText(String.valueOf(item.getRegistrationnumber()));
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=v.getContext();
                Intent intent=new Intent(context, AddEPRActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class EPRViewHolder extends RecyclerView.ViewHolder{
        private TextView epr_cname;
        private TextView epr_id;
        private TextView epr_ctype;
        private TextView vat_crate;
        private ImageButton edit;
        public EPRViewHolder(@NonNull View itemView) {
            super(itemView);
            epr_cname=itemView.findViewById(R.id.epr_cname);
            epr_id=itemView.findViewById(R.id.epr_id);
            epr_ctype=itemView.findViewById(R.id.epr_ctype);
            vat_crate=itemView.findViewById(R.id.vat_crate);
            edit=itemView.findViewById(R.id.edit);
        }
    }
}
