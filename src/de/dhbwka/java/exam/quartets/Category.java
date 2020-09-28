package de.dhbwka.java.exam.quartets;

public enum Category {

    FREEWAY("Autobahnen", "km"),
    EUROROUTE("Europastraßen", "km"),
    PIPELINE("Öl-Pipelines", "km"),
    RAILS("Schienennetz", "km"),
    INTERNET("Internet", "%"),
    INTERNET_MOBILE("Internet (Mobil)", "%");

    private String title;
    private String unit;

    Category(String title, String unit){
        this.title = title;
        this.unit = unit;
    }

    String getTitle(){
        return title;
    }

    String getUnit(){
        return unit;
    }
}