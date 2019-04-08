package com.example.ayedis_ecommerce;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class specialbonusFragment extends Fragment {

    TextView nextButton;
    TextView backButton;
    ViewPager viewPager;

    public specialbonusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_specialbonus, container, false);
        viewPager = getActivity().findViewById(R.id.viewPager);
        nextButton = view.findViewById(R.id.slideTwoNext);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        backButton = view.findViewById(R.id.slideTwoBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });
        return view;    }

}
