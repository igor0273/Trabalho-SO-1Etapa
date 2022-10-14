package br.edu.ifsul.trabalhoso2;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Executa o programa principal criando o menu para a interação do usuario
 *
 * @author igor.rocha
 * email igorrocha.pf273@academico.ifsul.edu.br
 * repositorio https://github.com/igor0273/Trabalho-SO-1Etapa
 * @version 1.0
 */
public class main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Integer codigoDeRegistro = null;
        Scanner sc = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento();
        BlockingQueue<Veiculo> vel = new ArrayBlockingQueue<>(12);
        int menu = -1;
        int i = 0;
        do {
            Veiculo veiculo = new Veiculo();

            System.out.println("0-Sair");
            System.out.println("1-Adicionar Veiculo");
            System.out.println("2-Remove Veiculo");
            System.out.println("3-Exibe veiculos no estacionamento");
            System.out.println("4-Exibe Salario do Atendente");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    if (estacionamento.getnVagas() == 0) {
                        System.out.println("Estacionamento esta cheio");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                    } else {
                        System.out.println("Informe o codigo de registro para veiculo");
                        veiculo.setCodigoDeRegistro(sc.nextInt());
                        vel.put(veiculo);
                        estacionamento = new Estacionamento(vel, false, null);
                        estacionamento.start();
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    }
                    break;

                case 2:
                    if (estacionamento.getnVagas() == 12) {
                        System.out.println("Estacionamento esta vazio");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                    } else {
                        System.out.println("Informe o codigo de registro do veiculo que ira ser removido");
                        codigoDeRegistro = sc.nextInt();
                        veiculo.setCodigoDeRegistro(codigoDeRegistro);
                        estacionamento = new Estacionamento(vel, true, codigoDeRegistro);
                        estacionamento.start();
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    }

                    break;

                case 3:
                    if (estacionamento.getnVagas() == 12) {
                        System.out.println("Estacionamento esta vazio");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                    } else {
                        estacionamento.getVeiculoList().forEach(z -> {
                            System.out.println("Veiculo com codigo de registro " + z.getCodigoDeRegistro()+ " esta na vaga "+z.getNumeroVaga());
                        });
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    }
                    break;

                case 4:
                    System.out.println("Salario atual do atentende " + estacionamento.getAtentende().getSalario());
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    break;

                case 0:
                    System.out.println("Programa Finalizado");
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    break;

            }
        } while (menu != 0);
    }

}
