package com.example.mywork_r1kka;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> list;
    private Context context;
    private View inflater;



    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflater);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.textView.getText() == "IPhone 13 pro max") {
                    Intent intent = new Intent(context, MainActivity2.class);
                    context.startActivity(intent);
                }
                if(holder.textView.getText() == "HUAWEI p50"){
                    Intent intent = new Intent(context, MainActivity3.class);
                    context.startActivity(intent);
                }
                if(holder.textView.getText() == "SAMSUNG Galaxy Z Filp3"){
                    Intent intent = new Intent(context, MainActivity4.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
