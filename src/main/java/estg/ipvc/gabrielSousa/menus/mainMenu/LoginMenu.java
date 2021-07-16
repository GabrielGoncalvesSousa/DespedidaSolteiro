package menus.mainMenu;

import entidades.MainData;
import entidades.pessoa.Pessoa;
import menus.base.Menu;
import menus.base.SingleOption;

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

        /** Reset the current pessoa
         *
         */
        getData().setCurrentPessoa(null);



        try {
            for (Pessoa p : getData().getPessoas()) {
                if (p.login(login, password)) {
                    getData().setCurrentPessoa(p);
                    break;
                }
            }

            if(getData().getCurrentPessoa() == null){
                throw new Exception();
            }else{
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

