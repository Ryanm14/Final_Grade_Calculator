package me.ryanmiles.finalgradecalculator.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import me.ryanmiles.finalgradecalculator.R;


public class SimpleGradeFragment extends Fragment {

    EditText mDesiredGradeEditText;
    EditText mCurrentGradeEditText;
    EditText mWeightEditText;
    Button mCalculateButton;
    TextView mNeededGrade;

    public SimpleGradeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_simple_grade, container, false);
        mDesiredGradeEditText = (EditText) rootView.findViewById(R.id.fragment_simple_grade_desired_grade_edit_text);
        mCurrentGradeEditText = (EditText) rootView.findViewById(R.id.fragment_simple_grade_current_grade_edit_text);
        mWeightEditText = (EditText) rootView.findViewById(R.id.fragment_simple_grade_weight_edit_text);
        mCalculateButton = (Button) rootView.findViewById(R.id.fragment_simple_grade_calculate_button);
        mNeededGrade = (TextView) rootView.findViewById(R.id.fragment_simple_grade_grade_need_text_view);


        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
        return rootView;
    }


    private void calculate() {
        hideKeyboard();
        if (!checkNullData()) {
            double desiredGrade = Double.parseDouble(mDesiredGradeEditText.getText().toString()) / 100.0;
            double currentGrade = Double.parseDouble(mCurrentGradeEditText.getText().toString()) / 100.0;
            double weight = Double.parseDouble(mWeightEditText.getText().toString()) / 100.0;
            double finalGrade = 0;
            finalGrade = (desiredGrade - (1 - weight) * currentGrade) / weight;
            finalGrade *= 100;
            mNeededGrade.setText((double) Math.round(finalGrade * 10d) / 10d + "%");
        }
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private boolean checkNullData() {
        if (mCurrentGradeEditText.getText().toString().matches("")
                || mDesiredGradeEditText.getText().toString().matches("")
                || mWeightEditText.getText().toString().matches("")) {

            new MaterialDialog.Builder(getActivity())
                    .title("Error")
                    .content("Please check the numbers entered")
                    .positiveText("Ok")
                    .show();
            return true;
        }
        return false;
    }

}
