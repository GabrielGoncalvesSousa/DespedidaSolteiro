package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

public class SingleMenu_VerEstadoMarcacao extends MenuData implements Menu {
    @Override
    public void action() {
        getMainData().getMarcacoes().forEach(marcacao -> {
            if(marcacao.getCliente().equals(getMainData().getCurrentPessoa())){
                System.out.println(marcacao);
            }
        });
    }

    @Override
    public String getName() {
        return "Ver estado das Marcações";
    }
}
