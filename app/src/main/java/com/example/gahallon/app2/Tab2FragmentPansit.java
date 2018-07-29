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

public class Tab2FragmentPansit extends Fragment {
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
        View view = inflater.inflate(R.layout.tab2_fragment_pansit,container,false);


        localNamesLabel = view.findViewById(R.id.localNamesLabel);
        localNamesLabel.setText("LOCAL NAMES");

        localNames = view.findViewById(R.id.localNames);
        localNames.setText("•baribatang (Tbw)\n" +
                "•ikmo (Bis)(Tag)\n" +
                "•lato-lato (Bik)\n" +
                "•saki -puti (Tag)\n" +
                "•sida-sida (Bis)\n" +
                "•ulasimang-bato (Tag)\n");

        distributionLabel = view.findViewById(R.id.distributionLabel);
        distributionLabel.setText("DISTRIBUTION");

        distribution = view.findViewById(R.id.distribution);
        distribution.setText("Throughout the Philippines. It is native to tropical America and is now a pantropic weed.");

        habitatLabel = view.findViewById(R.id.habitatLabel);
        habitatLabel.setText("HABITAT");

        habitat = view.findViewById(R.id.habitat);
        habitat.setText("In open, usually damp and shaded places");

        statusLabel = view.findViewById(R.id.statusLabel);
        statusLabel.setText("CONSERVATION STATUS");

        status = view.findViewById(R.id.status);
        status.setText("Common, Not a threatened species");

        propagationLabel = view.findViewById(R.id.propagationLabel);
        propagationLabel.setText("PROPAGATION");

        propagation = view.findViewById(R.id.propagation);
        propagation.setText("It is easily propagated by the tiny seeds which are readily spread by wind.");

        notesLabel = view.findViewById(R.id.notesLabel);
        notesLabel.setText("NOTES");

        notes = view.findViewById(R.id.notes);
        notes.setText("This is a weed common in gardens and cultivated fields. The leaves and stems are eaten as salad.");

        return view;
    }
}
