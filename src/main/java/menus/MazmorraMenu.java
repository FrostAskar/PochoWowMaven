package menus;

import Utils.Sesion;

public class MazmorraMenu extends Menu{

    private String nombreObjetivo;
    Sesion sesion= Sesion.getInstance();
    public MazmorraMenu(String title, String nombreMazmorra) {
        super(title);
        this.nombreObjetivo = nombreMazmorra;
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
            @Override
            public void execute() {
                System.out.println("Toca saltarse los dientes");
                sleep(2000);
                System.out.println("Aquí irán las castañas");
                sleep(2000);
                //Generar enemigos
                //combate
            }

            @Override
            public String getOptionName() {
                return "Adentrarse en la mazmorra";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                System.out.println("Ese señor me ha dicho que esta poción me quitará todos los males");
                sleep(2000);
            }

            @Override
            public String getOptionName() {
                return "Recuperarse con una poción rara";
            }
        });

        addOption("3", new MenuAction() {
            @Override
            public void execute() {
                System.out.println("Montar la tienda de campaña");
                sleep(2000);
            }

            @Override
            public String getOptionName() {
                return "Descansar";
            }
        });

        addOption("4", new MenuAction() {
            @Override
            public void execute() {
                System.out.println("Ahora vuelvo, que tengo que regar mi canario");
                sleep(2000);
                System.out.println();
                sleep(2000);
                return;
            }

            @Override
            public String getOptionName() {
                return "Escapar";
            }
        });
    }

    @Override
    protected void onPreOptions() {
        System.out.println("Bienvenido a " + nombreObjetivo);
    }
}
