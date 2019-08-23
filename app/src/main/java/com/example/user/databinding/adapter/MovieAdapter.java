package com.example.user.databinding.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.user.databinding.CustomClickListener;
import com.example.user.databinding.MainActivity;
import com.example.user.databinding.R;
import com.example.user.databinding.TwoWayDataBinding;
import com.example.user.databinding.databinding.ActivityMainBinding;
import com.example.user.databinding.databinding.ItemRowBinding;
import com.example.user.databinding.model.ModelClass;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> implements CustomClickListener {

    private Context context;
    private List<ModelClass> list;

//    public TextView textName, textEmail;
//    public ImageView imageView;

    public MovieAdapter(Context context, List<ModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void cardClicked(ModelClass f) {
        context.startActivity(new Intent(context,TwoWayDataBinding.class));
//        Toast.makeText(context, "You clicked on "+f.first_name,
//                Toast.LENGTH_LONG).show();
    }

    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView imageView, String url) {
        System.out.println("url = " + url);
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ItemRowBinding itemRowBinding;
      /*  public ViewHolder(View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.name);
            textEmail = itemView.findViewById(R.id.emailid);
            imageView = itemView.findViewById(R.id.imageView);
        }*/

        public ViewHolder(ItemRowBinding rowBinding) {
            super(rowBinding.getRoot());
            itemRowBinding = rowBinding;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       // View view = LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false);
        //return new ViewHolder(view);

        ItemRowBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_row, viewGroup, false);

        return new ViewHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
   /*     ModelClass modelClass = list.get(position);

        textName.setText(modelClass.getTitle());
        textEmail.setText(modelClass.getRating());
        String avatar = modelClass.getYear();
        System.out.println("avatar = " + avatar);
        Picasso.with(context)
                .load(avatar)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);*/

        ModelClass dataModel = list.get(position);
        holder.itemRowBinding.setModelClass(dataModel);
        holder.itemRowBinding.setItemClickListener(this);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
