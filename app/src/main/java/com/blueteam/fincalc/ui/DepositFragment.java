package com.blueteam.fincalc.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blueteam.fincalc.R;
import com.blueteam.fincalc.data.model.Credit;
import com.blueteam.fincalc.data.model.Deposit;

public class DepositFragment extends Fragment implements TitleOwner {

    private EditText depositAmountEditText;
    private EditText depositTermEditText;
    private EditText depositReplenishmentEditText;
    private EditText depositRateEditText;
    private CheckBox depositCapitalizationCheckBox;
    private EditText depositTaxEditText;

    private TextView depositMonthlyIncomeTextView;
    private TextView depositTotalRevTextView;
    private TextView depositTotalRepTextView;
    private TextView depositTotalAmountTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_deposit, container, false);

        depositAmountEditText = fragmentView.findViewById(R.id.depositAmountEditText);
        depositTermEditText = fragmentView.findViewById(R.id.depositTermEditText);
        depositReplenishmentEditText = fragmentView.findViewById(R.id.depositReplenishmentEditText);
        depositRateEditText = fragmentView.findViewById(R.id.depositRateEditText);
        depositCapitalizationCheckBox = fragmentView.findViewById(R.id.depositCapitalizationCheckBox);
        depositTaxEditText = fragmentView.findViewById(R.id.depositTaxEditText);

        depositMonthlyIncomeTextView = fragmentView.findViewById(R.id.depositMonthlyIncomeTextView);
        depositTotalRevTextView = fragmentView.findViewById(R.id.depositTotalRevTextView);
        depositTotalRepTextView = fragmentView.findViewById(R.id.depositTotalRepTextView);
        depositTotalAmountTextView = fragmentView.findViewById(R.id.depositTotalAmountTextView);

        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // do nothing
            }

            @Override
            public void afterTextChanged(Editable s) {

                Deposit deposit = new Deposit();

            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        setTitle();
    }

    @Override
    public void setTitle() {
        getActivity().setTitle(R.string.fragment_deposit_title);
    }

}
