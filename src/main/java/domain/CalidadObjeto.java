package domain;

public class CalidadObjeto {
    private float ataque, salud, precision, evasion;
    private String nivel;

    public CalidadObjeto (float ataque, float salud, float precision, float evasion, String nivel){
        this.ataque = ataque;
        this.salud = salud;
        this.precision = precision;
        this.evasion = evasion;
        this.nivel = nivel;
    }

    public float getAtaque() {
        return ataque;
    }

    public void setAtaque(float ataque) {
        this.ataque = ataque;
    }

    public float getSalud() {
        return salud;
    }

    public void setSalud(float salud) {
        this.salud = salud;
    }

    public float getPrecision() {
        return precision;
    }

    public void setPrecision(float precision) {
        this.precision = precision;
    }

    public float getEvasion() {
        return evasion;
    }

    public void setEvasion(float evasion) {
        this.evasion = evasion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
