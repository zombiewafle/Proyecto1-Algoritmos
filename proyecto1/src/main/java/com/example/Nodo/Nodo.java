package com.example.Nodo;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;


public class Nodo {
    public Integer ID = 0;
    public static int lastId = 0;
    public List<Nodo> nextStatesList;
    public List<Nodo> previousStatesList;

    private Boolean start;
    private Boolean end;
    private String symbol;
    private Integer value;

    public Nodo(String string){
        this.ID = lastId++;
        this.symbol = "";
        this.value = 0;
        this.nextStatesList = new LinkedList<>();
        this.previousStatesList = new LinkedList<>();
        this.start = false;
        this.end = false;
        
    }
    
    public Nodo(Integer ID, String symbol){
        this.ID = lastId++;
        this.symbol = symbol;
        this.value = 0;
        this.nextStatesList = new LinkedList<>();
        this.previousStatesList = new LinkedList<>();
        this.start = false;
        this.end = false;
        
    }

    //#region getters y setters

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public List<Nodo> getNextStatesList() {
        return nextStatesList;
    }

    public void setNextStatesList(List<Nodo> nextStatesList) {
        this.nextStatesList = nextStatesList;
    }

    public List<Nodo> getPreviousStatesList() {
        return previousStatesList;
    }

    public void setPreviousStatesList(List<Nodo> previousStatesList) {
        this.previousStatesList = previousStatesList;
    }

    public Boolean getStart() {
        return start;
    }

    public void setStart(Boolean start) {
        this.start = start;
    }

    public Boolean getEnd() {
        return end;
    }

    public void setEnd(Boolean end) {
        this.end = end;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void addNextState(Nodo nState){
        this.nextStatesList.add(nState);
    }

    public void addPreviousState(Nodo pState){
        this.previousStatesList.add(pState);   
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    
    //#endregion

    @Override
    public String toString() {
        return "Nodo [ID=" + ID + ", nextStatesList=" + nextStatesList + ", previousStatesList=" + previousStatesList
                + ", start=" + start + ", end=" + end + ", symbol=" + symbol + "]";
    }

    
}
