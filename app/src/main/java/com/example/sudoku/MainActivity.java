package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[][] values = new int[9][9];
        TableLayout table = (TableLayout) findViewById(R.id.textView);
        CharSequence[] nombres = {"|   |","1","2","3","4","5","6","7","8","9"};
        table.setDividerPadding(10);
        for(int i=0;i<9;i++) {
            TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT,10.0f);
            TableRow row=new TableRow(this);

            for(int j=0;j<9;j++) {
                values[i][j]=j;
                Spinner spinner = new Spinner(this);
                spinner.setBackground(null);
                spinner.setPadding(5, 5, 5, 5);

                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, nombres);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        // la posició del spinner és 'i', però també es pot buscar amb
                        String string = spinner.getSelectedItem().toString();
                        int fila = (int) adapterView.getTag(R.id.fila);
                        int col = (int) adapterView.getTag(R.id.col);
                        spinner.setTag(R.id.col,col);
                        spinner.setTag(R.id.fila,fila);
                        Toast toast1 =
                                    Toast.makeText(getApplicationContext(),
                                            "Toast por defecto", Toast.LENGTH_SHORT);

                            toast1.show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                row.addView(spinner);
                row.setLayoutParams(params1);
            }
            table.addView(row);
        }


    }

}