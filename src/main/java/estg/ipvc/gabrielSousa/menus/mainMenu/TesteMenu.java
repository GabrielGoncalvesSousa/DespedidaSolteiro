package menus.mainMenu;

import entidades.MainData;
import entidades.pessoa.Funcionario;
import menus.base.Menu;
import menus.base.SingleOption;

public class TesteMenu extends SingleOption implements Menu {

    public TesteMenu(MainData data) {
        super(data);
    }

    @Override
    public void action() {

        getData().getPessoas().add(new Funcionario(1, getData().getTpPessoas().get(1), "funcionario1", "123", "Nuno1", "Oliveira1"
                , "nunoOliveira@ipvc.pt1", "934506842"));
    }

    @Override
    public String getName() {
        return "Adding Nuno1";
    }
}
