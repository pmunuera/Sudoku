package com.example.sudoku;

import java.util.Arrays;

public class SudokuModel {
    int[][] values = new int[9][9];

    public int getVal(int fila, int columna){
        return values[fila][columna];
    }
    public int setVal(int valor,int fila,int columna){
        if(getVal(fila,columna)==0){
            values[fila][columna]=valor;
            return valor;
        }
        else {
            return -1;
        }
    }
    public boolean comprovaFila(int fila){
        for(int i=0;i<values[fila].length;i++){
            for(int j=i+1;j<values[fila].length;j++) {
                if (values[fila][i]==values[fila][j]) {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean comprovaColumna(int columna){
        for(int i=0;i<9;i++){
            for(int j=i+1;j<9;j++) {
                if (values[i][columna]==values[j][columna]) {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean comprovaQuad(){
        return true;
    }
    public void creaPartida(){
        int contador=0;
        while(contador<20){
            int randomValor= (int)(Math.random()*(1-9));
            int randomFila= (int)(Math.random()*(1-9));
            int randomColumna= (int)(Math.random()*(1-9));
            int correcte=0;
            if(comprovaFila(randomFila)&&comprovaColumna(randomColumna)) {
                correcte = this.setVal(randomValor, randomFila, randomColumna);
            }
            if(correcte==randomValor){
                contador++;
            }
        }
    }
}
