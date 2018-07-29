package com.example.gahallon.app2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by User on 2/28/2017.
 */

public class Tab1FragmentLagundi extends Fragment {
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment_lagundi,container,false);

        commonName = view.findViewById(R.id.commonName);
        commonName.setText("Lagundi");

        scientificName = view.findViewById(R.id.scienteficName);
        scientificName.setText("Vitex negundo");

        englishName = view.findViewById(R.id.englishName);
        englishName.setText("5-leaved Chaste Tree");

        recommendedLabel = view.findViewById(R.id.recommendedLabel);
        recommendedLabel.setText("RECOMMENDED");

        recommendedfor = view.findViewById(R.id.recommendedfor);
        recommendedfor.setText("COUGH");


        recommended = view.findViewById(R.id.recommended);
        recommended.setText("• Boil the chopped leaves of Vitex negundo in a pot with two cups of water until it reaches half full. When it is boiling, do not place the lid of the pot." +
                "\n• Let it sit for a while and drain the water." +
                "\n• Divide the boiled leaves into 3 portions. Drink 1 portion 3 times a day.  ");

        beneficialLabel = view.findViewById(R.id.beneficialLabel);
        beneficialLabel.setText("BENEFICIAL");

        beneficialFor = view.findViewById(R.id.beneficialFor);
        beneficialFor.setText("FOR WOMEN WHO RECENTLY GAVE BIRTH");

        beneficial = view.findViewById(R.id.beneficial);
        beneficial.setText("•Boil the right amount of fresh leaves in a pot filled with water." +
                "\n•When it is warm, it can now be used for cleansing/bathing.\n");


        return view;
    }
}
