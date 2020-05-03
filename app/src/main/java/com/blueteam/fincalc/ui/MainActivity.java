package com.blueteam.fincalc.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.blueteam.fincalc.R;

public class MainActivity extends AppCompatActivity implements FinCalcFragment.FinCalcFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainer, new FinCalcFragment(), "fragment")
                    .commit();
        }
    }


    @Override
    public void onNavigateToDeposit() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, new DepositFragment(), "fragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onNavigateToCredit() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, new CreditFragment(), "fragment")
                .addToBackStack(null)
                .commit();
    }
}
