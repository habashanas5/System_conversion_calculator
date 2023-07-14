package com.example.app1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DialogInterface.OnClickListener,CompoundButton.OnCheckedChangeListener{

    private TextView lab1, lab2, lab3, lab4, lab5;
    private EditText Edit;
    private RadioButton decimal, binary, octal, hexa;
    private Button myclear;

     @Override
  public void onBackPressed() {
        AlertDialog x = new AlertDialog.Builder(this)
                .setTitle("\t\t\t\tExit the application")
                .setMessage("\n\t\t\t\t\t\t\t\t\t\t Do you want to Exit?")
                .setIcon(R.drawable.exit).setCancelable(true)
                .setPositiveButton("yes", this)
                .setNeutralButton("cancel", this).create();
        x.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Number System Conversion");
        lab1 = findViewById(R.id.Text1);
        lab2 = findViewById(R.id.Text2);
        lab3 = findViewById(R.id.Text3);
        lab4 = findViewById(R.id.Text4);
        lab5 = findViewById(R.id.Text5);
        Edit = findViewById(R.id.myEdit);
        myclear = findViewById(R.id.clear);
        decimal = findViewById(R.id.rd_decimal);
        binary = findViewById(R.id.rd_binary);
        octal = findViewById(R.id.rd_octal);
        hexa = findViewById(R.id.rd_hex);
        myclear = findViewById(R.id.clear);
        myclear.setOnClickListener(this);
        binary.setOnClickListener(this);
        hexa.setOnClickListener(this);
        octal.setOnClickListener(this);
        decimal.setOnClickListener(this);
        decimal.setOnCheckedChangeListener(this);
        octal.setOnCheckedChangeListener(this);
        hexa.setOnCheckedChangeListener(this);
        binary.setOnCheckedChangeListener(this);

        Edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (binary.isChecked() == true) {
                    binary.callOnClick();
                } else if (decimal.isChecked() == true) {
                    decimal.callOnClick();
                } else if (octal.isChecked() == true) {
                    octal.callOnClick();
                } else if (hexa.isChecked() == true) {
                    hexa.callOnClick();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == myclear) {
            Edit.setText("");
            decimal.setChecked(false);
            octal.setChecked(false);
            hexa.setChecked(false);
            binary.setChecked(false);
        } else if (view == binary) {
            if (binary.isChecked()) {
                String ss = Edit.getText().toString();
                if (ss.isEmpty()) {
                    lab2.setText("Decimal:");
                    lab3.setText("Binary:");
                    lab4.setText("Octal:");
                    lab5.setText("Hexa:");
                 //   Edit.setKeyListener(DigitsKeyListener.getInstance("01"));
                } else {
                    if (ss.contains("A") || ss.contains("B") || ss.contains("C") || ss.contains("D") || ss.contains("E") || ss.contains("F")
                            || ss.contains("a") || ss.contains("a") || ss.contains("b") || ss.contains("c") || ss.contains("d")
                            || ss.contains("e") || ss.contains("f") || ss.contains("2") || ss.contains("3") || ss.contains("4")
                            || ss.contains("5") || ss.contains("6") || ss.contains("7") || ss.contains("8") || ss.contains("9")) {
                        Toast.makeText(getBaseContext(), "it contains number that not allow in this system", Toast.LENGTH_LONG).show();
                        Edit.setText("");
                    } else {
                        //Edit.setKeyListener(DigitsKeyListener.getInstance("01"));
                        int numB = Integer.parseInt(ss, 2);
                        lab2.setText("Decimal : " + numB);
                        lab3.setText("Binary :" + ss);
                        lab4.setText("Octal : " + Integer.toOctalString(numB));
                        lab5.setText("Hex : " + Integer.toHexString(numB));
                    }
                }
            }
        } else if (view == decimal) {
            if (decimal.isChecked()) {
                String ss = Edit.getText().toString();
                if (ss.isEmpty()) {
                    lab2.setText("Decimal:");
                    lab3.setText("Binary:");
                    lab4.setText("Octal:");
                    lab5.setText("Hexa:");
                    //Edit.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                } else {
                    if (ss.contains("A") || ss.contains("B") || ss.contains("C") || ss.contains("D") || ss.contains("E") || ss.contains("F")
                            || ss.contains("a") || ss.contains("a") || ss.contains("b") || ss.contains("c") || ss.contains("d")
                            || ss.contains("e") || ss.contains("f")) {
                        Toast.makeText(getBaseContext(), "it contains number that not allow in this system", Toast.LENGTH_LONG).show();
                        Edit.setText("");
                    } else {
                      //  Edit.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                        int num = Integer.parseInt(ss, 10);
                        lab2.setText("Decimal : " + num);
                        lab3.setText("Binary :" + Integer.toBinaryString(num));
                        lab4.setText("Octal : " + Integer.toOctalString(num));
                        lab5.setText("Hex : " + Integer.toHexString(num));
                    }
                }
            }
        } else if(view==octal){
            if (octal.isChecked()) {
                String ss = Edit.getText().toString();
                if (ss.isEmpty()) {
                    lab2.setText("Decimal:");
                    lab3.setText("Binary:");
                    lab4.setText("Octal:");
                    lab5.setText("Hexa:");
                   // Edit.setKeyListener(DigitsKeyListener.getInstance("01234567"));

                } else {
                    if (ss.contains("A") || ss.contains("B") || ss.contains("C") || ss.contains("D") || ss.contains("E") || ss.contains("F")
                            || ss.contains("a") || ss.contains("a") || ss.contains("b") || ss.contains("c") || ss.contains("d")
                            || ss.contains("e") || ss.contains("f")|| ss.contains("8") || ss.contains("9")) {
                        Toast.makeText(getBaseContext(), "it contains number that not allow in this system", Toast.LENGTH_LONG).show();
                        Edit.setText("");
                    } else {
                    //   Edit.setKeyListener(DigitsKeyListener.getInstance("01234567"));
                        Integer mynum = Integer.parseInt(ss, 8);
                        lab2.setText("Decimal : " + mynum);
                        lab3.setText("Binary :" + Integer.toBinaryString(mynum));
                        lab4.setText("Octal : " + ss);
                        lab5.setText("Hex : " + Integer.toHexString(mynum));
                    }
                }
            }
        } else if(view==hexa) {
            if (hexa.isChecked()) {
                String ss = Edit.getText().toString();
                if (ss.isEmpty()) {
                    lab2.setText("Decimal:");
                    lab3.setText("Binary:");
                    lab4.setText("Octal:");
                    lab5.setText("Hexa:");
                } else {
                  // Edit.setKeyListener(DigitsKeyListener.getInstance("0123456789abcdefABCDEF"));
                    int hex = Integer.parseInt(ss, 16);
                    lab2.setText("Decimal : " +hex);
                    lab3.setText("Binary :" + Integer.toBinaryString(hex));
                    lab4.setText("Octal : " + Integer.toOctalString(hex));
                    lab5.setText("Hex : " +  ss);
                }
            }
        }
    }
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == DialogInterface.BUTTON_POSITIVE) {
            super.onBackPressed();
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton View, boolean isChecked) {
        String ss = Edit.getText().toString();
        if (ss.isEmpty()) {
            lab2.setText("Decimal:");
            lab3.setText("Binary:");
            lab4.setText("Octal:");
            lab5.setText("Hexa:");
        } else {
            if (View==decimal)
                decimal.callOnClick();
            else if (View==binary)
                binary.callOnClick();
            else if(View==hexa)
                hexa.callOnClick();
            else if(View==octal)
                octal.callOnClick();
        }
    }
}