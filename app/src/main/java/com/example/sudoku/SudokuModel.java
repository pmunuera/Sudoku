package com.example.sudoku;

import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Arrays;

public class SudokuModel {
    int[][] values = new int[9][9];

    public int getVal(int fila, int columna){
        return values[fila][columna];
    }
    public int setVal(int valor,int fila,int columna){
        if(comprovaFila(fila,valor)==true&&comprovaColumna(columna,valor)==true){
            values[fila][columna]=valor;
            return valor;
        }
        else {
            return -1;
        }
    }
    public boolean comprovaFila(int fila,int valor){
        for(int i=0;i<(values[fila].length);i++){
                if (values[fila][i]==valor&&values[fila][i]!=0) {
                    return false;
                }
            }
        return true;
    }

    public boolean comprovaColumna(int columna,int valor){
        for(int i=0;i<9;i++){
            if (values[i][columna]==valor&&values[i][columna]!=0) {
                    return false;
            }
        }

        return true;
    }

    public boolean comprovaQuad(){
        return true;
    }
    public void creaPartida(){
        int contador=0;
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                values[i][j] = 0;
            }
        }
            while (contador < 20) {
                int randomValor = (int) (Math.random() * (9 + 1));
                int randomFila = (int) (Math.random() * (9 - 1));
                int randomColumna = (int) (Math.random() * (9 - 1));
                int correcte = 0;
                if (comprovaFila(randomFila, randomValor) == true && comprovaColumna(randomColumna, randomValor) == true) {
                    correcte = this.setVal(randomValor, randomFila, randomColumna);
                }
                if (correcte == randomValor) {
                    contador++;
                }
            }
        }
}
