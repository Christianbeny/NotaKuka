package com.example.notakuka.MODELOS;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tareas {
    @PrimaryKey
    public int id_tarea;

    @ColumnInfo(name = "titulo_tarea")
    public String tituloTarea;

    @ColumnInfo(name = "descripcion_tarea")
    public String descripcionTarea;

    @ColumnInfo(name = "contenido_tarea")
    public String contenidoTarea;

    @ColumnInfo(name = "fecha_tarea")
    public String fechaTarea;

    @ColumnInfo(name = "fecha_cumplir_tarea")
    public String fechaCumplirTarea;
}
