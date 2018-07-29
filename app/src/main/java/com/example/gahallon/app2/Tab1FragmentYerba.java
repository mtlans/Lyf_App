package com.example.gahallon.app2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by User on 2/28/2017.
 */

public class Tab1FragmentYerba extends Fragment {
    private static final String TAG = "Tab1Fragment";
    private TextView commonName;
    private TextView scientificName;
    private TextView englishName;
    private TextView recommendedLabel;
    private TextView recommendedfor;
    private TextView recommended;
    private TextView beneficialLabel;
    private TextView beneficialFor;
    private TextView beneficial;
    private TextView notRecommendedLabel;
    private TextView notRecommended;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment_yerba,container,false);

        commonName = view.findViewById(R.id.commonName);
        commonName.setText("Yerba Buena");

        scientificName = view.findViewById(R.id.scienteficName);
        scientificName.setText("Mentha x cordifolia");

        englishName = view.findViewById(R.id.englishName);
        englishName.setText("Peppermint");

        recommendedLabel = view.findViewById(R.id.recommendedLabel);
        recommendedLabel.setText("RECOMMENDED");

        recommendedfor = view.findViewById(R.id.recommendedfor);
        recommendedfor.setText("TOOTHACHE");


        recommended = view.findViewById(R.id.recommended);
        recommended.setText("•Boil the chopped leaves of Yerba Buena in a pot with two cups of water until it reaches half full. When it is boiling, do not place the lid of the pot.\n" +
                "•Let it sit for a while and drain the water. \n" +
                "•Divide the boiled leaves into 2 portions. Drink 1 portion every 3 or 4 hours if the pain does not fade." );

        beneficialLabel = view.findViewById(R.id.beneficialLabel);
        beneficialLabel.setText("BENEFICIAL");

        beneficialFor = view.findViewById(R.id.beneficialFor);
        beneficialFor.setText("HEADACHE");

        beneficial = view.findViewById(R.id.beneficial);
        beneficial.setText("•Crush some fresh leaves and use these to massage the forehead\n");


//        notRecommendedLabel = view.findViewById(R.id.notRecommendedLabel);
//        notRecommendedLabel.setText("NOT RECOMMENDED");
//
//        notRecommended = view.findViewById(R.id.notRecommended);
//        notRecommended.setText("•Bawang is not recommended to be used on snake or dog bites. It is an EMERGENCY that needs to be brough to the health center");


        return view;
    }
}
