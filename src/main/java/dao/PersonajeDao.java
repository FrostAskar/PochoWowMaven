package dao;

import domain.Jugador;
import domain.Personaje;
import domain.Objeto;
public interface PersonajeDao {

    boolean crearPersonaje (String clase, String nombre, Jugador jugador);

    void leerCaracteristicas (Jugador jugador);

    public Personaje listaPersonajes(Jugador jugador);

    void mostrarInventario ();

    Objeto buscarObjeto(int id);
}
