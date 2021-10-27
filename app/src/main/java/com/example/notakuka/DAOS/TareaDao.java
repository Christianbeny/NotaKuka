package com.example.notakuka.DAOS;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notakuka.MODELOS.Tareas;

import java.util.List;

@Dao
public interface TareaDao {
    @Query("SELECT * FROM tareas")
    List<Tareas> getAll();

    @Query("SELECT * FROM tareas WHERE id_tarea IN (:tareaIds)")
    List<Tareas> loadAllByIds(int[] tareaIds);

    @Query("SELECT * FROM tareas WHERE titulo_tarea LIKE :titulo AND " +
            "descripcion_tarea LIKE :desc LIMIT 1")
    Tareas findByName(String titulo, String desc);

    @Insert
    void insertAll(Tareas... tareas);

    @Delete
    void delete(Tareas tareas);
}
