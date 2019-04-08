package com.example.ayedis_ecommerce;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class everywhereFragment extends Fragment {

    TextView doneButton;
    TextView backButton;
    ViewPager viewPager;

    public everywhereFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_everywhere, container, false);
        viewPager = getActivity().findViewById(R.id.viewPager);
        doneButton = view.findViewById(R.id.slideFourthDone);
        doneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentMain = new Intent(getActivity(), MainActivity.class);
                startActivity(intentMain);
            }
        });

        backButton = view.findViewById(R.id.slideFourthBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });
        return view;
    }

}
