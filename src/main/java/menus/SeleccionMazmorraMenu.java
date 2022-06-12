package menus;

import Utils.Sesion;

public class SeleccionMazmorraMenu extends Menu{
    public SeleccionMazmorraMenu(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {

            @Override
            public void execute() {
                Sesion.getInstance().setMazmorraActiva("Cavernas de Brazanegra");
                new MazmorraMenu("Mazmorra", "Cavernas de Brazanegra").start();
            }

            @Override
            public String getOptionName() {
                return "Cavernas de Brazanegra";
            }
        });

        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                Sesion.getInstance().setMazmorraActiva("Templo Oscuro");
                new MazmorraMenu("Mazmorra", "Templo Oscuro").start();
            }

            @Override
            public String getOptionName() {
                return "Templo Oscuro";
            }
        });

        addOption("3", new MenuAction() {
            @Override
            public void execute() {
                Sesion.getInstance().setMazmorraActiva("Ciudadela de Corona de Hielo");
                new MazmorraMenu("Mazmorra", "Ciudadela de Corona de Hielo").start();
            }

            @Override
            public String getOptionName() {
                return "Ciudadela de Corona de Hielo";
            }
        });
    }

    @Override
    protected void onPreOptions() {
        System.out.println("¿En qué mazmorra quieres aventurarte?");
    }
}
