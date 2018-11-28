package com.capstone1.lehieu.petcare.fragment.newsfeed_fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.capstone1.lehieu.petcare.MainActivity;
import com.capstone1.lehieu.petcare.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListPostFragment extends Fragment {
    Button btnAddPeople;
    Button btnShare;
    EditText editNamePost;
    EditText editContentPost;
    ImageView photoPost;

    public ListPostFragment() {
        // Required empty public constructor
    }
    View v;
    private RecyclerView recyclerView;
    private List<DataShopPeople> arrayListHinhAnh;
    ShopAdapterPeople adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_list_post, container, false);
        ((MainActivity) Objects.requireNonNull(getActivity())).setNavigationVisibility(true);
        recyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);
        adapter=new ShopAdapterPeople(arrayListHinhAnh,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return  v;

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayListHinhAnh=new ArrayList<>();
        arrayListHinhAnh.add(new DataShopPeople(R.drawable.petpark02,"Phan Văn Duẩn","Các bệnh thường gặp ở chó cách phòng chống và điều trị"));
        arrayListHinhAnh.add(new DataShopPeople(R.drawable.petpark03, "Phan Văn Đào","Các bệnh thường gặp ở chó cách phòng chống và điều trị"));
        arrayListHinhAnh.add(new DataShopPeople(R.drawable.petpark04, "Lê Hiếu","Các bệnh thường gặp ở chó cách phòng chống và điều trị"));
        arrayListHinhAnh.add(new DataShopPeople(R.drawable.petpark05, "Nguyễn Cửu Thuận","Các bệnh thường gặp ở chó cách phòng chống và điều trị"));
        arrayListHinhAnh.add(new DataShopPeople(R.drawable.petpark06, "Phan Công Nam","Các bệnh thường gặp ở chó cách phòng chống và điều trị"));
        arrayListHinhAnh.add(new DataShopPeople(R.drawable.petpark07, "Anh Đại","Các bệnh thường gặp ở chó cách phòng chống và điều trị"));

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // int PhotoPost =photoPost
                String Namepost=editContentPost.getText().toString();
                String Contentpost=editContentPost.getText().toString();
                arrayListHinhAnh.add(new DataShopPeople(Contentpost,Namepost));
                adapter.notifyDataSetChanged();
            }
        });
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        navigationTo();
    }

    //METHOD
    private void init(View view) {
        btnAddPeople = view.findViewById(R.id.btnAddPost);
        btnShare =view.findViewById(R.id.btnSharePost);
        editNamePost=(EditText) view.findViewById(R.id.editNamePost);
        editNamePost=(EditText) view.findViewById(R.id.editContentPost);
        photoPost=(ImageView) view.findViewById(R.id.imgPostAvatar);
    }
    private void navigationTo() {
        //navgation using nav_graph
        btnAddPeople.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.ToPostFragment));
    }


}
