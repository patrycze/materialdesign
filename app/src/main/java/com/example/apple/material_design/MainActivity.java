package com.example.apple.material_design;

import android.app.DatePickerDialog;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.text.Editable;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView date;
    Button btn;
    int year_x, month_x, day_x;
    private TextInputLayout inputLayoutName;
    private EditText inputName;
    Calendar mCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout);
    inputName = (EditText) findViewById(R.id.input_text);
    inputName.addTextChangedListener(new MyTextWatcher(inputName));

    date = (TextView) findViewById(R.id.date);
    btn = (Button) findViewById(R.id.button);
    mCurrentDate = Calendar.getInstance();
    day_x = mCurrentDate.get(Calendar.DAY_OF_MONTH);
    month_x = mCurrentDate.get(Calendar.MONTH);
    year_x = mCurrentDate.get(Calendar.YEAR);

    btn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    date.setText(day_x + "/" + month_x + "/" + year_x);
                }
            }, year_x, month_x, day_x);
            datePickerDialog.show();
        }
    });
    }



    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {

            }
    }

}