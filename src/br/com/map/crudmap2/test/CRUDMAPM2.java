/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.crudmap2.test;

import br.com.map.crudmap2.dao.UsuarioDAO;
import br.com.map.crudmap2.facade.CRUDMAPFacade;
import br.com.map.crudmap2.model.Usuario;
import br.com.map.crudmap2.util.DateUtil;
import br.com.map.crudmap2.util.MensagensUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Allyson
 */
public class CRUDMAPM2 {

    public static void main(String[] args) throws Exception {

        // Scanner - permite ler dados do usuário
        Scanner input = new Scanner(System.in);

        Usuario usuario = null;
        CRUDMAPFacade facade = new CRUDMAPFacade();

        // menu
        String op = "";
        int id;

        do {
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_TITULO));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_CADASTRAR));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_EDITAR));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_EXCLUIR));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_LISTAR));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_CONSULTAR));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_IDIOMA));
            System.out.println(MensagensUtil.getString(MensagensUtil.MENU_PRINCIPAL_SAIR));

            op = input.nextLine();

            String msg = "Registro salvo com sucesso!";
            
            switch (op) {
                case "1":
                    System.out.println("----CADASTRAR----");

                    usuario = new Usuario();

                    // inserir
                    System.out.println("Nome: ");
                    usuario.setNome(input.nextLine()); // ler uma linha e guarda em nome
                    System.out.println("E-mail: ");
                    usuario.setEmail(input.nextLine());
                    System.out.println("Data de Nascimento:");
                    usuario.setDataNascimento(DateUtil.stringToDate(input.nextLine()));

                    facade.salvarUsuario(usuario);

                    break;
                case "2":
                    System.out.println("----EDITAR----");

                    System.out.println("Informe o ID: ");
                    id = Integer.parseInt(input.nextLine());

                    usuario = facade.buscarUsuario(id);

                    if (usuario != null) {

                        System.out.println("Novo Nome: (" + usuario.getNome() + ")");
                        usuario.setNome(input.nextLine());
                        System.out.println("Novo E-mail: (" + usuario.getEmail() + ")");
                        usuario.setEmail(input.nextLine());

                        facade.editarUsuario(usuario);

                        System.out.println("Usuário editado com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado!");
                    }

                    break;
                case "3":
                    System.out.println("----REMOVER----");

                    System.out.println("Informe o ID: ");
                    id = Integer.parseInt(input.nextLine());

                    usuario = facade.buscarUsuario(id);

                    if (usuario != null) {
                        facade.removerUsuario(usuario);
                        System.out.println("Usuário removido com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado!");
                    }

                    break;
                case "4":
                    System.out.println("----LISTAR----");
                    for (Usuario u : facade.listarUsuarios()) {
                        System.out.println(u);
                    }
                    break;
                case "5":
                    System.out.println("----CONSULTAR----");
                    System.out.println("Busca: ");
                    String busca = input.nextLine();

                    List<Usuario> lista = facade.buscarUsuarios(busca);

                    if (!lista.isEmpty()) {
                        for (Usuario u : lista) {
                            System.out.println(u);
                        }
                    } else {
                        System.out.println("Nenhum resultado encontrado!");
                    }

                    break;
                case "6":
                    System.out.println("----IDIOMA----");
                    
                    System.out.println("1 - pt-BR");
                    System.out.println("2 - en-US");
                    System.out.println("3 - fr-FR");
                    
                    System.out.println("Informe o idioma: ");
                    op = input.nextLine();
                    
                    if(op.endsWith("1")){
                        MensagensUtil.setLocale(MensagensUtil.PT_BR);
                    }
                    else if(op.endsWith("2")){
                        MensagensUtil.setLocale(MensagensUtil.EN_US);
                    }
                    else{
                        MensagensUtil.setLocale(MensagensUtil.FR_FR);
                    }
                    
                    break;
                case "7":
                    System.out.println("Saindo....");
                    break;
                default:
                    System.out.println("Informe uma opção válida!");

            }

        } while (!op.equals("6"));

    } // fim do método main

}
