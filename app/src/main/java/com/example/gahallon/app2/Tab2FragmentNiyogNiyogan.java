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

public class Tab2FragmentNiyogNiyogan extends Fragment {
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
        View view = inflater.inflate(R.layout.tab2_fragment_niyogniyogan,container,false);


        localNamesLabel = view.findViewById(R.id.localNamesLabel);
        localNamesLabel.setText("LOCAL NAMES");

        localNames = view.findViewById(R.id.localNames);
        localNames.setText("•alleluia (Ilk)\n" +
                "•balitadhan, pilones, pinyon(Bis)\n" +
                "•bawe-bawe(Kpm)\n" +
                "•talulong(Ibg, Ilk, Tag)\n" +
                "•taungon(Mbo)\n");

        distributionLabel = view.findViewById(R.id.distributionLabel);
        distributionLabel.setText("DISTRIBUTION");

        distribution = view.findViewById(R.id.distribution);
        distribution.setText("The species originated in South Asia and is now found in many parts of the tropics from India to the Malay Peninsula and Southeast Asia. It is widely distributed in the Philippines");

        habitatLabel = view.findViewById(R.id.habitatLabel);
        habitatLabel.setText("HABITAT");

        habitat = view.findViewById(R.id.habitat);
        habitat.setText("In thickets and secondary forests at low and medium altitudes. Commonly planted in gardens, or it escapes cultivation and becomes a weed.");

        statusLabel = view.findViewById(R.id.statusLabel);
        statusLabel.setText("CONSERVATION STATUS");

        status = view.findViewById(R.id.status);
        status.setText("Common, Not a threatened species");

        propagationLabel = view.findViewById(R.id.propagationLabel);
        propagationLabel.setText("PROPAGATION");

        propagation = view.findViewById(R.id.propagation);
        propagation.setText("By seeds, shoots, and stem cuttings");

//        notesLabel = view.findViewById(R.id.notesLabel);
//        notesLabel.setText("NOTES");
//
//        notes = view.findViewById(R.id.notes);
//        notes.setText("The local name, akapulko, indicates the origin of the plant from Mexico. The plant is cultivated in gardens as an ornamental. ");
        return view;
    }
}
