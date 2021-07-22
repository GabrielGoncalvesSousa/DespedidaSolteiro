package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.marcacao.Distrito;
import estg.ipvc.gabrielSousa.entidades.marcacao.Localidade;
import estg.ipvc.gabrielSousa.entidades.marcacao.ServicoEmpresa;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class SingleMenu_CriarServicoEmpresa extends MenuData implements Menu {
    @Override
    public void action() {
        RegisterServicoEmpresaStringGetter stringHelper = new RegisterServicoEmpresaStringGetter();

        Pessoa currentPessoa = getMainData().getCurrentPessoa();

        String nomeServico = stringHelper.getNomeServico();
        Boolean auxBoolean =verificaNomeServico(nomeServico);;

        while (!auxBoolean){
            System.out.print("Nome de serviço já usado. Escolha outro: ");
            nomeServico= scanner.nextLine();
            auxBoolean=verificaNomeServico(nomeServico);
        }

        String contato = stringHelper.getContatoSer();
        String duracao = stringHelper.getDuracaoSer();
        int iva = stringHelper.getIva();
        int precoComIva = stringHelper.getPrecoIva();
        String desc = stringHelper.getDescricaoSer();

        String codigo_postal = stringHelper.getCodPost();
        String rua = stringHelper.getRua();
        System.out.println("Selecione o Distrito a que pertence: ");

        getMainData().getDistritos().forEach(distrito -> {
            System.out.println(distrito.getId_distrito() + " - " + distrito.getNomeDistrito());
        });

        int dis = stringHelper.getDist();


        AtomicReference<Distrito> distritoSer = new AtomicReference<>();
        getMainData().getDistritos().forEach(distrito -> {
            if (distrito.getId_distrito() == dis) {
                distritoSer.set(distrito);
            }
        });

        Localidade locSer = new Localidade(codigo_postal, distritoSer.get(), rua);

        ServicoEmpresa currentServ = new ServicoEmpresa(currentPessoa, nomeServico, contato,
                duracao, locSer, precoComIva, iva, desc);

        getMainData().getServicoEmpresas().add(currentServ);


        System.out.println("Serviço criado com sucesso");
    }

    @Override
    public String getName() {
        return "Criar Serviço";
    }

    public boolean verificaNomeServico(String nomeServico) {
        for (ServicoEmpresa servicoEmpresa : getMainData().getServicoEmpresas()) {
            if (servicoEmpresa.getNomeServico().equals(nomeServico)) {
                return false;
            }
        }
        return true;
    }
}


class RegisterServicoEmpresaStringGetter {
    private final Scanner scanner = new Scanner(System.in);

    public String getNomeServico() {
        System.out.print("Introduza o Nome do Serviço: ");
        return scanner.nextLine();
    }

    public String getContatoSer() {
        System.out.print("Introduza o Contato: ");
        return scanner.nextLine();
    }

    public String getDuracaoSer() {
        System.out.print("Introduza a duração do serviço: ");
        return scanner.nextLine();
    }

    public int getIva() {
        System.out.print("Introduza o Iva: ");
        return Integer.parseInt(scanner.nextLine());
    }


    public int getPrecoIva() {
        System.out.print("Introduza o preço com Iva: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getDescricaoSer() {
        System.out.print("Introduza a descrição para o serviço: ");
        return scanner.nextLine();
    }

    public String getCodPost() {
        System.out.print("Introduza o código-postal: ");
        return scanner.nextLine();
    }

    public String getRua() {
        System.out.print("Introduza o nome da Rua: ");
        return scanner.nextLine();
    }

    public int getDist() {

        int dis = Integer.parseInt(scanner.nextLine());
        while (dis > 20 || dis < 0) {
            System.out.print("Distrito selecionado inválido, selecione outro: ");
            dis = Integer.parseInt(scanner.nextLine());
        }
        return dis;
    }

}
