package com.zoovisitors.pl;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoovisitors.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class about_species_fragment extends Fragment {


    public about_species_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.about_species_res, container, false);

        return rootView;
    }

}
