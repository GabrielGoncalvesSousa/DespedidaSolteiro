package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.marcacao.Distrito;
import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.entidades.marcacao.ServicoEmpresa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.SingleLeveledMenu;

import java.util.ArrayList;
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
            System.out.println(distrito.getId_distrito() + " - " + distrito.getNomeDistrito());
        });

        System.out.print("Introduza o distrito que pretende: ");
        int disId = Integer.parseInt(scanner.nextLine());

        while (disId >= 20 || disId <= 0) {
            System.out.println("Opção Inválida, selecione outra vez: ");
            disId = Integer.parseInt(scanner.nextLine());
        }

        ArrayList<ServicoEmpresa> servicosDisponiveis = new ArrayList<>();

       for(ServicoEmpresa servEmp : getData().getServicoEmpresas()){
           if(servEmp.getLocalidade().getDistrito().getId_distrito()==disId){
               servicosDisponiveis.add(servEmp);
           }
       }

        while (servicosDisponiveis.isEmpty()) {
            System.out.println("Nenhum serviço disponivel no distrito selecionado");
            System.out.println("Selecione outro distrito: ");
            disId = Integer.parseInt(scanner.nextLine());

            for (ServicoEmpresa servicoEmpresa: getData().getServicoEmpresas()){
                if(servicoEmpresa.getLocalidade().getDistrito().getId_distrito()==disId){
                    servicosDisponiveis.add(servicoEmpresa);
                }
            }
        }

        servicosDisponiveis.forEach(distri -> {
            System.out.println(distri.toStringCliente());
        });




        System.out.print("Introduza o serviço que pretende: ");
        int id = Integer.parseInt(scanner.nextLine());

        while (!servidoIdChecker(id,servicosDisponiveis)) {
            System.out.print("Introduza um serviço válido: ");
            id = Integer.parseInt(scanner.nextLine());
        }


       ServicoEmpresa servicoSelecionado = null;

        for(ServicoEmpresa servE: servicosDisponiveis){
            if(servE.getId_servicoEmpresa()==id){
                servicoSelecionado=servE;
            }
        }

        System.out.print("Introduza a data que pretende: ");
        String dataPretendida = scanner.nextLine();


        getData().getMarcacoes().add(new Marcacao(getData().getCurrentPessoa(), getData().getEstadoMarcacaos().get(0), servicoSelecionado, 0, dataPretendida));
        System.out.println("Adicionado com sucesso");

    }

    @Override
    public String getName() {
        return "Criar Marcação";
    }

    public boolean servidoIdChecker(int id, ArrayList<ServicoEmpresa> servicoDisponiveis) {
        for (ServicoEmpresa se : servicoDisponiveis) {
            if (se.getId_servicoEmpresa() == id) {
                return true;
            }
        }
        return false;
    }
}
