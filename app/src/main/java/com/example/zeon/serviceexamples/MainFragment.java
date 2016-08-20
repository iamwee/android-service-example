package com.example.zeon.serviceexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Zeon on 20/8/2559.
 */
public class MainFragment extends Fragment {

    Button btnStart, btnStop;

    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void onRestoreInstanceState(Bundle savedState){

    }

    private void initInstances(View rootView){
        btnStart = (Button) rootView.findViewById(R.id.btn_start);
        btnStop = (Button) rootView.findViewById(R.id.btn_stop);

        btnStop.setOnClickListener(clickListener);
        btnStart.setOnClickListener(clickListener);
    }

    private void init(){

    }

    private
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == btnStart){
                startServices();
            } else if (view == btnStop){
                stopServices();
            }
        }
    };

    private void startServices() {
        getActivity().startService(new Intent(getActivity(), MyService.class));
        getActivity().finish();
    }

    private void stopServices(){
        getActivity().stopService(new Intent(getActivity(), MyService.class));
        getActivity().finish();
    }

}
