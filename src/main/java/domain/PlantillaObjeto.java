package domain;

public class PlantillaObjeto {
    private int ataque, salud, precision, evasion;
    private String nombre;

    public PlantillaObjeto (int ataque, int salud, int precision, int evasion, String nombre){
        this.ataque = ataque;
        this.salud = salud;
        this.precision = precision;
        this.evasion = evasion;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
