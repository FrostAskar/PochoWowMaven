package domain;

public class Personaje {

    private String nombre;
    private String clase;
    private int nivel = 1;
    private int ataque;
    private int psActual;
    private int psMax;
    private int precision;
    private int evasion;
    private int oro = 0;
    private int experiencia = 0;
    private Jugador jugador;

    public Personaje(String nombre, String clase, int ataque, int psMax, int precision, int evasion, Jugador jugador) {
        this.nombre = nombre;
        this.clase = clase;
        this.ataque = ataque;
        this.psMax = psMax;
        this.precision = precision;
        this.evasion = evasion;
        this.jugador = jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getPsActual() {
        return psActual;
    }

    public void setPsActual(int psActual) {
        this.psActual = psActual;
    }

    public int getPsMax() {
        return psMax;
    }

    public void setPsMax(int psMax) {
        this.psMax = psMax;
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

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
