package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.marcacao.Distrito;
import estg.ipvc.gabrielSousa.entidades.marcacao.Localidade;
import estg.ipvc.gabrielSousa.entidades.marcacao.ServicoEmpresa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

import java.util.Scanner;

public class SingleMenu_CriarServicoEmpresa extends MenuData implements Menu {
    @Override
    public void action() {
        //Instanciar a nested class que ira ajudar a obter os dados para o registo
        RegisterServicoEmpresaStringGetter stringHelper = new RegisterServicoEmpresaStringGetter();

        //Get o nome do servico
        String nomeServico = stringHelper.getNomeServico();
        boolean auxBoolean = verificaNomeServico(nomeServico);

        //Verificar se o nome ja nao foi utilizado
        while (!auxBoolean) {
            System.out.print("Nome de serviço já usado. Escolha outro: ");
            nomeServico = scanner.nextLine();
            auxBoolean = verificaNomeServico(nomeServico);
        }

        //Obter dados do servico com o helper
        String contato = stringHelper.getContatoSer();
        String duracao = stringHelper.getDuracaoSer();

        //Get iva e verificar se nao está a ser introduzido uma string nem numeros negativos
        System.out.print("Introduza o Iva: ");
        int iva = intVerifier();
        while (iva < 0) {
            System.out.print("Introduza o Iva: ");
            iva = intVerifier();
        }

        //Get preco com iva e verificar se nao está a ser introduzido uma string.
        System.out.print("Introduza o preço com Iva: ");
        int precoComIva = intVerifier();
        while (precoComIva < 0) {
            System.out.print("Introduza o preço com Iva: ");
            precoComIva = intVerifier();
        }

        //String getters com verificacao
        String desc = stringHelper.getDescricaoSer();
        String codigo_postal = stringHelper.getCodPost();
        String rua = stringHelper.getRua();

        //Selecionar distrito e verificar
        printDistritos();
        int distritoId = getIdDistrito();

        //Obter a referencia do objeto a que o id corresponde
        Distrito distritoSelecionado = getMainData().getDistritos().get(distritoId);

        //Criar localidade nova onde o servico de empresa se localiza e adicionar na lista
        Localidade locSer = new Localidade(codigo_postal, distritoSelecionado, rua);

        //Criar instancia de servico com os dados do servico
        ServicoEmpresa currentServ = new ServicoEmpresa(getMainData().getCurrentPessoa(), nomeServico, contato,
                duracao, locSer, precoComIva, iva, desc);

        //Adicionar a instancia criada de servico na lista
        getMainData().getServicoEmpresas().add(currentServ);

        System.out.println("Serviço criado com sucesso");

        //Guardar os dados no ficheiro
        getSerialization().saveData(getMainData());
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
        String nomeServico = scanner.nextLine();

        while (nomeServico.isEmpty()) {
            System.out.print("Campo do nome de Serviço vazio, Introduza o nome de Serviço: ");
            nomeServico = scanner.nextLine();
        }
        return nomeServico;
    }

    public String getContatoSer() {
        System.out.print("Introduza o Contato: ");
        String contato = scanner.nextLine();

        while (contato.isEmpty()) {
            System.out.print("Campo de contato vazio, Introduza o contato: ");
            contato = scanner.nextLine();
        }
        return contato;
    }

    public String getDuracaoSer() {

        System.out.print("Introduza a duração do serviço em horas:minutos : ");
        String duracaoSer = scanner.nextLine();

        while (duracaoSer.isEmpty()) {
            System.out.print("Campo de duração vazio, Introduza a duração: ");
            duracaoSer = scanner.nextLine();
        }
        return duracaoSer;
    }

    public String getDescricaoSer() {
        System.out.print("Introduza a descrição para o serviço: ");
        String descricao = scanner.nextLine();

        while (descricao.isEmpty()) {
            System.out.print("Campo da descrição vazio. Introduza a descrição: ");
            descricao = scanner.nextLine();
        }
        return descricao;
    }

    public String getCodPost() {
        System.out.print("Introduza o código-postal: ");
        String codP = scanner.nextLine();

        while (codP.isEmpty()) {
            System.out.print("Campo do código-postal vazio. Introduza o código-postal: ");
            codP = scanner.nextLine();
        }
        return codP;
    }

    public String getRua() {
        System.out.print("Introduza o nome da Rua: ");
        String rua = scanner.nextLine();

        while (rua.isEmpty()) {
            System.out.print("Campo da rua vazio. Introduza o nome da Rua: ");
            rua = scanner.nextLine();
        }
        return rua;
    }
}
