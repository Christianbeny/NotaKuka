package com.example.notakuka.DBA;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notakuka.DAOS.NotaDao;
import com.example.notakuka.DAOS.TareaDao;
import com.example.notakuka.MODELOS.Tareas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities={Tareas.class}, version = 1)
public abstract class AppDataBaseTareas extends RoomDatabase {

    public abstract TareaDao getTareaDao();

    //Instancia de creacion de base de datos
    private static AppDataBaseTareas INSTANCE;

    //Sub procesos
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutorTareas =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    //veriicacion de creacion de base de datos --- Singlenton
    public static AppDataBaseTareas getAppDataBaseTareasInstance(Context context){
        if (INSTANCE == null){
            synchronized (AppDataBaseTareas.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBaseTareas.class, "tareas").build();
                }
            }
        }
        return INSTANCE;
    }

}
