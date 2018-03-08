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

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.MyviewHolder> {
   private List<Chapter> mylist;
    private Context context;
    private FragmentManager fragmentManager;
    private  View view;
    private Chapter chapter;

    public ChapterAdapter(List<Chapter> mylist, Context context, FragmentManager fragmentManager) {

        this.mylist = mylist;
        this.context = context;
        this.fragmentManager = fragmentManager;

    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.format_chapter,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
        final int pos = position;
        chapter = mylist.get(position);
        holder.txtchapName.setText(chapter.getChapterName());
        holder.txtChapWeight.setText(chapter.getWeightage());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chapter = mylist.get(pos);
                String a = chapter.getChapterId()+ "";
              //  String b = chapter.get
                Toast.makeText(context, "Success" + a , Toast.LENGTH_SHORT).show();
                TopicFragment topicFragment = new TopicFragment();

                Bundle bundle = new Bundle();
                bundle.putString("ChapId","Value is"+ a);
                topicFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containlist,topicFragment,"done");
                fragmentTransaction.commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }


    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView txtchapName;
        TextView txtChapWeight;
        public MyviewHolder(View itemView) {
            super(itemView);
            txtchapName = itemView.findViewById(R.id.txtChapSub);
            txtChapWeight = itemView.findViewById(R.id.txtChapWeight);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                }
//            });




        }

    }

}
