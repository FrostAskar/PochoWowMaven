package dao.Mysql;

import dao.EnemigoDao;
import domain.Enemigo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnemigoDaoMysql implements EnemigoDao {

    private Connection con = null;

    public EnemigoDaoMysql(Connection con) {
        this.con = con;
    }
    @Override
    public Enemigo RecuperarEnemigoporNombre(String nombre) {

        Enemigo enemigo = null;

        String query = "SELECT * FROM Enemigo WHERE nombre = ?";

        try {
            PreparedStatement selectEnemyStmnt = con.prepareStatement(query);
            selectEnemyStmnt.setString(1,nombre);

            ResultSet resultSet = selectEnemyStmnt.executeQuery(query);

            while (resultSet.next()){
                enemigo = new Enemigo(
                        resultSet.getString("nombre"),
                        resultSet.getInt("nivel"),
                        resultSet.getInt("ataque"),
                        resultSet.getInt("salud_max"),
                        resultSet.getInt("precisión"),
                        resultSet.getInt("evasión"),
                        resultSet.getInt("oro"),
                        resultSet.getInt("experiencia")
                );
            }

            return enemigo;

        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;
    }
}
