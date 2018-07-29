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

public class Tab2FragmentLagundi extends Fragment {
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
        View view = inflater.inflate(R.layout.tab2_fragment_lagundi,container,false);


        localNamesLabel = view.findViewById(R.id.localNamesLabel);
        localNamesLabel.setText("LOCAL NAMES");

        localNames = view.findViewById(R.id.localNames);
        localNames.setText("•dabtan (Ifg)\n" +
                "•dangla (Ilk)\n" +
                "•lagundi (Bik, Ibg, Tag, Bis)\n" +
                "•lingei (Bom)\n" +
                "•sagarai (Bgb)\n");

        distributionLabel = view.findViewById(R.id.distributionLabel);
        distributionLabel.setText("DISTRIBUTION");

        distribution = view.findViewById(R.id.distribution);
        distribution.setText("Throughout the Philippines, Tropical East Africa, Madagascar, from India to Japan, southward through Malesia to Polynesia.");

        habitatLabel = view.findViewById(R.id.habitatLabel);
        habitatLabel.setText("HABITAT");

        habitat = view.findViewById(R.id.habitat);
        habitat.setText("Often growing in open places and waste lands, at low and medium altitudes. Also cultivated in gardens.");

        statusLabel = view.findViewById(R.id.statusLabel);
        statusLabel.setText("CONSERVATION STATUS");

        status = view.findViewById(R.id.status);
        status.setText("Common, Not a threatened species");

        propagationLabel = view.findViewById(R.id.propagationLabel);
        propagationLabel.setText("PROPAGATION");

        propagation = view.findViewById(R.id.propagation);
        propagation.setText("By seeds and stem cuttings");

        notesLabel = view.findViewById(R.id.notesLabel);
        notesLabel.setText("NOTES");

        notes = view.findViewById(R.id.notes);
        notes.setText("The plant is used in landscaping because of its ornamental leaves and fragrant blooms. The flowers are attractive to butterflies and bees. The leaves are used as effective control against storage pests of garlic");

        return view;
    }
}
