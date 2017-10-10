package com.example.camilo.vectorderotacion.models;

/**
 * Created by camilo on 04/04/2017.
 */
public class Movimiento {
    private long id;
    private double minicial;
    private double mfinal;
    private double mangulo;

    public long getId() {return id;}

    public void setId(long id) {
        this.id = id;
    }

    public double getMinicial() {
        return minicial;
    }

    public void setMinicial(double minicial) {
        this.minicial = minicial;
    }

    public double getMfinal() {
        return mfinal;
    }

    public void setMfinal(double mfinal) {
        this.mfinal = mfinal;
    }

    public double getMangulo(){return mangulo;}

    public void setMangulo(double mangulo){this.mangulo = mangulo; }
}
