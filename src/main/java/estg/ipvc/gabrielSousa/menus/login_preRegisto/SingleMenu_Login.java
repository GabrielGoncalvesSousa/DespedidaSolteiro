package estg.ipvc.gabrielSousa.menus.login_preRegisto;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.GestorSistema;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.base.SingleLeveledMenu;
import estg.ipvc.gabrielSousa.menus.gestorSistema.MultiMenu_GestorSistemaHome;

import java.util.Scanner;
import java.util.Stack;

public class SingleMenu_Login extends SingleLeveledMenu implements Menu {
    private Menu currentUserMenu;
    private Stack stack;

    public SingleMenu_Login(MainData data) {
        super(data);
    }

    @Override
    public void action() {
        System.out.println("WTFFF");
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza o Login");
        String login = scanner.nextLine();
        System.out.println("Introduza a password");
        String password = scanner.nextLine();

        getData().setCurrentPessoa(null);

        try {
            //Return true if login is successful
            if (!getDataCheckers().checkIfLoginAndPasswordExists(login, password)) {
                throw new Exception();
            } else if (getData().getCurrentPessoa() instanceof GestorSistema) {
                System.out.println("Login com sucesso " + getData().getCurrentPessoa().getTipoPessoa().getNomeTipoPessoa() + " "
                        + getData().getCurrentPessoa().getPrimeiroNome() + " " + getData().getCurrentPessoa().getUltimoNome());
                currentUserMenu= new MultiMenu_GestorSistemaHome(getData());



            }
        } catch (Exception e) {
            System.out.println("Credencias Inválidas.");
        }

*/
    }


    @Override
    public String getName() {
        return null;
    }


}
