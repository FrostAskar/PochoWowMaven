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

    public Objeto(Personaje propietario, int ataque, int salud, int precision, int evasion, String nombre) {
        this.propietario = propietario;
        this.ataque = ataque;
        this.salud = salud;
        this.precision = precision;
        this.evasion = evasion;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public Personaje getPropietario() {
        return propietario;
    }

    public void setPropietario(Personaje propietario) {
        this.propietario = propietario;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

