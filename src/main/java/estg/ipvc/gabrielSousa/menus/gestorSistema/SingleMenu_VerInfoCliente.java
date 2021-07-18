package estg.ipvc.gabrielSousa.menus.gestorSistema;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.Cliente;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
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
