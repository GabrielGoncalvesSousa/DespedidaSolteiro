package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.entidades.marcacao.ServicoEmpresa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class SingleMenu_CriarMarcacao extends MenuData implements Menu {
    @Override
    public void action() {

        //Prints dos distritos
        printDistritos();
        int disId = getIdDistrito();

        //Getting os servicos disponiveis no distrito
        ArrayList<ServicoEmpresa> servicosDisponiveis = getServicosDisponiveisPorDistrito(disId);

        //Se nao houver servicos volta a pedir outro distrito
        while (servicosDisponiveis.isEmpty()) {
            System.out.println("Nenhum serviço disponivel no distrito selecionado");
            disId = getIdDistrito();
            servicosDisponiveis = getServicosDisponiveisPorDistrito(disId);
        }

        //Informacao do servico adaptada ao cliente, precoTotal=preco*1.35
        servicosDisponiveis.forEach(distri -> {
            System.out.println(distri.toStringCliente());
        });

        //Get servico que pretende com verificacao
        int idServico = getIdServicoPorServicosDisponiveis(servicosDisponiveis);

        //Buscar a referencia do objeto desse servico
        ServicoEmpresa servicoSelecionado = getMainData().getServicoEmpresas().get(idServico);

        LocalDateTime dataPretendida = getDate();

        Marcacao marcacao = new Marcacao(
                getMainData().getCurrentPessoa(),
                getMainData().getEstadoMarcacaos().get(0),
                servicoSelecionado, 0, dataPretendida
        );

        //Adicionar a marcacao na lista
        getMainData().getMarcacoes().add(marcacao);
        System.out.println("Marcação adicionada com sucesso");

        //Guardar os dados no ficheiro
        getSerialization().saveData(getMainData());

    }

    @Override
    public String getName() {
        return "Criar Marcação";
    }

    private LocalDateTime getDate() {
        boolean aux = false;
        LocalDateTime dataConvertida = LocalDateTime.now();
        do {
            try {
                //Get data
                System.out.print("Introduza a data que pretende em formato dia/mes/ano hora:minuto. Exemplo - " + LocalDateTime.now().format(getDateTimeFormatter()) + " : ");
                String dataPretendida = getScanner().nextLine();
                dataConvertida = LocalDateTime.parse(dataPretendida, getDateTimeFormatter());
                aux = true;
            } catch (Exception e) {
                System.out.print("Data Inválida. ");
            }
        } while (!aux);

        return dataConvertida;
    }

}
