package com.example.bazadanychsamochody;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SamochodDAO {
    @Insert
    void wstawAutko(Samochod samochod);
    @Delete
    void usunAutko(Samochod samochod);
    @Update
    void zmienParametryTokarki(Samochod samochod);

    @Query("Select * from autka")
    List<Samochod> zwrocWszystkieAutka();

    @Query("Select model from autka where moc_silnika > :moc")
    List<String> zwrocModeleOMocy(int moc);
}
