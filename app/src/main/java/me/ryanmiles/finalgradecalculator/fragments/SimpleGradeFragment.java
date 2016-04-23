package me.ryanmiles.finalgradecalculator.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.ryanmiles.finalgradecalculator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleGradeFragment extends Fragment {

    EditText mDesiredGradeEditText;
    EditText mCurrentGradeEditText;
    EditText mWeightEditText;
    Button mCalculateButton;

    public SimpleGradeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_simple_grade, container, false);
        mDesiredGradeEditText = (EditText) rootView.findViewById(R.id.fragment_simple_grade_desired_grade_edit_text);
        mCurrentGradeEditText = (EditText) rootView.findViewById(R.id.fragment_simple_grade_current_grade_edit_text);
        mWeightEditText = (EditText) rootView.findViewById(R.id.fragment_simple_grade_weight_edit_text);
        mCalculateButton = (Button) rootView.findViewById(R.id.fragment_simple_grade_calculate_button);

        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
        return rootView;
    }

    private void calculate() {
        double desiredGrade = Integer.parseInt(mDesiredGradeEditText.getText().toString()) / 100.0;
        double currentGrade = Integer.parseInt(mCurrentGradeEditText.getText().toString()) / 100.0;
        double weight = Integer.parseInt(mWeightEditText.getText().toString()) / 100.0;
        double finalGrade = 0;
        finalGrade = (desiredGrade - (1 - weight) * currentGrade) / weight;
        finalGrade *= 100;
        Toast.makeText(getActivity(),"Final grade: " + finalGrade, Toast.LENGTH_LONG).show();

    }

}
