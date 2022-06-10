package domain;

import java.util.List;

public class Equipo {
    private Jugador jugador;
    private List<Objeto> objetos;

    public Equipo(Jugador jugador){
        this.jugador = jugador;
    }

    public void anadeObjeto(Objeto objeto){
        this.objetos.add(objeto);
    }
}
