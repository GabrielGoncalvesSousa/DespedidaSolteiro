package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

public class SingleMenu_VerInfoCliente extends MenuData implements Menu {

    @Override
    public void action() {
        getAllClientInfo();
    }

    @Override
    public String getName() {
        return "Informação dos clientes.";
    }

}
