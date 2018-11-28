package com.capstone1.lehieu.petcare.fragment.mypet_fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.capstone1.lehieu.petcare.MainActivity;
import com.capstone1.lehieu.petcare.R;

import java.util.Objects;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddPetDetailFragment extends Fragment {
    private static final int RESULT_LOAD_IMAGE = 1;
    RelativeLayout rlAddImageAvatar;
    ImageView imgPetAvatar;
    TextView tvAddPetOK;
    public AddPetDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_pet_detail, container, false);
        ((MainActivity) Objects.requireNonNull(getActivity())).setNavigationVisibility(false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        onClick();
    }

    private void init(View view){
        rlAddImageAvatar = view.findViewById(R.id.rlAddImageAvatar);
        imgPetAvatar = view.findViewById(R.id.imgPetAvatar);
        tvAddPetOK = view.findViewById(R.id.tvAddPetOK);
    }

    private void onClick(){
        rlAddImageAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
                gallery.setType("image/*");
                startActivityForResult(gallery, RESULT_LOAD_IMAGE);
            }
        });
        tvAddPetOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Thêm vào database thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK){
            Uri imageUri = data.getData();
            imgPetAvatar.setImageURI(imageUri);

        }
    }

}
