package estg.ipvc.gabrielSousa.menus.login_preRegisto;


import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.GestorSistema;
import estg.ipvc.gabrielSousa.entidades.pessoa.TipoPessoa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MultiLeveledMenu;
import estg.ipvc.gabrielSousa.menus.gestorSistema.MultiMenu_GestorSistemaHome;

import java.util.Scanner;

public class MultiMenu_Login extends MultiLeveledMenu {
    private TipoPessoa tipoCurrentUtilizador = new TipoPessoa();

    public MultiMenu_Login(MainData data) {
        super(new Menu[]{
                new SingleMenu_Login(data),
        });
    }


    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza o Login");
        String login = scanner.nextLine();
        System.out.println("Introduza a password");
        String password = scanner.nextLine();

        getData().setCurrentPessoa(null);

        try {
            //Return true if exists
            if (!getDataCheckers().checkIfLoginAndPasswordExists(login, password)) {
                throw new Exception();
            } else if (getData().getCurrentPessoa() instanceof GestorSistema) {
                System.out.println("Bruh " + getData().getCurrentPessoa().getTipoPessoa().getNomeTipoPessoa() + " "
                        + getData().getCurrentPessoa().getPrimeiroNome() + " " + getData().getCurrentPessoa().getUltimoNome());
                super.addMenu(new MultiMenu_GestorSistemaHome(getData()));

            }
        } catch (Exception e) {
            System.out.println("Credencias Inválidas.");
        }
    }



    @Override
    public String getName() {
        return "Login";
    }

}

