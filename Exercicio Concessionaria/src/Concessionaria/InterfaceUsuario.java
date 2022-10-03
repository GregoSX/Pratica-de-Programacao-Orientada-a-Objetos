/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concessionaria;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.fabricas.*;

import java.util.Scanner;

/**
 *
 * @author julio
 */
public class InterfaceUsuario {

    private Concessionaria ppooVeiculos;
    private Scanner entrada;
        
    public void exibir() {
        
        ppooVeiculos = new Concessionaria("PPOO Veículos", new FabricaChevrolet());
        entrada = new Scanner(System.in);
        
        int opcao;        
        do {
            opcao = menu();
            
            switch (opcao) {
                case 1:
                    comprarCarro();
                    break;
                case 2:
                    mudarFranquia();
                    break;
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");                   
            }
            
        } while (opcao != 3);        
    }            
    
    private int menu() {
        System.out.println("1 - Comprar Carro");
        System.out.println("2 - Mudar Franquia");
        System.out.println("3 - Sair");
        
        return Integer.parseInt(entrada.nextLine());
    }

    private void comprarCarro() {        
        System.out.println("Concessionaria vende carros da: " + ppooVeiculos.getMarcaFranquia());        
        
        try {
            System.out.print("Escolha a categoria (1: Popular, 2: Pickup ou 3: Luxo): ");
            Categoria categoria = Categoria.peloID(Integer.parseInt(entrada.nextLine()));
            
            System.out.print("Escolha a cor: ");
            String cor = entrada.nextLine();
            
            if (ppooVeiculos.criarCarrosConcessionaria(categoria, cor)) {
                System.out.println("Parabéns!!! O carro é seu!!!");            
            }
            else {
                System.out.println("Não há modelos disponíveis para essa categoria");
                System.out.println("Sinto muito, não quer escolher outro?");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        esperarTecla();
    }

    private void mudarFranquia() {
        try {
            System.out.print("Escolha a franquia (1: VW, 2: Fiat ou 3: Chevrolet): ");
            Marca marca = Marca.peloID(Integer.parseInt(entrada.nextLine()));
            if(marca == Marca.CHEVROLET) {
                ppooVeiculos.setFabrica(new FabricaChevrolet());
            } else if(marca == Marca.FIAT) {
                ppooVeiculos.setFabrica(new FabricaFiat());
            } else {
                ppooVeiculos.setFabrica(new FabricaVW());
            }
            System.out.println("Mudança de franquia concluída!");
            esperarTecla();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private void esperarTecla() {
        entrada.nextLine();
    }
}

