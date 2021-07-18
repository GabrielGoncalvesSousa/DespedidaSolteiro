package estg.ipvc.gabrielSousa.menus.funcionario;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_AprovarPreRegisto;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_GerirEstadoMarcacao;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_VerInfoCliente;


public class MultiMenu_FuncionarioHome extends MultiLeveledMenu {

    public MultiMenu_FuncionarioHome(MainData data) {
        super(new Menu[]{
                new SingleMenu_AprovarPreRegisto(data),
                new SingleMenu_GerirEstadoMarcacao(data),
                new SingleMenu_VerInfoCliente(data)
        });
        super.setData(data);
    }

    @Override
    public String getName() {
        return "Main Menu Funcionario";
    }

}

