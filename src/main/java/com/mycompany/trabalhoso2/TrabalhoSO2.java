package com.mycompany.trabalhoso2;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author 20172pf.cc0273
 */
public class TrabalhoSO2 {
   
    public static void main(String[] args) throws InterruptedException, IOException {
        String placa = "";
        Scanner sc = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento();
        BlockingQueue<Veiculo> vel = new ArrayBlockingQueue<>(12);
         int menu = -1;
         int i = 0;
          do{
              Veiculo veiculo = new Veiculo();
             
              System.out.println("0-Sair");
              System.out.println("1-Adicionar Veiculo");
              System.out.println("2-Remove Veiculo");
              System.out.println("3-Exibe veiculos no estacionamento");
              System.out.println("4-Exibe Salario do Atendente");
              menu = sc.nextInt();
              
              switch (menu) {
                  case 1:
                       
                      System.out.println("Informe a placa do veiculo");
                      veiculo.setPlaca(sc.nextLine());
                      vel.put(veiculo);
                      estacionamento = new Estacionamento(vel,false,null);
                      estacionamento.start();
                      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                      break;
                      
                  case 2:
                      sc.nextLine();
                      System.out.println("Informe o id so carro que ira ser removido");
                      
                      placa =String.valueOf(sc.nextInt());
                      veiculo.setPlaca(placa);
                      estacionamento = new Estacionamento(vel,true,placa);
                      estacionamento.start();
                       new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                      break;
                      
                  case 3:
                      estacionamento.getVeiculoList().forEach(z->{
                          System.out.println("Veiculo com placa" +z.getPlaca());
                      });
                       new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                      break;
                      
                  case 4:
                      System.out.println("Salario atual do atentende "+estacionamento.getAtentende().getSalario());
                       new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                      break;
                              
              }
          }while(menu != 0);
    }
    
}

