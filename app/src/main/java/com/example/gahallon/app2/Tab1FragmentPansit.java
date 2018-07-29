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

public class Tab1FragmentPansit extends Fragment {
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
        View view = inflater.inflate(R.layout.tab1_fragment_pansit,container,false);

        commonName = view.findViewById(R.id.commonName);
        commonName.setText("Pansit-pansitan");

        scientificName = view.findViewById(R.id.scienteficName);
        scientificName.setText("Peperomia pellucida");

        englishName = view.findViewById(R.id.englishName);
        englishName.setText("Peperomia");

        recommendedLabel = view.findViewById(R.id.recommendedLabel);
        recommendedLabel.setText("RECOMMENDED");

        recommendedfor = view.findViewById(R.id.recommendedfor);
        recommendedfor.setText("HIGH URIC ACID LEVEL");


        recommended = view.findViewById(R.id.recommended);
        recommended.setText("•Consult a health center for the treatment of high uric acid level. Including the use of pansit-pansitan leaves to control the level of blood sugar.\n" +
                "•Doctors might suggest the consumption of 1 cup of pansit-pansitan, 3 times a day (as a salad; soaked in hot water), or they could also suggest boiling a cup of sprouts with 2 cups of water (15 minutes to boil). And drink 1/3 cup 3 times a day (after  a meal).\n");
        beneficialLabel = view.findViewById(R.id.beneficialLabel);
        beneficialLabel.setText("BENEFICIAL");

        beneficialFor = view.findViewById(R.id.beneficialFor);
        beneficialFor.setText("AVOID SICKNESS");

        beneficial = view.findViewById(R.id.beneficial);
        beneficial.setText("•To avoid hypertension, heart disease, diabetes, cancer, etc. Remember to eat a right amount of numerous vegetables such as pansit-pansitan, also fruits, beans, grains, nuts, and root crops daily. ");
//
//        notRecommendedLabel = view.findViewById(R.id.notRecommendedLabel);
//        notRecommendedLabel.setText("NOT RECOMMENDED");
//
//        notRecommended = view.findViewById(R.id.notRecommended);
//        notRecommended.setText("•Bawang is not recommended to be used on snake or dog bites. It is an EMERGENCY that needs to be brough to the health center");


        return view;
    }
}
