package estg.ipvc.gabrielSousa.menus.cliente;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.gestorSistema.SingleMenu_AprovarPreRegisto;


public class MultiMenu_ClienteHome extends MultiLeveledMenu {

    public MultiMenu_ClienteHome(MainData data) {
        super(new Menu[]{
                new SingleMenu_AprovarPreRegisto(data)
        });
        super.setData(data);
    }

    @Override
    public String getName() {
        return "Main Menu Cliente";
    }

}

