package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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


        Spinner[][] spinners = new Spinner[9][9];
        TableLayout table = (TableLayout) findViewById(R.id.textView);
        CharSequence[] nombres = {"0","1","2","3","4","5","6","7","8","9"};
        SudokuModel sudoku = new SudokuModel();

        table.setDividerPadding(10);
        refresh(spinners,table,nombres,sudoku);
        Button b2 = findViewById(R.id.button);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                refresh(spinners,table,nombres,sudoku);
            }
        });
    }
    public void refresh(Spinner[][] spinners,TableLayout table,CharSequence[] nombres,SudokuModel sudoku){
        table.removeAllViews();
        sudoku.creaPartida();
        for(int i=0;i<9;i++) {
            TableRow.LayoutParams params1 = new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, 10.0f);
            TableRow row = new TableRow(this);
            for (int j = 0; j < 9; j++) {
                CharSequence[] nombreSudoku = {String.valueOf(sudoku.values[i][j])};
                if (sudoku.values[i][j] == 0) {
                    Spinner spinner = new Spinner(this);
                    spinners[i][j] = spinner;
                    spinner.setBackground(null);
                    spinner.setPadding(5, 5, 5, 5);

                    ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                            android.R.layout.simple_spinner_item, nombres);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                    spinner.setTag("bug init");
                    spinner.setTag(R.id.col, j);
                    spinner.setTag(R.id.fila, i);
                    row.addView(spinners[i][j]);
                    row.setLayoutParams(params1);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            // la posició del spinner és 'i', però també es pot buscar amb
                            //String string = adapterView.getSelectedItem().toString();
                            int fila = (int) adapterView.getTag(R.id.fila);
                            int col = (int) adapterView.getTag(R.id.col);
                            if (spinner.getTag().equals("bug init")) {
                                spinner.setTag("okay, no more bug");
                            } else {
                                int correcte = sudoku.setVal(Integer.parseInt(String.valueOf(spinner.getSelectedItem())),fila,col);
                                if(correcte==-1){
                                    spinner.setAdapter(adapter);
                                    spinners[fila][col] = spinner;
                                    Toast toast1 =
                                            Toast.makeText(getApplicationContext(),
                                                    "No es pot", Toast.LENGTH_SHORT);

                                    toast1.show();
                                }
                            }
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
                else{
                    Spinner spinner = new Spinner(this);
                    spinners[i][j] = spinner;
                    spinner.setBackgroundColor(Color.LTGRAY);
                    spinner.setPadding(5, 5, 5, 5);

                    ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                            android.R.layout.simple_spinner_item, nombreSudoku);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                    spinner.setEnabled(false);
                    spinner.setTag(R.id.col, j);
                    spinner.setTag(R.id.fila, i);
                    row.addView(spinners[i][j]);
                    row.setLayoutParams(params1);
                }
            }
            table.addView(row);
        }
    }
}