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

public class Tab2FragmentBayabas extends Fragment {
    private static final String TAG = "Tab2Fragment";


    private TextView localNamesLabel;
    private TextView localNames;
    private TextView distributionLabel;
    private TextView distribution;
    private TextView habitatLabel;
    private TextView habitat;
    private TextView statusLabel;
    private TextView status;
    private TextView propagationLabel;
    private TextView propagation;
    private TextView notesLabel;
    private TextView notes;

    Global sharedData = Global.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment_bayabas,container,false);


        localNamesLabel = view.findViewById(R.id.localNamesLabel);
        localNamesLabel.setText("LOCAL NAMES");

        localNames = view.findViewById(R.id.localNames);
        localNames.setText("•ajos (Sp)\n" +
                "•bawang(Many Lgs)\n");

        distributionLabel = view.findViewById(R.id.distributionLabel);
        distributionLabel.setText("DISTRIBUTION");

        distribution = view.findViewById(R.id.distribution);
        distribution.setText("Garlic is native to Southern Europe and Central Asia and is now cultivated throughout the world. It was introduced into the Philippines during the early period and is now extensively grown in Batanes Islands, Batangas, Nueva Ecija, Ilocos Norte, Mindoro, and Cotabato. It is also cultivated to a lesser extent in other parts of the country");

//        habitatLabel = view.findViewById(R.id.habitatLabel);
//        habitatLabel.setText("HABITAT");

//        habitat = view.findViewById(R.id.habitat);
//        habitat.setText("Often growing in open places and waste lands, at low and medium altitudes. Also cultivated in gardens.");

        statusLabel = view.findViewById(R.id.statusLabel);
        statusLabel.setText("CONSERVATION STATUS");

        status = view.findViewById(R.id.status);
        status.setText("Common, Not a threatened species");

        propagationLabel = view.findViewById(R.id.propagationLabel);
        propagationLabel.setText("PROPAGATION");

        propagation = view.findViewById(R.id.propagation);
        propagation.setText("It is usually propagated vegetatively by separation of the cloves or bulblets.");

        notesLabel = view.findViewById(R.id.notesLabel);
        notesLabel.setText("NOTES");

        notes = view.findViewById(R.id.notes);
        notes.setText("Garlic is a popular spice and condiment, and is used as flavoring in many local dishes. The sticky juice is used as an adhesive in China, and the bulbs are used to eradicate worms and insects in some countries.");

        return view;
    }
}
