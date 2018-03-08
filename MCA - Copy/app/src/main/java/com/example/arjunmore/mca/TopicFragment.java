package com.example.arjunmore.mca;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TopicFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TopicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopicFragment extends android.app.Fragment {
    View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TopicFragment() {
    }

    public static TopicFragment newInstance(String param1, String param2) {
        TopicFragment fragment = new TopicFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_topic, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        //////////////////getting data from chapter adapter
        String chap_id = getArguments().getString("ChapId");
        Toast.makeText(getActivity(),""+chap_id,Toast.LENGTH_LONG).show();


        RecyclerView recyclerView = view.findViewById(R.id.recycleTOpic);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DatabaseClass databaseClass =new DatabaseClass(getActivity());

        List<Topic_And_Data> mylist=  databaseClass.GetSpecificTopicDataTopic();
        Toast.makeText(getActivity(), mylist + "", Toast.LENGTH_SHORT).show();
        TopicAdapter topicAdapter = new TopicAdapter(mylist,getActivity());
        recyclerView.setAdapter(topicAdapter);


    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
