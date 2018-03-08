package com.example.arjunmore.mca;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ARJUN on 2/4/2018.
 */

//public class TopicAdapter {
//}

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.MyviewHolde>{
    List<Topic_And_Data> mylist;
    Context context;
    View view;
    public TopicAdapter(List<Topic_And_Data> mylist, Context context) {
        this.mylist = mylist;
        this.context = context;
    }


    @Override
    public MyviewHolde onCreateViewHolder(ViewGroup parent, int viewType) {
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.format_topic,parent,false);
        return new MyviewHolde(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolde holder, int position) {
        Topic_And_Data topic = mylist.get(position);
        holder.txtTopicName.setText(topic.getTopicName());
        holder.txtTopicData.setText(topic.getTopicData());
        //   holder.txtTopicName.setText(topic.getTopicData());
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class MyviewHolde extends RecyclerView.ViewHolder {
        TextView txtTopicName ;
        TextView txtTopicData ;

        public MyviewHolde(View itemView) {
            super(itemView);
            txtTopicName = itemView.findViewById(R.id.txtTopicName);
            txtTopicData = itemView.findViewById(R.id.txtTopicContent);


        }
    }

}
