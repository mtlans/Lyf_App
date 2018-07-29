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

public class Tab1FragmentBayabas extends Fragment {
    private static final String TAG = "Tab1Fragment";
    private TextView commonName;
    private TextView scientificName;
    private TextView englishName;
    private TextView recommendedLabel;
    private TextView recommendedfor;
    private TextView recommended;
    private TextView beneficialLabel;
    private TextView beneficialFor1;
    private TextView beneficial1;
    private TextView beneficialFor2;
    private TextView beneficial2;
    private TextView beneficialFor3;
    private TextView beneficial3;
    private TextView beneficialFor4;
    private TextView beneficial4;
    private TextView beneficialFor5;
    private TextView beneficial5;
    private TextView notRecommendedLabel;
    private TextView notRecommended;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment_bayabas,container,false);

        commonName = view.findViewById(R.id.commonName);
        commonName.setText("Bayabas");

        scientificName = view.findViewById(R.id.scienteficName);
        scientificName.setText("Psidium guajava");

        englishName = view.findViewById(R.id.englishName);
        englishName.setText("Guava");

        recommendedLabel = view.findViewById(R.id.recommendedLabel);
        recommendedLabel.setText("RECOMMENDED");

        recommendedfor = view.findViewById(R.id.recommendedfor);
        recommendedfor.setText("SCABIES/WOUNDS WITH PUS");


        recommended = view.findViewById(R.id.recommended);
        recommended.setText("•Boil 1 or 2 handfuls of bayabas sprout in a small pot with water.\n" +
                "•Wash the wound using the boiled water. Do this 2 times a day until the scabies or wound recovers.\n" +
                "•Consult in a health center if it does not heal and results into a fever and/or redness of the wound surroundings. ");

        beneficialLabel = view.findViewById(R.id.beneficialLabel);
        beneficialLabel.setText("BENEFICIAL");

        beneficialFor1 = view.findViewById(R.id.beneficialFor1);
        beneficialFor1.setText("AVOID SICKNESS");

        beneficial1 = view.findViewById(R.id.beneficial1);
        beneficial1.setText("•To avoid hypertension, heart disease, diabetes, cancer, etc. Remember to eat the right amount of numerous vegetables such as bayabas, also fruits, beans, grains, nuts, and root crops daily. The leaf of a bayabas is considered as one of the healthiest vegetables.");

        beneficialFor2 = view.findViewById(R.id.beneficialFor2);
        beneficialFor2.setText("DIZZINESS");

        beneficial2 = view.findViewById(R.id.beneficial2);
        beneficial2.setText("•Crush or squeeze fresh sprouts of bayabas leaves and smell its aroma.");

        beneficialFor3 = view.findViewById(R.id.beneficialFor3);
        beneficialFor3.setText("SWOLLEN GUM");

        beneficial3 = view.findViewById(R.id.beneficial3);
        beneficial3.setText("•Take a kilo of bayabas sprouts and boil it in a small pot with water.\n" +
                "•Gargle the boiled water. Do this 2 times a day until it recovers.\n");


        beneficialFor4 = view.findViewById(R.id.beneficialFor4);
        beneficialFor4.setText("FOR CLEANSING THE PRIVATE PARTS OF A WOMAN WHO RECENTLY GIVE BIRTH");

        beneficial4 = view.findViewById(R.id.beneficial4);
        beneficial4.setText("•Boil a handful of bayabas sprouts in a pot with water.\n" +
                "•Use the boiled water for bathing.\n");

        beneficialFor5 = view.findViewById(R.id.beneficialFor5);
        beneficialFor5.setText("ITCHINESS");

        beneficial5 = view.findViewById(R.id.beneficial5);
        beneficial5.setText("•Boil the right amount of bayabas sprout in a pot with water.\n" +
                "•Use the boiled water, when warm, for bathing.\n");

//        notRecommendedLabel = view.findViewById(R.id.notRecommendedLabel);
//        notRecommendedLabel.setText("NOT RECOMMENDED");
//
//        notRecommended = view.findViewById(R.id.notRecommended);
//        notRecommended.setText("•Bawang is not recommended to be used on snake or dog bites. It is an EMERGENCY that needs to be brough to the health center");


        return view;
    }
}
