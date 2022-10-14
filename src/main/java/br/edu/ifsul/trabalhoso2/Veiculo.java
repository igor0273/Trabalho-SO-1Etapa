package br.edu.ifsul.trabalhoso2;

/**
 * Classe controla as informações
 * do veiculo que ira entrar no estacionamento
 * @author igor.rocha
 * @email igorrocha.pf273@academico.ifsul.edu.br
 * @repositorio https://github.com/igor0273/Trabalho-SO-1Etapa
 * * @version 1.0
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
