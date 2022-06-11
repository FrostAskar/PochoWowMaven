package menus;

import Utils.DBUtil;
import Utils.Sesion;
import dao.JugadorDao;
import dao.Mysql.JugadorDaoMysql;
import domain.Jugador;

public class LoginMenu extends Menu{

    Sesion sesion = Sesion.getInstance();
    JugadorDao jugadorDao = sesion.getJugador();

    public LoginMenu(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                String user = Input.readString("Introduce tu nombre");
                String pass = Input.readString("Introduce tu contraseña");
                sesion.setJugadorActivo(jugadorDao.verificarJugador(user, pass));
                if (sesion.getJugadorActivo() == null) {
                    System.out.println("Login Incorrecto");
                    sleep(2000);
                }else{
                    System.out.println("Login Correcto");
                    sleep(1000);
                    new SeleccionarPersonajeMenu("Selecciona tu personaje").start();
                }
            }

            @Override
            public String getOptionName() {
                return "Login";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                String user = Input.readString("Introduce Nombre de usuario");
                String pass = Input.readString("Introduce una contraseña");
                if (Sesion.getInstance().getJugador().crearJugador(user, pass)){
                    System.out.println("Usuario creado satisfactoriamente");
                    sleep(2000);
                } else{
                    sleep(2000);
                };
            }

            @Override
            public String getOptionName() {
                return "Registro";
            }
        });
    }
    @Override
    protected void onPreOptions() {

    }

    public static void main(String[] args) {
        LoginMenu login = new LoginMenu("Login");
        //DBUtil.createConnectionFromProperties("");
        login.start();
    }
}
