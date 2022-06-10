package domain;

import java.util.List;

public class Mazmorra {
    private String nombre;
    private int nivelMax;
    private List<Enemigo>  enemigos;

    public Mazmorra(String nombre, int nivelMax){
        this.nombre = nombre;
        this.nivelMax = nivelMax;
    }
}
