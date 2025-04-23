/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.embarquecontainer;

/**
 *
 * @author CaioBraz
 */
import java.util.Scanner;

public class EmbarqueContainer {
    
    // Função principal que organiza o embarque
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar capacidade total do container
        System.out.print("Informe a capacidade total do container (em kg): ");
        double capacidadeTotal = scanner.nextDouble();
        
        // Variáveis para controle do peso total embarcado e quantidade de itens
        double pesoTotalEmbarcado = 0;
        int quantidadeItens = 0;
        
        // Processo de embarque de produtos
        while (true) {
            System.out.print("Informe o peso do item (em kg, negativo para finalizar): ");
            double pesoItem = scanner.nextDouble();
            
            // Verificar se o peso do item é negativo (indicando o fim do embarque)
            if (pesoItem < 0) {
                break;
            }
            
            System.out.print("Informe a quantidade do item: ");
            int quantidadeItem = scanner.nextInt();
            
            // Calcular o peso total do item a ser embarcado
            double pesoTotalItem = pesoItem * quantidadeItem;
            
            // Verificar se o peso total não ultrapassa a capacidade do container
            if (pesoTotalEmbarcado + pesoTotalItem > capacidadeTotal) {
                System.out.println("Não foi possível inserir o produto. Excesso de peso.");
                continue; // Pula para a próxima iteração
            }
            
            // Atualizar o peso total embarcado e a quantidade de itens
            pesoTotalEmbarcado += pesoTotalItem;
            quantidadeItens += quantidadeItem;
            
            // Calcular o percentual do peso embarcado em relação à capacidade total
            double percentualEmbarcado = (pesoTotalEmbarcado / capacidadeTotal) * 100;
            
            // Exibir as informações após cada item
            System.out.println("Capacidade total do container: " + capacidadeTotal + " kg");
            System.out.println("Peso total já embarcado: " + pesoTotalEmbarcado + " kg (" + percentualEmbarcado + "%)");
            
            // Verificar se o embarque foi autorizado (80% ou mais da capacidade)
            if (pesoTotalEmbarcado >= 0.8 * capacidadeTotal) {
                System.out.println("Embarque autorizado.");
            } else {
                System.out.println("Embarque não autorizado.");
            }
            
            // Verificar se a capacidade total foi atingida
            if (pesoTotalEmbarcado == capacidadeTotal) {
                System.out.println("Capacidade máxima atingida. Processo de embarque encerrado.");
                break;
            }
        }
        
        // Verificar se o embarque foi autorizado após a conclusão
        if (pesoTotalEmbarcado >= 0.8 * capacidadeTotal) {
            System.out.println("Embarque autorizado.");
        } else {
            System.out.println("Embarque não autorizado. Peso insuficiente.");
        }
        
        // Exibir o resultado final
        System.out.println("Peso total embarcado: " + pesoTotalEmbarcado + " kg");
        System.out.println("Quantidade total de itens: " + quantidadeItens);
    }
}

