package menus;

import Utils.Sesion;
import domain.Enemigo;
import domain.Personaje;

public class CombateMenu extends Menu{

    Enemigo enemigo;
    Personaje personaje = Sesion.getInstance().getPersonajeActivo();

    public CombateMenu(String title, Enemigo enemigo) {
        super(title);
        this.enemigo = enemigo;
    }


    @Override
    protected void initActions() {

        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                System.out.println("Soltar Castaña");
                sleep(2000);
            }

            @Override
            public String getOptionName() {
                return "Atacar";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                System.out.println("Agacha la cabeza y corre");
                sleep(2000);
            }

            @Override
            public String getOptionName() {
                return "Defensa";
            }
        });

        addOption("3", new MenuAction() {
            @Override
            public void execute() {
                System.out.println("Habilidad de clase");
                sleep(2000);
            }

            @Override
            public String getOptionName() {
                return "Habilidad de Clase";
            }
        });

        addOption("4", new MenuAction() {
            @Override
            public void execute() {
                System.out.println("Salir por piernas");
                sleep(2000);
            }

            @Override
            public String getOptionName() {
                return "huir";
            }
        });
    }

    @Override
    protected void onPreOptions() {

    }
}
