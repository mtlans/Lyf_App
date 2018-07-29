package com.example.gahallon.app2;

public class Global {
    private static Global instance = new Global();
    // Getter-Setters
    public static Global getInstance() {
        return instance;
    }

    public static void setInstance(Global instance) {
        Global.instance = instance;
    }

    String selectedItem;

    private Global(){

    }
    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
}
