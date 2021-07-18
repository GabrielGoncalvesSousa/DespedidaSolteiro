package estg.ipvc.gabrielSousa.entidades;

import estg.ipvc.gabrielSousa.entidades.pessoa.*;
import estg.ipvc.gabrielSousa.entidades.marcacao.*;

import java.util.ArrayList;

public class MainData implements java.io.Serializable {

    private final ArrayList<Pessoa> pessoas = new ArrayList<>();
    private final ArrayList<TipoPessoa> tpPessoas = new ArrayList<>();
    private final ArrayList<ServicoEmpresa> servicoEmpresas = new ArrayList<>();
    private final ArrayList<Marcacao> marcacoes = new ArrayList<>();
    private final ArrayList<Localidade> localidades = new ArrayList<>();
    private final ArrayList<Distrito> distritos = new ArrayList<>();
    private Pessoa currentPessoa;

    public MainData() {
        //Adicionar Popular classe distritos
        String[] nomesDistritos = {"Viana do Castelo", "Braga", "Porto", "Vila Real", "Bragança", "Porto", "Aveiro", "Viseu", "Guarda",
                "Coimbra", "Castelo Branco", "Leiria", "Lisboa", "Santarém", "Portalegre", "Évora", "Setubal", "Beja", "Faro", "Madeira",
                "Açores"};

        for (int i = 0; i < nomesDistritos.length; i++) {
            Distrito d = new Distrito(i, nomesDistritos[i]);
            distritos.add(d);
        }

        //Popular os tipos de pessoa
        tpPessoas.add(new TipoPessoa(0, "Gestor de Sistema"));
        tpPessoas.add(new TipoPessoa(1, "Funcionario"));
        tpPessoas.add(new TipoPessoa(2, "Fornecedor"));
        tpPessoas.add(new TipoPessoa(3, "Cliente"));

        //Contas exemplo
        pessoas.add(new GestorSistema(tpPessoas.get(0), "login", "123", "Gabriel", "Sousa"
                , "gabrielsousa@ipvc.pt", "915875985"));
        pessoas.add(new Funcionario(tpPessoas.get(1), "funcionario", "123", "Nuno", "Oliveira"
                , "nunoOliveira@ipvc.pt", "934506842"));
        pessoas.add(new Cliente(tpPessoas.get(3), "cliente", "123", "Cliente", "Banana"
                , "banana@ipvc.pt", "93453295"));

        //Popular localidades
        localidades.add(new Localidade())
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


}
