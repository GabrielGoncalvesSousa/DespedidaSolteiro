package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.entidades.pessoa.FornecedorServico;
import estg.ipvc.gabrielSousa.entidades.pessoa.Pessoa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

import java.time.LocalDate;
import java.util.ArrayList;

public class SingleMenu_ServicosPrestadosPorFornecedorEntreDatas extends MenuData implements Menu {
    @Override
    public void action() {


        try {
            //Obter lista de fornecedores de serviço se tiver fornecedores disponiveis;
            ArrayList<Pessoa> fornecedorServicosDisponiveis = getListaFornecedorServicoDisponiveis();

            if (fornecedorServicosDisponiveis.isEmpty()) {
                throw new Exception();
            }

            try {
                //Obter 1 fornecedor da lista de fornecedores disponiveis
                Pessoa fornecedorSelecionado = getFornecedor(fornecedorServicosDisponiveis);

                //Obter as marcacoes realizadas por esse fornecedor
                ArrayList<Marcacao> marcacoesFornecedor = getMarcacoesPorFornecedor(fornecedorSelecionado);
                if (marcacoesFornecedor.isEmpty()) {
                    throw new Exception();
                }

                //Continuar datas aqui
                ArrayList<LocalDate> datas = getListaDatas();
                printMarcacoesEntreDatas(datas, marcacoesFornecedor);

            } catch (Exception e) {
                System.out.println("Fornecedor sem marcações realizadas.");
            }

        } catch (Exception e) {
            System.out.println("Nenhum Fornecedor de Serviço disponivel.");
        }
    }

    @Override
    public String getName() {
        return "Visualizar Serviços prestados entre datas";
    }

    private ArrayList<Pessoa> getListaFornecedorServicoDisponiveis() {

        //Popular e dar print dos fornecedores de servico disponiveis
        ArrayList<Pessoa> fornecedorServicosDisponiveis = new ArrayList<>();

        for (Pessoa pessoa : getMainData().getPessoas()) {
            if (pessoa instanceof FornecedorServico && pessoa.isAprovado()) {
                fornecedorServicosDisponiveis.add(pessoa);
                System.out.println(pessoa);
            }
        }
        return fornecedorServicosDisponiveis;
    }

    private Pessoa getFornecedor(ArrayList<Pessoa> fornecedorServicosDisponiveis) {
        Pessoa fornecedorServicoSelecionado = null;
        boolean aux = false;

        do {
            try {
                System.out.print("Selecione o fornecedor de serviço pretendido: ");
                int idFornecedorServico = Integer.parseInt(getScanner().nextLine());
                for (Pessoa pessoa : fornecedorServicosDisponiveis) {
                    if (pessoa.getId_pessoa() == idFornecedorServico) {
                        fornecedorServicoSelecionado = pessoa;
                        aux = true;
                    }
                }
                if (!aux) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("Opção Inválida. ");
            }
        } while (!aux);

        return fornecedorServicoSelecionado;
    }

    private ArrayList<Marcacao> getMarcacoesPorFornecedor(Pessoa fornecedor) {
        ArrayList<Marcacao> marcacoesFornecedor = new ArrayList<>();

        for (Marcacao marcacoes : getMainData().getMarcacoes()) {
            if (marcacoes.getServicoEmpresa().getPessoa() == fornecedor) {
                marcacoesFornecedor.add(marcacoes);
            }
        }
        return marcacoesFornecedor;
    }

    private ArrayList<LocalDate> getListaDatas() {
        boolean aux = false;

        ArrayList<LocalDate> datas = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            do {
                aux = false;
                try {
                    //Get data
                    System.out.print("Introduza a " + (i + 1) + "º data que pretende em formato dia/mes/ano: ");
                    String dataPretendida = getScanner().nextLine();
                    LocalDate dataConvertida = LocalDate.parse(dataPretendida, getDateFormatter());

                    if (i == 1) {
                        if (datas.get(0).isAfter(dataConvertida)) {
                            throw new Exception();
                        }

                    }
                    datas.add(dataConvertida);
                    aux = true;

                } catch (Exception e) {
                    System.out.print("Data Inválida. ");
                    if (i == 1) {
                        System.out.print("A data tem que ser depois da data de " + datas.get(0).format(getDateFormatter()) + ". ");
                    }
                }
            } while (!aux);
        }
        return datas;
    }

    private void printMarcacoesEntreDatas(ArrayList<LocalDate> datas, ArrayList<Marcacao> marcacoesServico) {
        for (Marcacao marcacao : marcacoesServico) {
            if (marcacao.getData().toLocalDate().isAfter(datas.get(0)) && marcacao.getData().toLocalDate().isBefore(datas.get(1))) {
                System.out.println(marcacao);
            }
        }
    }
}
