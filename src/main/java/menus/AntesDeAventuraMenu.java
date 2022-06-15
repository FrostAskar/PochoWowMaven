package menus;

import Utils.Sesion;

public class AntesDeAventuraMenu extends Menu{

    public AntesDeAventuraMenu(String title) {
        super(title);
    }

    @Override
    protected void initActions() {

        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                new SeleccionMazmorraMenu("Mazmorra").start();
            }

            @Override
            public String getOptionName() {
                return "Entrar en la mazmorra";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                System.out.println("Visitando el mercado.");
                sleep(2000);
                new MercadoMenu("¡Bienvenido al Mercado!").start();
            }

            @Override
            public String getOptionName() {
                return "Visitar el mercado";
            }
        });

        addOption("3", new MenuAction() {
            @Override
            public void execute() {
                System.out.println("Mirando el inventario.");
                Sesion.getInstance().getPersonaje().mostrarInventario();
                sleep(2000);
            }

            @Override
            public String getOptionName() {
                return "Inventario";
            }
        });

    }

    @Override
    protected void onPreOptions() {

    }
}
