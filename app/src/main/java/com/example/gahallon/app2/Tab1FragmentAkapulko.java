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

public class Tab1FragmentAkapulko extends Fragment {
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
        View view = inflater.inflate(R.layout.tab1_fragment_akapulko,container,false);

        commonName = view.findViewById(R.id.commonName);
        commonName.setText("Akapulko");

        scientificName = view.findViewById(R.id.scienteficName);
        scientificName.setText("Senna alata");

        englishName = view.findViewById(R.id.englishName);
        englishName.setText("Ringworm Bush");

        recommendedLabel = view.findViewById(R.id.recommendedLabel);
        recommendedLabel.setText("RECOMMENDED");

        recommendedfor = view.findViewById(R.id.recommendedfor);
        recommendedfor.setText("ATHLETE'S FOOT");


        recommended = view.findViewById(R.id.recommended);
        recommended.setText("•Grind an adequate amount of fresh akapulko leaves\n" +
                "•Rub the grinded leaves on the affected skin 2 times a day. \n" +
                "•Do these everyday for 3 weeks to remove the fungus.\n" +
                "•Keep your skin dry. \n\n" +
                "If you are allergic to the leaves of akapulko, do this instead; \n" +
                "•Boil the 1 cup of grinded leaves in a pot with 2 cups of water.\n" +
                "•Use it to wash the affected skin 2 times a day for 3 weeks. ");

        beneficialLabel = view.findViewById(R.id.beneficialLabel);
        beneficialLabel.setText("BENEFICIAL");

        beneficialFor = view.findViewById(R.id.beneficialFor);
        beneficialFor.setText("SCABIES");

        beneficial = view.findViewById(R.id.beneficial);
        beneficial.setText("•Grind the right amount of fresh akapulko leaves.\n" +
                        "•Before going to sleep, take a bath and rub it on your skin except your face. Repeat this for 3 consecutive nights for the scabies to fade.\n" +
                "•Let all the people that you live with perform these steps to avoid the infection to spread.");


//        notRecommendedLabel = view.findViewById(R.id.notRecommendedLabel);
//        notRecommendedLabel.setText("NOT RECOMMENDED");
//
//        notRecommended = view.findViewById(R.id.notRecommended);
//        notRecommended.setText("•Bawang is not recommended to be used on snake or dog bites. It is an EMERGENCY that needs to be brough to the health center");


        return view;
    }
}
