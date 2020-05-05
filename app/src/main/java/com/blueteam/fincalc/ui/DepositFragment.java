package com.blueteam.fincalc.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blueteam.fincalc.R;
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

    private boolean isCapitalizationEnabled;

    private double depositAmount;

    private int depositTerm;
    private double depositRate;
    private double depositReplenishment;
    private double depositTax;

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


        depositCapitalizationCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isCapitalizationEnabled = true;
                    createDeposit();

                } else {
                    isCapitalizationEnabled = false;
                    createDeposit();
                }
            }
        });


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


                if (!depositAmountEditText.getText().toString().matches("")) {
                    depositAmount = Double.parseDouble(depositAmountEditText.getText().toString());
                } else depositAmount = 0;

                if (!depositTermEditText.getText().toString().matches("")) {
                    depositTerm = Integer.parseInt(depositTermEditText.getText().toString());
                } else depositTerm = 0;


                if (!depositReplenishmentEditText.getText().toString().matches("")) {
                    depositReplenishment = Double.parseDouble(depositReplenishmentEditText.getText().toString());
                } else depositReplenishment = 0;


                if (!depositRateEditText.getText().toString().matches("")) {
                    depositRate = Double.parseDouble(depositRateEditText.getText().toString()) / 100;
                } else depositRate = 0;


                if (!depositTaxEditText.getText().toString().matches("")) {
                    depositTax = Double.parseDouble(depositTaxEditText.getText().toString()) / 100;
                } else depositTax = 0;

                createDeposit();
            }
        };

        depositAmountEditText.addTextChangedListener(afterTextChangedListener);
        depositTermEditText.addTextChangedListener(afterTextChangedListener);
        depositReplenishmentEditText.addTextChangedListener(afterTextChangedListener);
        depositRateEditText.addTextChangedListener(afterTextChangedListener);
        depositTaxEditText.addTextChangedListener(afterTextChangedListener);
    }


    private void createDeposit() {
        Deposit deposit = new Deposit(depositAmount, depositTerm, depositReplenishment, depositRate, isCapitalizationEnabled, depositTax);
        depositMonthlyIncomeTextView.setText(String.format("%s %.2f", getString(R.string.monthly_income), deposit.getMonthlyIncome()));
        depositTotalRevTextView.setText(String.format("%s %.2f", getString(R.string.total_revenue_after_n_months), deposit.getTotalRev()));
        depositTotalRepTextView.setText(String.format("%s %.2f", getString(R.string.total_replenishment_amount), deposit.getDepositRepAmount()));
        depositTotalAmountTextView.setText(String.format("%s %.2f", getString(R.string.total_amount_deposit), deposit.getTotalAmount()));
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
