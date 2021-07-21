package estg.ipvc.gabrielSousa.menus.funcionalidades;

import estg.ipvc.gabrielSousa.entidades.MainData;
import estg.ipvc.gabrielSousa.entidades.marcacao.ServicoEmpresa;
import estg.ipvc.gabrielSousa.menus.base.Menu;
import estg.ipvc.gabrielSousa.menus.base.MenuData;

import java.util.ArrayList;
import java.util.Scanner;

public class SingleMenu_AprovarServicoEmpresa extends MenuData implements Menu {
    @Override
    public void action() {
        try {
            ArrayList<ServicoEmpresa> servicosNaoAprovados =getContasServicosEmpresaParaAprovar();

            if (servicosNaoAprovados.isEmpty()) {
                throw new Exception("Não existem serviços aguardando aprovação.");
            }

            boolean verifier;
            do {
                verifier=optionChecker(servicosNaoAprovados);
            } while (!verifier);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String getName() {
        return "Aprovar Serviços de Empresa.";
    }

    public boolean optionChecker(ArrayList<ServicoEmpresa> servicosNaoAprovados) {
        try {
            System.out.print("Escolha um serviço a aprovar: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (ServicoEmpresa se : servicosNaoAprovados) {
                if (se.getId_servicoEmpresa() == id) {
                    se.setAprovado(true);
                    System.out.println("\nServiço Aprovado com Sucesso.");
                    return true;
                }
            }

            throw new Exception("\nOpção Inválida.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}