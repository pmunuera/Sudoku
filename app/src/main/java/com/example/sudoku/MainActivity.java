package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout table = (TableLayout) findViewById(R.id.textView);
        CharSequence[] nombres = {"0","1","2","3","4","5","6","7","8","9"};
        TableRow row=new TableRow(this);
        for(int i=0;i<9;i++) {
            TableRow.LayoutParams  params1=new TableRow.LayoutParams();
            for(int j=0;j<9;j++) {
                Spinner spinner = new Spinner(this);
                TextView txt1 = new TextView(this);
                txt1.setText(nombres[j]);
                row.addView(txt1);
                row.setLayoutParams(params1);

                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, nombres);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }
            table.addView(row);
        }
    }
}