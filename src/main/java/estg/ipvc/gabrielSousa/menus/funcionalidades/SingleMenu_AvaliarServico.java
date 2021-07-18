package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.SingleLeveledMenu;

import java.util.Scanner;

public class SingleMenu_AvaliarServico extends SingleLeveledMenu implements Menu {

    public SingleMenu_AvaliarServico(MainData data) {
        super(data);
    }

    @Override
    public void action() {

        Scanner scanner = new Scanner(System.in);

        getData().getMarcacoes().forEach(marcacao -> {
            if(marcacao.getCliente().equals(getData().getCurrentPessoa()) &&
            marcacao.getEstadoMarcacao().getId_estadoMarcacao()==2){
                System.out.println(marcacao.toString());
            }
        });


        System.out.print("Indique qual a marcação que pretende avaliar: ");
        int marcid= Integer.parseInt(scanner.nextLine());
        int pontuacao;
        System.out.print("Indique a pontuação que pretende dar: ");
        pontuacao = Integer.parseInt(scanner.nextLine());

        getData().getMarcacoes().forEach(marcacao -> {
            if(marcacao.getId_marcacao()==marcid){
                marcacao.setPontuacao(pontuacao);
            }
        });

        System.out.println("ya");

    }

    @Override
    public String getName() {
        return "Avaliar Serviços";
    }
}
