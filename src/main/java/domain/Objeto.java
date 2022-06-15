package domain;

public class Objeto {

    private Personaje propietario;
    private int ataque, salud, precision, evasion,id;
    private String nombre;

    public Objeto(Personaje propietario, int ataque, int salud, int precision, int evasion, String nombre, int id) {
        this.propietario = propietario;
        this.ataque = ataque;
        this.salud = salud;
        this.precision = precision;
        this.evasion = evasion;
        this.nombre = nombre;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "propietario=" + propietario.getNombre() +
                        ", nombre=" + nombre +
                ", ataque=" + ataque +
                ", salud=" + salud +
                ", precision=" + precision +
                ", evasion=" + evasion
                ;
    }
}
