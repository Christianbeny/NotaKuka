package com.example.notakuka.DBA;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notakuka.DAOS.NotaDao;
import com.example.notakuka.MODELOS.Notas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Notas.class}, version = 1)
public abstract class AppDataBaseNotas extends RoomDatabase {

    public abstract NotaDao getNotaDao();

    //Instancia de creacion de base de datos
    private static AppDataBaseNotas INSTANCE;

    //Sub procesos
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutorNotas =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    //veriicacion de creacion de base de datos --- Singlenton
    public static AppDataBaseNotas getAppDataBaseNotasInstance(Context context){
        if (INSTANCE == null){
            synchronized (AppDataBaseNotas.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBaseNotas.class, "notas").build();
                }
            }
        }
        return INSTANCE;
    }

}
