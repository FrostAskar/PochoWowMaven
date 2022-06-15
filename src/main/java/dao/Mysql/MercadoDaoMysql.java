package dao.Mysql;


import Utils.Sesion;
import dao.MercadoDao;
import dao.JugadorDao;
import domain.Jugador;
import domain.Objeto;
import menus.Input;

import java.sql.*;

public class MercadoDaoMysql implements MercadoDao {
    private Connection con =null;

    public MercadoDaoMysql(Connection con){
        this.con= con;
    }

    //FUNCIONA
    public void mostrarObjetosenVenta(){
        ResultSet lista;
        String query="SELECT ID_venta, nombre_vendedor, nombre, precio,ataque, salud, precisión, evasión FROM Mercado JOIN Objeto ON Mercado.ID_objeto = Objeto.ID_objeto";
        /*
        String query= "SELECT * FROM Mercado NATURAL JOIN Objeto";
         */
        try{
            PreparedStatement listaObjetos= con.prepareStatement(query);
            lista= listaObjetos.executeQuery();

            while(lista.next()){
                System.out.println(
                        lista.getInt("ID_venta")+") "+
                        " Vendedor:"+lista.getString("nombre_vendedor")+
                        " Item:"+ lista.getString("nombre")+
                        " Precio:"+ lista.getInt("precio")+
                        " ataque:"+ lista.getInt("ataque")+
                        " salud:"+lista.getInt("salud")+
                        " precisión:"+ lista.getInt("precisión")+
                        " evasión:"+ lista.getInt("evasión")
                );
            }
        }catch(SQLException e){
            System.err.println(e);
        }


    }


    /**
     * No hace falta un param Jugador pq solo el jugador activo puede poner objetos a la venta
     *
     * FUNCIONA
     */
    @Override
    public void venderObjeto() {

        //Paso 1 Mostrar Objetos del Jugador para que elija cual vende
        Sesion.getInstance().getPersonaje().mostrarInventario();
        //Paso 2 Seleccionar un item para poner a la venta
        int id_objeto = Input.readInt("Introduce el número del objeto que quieres vender");
        int precio = Input.readInt("¿A cuanto quieres venderlo?");
        //Query de inserción
        String query= "INSERT INTO Mercado (nombre_vendedor,ID_objeto,precio) " +
                        "VALUES (?,?,?)";
        try {
            PreparedStatement objetoVenta = con.prepareStatement(query);
            objetoVenta.setString(1,Sesion.getInstance().getPersonajeActivo().getNombre());
            objetoVenta.setInt(2,id_objeto);
            objetoVenta.setInt(3,precio);

            objetoVenta.executeUpdate();
        }catch(SQLException error){
            System.err.println(error);
        }


    }

    public void comprarObjeto(){
        mostrarObjetosenVenta();
        ResultSet rs;
        String vendedor;
        int objeto;
        int opcion= Input.readInt("Introduce el número del objeto que quieres comprar");
        String query= "SELECT nombre_vendedor, ID_objeto FROM Mercado WHERE ID_venta=?";
        try {
            PreparedStatement comprar= con.prepareStatement(query);
            comprar.setInt(1,opcion);
            rs= comprar.executeQuery();
            //No hace falta bucle pq la query solo puede devolver una fila;
            rs.next();
            vendedor=rs.getString("nombre_vendedor");
            objeto=rs.getInt("ID_objeto");
            query= "SELECT comprarObjeto(?,?,?,?)";
            comprar =con.prepareStatement(query);
            comprar.setInt(1,opcion);
            comprar.setInt(2,objeto);
            comprar.setString(3,Sesion.getInstance().getPersonajeActivo().getNombre());
            comprar.setString(4,vendedor);

            comprar.executeQuery();
        }catch (SQLException fallo){
            System.err.println(fallo);
        }

    }
}
