package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.marcacao.Marcacao;
import estg.ipvc.gabrielSousa.entidades.marcacao.ServicoEmpresa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

import java.util.ArrayList;
import java.util.Scanner;


public class SingleMenu_CriarMarcacao extends MenuData implements Menu {
    @Override
    public void action() {

        getMainData().getDistritos().forEach(distrito -> {
            System.out.println(distrito.getId_distrito() + " - " + distrito.getNomeDistrito());
        });

        System.out.print("Introduza o distrito que pretende: ");
        int disId = Integer.parseInt(scanner.nextLine());

        while (disId >= 20 || disId <= 0) {
            System.out.println("Opção Inválida, selecione outra vez: ");
            disId = Integer.parseInt(scanner.nextLine());
        }

        ArrayList<ServicoEmpresa> servicosDisponiveis = new ArrayList<>();

       for(ServicoEmpresa servEmp : getMainData().getServicoEmpresas()){
           if(servEmp.getLocalidade().getDistrito().getId_distrito()==disId){
               servicosDisponiveis.add(servEmp);
           }
       }

        while (servicosDisponiveis.isEmpty()) {
            System.out.println("Nenhum serviço disponivel no distrito selecionado");
            System.out.println("Selecione outro distrito: ");
            disId = Integer.parseInt(scanner.nextLine());

            for (ServicoEmpresa servicoEmpresa: getMainData().getServicoEmpresas()){
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


        getMainData().getMarcacoes().add(new Marcacao(getMainData().getCurrentPessoa(), getMainData().getEstadoMarcacaos().get(0), servicoSelecionado, 0, dataPretendida));
        System.out.println("Adicionado com sucesso");
        //Guardar os dados no ficheiro
        getSerialization().saveData(getMainData());

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
