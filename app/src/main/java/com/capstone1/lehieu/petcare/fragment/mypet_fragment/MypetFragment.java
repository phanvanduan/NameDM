package com.capstone1.lehieu.petcare.fragment.mypet_fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.capstone1.lehieu.petcare.MainActivity;
import com.capstone1.lehieu.petcare.R;

import java.util.Objects;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MypetFragment extends Fragment {
    Button btnAddPet;

    public MypetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mypet, container, false);
        ((MainActivity) Objects.requireNonNull(getActivity())).setNavigationVisibility(true);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        navigationTo();
    }

    //METHOD
    private void init(View view) {
        btnAddPet = view.findViewById(R.id.btnAddPet);
    }
    private void navigationTo() {
        //navgation using nav_graph
        btnAddPet.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toAddPetFragment));
    }
}
