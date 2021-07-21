package estg.ipvc.gabrielSousa.menus.cliente;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_AprovarPreRegisto;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_AvaliarServico;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_CriarMarcacao;
import estg.ipvc.gabrielSousa.menus.funcionalidades.SingleMenu_VerEstadoMarcacao;


public class MultiMenu_ClienteHome extends MultiLeveledMenu {

    public MultiMenu_ClienteHome() {
        super(new Menu[]{
                new SingleMenu_CriarMarcacao(),
                new SingleMenu_VerEstadoMarcacao(),
                new SingleMenu_AvaliarServico()
        });
    }

    @Override
    public String getName() {
        return "Main Menu Cliente";
    }

}

