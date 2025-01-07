package org.example;

import com.google.gson.annotations.SerializedName;

public class Cotacoes {
    @SerializedName("BRL")
    private Double real;
    @SerializedName("ARS")
    private Double pesoArgentino;
    @SerializedName("COP")
    private Double pesoColombiano;

    public Cotacoes( Double BRL, Double ARS, Double COP) {
        this.real = BRL;
        this.pesoArgentino = ARS;
        this.pesoColombiano = COP;
    }

    @Override
    public String toString() {
        return "Cotacoes{" +
                "real=" + real +
                ", pesoArgentino=" + pesoArgentino +
                ", pesoColombiano=" + pesoColombiano +
                '}';
    }

    public String dolarPesoArgentino(Double valor){
        return "Valor " + valor + " [USD] " + "corresponde ao valor final de =>>> " + (valor * pesoArgentino) + " [ARS]";
    }

    public String pesoArgentinoDolar(Double valor){
        return "Valor " + valor + " [ARS] " + "corresponde ao valor final de =>>> " + (valor * (1/pesoArgentino)) + " [USD]";
    }

    public String dolarReal(Double valor){
        return "Valor " + valor + " [USD] " + "corresponde ao valor final de =>>> " + (valor * real) + " [BRL]";
    }

    public String realDolar(Double valor){
        return "Valor " + valor + " [USD] " + "corresponde ao valor final de =>>> " + (valor * (1/real)) + " [USD]";
    }

    public String dolarPesoColombiano(Double valor){
        return "Valor " + valor + " [USD] " + "corresponde ao valor final de =>>> " + (valor * pesoColombiano) + " [COP]";
    }

    public String pesoColombianoDolar(Double valor){
        return "Valor " + valor + " [COP] " + "corresponde ao valor final de =>>> " + (valor * (1/pesoColombiano)) + " [USD]";
    }
}
