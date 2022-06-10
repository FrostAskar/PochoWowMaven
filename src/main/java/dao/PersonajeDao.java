package dao;

import domain.Jugador;

public interface PersonajeDao {

    boolean crearPersonaje (String clase, String nombre, Jugador jugador);

    void leerCaracteristicas (Jugador jugador);

}
