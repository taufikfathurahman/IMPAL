package com.example.ayedis_ecommerce;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class bigsaleFragment extends Fragment {

    TextView nextFragment;
    ViewPager viewPager;

    public bigsaleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bigsale, container, false);
        viewPager = getActivity().findViewById(R.id.viewPager);
        nextFragment = view.findViewById(R.id.slideOneNext);
        nextFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        return view;
    }

}
