/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoso2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe executa a thread que ira
 * adicionar e remover os veiculos do estacionamento
 * e calcula o salario do atentente com base no 
 * tempo de trabalho adicionando e removendo os veiculos
 * @author igor.rocha
 * @email igorocha.pf273@academico.ifsul.edu.br
 */
public class Estacionamento extends Thread {

    private Boolean removeOrInsert = false;
    static BlockingQueue<Veiculo> veiculos = new ArrayBlockingQueue(12);
    private String removerVeiculoPlaca = null;
    private static List<Veiculo> veiculoList = new ArrayList<>(12);
    private static Atentende atentende = new Atentende();

    public Estacionamento(BlockingQueue<Veiculo> vel, Boolean removeOrInsert, String removerVeiculoPlaca) {
        this.veiculos = vel;
        this.removeOrInsert = removeOrInsert;
        this.removerVeiculoPlaca = removerVeiculoPlaca;
    }

    public Estacionamento() {
    }

    /**
     *<p> Metodo executa a thread do estacionamento
     * </p>
     */
    @Override
    public void run() {
        Long tempoInicial = System.currentTimeMillis();
        Double sal = 0.00;
        synchronized (Estacionamento.veiculos) {
            if (!this.removeOrInsert) {
                try {
                    Veiculo veiculo = this.veiculos.take();
                    veiculoList.add(veiculo);
                    System.out.println("Adicionado veiculo com placa "+ veiculo.getPlaca());
                   
             
                } catch (InterruptedException ex) {
                    Logger.getLogger(Estacionamento.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    atentende.setTempo(System.currentTimeMillis() - tempoInicial);
                    sal = atentende.getSalario() + (atentende.getTempo() * 2);
                    atentende.setSalario(sal);
                    System.out.println("");
                     System.out.println("");
                      System.out.println("");
                       System.out.println("");
                }
             
            } else {
                try{
                      Optional<Veiculo> c = veiculoList.stream().filter(x-> x.getPlaca()== removerVeiculoPlaca).findFirst();
                veiculoList.removeIf(x -> x.getPlaca()== removerVeiculoPlaca);
                System.out.println("Veiculo com placa "+ c.get().getPlaca()+" removido do estacionamento");
              
                }
               catch(Exception e){
                   e.printStackTrace();
               }finally{
                    atentende.setTempo(System.currentTimeMillis() - tempoInicial);
                    sal = atentende.getSalario() + (atentende.getTempo() * 2);
                    atentende.setSalario(sal);
                     System.out.println("");
                     System.out.println("");
                      System.out.println("");
                       System.out.println("");
                }

            }
        }

    }

    public static List<Veiculo> getVeiculoList() {
        return veiculoList;
    }

    public static BlockingQueue<Veiculo> getVeiculos() {
        return veiculos;
    }

    public static Atentende getAtentende() {
        return atentende;
    }
     
}
