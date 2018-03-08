package com.example.arjunmore.mca;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ARJUN on 2/4/2018.
 */

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.myViewHolder> {
    View view;
    List<Subject> mylist;
    Context context;
    FragmentManager fragmentManager;
    Subject subject;


    SubjectAdapter(List<Subject> mylist,Context context,FragmentManager fragmentManager)
    {
        this.mylist = mylist;
        this.context  = context;
        this.fragmentManager = fragmentManager;
    }


    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.format_subject,parent,false);
        return new myViewHolder(view);

    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        final int pos = position;
        subject = mylist.get(position);
        holder.txt1.setText(subject.getSubname());
        holder.txt2.setText(subject.getSubId());
        holder.txt3.setText(subject.getSemId());

        ///getting sub id and pass to Chapter Fragment

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subject = mylist.get(pos);
                String a = subject.getSubId()+ "";
                Toast.makeText(context, "Success value retrieved is" + a , Toast.LENGTH_SHORT).show();

                ChapterFragment chapterFragment = new ChapterFragment();

                Bundle bundle = new Bundle();
                bundle.putString("Sub_Id",""+a);
                chapterFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containlist,chapterFragment,"done");
                fragmentTransaction.commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    

    public class myViewHolder extends RecyclerView.ViewHolder {
        final TextView txt1,txt2,txt3;
        public myViewHolder(final View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txtsub);
            txt2 = itemView.findViewById(R.id.txtsemid);
            txt3 = itemView.findViewById(R.id.txtid);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    ChapterFragment chapterFragment = new ChapterFragment();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containlist,chapterFragment,"done");
                    fragmentTransaction.commit();


                }
            });

        }
    }




}
