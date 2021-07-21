package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.SingleLeveledMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class SingleMenu_AvaliarServico extends SingleLeveledMenu implements Menu {

    public SingleMenu_AvaliarServico(MainData data) {
        super(data);
    }

    @Override
    public void action() {

        try {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Marcacao> marcacoesDisponiveisParaAvaliar = new ArrayList<>();

            getData().getMarcacoes().forEach(marcacao -> {
                if (marcacao.getCliente().equals(getData().getCurrentPessoa()) &&
                        marcacao.getEstadoMarcacao().getId_estadoMarcacao() == 2) {
                    System.out.println(marcacao.toString());
                    marcacoesDisponiveisParaAvaliar.add(marcacao);
                }
            });


            if(marcacoesDisponiveisParaAvaliar.isEmpty()){
                System.out.println("Sem Marcações concluidas para avaliar");
                throw new Exception();
            }

            System.out.print("Indique qual a marcação que pretende avaliar: ");
            int marcid = Integer.parseInt(scanner.nextLine());

            while (!checkMarcacaoEscolhida(marcid, marcacoesDisponiveisParaAvaliar)) {
                System.out.print("Marcação Inválida, selecione outra: ");
                marcid = Integer.parseInt(scanner.nextLine());
            }

            int pontuacao;
            System.out.print("Indique a pontuação que pretende dar de 1-5: ");
            pontuacao = Integer.parseInt(scanner.nextLine());

            while (!checkPontuacao(pontuacao)) {
                System.out.print("Pontuação inválida, selecione entre 1-5: ");
                pontuacao = Integer.parseInt(scanner.nextLine());
            }

            int finalMarcid = marcid;
            int finalPontuacao = pontuacao;
            getData().getMarcacoes().forEach(marcacao -> {
                if (marcacao.getId_marcacao() == finalMarcid) {
                    marcacao.setPontuacao(finalPontuacao);
                }
            });

            System.out.println("Pontuação adicionda com sucesso.");
        } catch (Exception e) {

        }


    }

    public boolean checkMarcacaoEscolhida(int id, ArrayList<Marcacao> marcacoesDisponiveisParaAvaliar) {
        for (Marcacao marcacao : marcacoesDisponiveisParaAvaliar) {
            if (marcacao.getId_marcacao() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPontuacao(int pont) {
        if (pont > 5 || pont < 1) {
            return false;
        }
        return true;
    }

    @Override
    public String getName() {
        return "Avaliar Serviços";
    }
}
