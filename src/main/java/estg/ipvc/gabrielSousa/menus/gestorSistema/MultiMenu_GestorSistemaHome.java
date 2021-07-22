package estg.ipvc.gabrielSousa.menus.gestorSistema;

import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_AprovarPreRegisto;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_AprovarServicoEmpresa;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_GerirEstadoMarcacao;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_VerInfoCliente;


public class MultiMenu_GestorSistemaHome extends MultiLeveledMenu {

    public MultiMenu_GestorSistemaHome() {
        super(new Menu[]{
                new SingleMenu_AprovarPreRegisto(),
                new SingleMenu_AprovarServicoEmpresa(),
                new SingleMenu_VerInfoCliente(),
                new SingleMenu_GerirEstadoMarcacao()
        });
    }

    @Override
    public String getName() {
        return "Main Menu Gestor Sistema";
    }

}

