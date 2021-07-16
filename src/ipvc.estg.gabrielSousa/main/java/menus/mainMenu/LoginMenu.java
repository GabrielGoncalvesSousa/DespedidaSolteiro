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

        for (Pessoa p:getData().getPessoas()){
            System.out.println("Login - "+p.getLogin() + "Password - " +p.getPassword());
            if(p.login(login, password)){
                getData().setCurrentPessoa(p);
                System.out.println("Login com sucesso " + p.getTipoPessoa().getNomeTipoPessoa() + " " + p.getPrimeiroNome() + " " +p.getUltimoNome());
            }else{
                System.out.println("Credenciais Invalidas");
            }
        }
    }

    @Override
    public String getName() {
        return "Login";
    }

}

