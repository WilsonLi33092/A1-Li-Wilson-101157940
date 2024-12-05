package org.example;

class Card {
    String type;
    int value;
    int sortValue;
    public String getCardType(){
        return type;
    }
    public int getCardValue() {
        return value;
    }
    public int getSortValue() {
        return sortValue;
    }
//    public String toString() {
//        return type + " " + value + " " + sortValue;
//    }
    public String toString() {
        return type + " " + value;
    }
    public void setType(String newType){
        type = newType;
    }
    public void setValue(int newValue){
        value = newValue;
    }
    public void setSortValue(int newSortValue){
        sortValue = newSortValue;
    }
}
