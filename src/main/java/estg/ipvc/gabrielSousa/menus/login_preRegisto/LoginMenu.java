package estg.ipvc.gabrielSousa.menus.login_preRegisto;


import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
import estg.ipvc.gabrielSousa.menus.base.SingleOption;
import estg.ipvc.gabrielSousa.menus.base.Menu;

import java.util.Scanner;

public class LoginMenu extends SingleOption implements Menu {

    public LoginMenu(MainData data) {
        super(data);
    }


    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza o Login");
        String login = scanner.nextLine();
        System.out.println("Introduza a password");
        String password = scanner.nextLine();

        getData().setCurrentPessoa(null);

        //checks if login and password exists
        try {
            for (Pessoa p : getData().getPessoas()) {
                if (p.login(login, password)) {

                    //The current user is stored in a instance var.
                    getData().setCurrentPessoa(p);
                    break;
                }
            }

            //if it doesnt exit it throws the exception
            if (getData().getCurrentPessoa() == null) {
                throw new Exception();

                //else prints the login with success.
            } else {
                System.out.println("Login com sucesso " + getData().getCurrentPessoa().getTipoPessoa().getNomeTipoPessoa() + " "
                        + getData().getCurrentPessoa().getPrimeiroNome() + " " + getData().getCurrentPessoa().getUltimoNome());
            }

        } catch (Exception e) {
            System.out.println("Credenciais Invalidas");
        }
    }

    @Override
    public String getName() {
        return "Login";
    }

}

