package com.example.bazadanychsamochody;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tokareczki")

public class Samochod {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String marka;
    private String model;
    @ColumnInfo(name = "rocznik")
    private int rocznik;
    @ColumnInfo(name = "moc_silnika")
    private int mocSilnika;

    public Samochod(String marka, String model, int rocznik, int mocSilnika) {
        this.id = 0;
        this.marka = marka;
        this.model = model;
        this.rocznik = rocznik;
        this.mocSilnika = mocSilnika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRocznik() {
        return rocznik;
    }

    public void setRocznik(int rocznik) {
        this.rocznik = rocznik;
    }

    public int getMocSilnika() {
        return mocSilnika;
    }

    public void setMocSilnika(int mocSilnika) {
        this.mocSilnika = mocSilnika;
    }

    @Override
    public String toString() {
        return "Tokarka{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", rocznik=" + rocznik +
                ", mocSilnika=" + mocSilnika +
                '}';
    }
}
