package com.example.gahallon.app2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by User on 2/28/2017.
 */

public class Tab3FragmentPansit extends Fragment {
    private static final String TAG = "Tab2Fragment";
    private TextView plantLabel;
    private TextView leafLabel;
    private TextView inflorescenceLabel;
    private TextView botanicalLabel;

    private Button btnTEST;
    Global sharedData = Global.getInstance();
    private String selectedItem;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3_fragment_pansit,container,false);

        plantLabel = view.findViewById(R.id.plantLabel);
        plantLabel.setText("Pansit-pansitan Plant");

        leafLabel = view.findViewById(R.id.leafLabel);
        leafLabel.setText("Pansit-pansitan Leaf");

//        inflorescenceLabel = view.findViewById(R.id.inflorescenceLabel);
//        inflorescenceLabel.setText("Bawang Bulb");

        botanicalLabel = view.findViewById(R.id.botanicalLabel);
        botanicalLabel.setText("Botanical Illustration");
        return view;
    }
}
