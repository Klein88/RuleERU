package zjc.edu.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import zjc.edu.R;
import zjc.edu.model.VAT.TaxService;
import zjc.edu.view.activity.Tax.AddTaxActivity;
import zjc.edu.view.activity.Tax.TaxActivity;

public class TaxAdapter extends RecyclerView.Adapter<TaxAdapter.TaxViewHolder> {

    private Context mContext;
    private List<TaxService> taxServices;

    public TaxAdapter(TaxActivity taxActivity, List<TaxService> taxServices){
        this.mContext=taxActivity;
        this.taxServices=taxServices;
    }

    @Override
    public TaxAdapter.TaxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaxViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_tax_style,parent,false));
    }

    @Override
    public void onBindViewHolder(TaxAdapter.TaxViewHolder holder, int position) {
        TaxService item=taxServices.get(position);
        holder.vat_cname.setText(String.valueOf(item.getCompanyname()));
        holder.vat_id.setText(String.valueOf(item.getVatnumber()));
        holder.vat_cprogress.setText(String.valueOf(item.getServiceprogress()));
        holder.vat_crate.setText(String.valueOf(item.getTaxrate()));
        holder.vat_ctype.setText(String.valueOf(item.getTaxtype()));
        String countryname=item.getCountry().toString();
        if (countryname == "英国"){
            holder.country_vat.setImageResource(R.drawable.yingguo);
        }else if(countryname == "法国"){
            holder.country_vat.setImageResource(R.drawable.faguo);
        }else if(countryname == "德国"){
            holder.country_vat.setImageResource(R.drawable.deguo);
        }else if(countryname == "安道尔"){
            holder.country_vat.setImageResource(R.drawable.andaoer);
        }else if(countryname == "波兰"){
            holder.country_vat.setImageResource(R.drawable.bolan);
        }else if(countryname == "荷兰"){
            holder.country_vat.setImageResource(R.drawable.helan);
        }else if(countryname == "西班牙"){
            holder.country_vat.setImageResource(R.drawable.xibanya);
        }else {

        }
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=v.getContext();
                Intent intent=new Intent(context, AddTaxActivity.class);
                intent.putExtra("vatnumber",item.getVatnumber().toString());
                intent.putExtra("taxrate",item.getTaxrate());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return taxServices.size();
    }
    class TaxViewHolder extends RecyclerView.ViewHolder{
            private TextView vat_cname;
            private TextView vat_id;
            private TextView vat_cprogress;
            private TextView vat_crate;
            private TextView vat_ctype;
            private ImageView country_vat;
            private ImageButton edit;
        public TaxViewHolder(@NonNull View itemView) {
            super(itemView);
            vat_cname=itemView.findViewById(R.id.vat_cname);
            vat_id=itemView.findViewById(R.id.vat_id);
            vat_cprogress=itemView.findViewById(R.id.vat_cprogress);
            vat_crate=itemView.findViewById(R.id.vat_crate);
            vat_ctype=itemView.findViewById(R.id.vat_ctype);
            country_vat=itemView.findViewById(R.id.country_vat);
            edit=itemView.findViewById(R.id.edit);
        }
    }
}
