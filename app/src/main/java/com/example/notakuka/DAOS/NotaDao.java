package com.example.notakuka.DAOS;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notakuka.MODELOS.Notas;

import java.util.List;

@Dao
public interface NotaDao {
    @Query("SELECT * FROM notas")
    List<Notas> getAll();

    @Query("SELECT * FROM notas WHERE id_nota IN (:notaIds)")
    List<Notas> loadAllByIds(int[] notaIds);

    @Query("SELECT * FROM notas WHERE titulo_nota LIKE :titulo AND " +
            "descripcion_nota LIKE :desc LIMIT 1")
    Notas findByName(String titulo, String desc);

    @Insert
    void insertAll(Notas... notas);

    @Delete
    void delete(Notas notas);
}
