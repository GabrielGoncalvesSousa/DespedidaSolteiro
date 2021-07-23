package estg.ipvc.gabrielSousa.menus.base;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.marcacao.Distrito;
import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.entidades.marcacao.ServicoEmpresa;
import estg.ipvc.gabrielSousa.entidades.pessoa.Cliente;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
import estg.ipvc.gabrielSousa.entidades.pessoa.TipoPessoa;

import java.util.ArrayList;
import java.util.Scanner;


public abstract class MenuData implements Menu {
    private static final Serialization serialization = new Serialization();
    private static MainData mainData = serialization.loadData();
    public static Scanner scanner = new Scanner(System.in);

    public static Serialization getSerialization() {
        return serialization;
    }

    public MainData getMainData() {
        return mainData;
    }

    public boolean checkIfMailExists(String mail) {
        try {
            for (Pessoa p : mainData.getPessoas()) {
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
                if (p.login(login, password)) {
                    mainData.setCurrentPessoa(p);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void getTiposDeUtilizadorParaPreRegisto() {

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
            System.out.println(e.getMessage());
        }
        return pessoasNaoProvadas;
    }

    public ArrayList<ServicoEmpresa> getServicosEmpresaParaAprovar() {
        ArrayList<ServicoEmpresa> servicosNaoAprovados = new ArrayList<>();

        try {
            for (ServicoEmpresa se : mainData.getServicoEmpresas()) {
                if (!se.isAprovado()) {
                    servicosNaoAprovados.add(se);
                }
            }

            if (!servicosNaoAprovados.isEmpty()) {
                servicosNaoAprovados.forEach(servico -> System.out.println(servico.toString()));
                return servicosNaoAprovados;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return servicosNaoAprovados;
    }


    public void getAllClientInfo() {
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
            return;
        }

        int totalGasto = 0;

        //Getting all clients marcacoes
        for (Pessoa cliente : pessoaClientes) {
            System.out.println(cliente.toString());
            ArrayList<Marcacao> marcacoesCliente = new ArrayList<>();

            //Lopping pelas marcacoes todas e ver se pertence a cliente
            for (Marcacao marcacao : mainData.getMarcacoes()) {
                if (marcacao.getCliente() == cliente) {
                    System.out.println(marcacao.toString());
                    totalGasto += (marcacao.getServicoEmpresa().getPrecoComIva());
                    marcacoesCliente.add(marcacao);
                }
            }
            if (marcacoesCliente.isEmpty()) {
                System.out.println("\n\tCliente sem Marcações Realizadas");
            } else {
                System.out.println("\n\tTotal Gasto - " + totalGasto);
            }
        }
    }

    public ArrayList<Marcacao> getMarcadoesDisponiveisParaAvaliar() {
        ArrayList<Marcacao> marcacoesDisponiveisParaAvaliar = new ArrayList<>();
        try {
            getMainData().getMarcacoes().forEach(marcacao -> {
                if (marcacao.getCliente().equals(getMainData().getCurrentPessoa()) &&
                        marcacao.getEstadoMarcacao().getId_estadoMarcacao() == 2) {
                    System.out.println(marcacao.toString());
                    marcacoesDisponiveisParaAvaliar.add(marcacao);
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return marcacoesDisponiveisParaAvaliar;
    }

    public ArrayList<ServicoEmpresa> getServicosDisponiveisPorDistrito(int distritoId) {
        ArrayList<ServicoEmpresa> servicosDisponiveis = new ArrayList<>();

        try {
            for (ServicoEmpresa servEmp : getMainData().getServicoEmpresas()) {
                if (servEmp.getLocalidade().getDistrito().getId_distrito() == distritoId) {
                    servicosDisponiveis.add(servEmp);
                }
            }
            return servicosDisponiveis;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return servicosDisponiveis;
    }

    public ServicoEmpresa getServicoById(int id) {
        try {
            for (ServicoEmpresa servico : getMainData().getServicoEmpresas()) {
                if (servico.getId_servicoEmpresa() == id) {
                    return servico;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void printDistritos() {
        getMainData().getDistritos().forEach(distrito -> {
            System.out.println(distrito.getId_distrito() + " - " + distrito.getNomeDistrito());
        });
    }

    public int getMarcacao() {
        boolean aux = false;
        int idMarcacaoEscolhida = -1;
        do {
            try {
                idMarcacaoEscolhida = Integer.parseInt(scanner.nextLine());
                getMainData().getMarcacoes().get(idMarcacaoEscolhida);
                aux = true;
            } catch (Exception e) {
                System.out.print("Opção Inválida. Selecione uma marcação: ");
            }
        } while (!aux);
        return idMarcacaoEscolhida;
    }

    public int getEstadoMarcacao() {
        boolean aux = false;
        int idEstadoEscolhido = -1;
        do {
            try {
                idEstadoEscolhido = Integer.parseInt(scanner.nextLine());
                getMainData().getEstadoMarcacaos().get(idEstadoEscolhido);
                aux = true;
            } catch (Exception e) {
                System.out.print("Opção Inválida. Selecione um estado: ");
            }
        } while (!aux);
        return idEstadoEscolhido;
    }

    public int intVerifier() {
        int id = -1;
        try {
            id = Integer.parseInt(scanner.nextLine());
            if (id < 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.print("Opção Inválida. ");
        }
        return id;
    }

    public int getIdDistrito() {
        int distritoId = -1;
        while (distritoId > 20 || distritoId < 0) {
            try {
                System.out.print("Selecione o Distrito a que pertence: ");
                distritoId = Integer.parseInt(scanner.nextLine());
                if (distritoId > 20 || distritoId < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("Opção Inválida. ");
            }
        }
        return distritoId;
    }

    public int getIdServicoPorServicosDisponiveis(ArrayList<ServicoEmpresa> servicosDisponiveis) {
        int servicoId = -1;
        boolean aux = false;
        do {
            try {
                System.out.print("Selecione o serviço que pretende: ");
                servicoId = Integer.parseInt(scanner.nextLine());
                for (ServicoEmpresa servico : servicosDisponiveis) {
                    if (servico.getId_servicoEmpresa() == servicoId) {
                        aux = true;
                        return servicoId;

                    }
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.print("Opção Inválida. ");
            }
        } while (!aux);
        return servicoId;
    }

    public int getIdMaracaoParaAvaliarDisponiveis(ArrayList<Marcacao> marcacoesDisponiveis) {
        int marcacaoId = -1;
        boolean aux = false;
        do {
            try {
                System.out.print("Selecione a marcação que pretende avaliar: ");
                marcacaoId = Integer.parseInt(scanner.nextLine());
                for (Marcacao marcacao : marcacoesDisponiveis) {
                    if (marcacao.getId_marcacao() == marcacaoId) {
                        aux = true;
                        return marcacaoId;

                    }
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.print("Opção Inválida. ");
            }
        } while (!aux);
        return marcacaoId;
    }

}
