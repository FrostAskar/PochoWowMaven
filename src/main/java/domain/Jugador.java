package domain;

public class Jugador {
    private String nombre;
    private String contraseña;
    private Personaje[] personajes;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador (String nombre, String contraseña){
        this.nombre = nombre;
        this.contraseña = contraseña;
    }


}
