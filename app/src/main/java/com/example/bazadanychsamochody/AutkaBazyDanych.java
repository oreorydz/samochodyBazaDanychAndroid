package com.example.bazadanychsamochody;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Samochod.class}, version = 1)
public abstract class AutkaBazyDanych extends RoomDatabase {
    public abstract SamochodDAO zwrocAutkaDao();
    private static AutkaBazyDanych instancja;
    public static AutkaBazyDanych zwrocBazeDanych(Context context){
        if (instancja==null){
            instancja = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AutkaBazyDanych.class,
                            "samochody.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instancja;
    }
}
