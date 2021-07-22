package estg.ipvc.gabrielSousa.menus.base;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.entidades.marcacao.ServicoEmpresa;
import estg.ipvc.gabrielSousa.entidades.pessoa.Cliente;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
import estg.ipvc.gabrielSousa.entidades.pessoa.TipoPessoa;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MenuData implements Menu{
   private static final Serialization serialization = new Serialization();
    private static MainData mainData = serialization.loadData();
    public static Scanner scanner = new Scanner(System.in);

    public static Serialization getSerialization() {
        return serialization;
    }

    public MainData getMainData(){
        return mainData;
    }

    public boolean checkIfMailExists(String mail) {
        try {
            for (Pessoa p :mainData.getPessoas()) {
                if (p.getEmail().equals(mail)) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public boolean checkIfLoginExists(String login) {
        try {
            for (Pessoa p : mainData.getPessoas()) {
                if (p.getLogin().equals(login)) {
                    throw new Exception();
                }
            }

        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public boolean checkIfLoginAndPasswordExists(String login, String password) {
        try {
            for (Pessoa p : mainData.getPessoas()) {
                if (p.login(login, password)) { mainData.setCurrentPessoa(p);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void getTiposParaPreRegisto() {

        for (TipoPessoa tp : mainData.getTpPessoas()) {
            if (tp.getId_tipoPessoa() == 2 | tp.getId_tipoPessoa() == 3)
                System.out.println(tp.getId_tipoPessoa() + " - " + tp.getNomeTipoPessoa());
        }
    }

    public TipoPessoa getTipoPessoaSelecionadaParaRegisto(int id_tp) {
        try {
            for (TipoPessoa tipoPessoa : mainData.getTpPessoas()) {
                if (tipoPessoa.getId_tipoPessoa() == id_tp) {
                    return tipoPessoa;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Pessoa> getContasParaAprovar() {
        ArrayList<Pessoa> pessoasNaoProvadas = new ArrayList<>();

        try {
            for (Pessoa p : mainData.getPessoas()) {
                if (!p.isAprovado()) {
                    pessoasNaoProvadas.add(p);
                }
            }

            if (!pessoasNaoProvadas.isEmpty()) {
                pessoasNaoProvadas.forEach(pessoa -> System.out.println(pessoa.toString()));
                return pessoasNaoProvadas;
            }


        } catch (Exception e) {

        }
        return pessoasNaoProvadas;
    }

    public ArrayList<ServicoEmpresa> getContasServicosEmpresaParaAprovar() {
        ArrayList<ServicoEmpresa> servicosNaoAprovados = new ArrayList<>();

        try {
            for (ServicoEmpresa se : mainData.getServicoEmpresas()) {
                if (!se.isAprovado()) {
                    servicosNaoAprovados.add(se);
                }
            }

            if (!servicosNaoAprovados.isEmpty()) {
                servicosNaoAprovados.forEach(servico -> System.out.println(servico.toString()));
                ;
                return servicosNaoAprovados;
            }

        } catch (Exception e) {

        }
        return servicosNaoAprovados;
    }


    public boolean getAllClientInfo() {
        ArrayList<Pessoa> pessoaClientes = new ArrayList<>();

        //Getting all clients
        mainData.getPessoas().forEach(pessoa -> {
            if (pessoa instanceof Cliente && pessoa.isAprovado()) {
                pessoaClientes.add(pessoa);
            }
        });

        //if there are no clients
        if (pessoaClientes.isEmpty()) {
            System.out.println("Não existem clientes de momento.");
            return false;
        }

        AtomicInteger totalGasto = new AtomicInteger();
        //Looping through clients
        pessoaClientes.forEach(cliente -> {
            System.out.println(cliente.toString());
            ArrayList<Marcacao> marcacoesClientes = new ArrayList<>();

            //Buscar marcacoes do respetivo cliente
            mainData.getMarcacoes().forEach(marcacao -> {
                if (marcacao.getCliente() == cliente) {

                    System.out.println(marcacao.toString());
                    totalGasto.addAndGet(marcacao.getServicoEmpresa().getPrecoComIva());
                    marcacoesClientes.add(marcacao);
                }
            });

            if (marcacoesClientes.isEmpty()) {
                System.out.println("\n\tCliente sem Marcações Realizadas");
            } else {
                System.out.println("\n\tTotal Gasto - " + totalGasto);
            }
        });
        return true;
    }
}
