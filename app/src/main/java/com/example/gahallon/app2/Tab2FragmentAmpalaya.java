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

public class Tab2FragmentAmpalaya extends Fragment {
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
        View view = inflater.inflate(R.layout.tab2_fragment_ampalaya,container,false);


        localNamesLabel = view.findViewById(R.id.localNamesLabel);
        localNamesLabel.setText("LOCAL NAMES");

        localNames = view.findViewById(R.id.localNames);
        localNames.setText("•afafe (Ibg)\n" +
                "•amaragoso(Bik)\n" +
                "•palya (Bis)\n" +
                "•palya apafit (Ifg)\n" +
                "•paria (Ilk)\n" +
                "•periya (Mbo)");

        distributionLabel = view.findViewById(R.id.distributionLabel);
        distributionLabel.setText("DISTRIBUTION");

        distribution = view.findViewById(R.id.distribution);
        distribution.setText("Throughout the Philippines. Introduced to the Philippines in the early times, probably before the colonial period, and is now naturalized. Its origin is unknown.");
        habitatLabel = view.findViewById(R.id.habitatLabel);
        habitatLabel.setText("HABITAT");

        habitat = view.findViewById(R.id.habitat);
        habitat.setText("It is mostly cultivated in gardens or growing wild in thickets and waste places at low and medium altitudes.");
        statusLabel = view.findViewById(R.id.statusLabel);
        statusLabel.setText("CONSERVATION STATUS");

        status = view.findViewById(R.id.status);
        status.setText("Common, Not a threatened species");

        propagationLabel = view.findViewById(R.id.propagationLabel);
        propagationLabel.setText("PROPAGATION");

        propagation = view.findViewById(R.id.propagation);
        propagation.setText("By seeds.");

        notesLabel = view.findViewById(R.id.notesLabel);
        notesLabel.setText("NOTES");

        notes = view.findViewById(R.id.notes);
        notes.setText("The fruit is edible and is a popular vegetable. The wild variety has small, ovoid, and bitter fruits and the cultivated varieties have elongate or oblong fruits. The tender shoots and leaves are also eaten as vegetables.");
        return view;
    }
}
