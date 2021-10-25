package com.example.mywork_r1kka;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import java.util.List;



public class WeChatFragment extends Fragment {
    public WeChatFragment() {
        // Required empty public constructor
    }
    private MyAdapter myAdapter;
    private RecyclerView recyclerView;
    private Context context;
    private List<String> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_wechat, container, false);
        context = this.getActivity();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        list = new ArrayList<>();
        list.add("IPhone 13 pro max");
        list.add("HUAWEI p50");
        list.add("小米 k40");
        list.add("SAMSUNG Galaxy Z Filp3");
        list.add("realme");
        list.add("Redmi 9a");
        list.add("oppo k9");
        list.add("vivo ioqq");
        list.add("8848钛金手机");
        list.add("Huawei matex2");
        list.add("Gemry v11v");

            myAdapter = new MyAdapter(context, list);
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.VERTICAL);

            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(myAdapter);

            // Inflate the layout for this fragment
            return view;
        }

}