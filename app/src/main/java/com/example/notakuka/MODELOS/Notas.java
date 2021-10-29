package com.example.notakuka.MODELOS;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Notas {
    @PrimaryKey(autoGenerate = true)
    public int id_nota;

    @ColumnInfo(name = "titulo_nota")
    public String tituloNota;

    @ColumnInfo(name = "descripcion_nota")
    public String descripcionNota;

    @ColumnInfo(name = "contenido_nota")
    public String contenidoNota;

    @ColumnInfo(name = "fecha_nota")
    public String fechaNota;
}
