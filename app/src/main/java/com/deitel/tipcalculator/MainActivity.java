// MainActivity.java
// Calculates a bill total based on a tip percentage
package com.deitel.tipcalculator;

import android.os.Bundle; // for saving state information
import android.support.v7.app.AppCompatActivity; // base class
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText; // for bill amount input
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener; // SeekBar listener
import android.widget.TextView; // for displaying text


// MainActivity class for the Tip Calculator app
public class MainActivity extends AppCompatActivity {

    private double celsius = 0.0; // bill amount entered by the user
    private double fahrenheit = 0.0;
    private double c = 0.0;
    private TextView cTextView;
    private TextView totalTextView;
    private TextView totalTextView2;

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalTextView2 = (TextView) findViewById(R.id.totalTextView2);


        // set amountEditText's TextWatcher
        EditText amountEditText = (EditText) findViewById(R.id.amountEditText);
        amountEditText.addTextChangedListener(amountEditTextWatcher);//img --> objeto ---> ouvinte
        amountEditText.setText("");

        EditText amountEditText2 = (EditText) findViewById(R.id.amountEditText2);
        amountEditText2.addTextChangedListener(amountEditTextWatcher2);//img --> objeto ---> ouvinte
        amountEditText2.setText("");

        SeekBar cSeekBar =
                (SeekBar) findViewById(R.id.cSeekBar);
        cSeekBar.setOnSeekBarChangeListener(seekBarListener);
    }

    // calculate and display tip and total amounts
    private void calculate() {
        cTextView.setText(celsius+"");
        double total = celsius * 1.8 + 32;

        String result = new Double(total).toString();
        totalTextView.setText("ºF "+ result);
       // double tip = celsius * percent;
      //  double total = (celsius-32) * (5/9);

        // display tip and total formatted as currency
        // tipTextView.setText(currencyFormat.format(tip));
       // totalTextView.setText(currencyFormat.format(total));
    }

    private void calculate2() {

        double total2 = (fahrenheit - 32)* 5/9;

        String result2 = new Double(total2).toString();
        totalTextView2.setText("ºC "+ result2);
    }

    // listener object for the EditText's text-changed events
    private final TextWatcher amountEditTextWatcher = new TextWatcher() {//evento reagir
        // called when the user modifies the bill amount
        @Override
        //igual onclick
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get bill amount and display currency formatted value
                celsius = Double.parseDouble(s.toString()) / 100.0;
                String r = new Double(celsius).toString();
                cTextView.setText(r);
            } catch (NumberFormatException e) { // if s is empty or non-numeric
                cTextView.setText("");
                celsius = 0.0;
            }

            calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };

    private final TextWatcher amountEditTextWatcher2 = new TextWatcher() {//evento reagir
        // called when the user modifies the bill amount
        @Override
        //igual onclick
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get bill amount and display currency formatted value
                fahrenheit = Double.parseDouble(s.toString())/ 100.0;
                String r2 = new Double(fahrenheit).toString();
               // amountTextView2.setText("ºF "+ r2);
            } catch (NumberFormatException e) { // if s is empty or non-numeric
              //  amountTextView2.setText("");
                fahrenheit = 0.0;
            }

            calculate2(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };

    // listener object for the SeekBar's progress changed events
    private final OnSeekBarChangeListener seekBarListener =
            new OnSeekBarChangeListener() {
                // update percent, then call calculate
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    celsius = progress / 100.0; // set percent based on progress
                    calculate(); // calculate and display tip and total
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };

}


/* ************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 ************************************************************************ */
