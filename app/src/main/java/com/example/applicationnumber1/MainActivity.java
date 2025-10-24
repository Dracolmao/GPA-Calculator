package com.example.applicationnumber1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity    {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main);
            android.util.Log.d("MainActivity", "Layout successfully set");
            
            Toolbar bar1 = findViewById(R.id.toolbar);
            if (bar1 != null) {
                bar1.setTitle("GPA Calculator");
                bar1.setSubtitle("Made by Jaffar Alromaih");
                android.util.Log.d("MainActivity", "Toolbar successfully initialized");
            } else {
                android.util.Log.e("MainActivity", "Toolbar is null - findViewById failed");
            }
        } catch (Exception e) {
            android.util.Log.e("MainActivity", "Error in onCreate: " + e.getMessage(), e);
            throw e;
        }
    }
    public void Calculate(View v){
        double credits=0;
        double gpa=0;
        double totalcredit=0;
        double totalgrade=0;
        EditText[] credit = new EditText[8];
        credit[0] = findViewById(R.id.credit1);
        credit[1] = findViewById(R.id.credit2);
        credit[2] = findViewById(R.id.credit3);
        credit[3] = findViewById(R.id.credit4);
        credit[4] = findViewById(R.id.credit5);
        credit[5] = findViewById(R.id.credit6);
        credit[6] = findViewById(R.id.credit7);
        credit[7] = findViewById(R.id.credit8);
        CheckBox[] boxes = new CheckBox[8];
        boxes[0] = findViewById(R.id.c1);
        boxes[1] = findViewById(R.id.c2);
        boxes[2] = findViewById(R.id.c3);
        boxes[3] = findViewById(R.id.c4);
        boxes[4] = findViewById(R.id.c5);
        boxes[5] = findViewById(R.id.c6);
        boxes[6] = findViewById(R.id.c7);
        boxes[7] = findViewById(R.id.c8);
        EditText[] letters = new EditText[8];
        letters[0] = findViewById(R.id.l1);
        letters[1] = findViewById(R.id.l2);
        letters[2] = findViewById(R.id.l3);
        letters[3] = findViewById(R.id.l4);
        letters[4] = findViewById(R.id.l5);
        letters[5] = findViewById(R.id.l6);
        letters[6] = findViewById(R.id.l7);
        letters[7] = findViewById(R.id.l8);
        for(int i=0;i<boxes.length;i++){
            if(boxes[i].isChecked()){
                if(!credit[i].getText().toString().isEmpty()){
                int num = Integer.parseInt(credit[i].getText().toString());
                if((num<=4&&num>=1)||num==9){
                    credits =num;
                    String lettergrade = letters[i].getText().toString();
                    switch (lettergrade.trim()){
                        case("A+"):{ totalgrade += 4*credits;
                            totalcredit += num; }
                            break;
                        case("A"): {totalgrade += 3.75*credits;
                            totalcredit += num; }
                            break;
                        case("B+"): {totalgrade += 3.5*credits;
                            totalcredit += num; }
                            break;
                        case("B"): {totalgrade += 3*credits;
                            totalcredit += num;}
                            break;
                        case("C+"): {totalgrade += 2.5*credits;
                            totalcredit += num; }
                            break;
                        case("C"): {totalgrade += 2*credits;
                            totalcredit += num; }
                            break;
                        case("D+"): {totalgrade += 1.5*credits;
                            totalcredit += num; }
                            break;
                        case("D"): {totalgrade += 1*credits;
                            totalcredit += num; }
                            break;
                        case("F"): {totalgrade += 0;
                            totalcredit += num; }
                            break;
                        default: {Snackbar.make(v, "The Letter is not valid", Snackbar.LENGTH_LONG).show();
                        }
                    }
                }else Snackbar.make(v, "The credit number is not valid", Snackbar.LENGTH_LONG).show();
            }else Snackbar.make(v, "The credit number is empty", Snackbar.LENGTH_LONG).show(); }
        }
        gpa = totalgrade/totalcredit;
        Intent screen1 = new Intent(this,Main2Activity.class);
        CheckBox c = findViewById(R.id.c);
        if (totalcredit != 0){
            if(c.isChecked()){
                EditText credittotal = findViewById(R.id.creditt);
                EditText totalgpa = findViewById(R.id.gpat);
                if(!totalgpa.getText().toString().isEmpty()&&!credittotal.getText().toString().isEmpty()){
                    double totalGPA = Double.parseDouble(totalgpa.getText().toString());
                    double cumulativecredit = Integer.parseInt(credittotal.getText().toString());
                    if(totalGPA>=0 && totalGPA<=4){
                        if(cumulativecredit>0){
                            Double cumulativegpa =((totalgrade+(cumulativecredit*totalGPA))/(cumulativecredit+totalcredit));
                            screen1.putExtra("GPA",gpa);
                            screen1.putExtra("totalcredit",totalcredit);
                            screen1.putExtra("GPAtotal",cumulativegpa);
                            screen1.putExtra("cumulativecredit",(cumulativecredit+totalcredit));
                            startActivity(screen1);
                        }else {Snackbar.make(v,"The total credit is not acceptable",Snackbar.LENGTH_LONG).show();}
                    }else {Snackbar.make(v,"Calculate your GPA out of 4",Snackbar.LENGTH_LONG).show();}
                }else {Snackbar.make(v,"The information box\\es is\\are empty",Snackbar.LENGTH_LONG).show();}
            }else{
            screen1.putExtra("GPA",gpa);
            screen1.putExtra("totalcredit",totalcredit);
            startActivity(screen1);}
        }
    }
    public void onCheck(View v){
        EditText[] credit = new EditText[8];
        credit[0] = findViewById(R.id.credit1);
        credit[1] = findViewById(R.id.credit2);
        credit[2] = findViewById(R.id.credit3);
        credit[3] = findViewById(R.id.credit4);
        credit[4] = findViewById(R.id.credit5);
        credit[5] = findViewById(R.id.credit6);
        credit[6] = findViewById(R.id.credit7);
        credit[7] = findViewById(R.id.credit8);
        CheckBox[] boxes = new CheckBox[8];
        boxes[0] = findViewById(R.id.c1);
        boxes[1] = findViewById(R.id.c2);
        boxes[2] = findViewById(R.id.c3);
        boxes[3] = findViewById(R.id.c4);
        boxes[4] = findViewById(R.id.c5);
        boxes[5] = findViewById(R.id.c6);
        boxes[6] = findViewById(R.id.c7);
        boxes[7] = findViewById(R.id.c8);
        EditText[] letters = new EditText[8];
        letters[0] = findViewById(R.id.l1);
        letters[1] = findViewById(R.id.l2);
        letters[2] = findViewById(R.id.l3);
        letters[3] = findViewById(R.id.l4);
        letters[4] = findViewById(R.id.l5);
        letters[5] = findViewById(R.id.l6);
        letters[6] = findViewById(R.id.l7);
        letters[7] = findViewById(R.id.l8);
        EditText[] course = new EditText[8];
        course[0] = findViewById(R.id.co1);
        course[1] = findViewById(R.id.co2);
        course[2] = findViewById(R.id.co3);
        course[3] = findViewById(R.id.co4);
        course[4] = findViewById(R.id.co5);
        course[5] = findViewById(R.id.co6);
        course[6] = findViewById(R.id.co7);
        course[7] = findViewById(R.id.co8);
        for(int i = 0;i< boxes.length;i++){
            if(boxes[i].isChecked()){
                course[i].setEnabled(true);
                letters[i].setEnabled(true);
                credit[i].setEnabled(true);
            }else if(!boxes[i].isChecked()){
                course[i].setEnabled(false);
                letters[i].setEnabled(false);
                credit[i].setEnabled(false);
            }}
        CheckBox c = findViewById(R.id.c);
        EditText totalcredit = findViewById(R.id.creditt);
        EditText totalgpa = findViewById(R.id.gpat);
        if(c.isChecked()){
            totalcredit.setEnabled(true);
            totalgpa.setEnabled(true);
        }else if(!c.isChecked()){
            totalcredit.setEnabled(false);
            totalgpa.setEnabled(false);
        }
    }
    public void restart(View v){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
