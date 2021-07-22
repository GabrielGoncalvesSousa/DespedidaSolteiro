package estg.ipvc.gabrielSousa.menus.funcionario;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_AprovarPreRegisto;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_GerirEstadoMarcacao;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_VerInfoCliente;


public class MultiMenu_FuncionarioHome extends MultiLeveledMenu {

    public MultiMenu_FuncionarioHome() {
        super(new Menu[]{
                new SingleMenu_AprovarPreRegisto(),
                new SingleMenu_GerirEstadoMarcacao(),
                new SingleMenu_VerInfoCliente()
        });

    }

    @Override
    public String getName() {
        return "Main Menu Funcionario";
    }

}

