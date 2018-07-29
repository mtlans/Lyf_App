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

public class Tab1FragmentSambong extends Fragment {
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
        View view = inflater.inflate(R.layout.tab1_fragment_sambong,container,false);

        commonName = view.findViewById(R.id.commonName);
        commonName.setText("Sambong");

        scientificName = view.findViewById(R.id.scienteficName);
        scientificName.setText("Blumea balsamifera");

        englishName = view.findViewById(R.id.englishName);
        englishName.setText("Sambong");

        recommendedLabel = view.findViewById(R.id.recommendedLabel);
        recommendedLabel.setText("RECOMMENDED");

        recommendedfor = view.findViewById(R.id.recommendedfor);
        recommendedfor.setText("KIDNEY STONES");


        recommended = view.findViewById(R.id.recommended);
        recommended.setText("•Consult a health center to know the best treatment for kidney stones.\n" +
                "•Boil the chopped leaves of sambong in a pot with two cups of water until it reaches half full. When it is boiling, do not place the lid of the pot.\n"+
                "•Let it sit for a while and drain the water. ");


//        beneficialLabel = view.findViewById(R.id.beneficialLabel);
//        beneficialLabel.setText("BENEFICIAL");
//
//        beneficialFor = view.findViewById(R.id.beneficialFor);
//        beneficialFor.setText("AVOID SICKNESS");
//
//        beneficial = view.findViewById(R.id.beneficial);
//        beneficial.setText("•To avoid hypertension, heart disease, diabetes, cancer, etc. Remember to eat a right amount of numerous vegetables, fruits, beans, grains, nuts, root crops, and spices (such as bawang) every day. \n" +
//                "•Let it be a habit to have a healthy lifestyle by exercising, having enough sleep, being active to avoid stress, avoiding smoking, and many more.\n" +
//                "");
//
//        notRecommendedLabel = view.findViewById(R.id.notRecommendedLabel);
//        notRecommendedLabel.setText("NOT RECOMMENDED");
//
//        notRecommended = view.findViewById(R.id.notRecommended);
//        notRecommended.setText("•Bawang is not recommended to be used on snake or dog bites. It is an EMERGENCY that needs to be brough to the health center");


        return view;
    }
}
