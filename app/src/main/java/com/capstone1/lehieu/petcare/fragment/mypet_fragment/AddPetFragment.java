package com.capstone1.lehieu.petcare.fragment.mypet_fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


import com.capstone1.lehieu.petcare.MainActivity;
import com.capstone1.lehieu.petcare.R;

import java.util.Objects;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddPetFragment extends Fragment {
    RelativeLayout rlAddDog, rlAddCat, rlAddHamster;
    public AddPetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_pet, container, false);
        ((MainActivity) Objects.requireNonNull(getActivity())).setNavigationVisibility(false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        onClick();
    }

    private void init(View view) {
        rlAddDog = view.findViewById(R.id.rlAddDog);
        rlAddCat = view.findViewById(R.id.rlAddCat);
        rlAddHamster = view.findViewById(R.id.rlAddHamster);
    }

    public void onClick() {
        rlAddDog.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toAddPetDetailFragment));
        rlAddCat.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toAddPetDetailFragment));
        rlAddHamster.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toAddPetDetailFragment));
    }

}
