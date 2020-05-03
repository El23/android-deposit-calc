package com.blueteam.fincalc.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.blueteam.fincalc.data.model.Credit;
import com.blueteam.fincalc.R;

public class CreditFragment extends Fragment implements TitleOwner {

    private EditText loanAmountEditText;
    private EditText loanTermEditText;
    private EditText loanAdvanceEditText;
    private EditText loanRateEditText;
    private EditText loanInsuranceEditText;
    private EditText loanCommissionEditText;

    private TextView loanInitialTextView;
    private TextView loanPaymentTextView;
    private TextView loanOverpaymentTextView;
    private TextView loanTotalRepaymentTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_credit, container, false);

        loanAmountEditText = fragmentView.findViewById(R.id.loanAmountEditText);
        loanTermEditText = fragmentView.findViewById(R.id.loanTermEditText);
        loanAdvanceEditText = fragmentView.findViewById(R.id.loanAdvanceEditText);
        loanRateEditText = fragmentView.findViewById(R.id.loanRateEditText);
        loanInsuranceEditText = fragmentView.findViewById(R.id.loanInsuranceEditText);
        loanCommissionEditText = fragmentView.findViewById(R.id.loanCommissionEditText);

        loanInitialTextView = fragmentView.findViewById(R.id.loanInitialTextView);
        loanPaymentTextView = fragmentView.findViewById(R.id.loanPaymentTextView);
        loanOverpaymentTextView = fragmentView.findViewById(R.id.loanOverpaymentTextView);
        loanTotalRepaymentTextView = fragmentView.findViewById(R.id.loanTotalRepaymentTextView);

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

                Credit credit = new Credit();

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
        getActivity().setTitle(R.string.fragment_credit_title);
    }

}
