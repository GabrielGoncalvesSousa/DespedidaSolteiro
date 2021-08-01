package estg.ipvc.gabrielSousa.menus.gestorSistema;

import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.funcionalidades.*;


public class MultiMenu_GestorSistemaHome extends MultiLeveledMenu {

    public MultiMenu_GestorSistemaHome() {
        super(new Menu[]{
                new SingleMenu_AprovarPreRegisto(),
                new SingleMenu_AprovarServicoEmpresa(),
                new SingleMenu_VerInfoCliente(),
                new SingleMenu_GerirEstadoMarcacao(),
                new SingleMenu_ServicosPrestadosPorFornecedorEntreDatas()
        });
    }

    @Override
    public String getName() {
        return "Main Menu Gestor Sistema";
    }

}

