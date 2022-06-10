package dao;

import domain.Mazmorra;
import domain.Enemigo;

import java.util.List;

public interface MazmorraDao {

    List<Enemigo> poblarMazmorra(Mazmorra mazmorra);
}
