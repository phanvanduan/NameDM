package com.capstone1.lehieu.petcare.fragment.newsfeed_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.capstone1.lehieu.petcare.MainActivity;
import com.capstone1.lehieu.petcare.R;

import java.util.Objects;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostDetailFragment extends Fragment {
    TextView txtname,txtcontent;
    ImageView photo;
    View view;


    public PostDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_post_detail, container, false);
        ((MainActivity) Objects.requireNonNull(getActivity())).setNavigationVisibility(true);
        AnhXa();
        return view;
    }
    private void AnhXa(){
        txtname    = (TextView) view.findViewById(R.id.txtDialodNameUser);
        txtname.setText(getArguments().getString("Name"));
        txtcontent =(TextView) view.findViewById(R.id.txtDialodContent);
        txtcontent.setText(getArguments().getString("Content"));
        photo      =(ImageView) view.findViewById(R.id.imgDialodHinh);
         photo.setImageResource(getArguments().getInt("Hinh"));

    }






}
