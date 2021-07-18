package estg.ipvc.gabrielSousa.menus.gestorSistema;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.marcacao.EstadoMarcacao;
import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.SingleLeveledMenu;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class SingleMenu_GerirEstadoMarcacao extends SingleLeveledMenu implements Menu {
    public SingleMenu_GerirEstadoMarcacao(MainData data) {
        super(data);
    }

    @Override
    public void action() {
        System.out.println("Estados Disponiveis");
        Scanner scanner = new Scanner(System.in);

        getData().getEstadoMarcacaos().forEach(estadoMarcacao -> {
            System.out.println(estadoMarcacao.getId_estadoMarcacao()+" - " +estadoMarcacao.getNomeEstadoMarcacao());
        });

        getData().getMarcacoes().forEach(marcacao -> System.out.println(marcacao.toString()));
        int estado;

        System.out.print("Selecione um estado: ");
        estado = Integer.parseInt(scanner.nextLine());

        while (estado!=0&&estado!=1&&estado!=2){
            System.out.print("Estado Selecionado Inválido, selecione outro estado: ");
            estado = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Selecione a marcação pretendida: ");
        int marcacao = Integer.parseInt(scanner.nextLine());
        AtomicBoolean spagghetiMuch = new AtomicBoolean(false);


        int finalMarcacao1 = marcacao;
        getData().getMarcacoes().forEach(marcacao1->{
            if(marcacao1.getId_marcacao()== finalMarcacao1){
                spagghetiMuch.set(true);
            }
        });


        while (!spagghetiMuch.get()){
            System.out.print("Marcação Selecionado Inválida, selecione outra marcação: ");
            marcacao = Integer.parseInt(scanner.nextLine());
            int finalMarcacao = marcacao;
            getData().getMarcacoes().forEach(marcacao1->{
                if(marcacao1.getId_marcacao()== finalMarcacao){
                    spagghetiMuch.set(true);
                }
            });
        }

        Marcacao thisIsSoSpaghetti = getData().getMarcacoes().get(marcacao);
        AtomicReference<EstadoMarcacao> srlsIdontHaveTheTimeToUnspaghetti = new AtomicReference<>();
        int finalEstado = estado;
        getData().getEstadoMarcacaos().forEach(estadoMarc ->{
            if(estadoMarc.getId_estadoMarcacao()== finalEstado){
                srlsIdontHaveTheTimeToUnspaghetti.set(estadoMarc);
            }
        });

       thisIsSoSpaghetti.setEstadoMarcacao(srlsIdontHaveTheTimeToUnspaghetti.get());
    }

    @Override
    public String getName() {
        return "Gerir Estado das Marcações";
    }
}
