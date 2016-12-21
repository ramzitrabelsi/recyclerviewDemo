package com.it_skills.ramzi.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ramzi on 21/12/16.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    ArrayList<Contact> adapter_list =new ArrayList<>();

    Context ctx;
    public ContactAdapter(ArrayList<Contact> adapter_list,Context ctx){
        this.adapter_list=adapter_list;
        this.ctx=ctx;
    }
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
        ContactViewHolder contactViewHolder= new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        //holder.img.setImageResource(adapter_list.get(position).getImg_id());

        Picasso.with(ctx)
                .load(adapter_list.get(position).getImg_id())
                .placeholder(R.mipmap.ic_launcher)
                .resize(150, 150)
                .centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(holder.img);

        holder.Name.setText(adapter_list.get(position).getName());
        holder.Email.setText(adapter_list.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return adapter_list.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView Name,Email;
        CheckBox checkBox;

        public ContactViewHolder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.img_id);
            Name=(TextView)itemView.findViewById(R.id.name);
            Email=(TextView)itemView.findViewById(R.id.email);
            checkBox=(CheckBox)itemView.findViewById(R.id.check_list_item);

        }
    }
}
