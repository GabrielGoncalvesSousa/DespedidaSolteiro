package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

import java.util.ArrayList;
import java.util.Scanner;

public class SingleMenu_AvaliarServico extends MenuData implements Menu {
    @Override
    public void action() {

        try {
            ArrayList<Marcacao> marcacoesDisponiveisParaAvaliar = getMarcadoesDisponiveisParaAvaliar();

            //Checkar se o utilizador nao tem nenhuma marcacao concluida
            if (marcacoesDisponiveisParaAvaliar.isEmpty()) {
                System.out.println("Sem Marcações concluidas para avaliar");
                throw new Exception();
            }

            //Obter a marcacao a avaliar
            int marcid = getIdMaracaoParaAvaliarDisponiveis(marcacoesDisponiveisParaAvaliar);
            Marcacao marcacaoEscolhida = getMainData().getMarcacoes().get(marcid);

            //Obter Pontuacao
            int pontuacao = getPontuacao();

            //Adicionar a pontuacao
            marcacaoEscolhida.setPontuacao(pontuacao);

            //Guardar os dados no ficheiro
            getSerialization().saveData(getMainData());


            System.out.println("Pontuação adicionda com sucesso.");

        } catch (Exception e) {

        }
    }

    private int getPontuacao() {
        int pontuacao = -1;
        boolean aux = false;
        do {
            try {
                System.out.print("Indique a pontuação que pretende dar de 1-5: ");
                pontuacao = Integer.parseInt(getScanner().nextLine());
                if (pontuacao > 5 || pontuacao < 1) {
                    throw new Exception();
                }
                aux = true;
            } catch (Exception e) {
                System.out.print("Opção Inválida. ");
            }
        } while (!aux);
        return pontuacao;
    }

    @Override
    public String getName() {
        return "Avaliar Serviços";
    }
}
