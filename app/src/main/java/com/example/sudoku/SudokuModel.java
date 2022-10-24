package com.example.sudoku;

public class SudokuModel {
    int[][] values = new int[9][9];

    public int getVal(int fila, int columna){
        return values[fila][columna];
    }
    public void setVal(){

    }
    public boolean comprovaFila(int fila){
        for(int i=0;i<9;i++){
            if(values[fila][i]==1){
                return false;
            }
        }
        return true;
    }
    public void comprovaColumna(int columna){

    }
    public void comprovaQuad(){

    }
    public void creaPartida(){

    }
}
