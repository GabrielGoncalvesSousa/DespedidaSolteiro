package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.entidades.marcacao.ServicoEmpresa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

        LocalDate dataPretendida = getDate();
        LocalDateTime marcacaoPretendida = getMarcacaoDisponivelNaData(dataPretendida, servicoSelecionado);


        Marcacao marcacao = new Marcacao(
                getMainData().getCurrentPessoa(),
                getMainData().getEstadoMarcacaos().get(0),
                servicoSelecionado, 0, marcacaoPretendida
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

    private LocalDate getDate() {
        boolean aux = false;
        LocalDate dataConvertida = LocalDate.now();
        do {
            try {
                //Get data
                System.out.print("Introduza a data que pretende em formato dia/mes/ano: ");
                String dataPretendida = getScanner().nextLine();
                dataConvertida = LocalDate.parse(dataPretendida, getDateFormatter());

                if (dataConvertida.isBefore(LocalDate.now())) {
                    throw new Exception();
                }

                aux = true;
            } catch (Exception e) {
                System.out.print("Data Inválida. ");
            }
        } while (!aux);

        return dataConvertida;
    }

    private LocalDateTime getMarcacaoDisponivelNaData(LocalDate data, ServicoEmpresa servicoSelecionado) {
        ArrayList<LocalDateTime> listaHorariosDisponiveis = new ArrayList<>();
        LocalTime tempo = LocalTime.parse("09:00");

        for (int i = 0; i < 200; i++) {
            if (tempo.isAfter(LocalTime.parse("17:00"))) {
                break;
            }
            LocalDateTime aux = LocalDateTime.of(data, tempo);
            listaHorariosDisponiveis.add(aux);
            tempo = tempo.plus(servicoSelecionado.getDuracao());
        }

        for (Marcacao marcacao : getMainData().getMarcacoes()) {
            if (marcacao.getData().toLocalDate().equals(data)) {
                listaHorariosDisponiveis.removeIf(tempoMarc -> tempoMarc.equals(marcacao.getData()));
            }
        }

        System.out.println("Marcações Disponvieis: ");
        int i = 0;
        for (LocalDateTime aux : listaHorariosDisponiveis) {
            System.out.println("\t " + i + "- As " + aux.getHour() + " horas e " + aux.getMinute() + " minutos.");
            i++;
        }

        boolean aux = false;
        LocalDateTime marcacaoEscolhida = LocalDateTime.now();
        do {
            try {
                System.out.print("Escolha a marcação pretendida: ");
                int escolhaHorario = Integer.parseInt(getScanner().nextLine());
                marcacaoEscolhida = listaHorariosDisponiveis.get(escolhaHorario);
                aux = true;
            } catch (Exception e) {
                System.out.print("Opção Inválida. ");
            }
        } while (!aux);
        return marcacaoEscolhida;
    }
}
