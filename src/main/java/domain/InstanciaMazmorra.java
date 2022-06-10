package domain;

public class InstanciaMazmorra {

    private int id;
    private Personaje personaje;
    private Mazmorra mazmorra;
    private int nivelActual;

    public InstanciaMazmorra(Personaje personaje, Mazmorra mazmorra, int id){
        this.personaje = personaje;
        this.mazmorra = mazmorra;
        this.id = id;
    }
}
