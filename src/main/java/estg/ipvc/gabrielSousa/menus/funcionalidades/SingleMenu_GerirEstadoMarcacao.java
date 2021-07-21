package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.marcacao.EstadoMarcacao;
import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class SingleMenu_GerirEstadoMarcacao extends MenuData implements Menu {
    @Override
    public void action() {

        getMainData().getMarcacoes().forEach(marcacao -> System.out.println(marcacao.toString()));
        int estado;


        System.out.print("Selecione a marcação pretendida: ");
        int marcacao = Integer.parseInt(scanner.nextLine());
        AtomicBoolean marcacaoVerifier = new AtomicBoolean(false);


        int finalMarcacao1 = marcacao;
        getMainData().getMarcacoes().forEach(marcacao1 -> {
            if (marcacao1.getId_marcacao() == finalMarcacao1) {
                marcacaoVerifier.set(true);
            }
        });


        while (!marcacaoVerifier.get()) {
            System.out.print("Marcação Selecionado Inválida, selecione outra marcação: ");
            marcacao = Integer.parseInt(scanner.nextLine());
            int finalMarcacao = marcacao;
            getMainData().getMarcacoes().forEach(marcacao1 -> {
                if (marcacao1.getId_marcacao() == finalMarcacao) {
                    marcacaoVerifier.set(true);
                }
            });
        }

        System.out.println("Estados Disponiveis");
        getMainData().getEstadoMarcacaos().forEach(estadoMarcacao -> {
            System.out.println(estadoMarcacao.getId_estadoMarcacao() + " - " + estadoMarcacao.getNomeEstadoMarcacao());
        });

        System.out.print("Selecione um estado: ");
        estado = Integer.parseInt(scanner.nextLine());

        while (estado != 0 && estado != 1 && estado != 2) {
            System.out.print("Estado Selecionado Inválido, selecione outro estado: ");
            estado = Integer.parseInt(scanner.nextLine());
        }

        Marcacao marcacaoSelecionada = getMainData().getMarcacoes().get(marcacao);
        AtomicReference<EstadoMarcacao> estadoMarcacaoAtomicReference = new AtomicReference<>();
        int finalEstado = estado;
        getMainData().getEstadoMarcacaos().forEach(estadoMarc -> {
            if (estadoMarc.getId_estadoMarcacao() == finalEstado) {
                estadoMarcacaoAtomicReference.set(estadoMarc);
            }
        });

        marcacaoSelecionada.setEstadoMarcacao(estadoMarcacaoAtomicReference.get());
        System.out.println("Marcação alterada com sucesso.");
    }

    @Override
    public String getName() {
        return "Gerir Estado das Marcações";
    }
}
