package com.capstone1.lehieu.petcare.fragment.newsfeed_fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.capstone1.lehieu.petcare.R;

import java.util.List;

import androidx.navigation.Navigation;

public class ShopAdapterPeople  extends RecyclerView.Adapter<ShopAdapterPeople.ViewHolder> {
    List<DataShopPeople> dataShops;
    Context context;
    Dialog myDialog;

    public ShopAdapterPeople(List<DataShopPeople> dataShops, Context context) {
        this.dataShops = dataShops;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.itempeople,parent,false);
        final ViewHolder vHooler=new ViewHolder(v);
      /*  //dialog từ cá nhân
        myDialog =new Dialog(context);
        myDialog.setContentView(R.layout.dialog_people);


        vHooler.people_itemrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_name = (TextView) myDialog.findViewById(R.id.txtDialodNameUser);
                TextView dialog_content = (TextView) myDialog.findViewById(R.id.txtDialodContent);
                ImageView dialog_hinh = (ImageView)  myDialog.findViewById(R.id.imgDialodHinh);
                dialog_name.setText(dataShops.get(vHooler.getAdapterPosition()).getTen());
                dialog_content.setText(dataShops.get(vHooler.getAdapterPosition()).getContent());
                dialog_hinh.setImageResource(dataShops.get(vHooler.getAdapterPosition()).getHinhAnh());
                Toast.makeText(context,"Dm  Click"+String.valueOf(vHooler.getAdapterPosition()),Toast.LENGTH_LONG).show();
                myDialog.show();
            }
        });//của dialog*/

       // vHooler.people_itemrow.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.ListPostToPostDetailFragment));

        return  vHooler;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
      //  DataShopPeople dataShopPeople =dataShops.get(position);
        holder.txtName.setText(dataShops.get(position).getTen());
        holder.imgHinh.setImageResource(dataShops.get(position).getHinhAnh());
        holder.txtcontent.setText(dataShops.get(position).getContent());
        holder.people_itemrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent=new Intent(context,PostDetailFragment.class);
                intent.putExtra("Name",dataShops.get(position).getTen());
                intent.putExtra("Content",dataShops.get(position).getContent());
                intent.putExtra("Hinh",dataShops.get(position).getHinhAnh());
                context.startActivity(intent);*/
                Bundle bundle = new Bundle();

                bundle.putString("Name",dataShops.get(position).getTen());
                bundle.putString("Content",dataShops.get(position).getContent());
                bundle.putInt("Hinh",dataShops.get(position).getHinhAnh());
                Navigation.findNavController(v).navigate(R.id.ListPostToPostDetailFragment,bundle);


            }
        });

    }


    @Override
    public int getItemCount() {
        return dataShops.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       CardView people_itemrow;

        TextView txtName;
        TextView txtcontent;
        ImageView imgHinh;



        public ViewHolder(View itemView) {
            super(itemView);

          people_itemrow = (CardView) itemView.findViewById(R.id.people_itemrow_id);
           // cardView =(CardView) itemView.findViewById(R.id.cardview_id);
            txtName =(TextView) itemView.findViewById(R.id.txtNameUser);
            imgHinh =(ImageView) itemView.findViewById(R.id.imgHinh);
            txtcontent = (TextView) itemView.findViewById(R.id.txtContent);
        }


    }
}
