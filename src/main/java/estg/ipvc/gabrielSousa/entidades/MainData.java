package estg.ipvc.gabrielSousa.entidades;

import estg.ipvc.gabrielSousa.entidades.pessoa.*;
import estg.ipvc.gabrielSousa.entidades.marcacao.*;

import java.util.ArrayList;

public class MainData implements java.io.Serializable {

    private final ArrayList<Pessoa> pessoas = new ArrayList<>();
    private final ArrayList<TipoPessoa> tpPessoas = new ArrayList<>();
    private final ArrayList<ServicoEmpresa> servicoEmpresas = new ArrayList<>();
    private final ArrayList<Marcacao> marcacoes = new ArrayList<>();
    private final ArrayList<EstadoMarcacao> estadoMarcacaos = new ArrayList<>();
    private final ArrayList<Localidade> localidades = new ArrayList<>();
    private final ArrayList<Distrito> distritos = new ArrayList<>();
    private Pessoa currentPessoa;

    public MainData() {
        //Adicionar Popular classe distritos
        String[] nomesDistritos = {"Viana do Castelo", "Braga", "Porto", "Vila Real", "Bragança", "Porto", "Aveiro", "Viseu", "Guarda",
                "Coimbra", "Castelo Branco", "Leiria", "Lisboa", "Santarém", "Portalegre", "Évora", "Setubal", "Beja", "Faro", "Madeira",
                "Açores"};

        for (int i = 0; i < nomesDistritos.length; i++) {
            Distrito d = new Distrito(nomesDistritos[i]);
            distritos.add(d);
        }

        //Popular os tipos de pessoa
        tpPessoas.add(new TipoPessoa(0, "Gestor de Sistema"));
        tpPessoas.add(new TipoPessoa(1, "Funcionario"));
        tpPessoas.add(new TipoPessoa(2, "Fornecedor"));
        tpPessoas.add(new TipoPessoa(3, "Cliente"));

        //Contas exemplo
        pessoas.add(new GestorSistema(tpPessoas.get(0), "admin", "123", "Gabriel", "Sousa"
                , "gabrielsousa@ipvc.pt", "915875985"));
        pessoas.add(new Funcionario(tpPessoas.get(1), "funcionario", "123", "Nuno", "Oliveira"
                , "nunoOliveira@ipvc.pt", "934506842"));

        //Popular estados de marcacao
        estadoMarcacaos.add(new EstadoMarcacao(0, "Aguardando Aprovação"));
        estadoMarcacaos.add(new EstadoMarcacao(1, "Aprovado"));
        estadoMarcacaos.add(new EstadoMarcacao(2, "Concluido"));


        FornecedorServico fornecedorServico = new FornecedorServico(tpPessoas.get(2), "servico", "123", "Servico", "Banana"
                , "servico@ipvc.pt", "93454578");
        fornecedorServico.setAprovado(true);
        pessoas.add(fornecedorServico);

        Cliente clienteAprovado = new Cliente(tpPessoas.get(3), "cliente", "123", "Cliente", "Banana"
                , "banana@ipvc.pt", "93453295");
        clienteAprovado.setAprovado(true);
        pessoas.add(clienteAprovado);

/*

        pessoas.add(new Cliente(tpPessoas.get(3), "loginfixe", "123", "ClienteSemMarcacoes", "Banana"
                , "clienteSemMarcacoes@ipvc.pt", "93453295"));


        //Popular localidades de viana
        localidades.add(new Localidade("4900-764",distritos.get(0),"Rua Abade Fanha"));
        localidades.add(new Localidade("4900-267",distritos.get(0),"Beco do Mosteiro"));
        localidades.add(new Localidade("4900-283",distritos.get(0),"Estrada da Abelheira"));

        //Popular serviço de empresa
        servicoEmpresas.add(new ServicoEmpresa(getPessoas().get(3), "Banana Catcher", "932133123", "forever"
        ,getLocalidades().get(0),222,23,"As bananas todas que conseguires"));


        //Popular marcacoes
        marcacoes.add(new Marcacao(getPessoas().get(3),estadoMarcacaos.get(0), servicoEmpresas.get(0), 0,"12/12/12"));
        marcacoes.add(new Marcacao(getPessoas().get(3),estadoMarcacaos.get(2), servicoEmpresas.get(0), 3,"12/12/12"));
        marcacoes.add(new Marcacao(getPessoas().get(3),estadoMarcacaos.get(2), servicoEmpresas.get(0), 3,"12/12/12"));
*/

    }

    public ArrayList<Distrito> getDistritos() {
        return distritos;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public ArrayList<TipoPessoa> getTpPessoas() {
        return tpPessoas;
    }

    public void setCurrentPessoa(Pessoa p) {
        this.currentPessoa = p;
    }

    public Pessoa getCurrentPessoa() {
        return currentPessoa;
    }

    public void registarPessoa(Pessoa p) {
        pessoas.add(p);
    }

    public ArrayList<Localidade> getLocalidades() {
        return localidades;
    }

    public ArrayList<Marcacao> getMarcacoes() {
        return marcacoes;
    }

    public ArrayList<ServicoEmpresa> getServicoEmpresas() {
        return servicoEmpresas;
    }

    public ArrayList<EstadoMarcacao> getEstadoMarcacaos() {
        return estadoMarcacaos;
    }
}
