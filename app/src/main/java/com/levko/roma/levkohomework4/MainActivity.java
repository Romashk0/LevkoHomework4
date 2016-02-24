package com.levko.roma.levkohomework4;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener, View.OnTouchListener{

    public Button btnCalc;
    public TextView tv_a, tv_b, tv_res;
    public EditText et_oper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onFindViews();
        onListeners();
    }
    public void onFindViews(){
        btnCalc = (Button) findViewById(R.id.btnCalc_AM);
        tv_a = (TextView) findViewById(R.id.tvA_AM);
        tv_b = (TextView) findViewById(R.id.tvB_AM);
        tv_res = (TextView) findViewById(R.id.tvRes_AM);
        et_oper = (EditText) findViewById(R.id.etOperator_AM);
    }
    private void onListeners(){
        btnCalc.setOnClickListener(this);
        tv_a.setOnTouchListener(this);
        tv_b.setOnTouchListener(this);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
