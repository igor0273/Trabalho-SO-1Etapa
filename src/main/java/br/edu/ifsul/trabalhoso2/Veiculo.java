/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.trabalhoso2;

/**
 * Classe controla as informações
 * do veiculo que ira entrar no estacionamento
 * @author igor.rocha
 * @email igorrocha.pf273@academico.ifsul.edu.br
 */
public class Veiculo{
    
    private Integer codigoDeRegistro;
    private Integer numeroVaga;
  
 
    public Veiculo(Integer codigoDeRegistro) {
        this.codigoDeRegistro = codigoDeRegistro;
    }
    
    public Veiculo(){
    }

    public Integer getCodigoDeRegistro() {
        return codigoDeRegistro;
    }

    public void setCodigoDeRegistro(Integer codigoDeRegistro) {
        this.codigoDeRegistro = codigoDeRegistro;
    }

    public Integer getNumeroVaga() {
        return numeroVaga;
    }

    public void setNumeroVaga(Integer numeroVaga) {
        this.numeroVaga = numeroVaga;
    }

    
    
    
}
