package domain;

public class Mercado {

    private Jugador vendedor;
    private Objeto objeto;

    private int precio;

    public Mercado(Jugador vendedor, Objeto objeto, int precio){
        this.vendedor = vendedor;
        this.objeto = objeto;
        this.precio = precio;
    }

}
