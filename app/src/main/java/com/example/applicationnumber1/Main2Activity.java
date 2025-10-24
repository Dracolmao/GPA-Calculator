package com.example.applicationnumber1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            android.util.Log.d("Main2Activity", "Starting onCreate");
            setTheme(R.style.SecondTheme);
            android.util.Log.d("Main2Activity", "Theme set successfully");
            super.onCreate(savedInstanceState);
            android.util.Log.d("Main2Activity", "super.onCreate completed");
            setContentView(R.layout.activity_main2);
            android.util.Log.d("Main2Activity", "Layout set successfully");
            
            Toolbar bar2 = findViewById(R.id.bar2);
            if (bar2 != null) {
                bar2.setTitle("Your GPA");
                bar2.setSubtitle("is terms of 4 or 5");
                android.util.Log.d("Main2Activity", "Toolbar initialized successfully");
            } else {
                android.util.Log.e("Main2Activity", "Toolbar is null - findViewById failed");
            }
            
            Intent intent1 = getIntent();
            double gpa = intent1.getDoubleExtra("GPA",0);
            double credit = intent1.getDoubleExtra("totalcredit",0);
            double totalcredit = intent1.getDoubleExtra("cumulativecredit",-1);
            double totalgpa = intent1.getDoubleExtra("GPAtotal",-1);
            
            TextView display = findViewById(R.id.textView);
            if (display != null) {
                if(totalcredit==-1||totalgpa==-1){
                    String displayed = String.format(Locale.US,"Term GPA = %.3f out of 4 %n%nTerm GPA = %.3f out of 5 %n%nCredit hours = %.0f",gpa,((gpa/4)*5),credit);
                    display.setText(displayed);
                }else {
                    String displayed = String.format(Locale.US,"Term GPA = %.3f out of 4 %n%nTerm GPA = %.3f out of 5 %n%nCredit hours = %.0f %n%nTotal GPA = %.3f out of 4 %n%nTotal GPA = %.3f out of 5 %n%nTotal credit = %.0f",gpa,((gpa/4)*5),credit,totalgpa,(totalgpa/4)*5,totalcredit);
                    display.setText(displayed);
                }
                android.util.Log.d("Main2Activity", "TextView updated successfully");
            } else {
                android.util.Log.e("Main2Activity", "TextView is null - findViewById failed");
            }
        } catch (Exception e) {
            android.util.Log.e("Main2Activity", "Error in onCreate: " + e.getMessage(), e);
            throw e;
        }
    }
}
