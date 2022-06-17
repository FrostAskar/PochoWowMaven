package dao;

import domain.Objeto;

public interface ObjetoDao {

    public Objeto crearObjeto();

    public Objeto aplicarModificador(Objeto objeto);
}
