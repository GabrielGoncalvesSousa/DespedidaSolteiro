package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.entidades.marcacao.ServicoEmpresa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.SingleLeveledMenu;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class SingleMenu_CriarMarcacao extends SingleLeveledMenu implements Menu {
    public SingleMenu_CriarMarcacao(MainData data) {
        super(data);
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void action() {
        getData().getDistritos().forEach(distrito -> {
            System.out.println(distrito.getId_distrito()+" - "+distrito.getNomeDistrito());
        });

        System.out.print("Introduza o distrito que pretende: ");
        int disId =Integer.parseInt(scanner.nextLine());

        getData().getServicoEmpresas().forEach(servicoEmpresa -> {
            if(servicoEmpresa.getLocalidade().getDistrito().getId_distrito()==disId){
                System.out.println(servicoEmpresa.toString());
            }
        });

        System.out.print("Introduza o serviço que pretende: ");
        int id = Integer.parseInt(scanner.nextLine());
        AtomicReference<ServicoEmpresa> servicoEmpresaSelecionado = new AtomicReference<>();

        getData().getServicoEmpresas().forEach(servicoEmpresa -> {
            if(servicoEmpresa.getId_servicoEmpresa()==id){
                servicoEmpresaSelecionado.set(servicoEmpresa);
            }
        });

        System.out.print("Introduza a data que pretende: ");
        String dataPretendida = scanner.nextLine();

        getData().getMarcacoes().add(new Marcacao(getData().getCurrentPessoa(),getData().getEstadoMarcacaos().get(0),servicoEmpresaSelecionado.get(),0,dataPretendida ));
        System.out.println("Adicionado com sucesso");

    }

    @Override
    public String getName() {
        return "Criar Marcação";
    }
}
