package dao;

import domain.Jugador;
import domain.Objeto;

public interface MercadoDao {

    boolean venderObjeto(Objeto objeto, Jugador vendedor);
}
