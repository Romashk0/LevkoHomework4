package com.levko.roma.levkohomework4.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.levko.roma.levkohomework4.Constants;
import com.levko.roma.levkohomework4.R;

/**
 * Created by User on 23.02.2016.
 */
public class InputActivity extends Activity implements View.OnClickListener{

    private EditText etNumber;
    private String sNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
            onFindviews();
            setListeners();

    }

    private void setListeners() {
        findViewById(R.id.btnOk_AI).setOnClickListener(this);
    }

    private void onFindviews() {
        etNumber = (EditText) findViewById(R.id.etInputValue_AI);

    }


    private void sendRezToMainActivity() {
        sNumber = etNumber.getText().toString();
        if (sNumber.equals("")) {
            Toast.makeText(getApplicationContext(), "введіть число", Toast.LENGTH_SHORT)
                    .show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("rez", sNumber);
            setResult(RESULT_OK, intent);
            Log.d(Constants.TAG, "результат вводу: " + sNumber);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnOk_AI) sendRezToMainActivity();
    }
}
