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

public class Tab1FragmentNiyogNiyogan extends Fragment {
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
        View view = inflater.inflate(R.layout.tab1_fragment_niyogniyogan,container,false);

        commonName = view.findViewById(R.id.commonName);
        commonName.setText("Niyog-Niyogan");

        scientificName = view.findViewById(R.id.scienteficName);
        scientificName.setText("Quisqualis indica");

        englishName = view.findViewById(R.id.englishName);
        englishName.setText("Chinese Honey Suckle");

        recommendedLabel = view.findViewById(R.id.recommendedLabel);
        recommendedLabel.setText("RECOMMENDED");

        recommendedfor = view.findViewById(R.id.recommendedfor);
        recommendedfor.setText("WORM");


        recommended = view.findViewById(R.id.recommended);
        recommended.setText("•Get a parent seed and a dry fruit of niyogniyogan.\n" +
                "•Eat it and drink half a cup of water. \n" +
                "•Possible side effects: dizziness, fever, stomach ache, or constipation. Be strict on the recommended number of seeds. " );

//        beneficialLabel = view.findViewById(R.id.beneficialLabel);
//        beneficialLabel.setText("BENEFICIAL");
//
//        beneficialFor = view.findViewById(R.id.beneficialFor);
//        beneficialFor.setText("SCABIES");
//
//        beneficial = view.findViewById(R.id.beneficial);
//        beneficial.setText("•Grind a right amount of fresh akapulko leaves.\n" +
//                        "•Before going to sleep, take a bath and rub it at your skin except your face. Repeat this for 3 consecutive nights for the scabies to fade.\n" +
//                "•Let all the people that you live with perform these steps to avoid the infection to spread.");


//        notRecommendedLabel = view.findViewById(R.id.notRecommendedLabel);
//        notRecommendedLabel.setText("NOT RECOMMENDED");
//
//        notRecommended = view.findViewById(R.id.notRecommended);
//        notRecommended.setText("•Bawang is not recommended to be used on snake or dog bites. It is an EMERGENCY that needs to be brough to the health center");


        return view;
    }
}
