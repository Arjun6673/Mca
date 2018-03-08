package com.example.arjunmore.mca;

import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class SubjectFragment extends android.app.Fragment {
    View view;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SubjectFragment() {
        // Required empty public constructor
    }

    public static SubjectFragment newInstance(String param1, String param2) {
        SubjectFragment fragment = new SubjectFragment();
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

        view= inflater.inflate(R.layout.fragment_subject, container, false);
        //passed value


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        ///getting data from home activity
        String semid = getArguments().getString("key_value");//Get pass data with its key value

        RecyclerView recyclerView = view.findViewById(R.id.recycleSubject);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DatabaseClass databaseClass = new DatabaseClass(getActivity());

         List<Subject> mylist = databaseClass.GetSpecificSubject(semid);
       // List<Subject> mylist = databaseClass.GetSubjectData();

        FragmentManager fragmentManager11= getFragmentManager();
        SubjectAdapter subjectAdapter = new SubjectAdapter(mylist,getActivity(),fragmentManager11);
        recyclerView.setAdapter(subjectAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
