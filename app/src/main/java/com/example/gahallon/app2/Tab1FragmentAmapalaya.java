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

public class Tab1FragmentAmapalaya extends Fragment {
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
        View view = inflater.inflate(R.layout.tab1_fragment_ampalaya,container,false);

        commonName = view.findViewById(R.id.commonName);
        commonName.setText("Amapalaya");

        scientificName = view.findViewById(R.id.scienteficName);
        scientificName.setText("Momordica charantia");

        englishName = view.findViewById(R.id.englishName);
        englishName.setText("Bitter Gourd");

        recommendedLabel = view.findViewById(R.id.recommendedLabel);
        recommendedLabel.setText("RECOMMENDED");

        recommendedfor = view.findViewById(R.id.recommendedfor);
        recommendedfor.setText("DIABETES");


        recommended = view.findViewById(R.id.recommended);
        recommended.setText("•Consult a health center for the treatment of diabetes. Including the use of ampalaya leaves for controlling the level of blood sugar.\n" +
                "•Doctors might suggest drinking a teacup of ampalaya leaves 2 times a day (as a salad; soaked in hot water). Or they could also suggest boiling a cup of sprouts with 2 cups of water (15 minutes to boil). And drink 1/3 cup 3 times a day (30 minutes before taking a meal).\n");
        beneficialLabel = view.findViewById(R.id.beneficialLabel);
        beneficialLabel.setText("BENEFICIAL");

        beneficialFor = view.findViewById(R.id.beneficialFor);
        beneficialFor.setText("GASTROINTESTINAL HEALTH");

        beneficial = view.findViewById(R.id.beneficial);
        beneficial.setText("•To avoid constipation, let it be a habit to eat ampalaya and other vegetables, fruits, and other foods that are rich in fiber.");
        notRecommendedLabel = view.findViewById(R.id.notRecommendedLabel);
        notRecommendedLabel.setText("NOT RECOMMENDED");

        notRecommended = view.findViewById(R.id.notRecommended);
        notRecommended.setText("•Do not use seeds for irregular menstruation. Irregularity of menstruation might be a sign of pregnancy; Using the seeds of ampalaya is bad for a pregnant woman.");


        return view;
    }
}
