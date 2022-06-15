package dao.Mysql;

import Utils.Sesion;
import dao.JugadorDao;
import dao.JugadorDao;
import domain.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadorDaoMysql implements JugadorDao {

    private Connection con = null;


    public JugadorDaoMysql(Connection con){
        this.con = con;
    }

    @Override
    public boolean crearJugador(String nombre, String pass) {

        Jugador jugador = null;

        String query = "INSERT INTO Jugador (nombre, contraseña) VALUES (?, ?)";

        try {
            PreparedStatement getJugadorStatement = con.prepareStatement(query);

            getJugadorStatement.setString(1, nombre);
            getJugadorStatement.setString(2, pass);

            int exito = getJugadorStatement.executeUpdate();

            return exito == 1;

        } catch (SQLException SQLIntegrityConstraintViolationException) {
            System.err.println("El Jugador ya existe.");
        }

        return false;

    }

    @Override
    public Jugador buscarPorNombre(String nombre) {
        return null;
    }

    @Override
    public Jugador verificarJugador(String nombre, String contraseña) {

        Jugador jugador = null;

        String query = "SELECT nombre, contraseña FROM Jugador WHERE nombre = ? AND contraseña = ?";

        try {
            PreparedStatement verifyStmnt = con.prepareStatement(query);

            verifyStmnt.setString(1, nombre);
            verifyStmnt.setString(2, contraseña);

            ResultSet resultado = verifyStmnt.executeQuery();


        if (resultado.next()) {
            jugador = new Jugador(nombre, contraseña);
            return jugador;
        }

        } catch (SQLException e) {
            System.err.println("El jugador no existe.");
        }

        return null;
    }



}
