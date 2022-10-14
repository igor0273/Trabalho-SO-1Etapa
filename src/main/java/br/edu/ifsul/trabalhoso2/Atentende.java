/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.trabalhoso2;


/**
 * Classe controla as informações 
 * do tempo de serviço e do salario
 * do atentende
 * @author igor.rocha
 * email igorrocha.pf273@academico.ifsul.edu.br
 * repositorio https://github.com/igor0273/Trabalho-SO-1Etapa
 * * @version 1.0
 */
public class Atentende{
    private static Double salario;
    private static Long tempo = 0L;
   

    public Atentende() {
        this.salario = 0.00;
        this.tempo = 0L;
    }
    
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Long getTempo() {
        return tempo;
    }

    public void setTempo(Long tempo) {
        this.tempo = tempo;
    }  
}
