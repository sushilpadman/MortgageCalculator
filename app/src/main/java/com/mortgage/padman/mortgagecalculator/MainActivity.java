package com.mortgage.padman.mortgagecalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;



import java.lang.Math.*;


public class MainActivity extends ActionBarActivity {

    private double p;
    private double n;
    private double i;
    private SeekBar skYears;
    TextView years,mortgagePayment,totalLoanPayment;
   private EditText editText1,editText2,editText3,editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mortgagePayment= (TextView) findViewById(R.id.textView9);
        totalLoanPayment= (TextView) findViewById(R.id.textView13);

        editText2= (EditText) findViewById(R.id.editText2);
        editText3= (EditText) findViewById(R.id.editText3);
        editText1= (EditText) findViewById(R.id.editText1);
        editText= (EditText) findViewById(R.id.editText);


    }

    public void calculate(View view) {
        String str1,str2,str3,str4;
        str1 = editText1.getText().toString().trim();
        str2 = editText2.getText().toString().trim();
        str3 = editText3.getText().toString().trim();
        str4 = editText.getText().toString().trim();
        if (str1.equals("") ||str4.equals("") || str3.equals(""))
        {
            Toast.makeText(this,"please enter all fields",Toast.LENGTH_SHORT).show();

        }
        else
        {
            int purchaseValue=Integer.parseInt(str1);
            int downPayment=0;
            downPayment=Integer.parseInt(str2);
           double interestRate=Integer.parseInt(str3);
            double years=Integer.parseInt(str4);
            p=purchaseValue-downPayment;

            n=years*12;
            i=(double)(interestRate/1200);



            double a=(double)i*(Math.pow(1 + i, n));
            double b=(double)(Math.pow(1+i, n))-1;
            double m=(double)p*(a/b);
            String mPayment=String.valueOf(String.format("%.2f",m));
            String loanPayment=String.valueOf(String.format("%.2f",m*n));
            mortgagePayment.setText(mPayment);
            totalLoanPayment.setText(loanPayment);



        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
