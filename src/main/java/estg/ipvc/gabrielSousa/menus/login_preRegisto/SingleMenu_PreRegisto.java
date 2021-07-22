package estg.ipvc.gabrielSousa.menus.login_preRegisto;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
import estg.ipvc.gabrielSousa.entidades.pessoa.TipoPessoa;
import estg.ipvc.gabrielSousa.menus.base.*;

import java.util.Scanner;

public class SingleMenu_PreRegisto extends MenuData implements Menu {
    @Override
    public void action() {
        try {
            RegisterStringGetter registerStringGetter = new RegisterStringGetter();

            /*Getting login and verifying if exists return true if exists */
            String login = registerStringGetter.getLogin();

            while (checkIfLoginExists(login)) {
                System.out.println("Login ja existe");
                login = registerStringGetter.getLogin();
            }

            //Getting the password String
            String password = registerStringGetter.getPassword();

            /*Getting the id selected plus finding the match for the id
            and returning the corresponding tipoPessoa instance from the list */
            getTiposParaPreRegisto();
            int id = registerStringGetter.getTipoUtilizador();
            while (id != 2 && id != 3) {
                System.out.print("Opção Inválida. ");
                id = registerStringGetter.getTipoUtilizador();
            }
            TipoPessoa tipoPessoa = getTipoPessoaSelecionadaParaRegisto(id);

            //Getting First Name
            String primeiroNome = registerStringGetter.getPrimeiroNome();

            //Geting Last Name
            String ulimoNome = registerStringGetter.getUltimoNome();

            //Getting email and verifying if exists return true if exists
            String email = registerStringGetter.getMail();
            while (checkIfMailExists(email)) {
                email = registerStringGetter.getMail();
                checkIfMailExists(email);
            }

            //getting contato
            String contato = registerStringGetter.getContato();

            Pessoa p = new Pessoa(tipoPessoa, login, password, primeiroNome, ulimoNome,
                    email, contato, false);

            getMainData().getPessoas().add(p);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String getName() {
        return "Registar";
    }
}

class RegisterStringGetter {
    private final Scanner scanner = new Scanner(System.in);

    public String getLogin() {
        System.out.println("Introduza o Login");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.println("Introduza a password");
        return scanner.nextLine();
    }

    public String getPrimeiroNome() {
        System.out.println("Introduza o Primeiro Nome");
        return scanner.nextLine();
    }

    public String getUltimoNome() {
        System.out.println("Introduza o Ultimo Nome");
        return scanner.nextLine();

    }

    public String getMail() {
        System.out.println("Introduza o Email");
        return scanner.nextLine();
    }

    public int getTipoUtilizador() {
        System.out.println("Introduza o tipo de utilizador");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getContato() {
        System.out.println("Introduza o seu contato");
        return scanner.nextLine();
    }

}


