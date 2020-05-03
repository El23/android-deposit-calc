package com.blueteam.fincalc.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.blueteam.fincalc.R;

public class FinCalcFragment extends Fragment implements TitleOwner {

    private Button gotoDeposit;
    private Button gotoCredit;
    private FinCalcFragmentListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (FinCalcFragmentListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_fincalc, container, false);

        gotoDeposit = fragmentView.findViewById(R.id.btn_deposit);
        gotoDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onNavigateToDeposit();
                }
            }
        });

        gotoCredit = fragmentView.findViewById(R.id.btn_credit);
        gotoCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onNavigateToCredit();
                }
            }
        });

        return fragmentView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        setTitle();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setTitle() {
        getActivity().setTitle(R.string.app_name);
    }

    interface FinCalcFragmentListener {
        void onNavigateToDeposit();

        void onNavigateToCredit();
    }
}
