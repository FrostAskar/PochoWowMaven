package dao.Mysql;

import Utils.Sesion;
import dao.PersonajeDao;
import domain.Jugador;
import domain.Personaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonajeDaoMysql implements PersonajeDao {

    private Connection con = null;

    public PersonajeDaoMysql(Connection con){this.con = con;}
    @Override
    public boolean crearPersonaje(String clase, String nombre, Jugador jugador) {
        Personaje personaje = null;

        String query = "SELECT * FROM Clase WHERE nombre = ?";

        try {
            PreparedStatement personajeCreationStmnt = con.prepareStatement(query);
            personajeCreationStmnt.setString(1, clase);
            ResultSet result = personajeCreationStmnt.executeQuery();

            while (result.next()){
                personaje = new Personaje(
                    result.getString("nombre"),
                    clase,
                    result.getInt("ataque"),
                    result.getInt("salud"),
                    result.getInt("precisión"),
                    result.getInt("evasión"),
                    jugador
                );
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
//        return personaje;

        query = "INSERT INTO Personaje (nombre, clase, nivel, ataque, salud_max, salud_actual, precisión, evasión, oro, experiencia, nombre_jugador)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try {
            PreparedStatement personajeCreationStmnt = con.prepareStatement(query);
            personajeCreationStmnt.setString(1, nombre);
            personajeCreationStmnt.setString(2, personaje.getClase());
            personajeCreationStmnt.setInt(3, personaje.getNivel());
            personajeCreationStmnt.setInt(4, personaje.getAtaque());
            personajeCreationStmnt.setInt(5, personaje.getPsMax());
            personajeCreationStmnt.setInt(6, personaje.getPsMax());
            personajeCreationStmnt.setInt(7, personaje.getPrecision());
            personajeCreationStmnt.setInt(8, personaje.getEvasion());
            personajeCreationStmnt.setInt(9, personaje.getOro());
            personajeCreationStmnt.setInt(10, personaje.getExperiencia());
            personajeCreationStmnt.setString(11, Sesion.getInstance().getJugadorActivo().getNombre());

            int exito = personajeCreationStmnt.executeUpdate();

            return exito == 1;

        } catch (SQLException e) {
            System.err.println(e);
        }

        return false;
    }

    @Override
    public void leerCaracteristicas(Jugador jugador) {

    }
}
