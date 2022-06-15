package dao;

import domain.Jugador;

public interface JugadorDao {

    boolean crearJugador(String nombre, String contraseña);

    Jugador buscarPorNombre (String nombre);

    Jugador verificarJugador(String nombre, String contraseña);


}
