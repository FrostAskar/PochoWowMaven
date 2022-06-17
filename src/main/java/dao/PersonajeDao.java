package dao;

import domain.Jugador;
import domain.Personaje;
public interface PersonajeDao {

    boolean crearPersonaje (String clase, String nombre, Jugador jugador);

    void leerCaracteristicas (Jugador jugador);

    public Personaje listaPersonajes(Jugador jugador);

    public void actualizarPersonaje(Personaje personaje);
}
