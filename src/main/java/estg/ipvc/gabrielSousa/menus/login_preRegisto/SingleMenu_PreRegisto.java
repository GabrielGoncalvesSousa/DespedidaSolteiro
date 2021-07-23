package estg.ipvc.gabrielSousa.menus.login_preRegisto;

import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
import estg.ipvc.gabrielSousa.entidades.pessoa.TipoPessoa;
import estg.ipvc.gabrielSousa.menus.base.*;

import java.io.Console;
import java.util.Scanner;

public class SingleMenu_PreRegisto extends MenuData implements Menu {
    @Override
    public void action() {
        try {
            RegisterStringGetter registerStringGetter = new RegisterStringGetter();

            //Obter login
            String login = registerStringGetter.getLogin();

            //Verificar se login ja existe
            while (checkIfLoginExists(login)) {
                System.out.print("Login ja existe. ");
                login = registerStringGetter.getLogin();
            }

            //Obter password
            String password = registerStringGetter.getPassword();

            //Obter os tipos de utilizador disponiveis
            getTiposDeUtilizadorParaPreRegisto();

            //Guardar o id do tipo utilizador pretendido
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
                System.out.print("Email já utilizado. ");
                email = registerStringGetter.getMail();
                checkIfMailExists(email);
            }

            //getting contato
            String contato = registerStringGetter.getContato();

            Pessoa p = new Pessoa(tipoPessoa, login, password, primeiroNome, ulimoNome,
                    email, contato, false);

            //Adicionar no arrayList
            getMainData().getPessoas().add(p);

            System.out.println("Conta criada com sucesso. Aguarde Aprovação.");

            //Guardar os dados no ficheiro
            getSerialization().saveData(getMainData());

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
        System.out.print("Introduza o Login:");
        String login = scanner.nextLine();

        while (login.isEmpty()) {
            System.out.print("Campo de login vazio, Introduza o Login: ");
            login = scanner.nextLine();
        }
        return login;
    }

    public String getPassword() {
        System.out.print("Introduza a password: ");
        String password = scanner.nextLine();

        while (password.isEmpty()) {
            System.out.print("Campo de password vazio, Introduza a password: ");
            password = scanner.nextLine();
        }
        return password;
    }

    public String getPrimeiroNome() {
        System.out.print("Introduza o Primeiro Nome: ");
        String pNome = scanner.nextLine();

        while (pNome.isEmpty()) {
            System.out.print("Campo do Primeiro Nome vazio, Introduza o primeiro Nome: ");
            pNome = scanner.nextLine();
        }
        return pNome;
    }

    public String getUltimoNome() {
        System.out.print("Introduza o Ultimo Nome: ");
        String pNome = scanner.nextLine();

        while (pNome.isEmpty()) {
            System.out.print("Campo do Ultimo Nome vazio, Introduza o Ultimo Nome: ");
            pNome = scanner.nextLine();
        }
        return pNome;
    }

    public String getMail() {
        System.out.print("Introduza o Email: ");
        String email = scanner.nextLine();

        while (email.isEmpty()) {
            System.out.print("Campo do email vazio, Introduza o email: ");
            email = scanner.nextLine();
        }
        return email;
    }

    public int getTipoUtilizador() {
        int tipoUtilizador=-1;
        try{
            System.out.print("Introduza o tipo de utilizador: ");
            tipoUtilizador = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
        }

        return tipoUtilizador;
    }

    public String getContato() {
        System.out.print("Introduza o seu contato: ");
        String contato = scanner.nextLine();

        while (contato.isEmpty()) {
            System.out.print("Campo do contato vazio, Introduza o contato: ");
            contato = scanner.nextLine();
        }
        return contato;
    }

}


