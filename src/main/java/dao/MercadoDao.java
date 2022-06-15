package dao;

import domain.Jugador;
import domain.Objeto;

public interface MercadoDao {
    void mostrarObjetosenVenta();
    void venderObjeto();
    void comprarObjeto();
}
