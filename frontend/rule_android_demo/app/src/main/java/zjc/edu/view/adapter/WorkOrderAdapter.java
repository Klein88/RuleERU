package zjc.edu.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.util.List;

import zjc.edu.R;
import zjc.edu.model.WorkOrders;
import zjc.edu.util.DateConverter;
import zjc.edu.view.activity.WordOrderActivity;

public class WorkOrderAdapter extends RecyclerView.Adapter<WorkOrderAdapter.WorkOrderViewHolder> {

    private Context mContext;
    private List<WorkOrders> data;

    public WorkOrderAdapter(WordOrderActivity wordOrderActivity,List<WorkOrders> data) {
        this.mContext=wordOrderActivity;
        this.data=data;
    }

//    public void WordOrderAdapter(Context context,List<WorkOrders> data){
//        this.mContext=context;
//        this.data=data;
//    }
    @Override
    public WorkOrderAdapter.WorkOrderViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new WorkOrderViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_workorder_style,parent,false));
    }

    @Override
    public void onBindViewHolder( WorkOrderAdapter.WorkOrderViewHolder holder, int position) {
        WorkOrders item = data.get(position);
        holder.tv_2.setText(String.valueOf(item.getWorkorderid()));
        holder.tv_4.setText(String.valueOf(item.getUserid()));
        String date=null;
        try {
            date= DateConverter.extractDate(item.getCreationdate().toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        holder.tv_6.setText(date);
        holder.tv_11.setText(String.valueOf(item.getWorkordertheme()));
        holder.tv_8.setText(String.valueOf(item.getDescription()));
        String sta=item.getStatus();
        if (sta.equals("处理中")){
            holder.tv_9.setText(sta);
            holder.tv_9.setBackgroundResource(R.drawable.in_border);
        }else {
            holder.tv_9.setText(sta);
            holder.tv_9.setBackgroundResource(R.drawable.out_border);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class WorkOrderViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_2;
        private TextView tv_4;
        private TextView tv_6;
        private TextView tv_8;
        private TextView tv_9;
        private TextView tv_11;

        public WorkOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_2=itemView.findViewById(R.id.tv_2);
            tv_4=itemView.findViewById(R.id.tv_4);
            tv_6=itemView.findViewById(R.id.tv_6);
            tv_8=itemView.findViewById(R.id.tv_8);
            tv_9=itemView.findViewById(R.id.tv_9);
            tv_11=itemView.findViewById(R.id.tv_11);
        }
    }
}
