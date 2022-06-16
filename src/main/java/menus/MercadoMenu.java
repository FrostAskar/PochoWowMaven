package menus;

import Utils.Sesion;

public class MercadoMenu extends Menu{


    public MercadoMenu(String title) {
        super(title);
    }

    @Override
    protected void initActions() {
        addOption("1", new MenuAction() {
                    @Override
                    public void execute() {
                        Sesion.getInstance().getMercado().mostrarObjetosenVenta();
                    }

                    @Override
                    public String getOptionName() {
                        return "Ver Objetos en GnomeBay";
                    }
                }

        );
        addOption("2", new MenuAction() {
            @Override
            public void execute() {
                    Sesion.getInstance().getMercado().venderObjeto();
            }

            @Override
            public String getOptionName() {
                return "Vender";
            }
        });

        addOption("3", new MenuAction() {
            @Override
            public void execute() {
                Sesion.getInstance().getMercado().comprarObjeto();
            }

            @Override
            public String getOptionName() {
                return "Comprar";
            }
        });
    }

    @Override
    protected void onPreOptions() {
        System.out.println("Tienes "+ Sesion.getInstance().getPersonajeActivo().getOro()+" monedas de Oro");
    }
}
