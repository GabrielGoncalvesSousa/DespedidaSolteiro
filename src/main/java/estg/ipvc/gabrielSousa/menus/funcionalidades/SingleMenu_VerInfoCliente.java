package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.SingleLeveledMenu;

import java.util.ArrayList;

public class SingleMenu_VerInfoCliente extends SingleLeveledMenu implements Menu {
    public SingleMenu_VerInfoCliente(MainData data) {
        super(data);
    }

    @Override
    public void action() {
        getDataFilters().getAllClientInfo();
    }

    @Override
    public String getName() {
        return "Informação dos clientes.";
    }

}
