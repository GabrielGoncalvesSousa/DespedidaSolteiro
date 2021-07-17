package estg.ipvc.gabrielSousa.menus.gestorSistema;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.SingleLeveledMenu;

public class SingleMenu_AprovarPreRegisto extends SingleLeveledMenu implements Menu {

    public SingleMenu_AprovarPreRegisto(MainData data) {
        super(data);
    }

    @Override
    public void action() {
        System.out.println("ok");
    }

    @Override
    public String getName() {
        return "Aprovar Pré-Registos.";
    }
}
