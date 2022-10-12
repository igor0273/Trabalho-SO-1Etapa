/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhoso2;

/**
 * Classe controla as informações
 * do veiculo que ir entrar no estacionamento
 * @author igor.rocha
 * @email igorrocha.pf273@academico.ifsul.edu.br
 */
public class Veiculo{
    
    private String placa;
    private Integer numeroVaga;
  
 
    public Veiculo(String placa) {
        this.placa = placa;
    }
    
    public Veiculo(){
    }

   
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getNumeroVaga() {
        return numeroVaga;
    }

    public void setNumeroVaga(Integer numeroVaga) {
        this.numeroVaga = numeroVaga;
    }

    
    
    
}
