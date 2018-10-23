package com.example.meghana.jsonparse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MLAAdapetr extends RecyclerView.Adapter<MLAAdapetr.ViewHolder> {
    public MLAAdapetr(Context context, List<MLAItem> list) {
        this.context = context;
        this.list = list;
    }

    private Context context;
    private List<MLAItem> list;
    @NonNull
    @Override
    public MLAAdapetr.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View layout= LayoutInflater.from(context).inflate(R.layout.mla_item,parent,false);
     return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MLAAdapetr.ViewHolder holder, int position) {

     holder.name.setText(list.get(position).getName());
     holder.constituencyName.setText(list.get(position).getConstituencyName());
     if(list.get(position).getParty().contentEquals("JD(S)")){
         Picasso.with(context).load(R.drawable.jds).into(holder.party);
     }else if(list.get(position).getParty().contentEquals("INC")){
         Picasso.with(context).load(R.drawable.congress).into(holder.party);
     }else {
         Picasso.with(context).load(R.drawable.bjp).into(holder.party);
         Picasso.with(context).load(R.drawable.bjp).into(holder.party);
     }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,constituencyName;
        ImageView party;
        public ViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.mla_name);
            constituencyName=itemView.findViewById(R.id.constituency);
            party=itemView.findViewById(R.id.party);
        }
    }
}
