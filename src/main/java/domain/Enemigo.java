package domain;

public class Enemigo {
    private String nombre;
    private int nivel, ataque, salud, precision, evasion, oro, experiencia;

    public Enemigo (String nombre, int nivel, int ataque, int salud, int precision, int evasion, int oro, int experiencia){
        this.nombre = nombre;
        this.nivel = nivel;
        this.ataque = ataque;
        this.salud = salud;
        this.precision = precision;
        this.evasion = evasion;
        this.oro = oro;
        this.experiencia = experiencia;
    }
}
