package com.levko.roma.levkohomework4.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.levko.roma.levkohomework4.Constants;
import com.levko.roma.levkohomework4.R;


public class MainActivity extends Activity implements View.OnClickListener{

    public static boolean theme = true;
    private Button btnCalc;
    private TextView tvA, tvB, tvRes;
    private EditText etOper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (theme) setTheme(R.style.AppTheme);
        else setTheme(R.style.AppTheme2);

        setContentView(R.layout.activity_main);

        onFindViews();
        onListeners();
        Switch aSwitch = (Switch) findViewById(R.id.sw);
        aSwitch.setChecked(theme);
    }



    public void onFindViews() {
        btnCalc = (Button) findViewById(R.id.btnCalc_AM);
        tvA = (TextView) findViewById(R.id.tvA_AM);
        tvB = (TextView) findViewById(R.id.tvB_AM);
        tvRes = (TextView) findViewById(R.id.tvRes_AM);
        etOper = (EditText) findViewById(R.id.etOperator_AM);
    }

    private void onListeners() {
        btnCalc.setOnClickListener(this);
        tvA.setOnClickListener(this);
        tvB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvA_AM:
                openInputActivity(Constants.REQUEST_CODE_FOR_FIRST_NUMBER);
                break;
            case R.id.tvB_AM:
                openInputActivity(Constants.REQUEST_CODE_FOR_SECOND_NUMBER);
                break;
            case R.id.btnCalc_AM:
                if (!TextUtils.isEmpty(tvA.getText().toString()) && !TextUtils.isEmpty(tvB.getText().toString()))
                    tvRes.setText(Integer.toString(makeCalculation()));
                else Toast.makeText(this, "Введіть числа в поля a та b", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private int makeCalculation() {

        int a = Integer.parseInt(tvA.getText().toString());
        int b = Integer.parseInt(tvB.getText().toString());
        int res = 0;

        switch (etOper.getText().toString()) {
            case Constants.PLUS:
                res = a + b;
                break;
            case Constants.MINUS:
                res = a - b;
                break;
            case Constants.MULTIPLY:
                res = a * b;
                break;
            case Constants.DIVIDE:
                if (b == 0) Toast.makeText(this, "Неможна ділити на 0", Toast.LENGTH_LONG).show();
                else
                    res = a / b;
                break;
            default:
                etOper.setText("");
                Toast.makeText(this, "Невірно введений оператор. Введіть : +, -, *, або /", Toast.LENGTH_LONG).show();
                break;
        }
        return res;
    }


    private void openInputActivity(int requestCod) {
        Intent intent = new Intent(this, InputActivity.class);
        startActivityForResult(intent, requestCod);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Log.d(Constants.TAG, "повернення в головне актівіті");
            switch (requestCode) {
                case Constants.REQUEST_CODE_FOR_FIRST_NUMBER:
                    tvA.setText(data.getStringExtra("rez"));
                    break;
                case Constants.REQUEST_CODE_FOR_SECOND_NUMBER:
                    tvB.setText(data.getStringExtra("rez"));
            }
        } else {
            Toast.makeText(getApplicationContext(), "Ви не ввели значення", Toast.LENGTH_SHORT)
                    .show();
        }
    }
    public void changeTheme(View view) {
        if (theme) theme = false;
        else theme = true;

        this.finish();
        startActivity(new Intent(this, this.getClass()));
    }

}
