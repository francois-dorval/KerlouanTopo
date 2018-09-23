package com.github.dorval.francois.kerlouantopo.model.voie;


import java.util.HashMap;
import java.util.Map;

public  enum Cotation{
    TROIS("3"),
    QUATRE("4"),
    QUATRE_PLUS("4+"),
    CINQ_A("5a"),
    CINQ_B("5b"),
    CINQ_C("5c"),
    CINQ_C_PLUS("5c+"),
    SIX_A("6a"),
    SIX_A_PLUS("6a+"),
    SIX_B("6b"),
    SIX_B_PLUS("6b+"),
    SIX_C("6c"),
    SIX_C_PLUS("6c+"),
    SEPT_A("7a"),
    SEPT_A_PLUS("7a+"),
    SEPT_B("7b"),
    SEPT_B_PLUS("7b+"),
    SEPT_C("7c"),
    SEPT_C_PLUS("7c+"),

    NEUF_Z_PLUS("inconnue");

    private static final Map<String, Cotation> nameIndex =
            new HashMap<>();
    static {
        for (Cotation cot : Cotation.values()) {
            nameIndex.put(cot.getLabel().toUpperCase(), cot);
        }
    }

    private final String label;

    private Cotation(String label){
        this.label=label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

    public static Cotation lookupByLabel(String label) {
        return nameIndex.get(label.toUpperCase());
    }

}