package dao.Mysql;

import Utils.Sesion;
import dao.ObjetoDao;
import domain.Objeto;
import domain.Personaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjetoDaoMysql implements ObjetoDao {


    private Connection con = null;

    public ObjetoDaoMysql(Connection con){this.con = con;}

    @Override
    public Objeto crearObjeto() {

        List<Objeto> listaObjetos = new ArrayList<>();

        String query = "SELECT * FROM Plantilla_objeto";

        try {
            PreparedStatement crearObjetoStmnt = con.prepareStatement(query);

            ResultSet resultSet = crearObjetoStmnt.executeQuery();

            while (resultSet.next()){
                listaObjetos.add(new Objeto(
                        Sesion.getInstance().getPersonajeActivo(),
                        resultSet.getInt("ataque"),
                        resultSet.getInt("salud"),
                        resultSet.getInt("precisión"),
                        resultSet.getInt("evasión"),
                        resultSet.getString("nombre")
                ));
            }

            double chance = (int)(Math.random()*39);

            return listaObjetos.get((int)chance);

        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public Objeto aplicarModificador(Objeto objeto) {
        Objeto objetoMod = null;

        String nivel;
        double chance = Math.random();
        if (chance <= 0.33){
            nivel = "normal";
        } if (chance <= 0.66){
            nivel = "bendecido";
        } else {
            nivel = "epico";
        }

        String query = "SELECT * FROM Calidad WHERE nivel = ?";

        try {
            PreparedStatement modStmnt = con.prepareStatement(query);
            modStmnt.setString(1,nivel);
            ResultSet result = modStmnt.executeQuery();

            while (result.next()){
                objetoMod = new Objeto(
                        objeto.getPropietario(),
                        objeto.getAtaque() * result.getInt("ataque"),
                        objeto.getSalud() * result.getInt("salud"),
                        objeto.getPrecision() * result.getInt("precisión"),
                        objeto.getEvasion() * result.getInt("evasión"),
                        objeto.getNombre() + " " + result.getString("nivel")
                );
            }

            return objetoMod;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return objetoMod;
    }
}
