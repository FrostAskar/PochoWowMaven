package domain;

public class Clase {
    private int ataque, psMax, precision, evasion;
    private enum nombreClases {Guerrero, Pícaro, Cazador, Mago, Brujo, Sacerdote, Chamán, Druida, Paladín};
    private String nombreClase;
    public Clase(int ataque, int psMax, int precision, int evasion, nombreClases nombre){
        this.ataque = ataque;
        this.psMax = psMax;
        this.precision = precision;
        this.evasion = evasion;
        this.nombreClase = nombre.toString();
    }

    public String getNombreClase() {
        return nombreClase;
    }
}
