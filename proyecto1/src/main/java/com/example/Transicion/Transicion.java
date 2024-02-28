package com.example.Transicion;

import com.example.Nodo.Nodo;

public class Transicion {
    private String symbol;
    private Nodo initialState;
    private Nodo finalState;
    
    public Transicion(Nodo iniState, String symbol, Nodo finalState){
        this.symbol = symbol;
        this.initialState = iniState;
        this.finalState = finalState;

        this.initialState.addNextState(finalState);
        this.finalState.addPreviousState(iniState);
    }

    //#region getters y setters

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Nodo getInitialState() {
        return initialState;
    }

    public void setInitialState(Nodo initialState) {
        this.initialState = initialState;
    }

    public Nodo getFinalState() {
        return finalState;
    }

    public void setFinalState(Nodo finalState) {
        this.finalState = finalState;
    }

    //#endregion

    @Override
    public String toString() {
        return "Transicion [symbol=" + symbol + ", initialState=" + initialState + ", finalState=" + finalState + "]";
    }

    
    
    
}
