package zjc.edu.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import zjc.edu.R;
import zjc.edu.model.VAT.TaxPayment;
import zjc.edu.view.activity.Tax.TaxPaymentActivity_Edit;

public class TaxPaymentAdapter extends RecyclerView.Adapter<TaxPaymentAdapter.TaxPaymentAdapterViewHolder> {
    private Context mContext;
    private List<TaxPayment> data;

    public TaxPaymentAdapter(Context mContext,List<TaxPayment> data){
        this.mContext=mContext;
        this.data=data;
    }
    @Override
    public TaxPaymentAdapter.TaxPaymentAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaxPaymentAdapterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_taxpayment_style,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaxPaymentAdapter.TaxPaymentAdapterViewHolder holder, int position) {
        TaxPayment item=data.get(position);
        holder.taxpay_cname.setText(String.valueOf(item.getCompanyname()));
        holder.taxpay_id.setText(String.valueOf(item.getVatnumber()));
        holder.taxpay_pay.setText(String.valueOf(item.getAmountdue()));
        holder.taxpay_type.setText(String.valueOf(item.getDeclarationtype()));
        if (item.getPaymentstatus() == 1 ){
            holder.taxpay_state.setText("未缴税");
        }else {
            holder.taxpay_state.setText("已缴税");
        }
        holder.vatpay_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=v.getContext();
                Intent intent=new Intent(context, TaxPaymentActivity_Edit.class);
                intent.putExtra("companyname",item.getCompanyname().toString());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class TaxPaymentAdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView taxpay_cname;
        private TextView taxpay_id;
        private TextView taxpay_pay;
        private TextView taxpay_type;
        private TextView taxpay_state;
        private ImageView vatpay_edit;
        public TaxPaymentAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            taxpay_cname=itemView.findViewById(R.id.taxpay_cname);
            taxpay_id=itemView.findViewById(R.id.taxpay_id);
            taxpay_pay=itemView.findViewById(R.id.taxpay_pay);
            taxpay_type=itemView.findViewById(R.id.taxpay_type);
            taxpay_state=itemView.findViewById(R.id.taxpay_state);
            vatpay_edit=itemView.findViewById(R.id.vatpay_edit);
        }
    }
}
