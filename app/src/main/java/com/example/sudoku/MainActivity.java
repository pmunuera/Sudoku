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
        CharSequence[] nombres = {"|   |","1","2","3","4","5","6","7","8","9"};
        table.setDividerPadding(10);
        for(int i=0;i<9;i++) {
            TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT,10.0f);
            TableRow row=new TableRow(this);

            for(int j=0;j<9;j++) {
                Spinner spinner = new Spinner(this);
                spinner.setBackground(null);
                spinner.setPadding(5, 5, 5, 5);

                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, nombres);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setTag(R.id.col,i);
                spinner.setTag(R.id.fila,j);
                row.addView(spinner);
                row.setLayoutParams(params1);
            }
            table.addView(row);
        }
    }
}