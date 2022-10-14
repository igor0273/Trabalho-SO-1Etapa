package br.edu.ifsul.trabalhoso2;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe executa a thread que ira adicionar e remover os veiculos do
 * estacionamento e calcula o salario do atentente com base no tempo de trabalho
 * adicionando e removendo os veiculos
 *
 * @author igor.rocha
 * email igorocha.pf273@academico.ifsul.edu.br
 * repositorio https://github.com/igor0273/Trabalho-SO-1Etapa
 * * @version 1.0
 */
public class Estacionamento extends Thread {

    private Boolean removeOrInsert = false;
    static BlockingQueue<Veiculo> veiculos = new ArrayBlockingQueue(12);
    private Integer removerVeiculoCodRegistro = null;
    private static List<Veiculo> veiculoList = new ArrayList<>(12);
    private static Atentende atentende = new Atentende();
    private static Integer nVagas = 12;

    public Estacionamento(BlockingQueue<Veiculo> vel, Boolean removeOrInsert, Integer removerVeiculoCodRegistro) {
        this.veiculos = vel;
        this.removeOrInsert = removeOrInsert;
        this.removerVeiculoCodRegistro = removerVeiculoCodRegistro;
    }

    public Estacionamento() {
    }

    /**
     * <p>
     * Metodo executa a thread do estacionamento
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
                        veiculo.setNumeroVaga(nVagas);
                        veiculoList.add(veiculo);
                        System.out.println("Adicionado veiculo com codigo de registro " + veiculo.getCodigoDeRegistro());
                        nVagas--;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Estacionamento.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    atentende.setTempo(System.currentTimeMillis() - tempoInicial);
                    sal = atentende.getSalario() + (atentende.getTempo() * 2);
                    atentende.setSalario(sal);
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                }
            } else {
                try {
                   
                        Optional<Veiculo> c = null; 
                        c = veiculoList.stream().filter(x->Objects.equals(x.getCodigoDeRegistro(), removerVeiculoCodRegistro)).findFirst();
                        if (c != null) {
                            veiculoList.removeIf(x -> x.getCodigoDeRegistro() == removerVeiculoCodRegistro);
                            System.out.println("Veiculo com codigo de registro " + c.get().getCodigoDeRegistro() + " removido do estacionamento");
                            nVagas++;
                        } else {
                            System.out.println("Veiculo com codigo de registro " + removerVeiculoCodRegistro + " nao encontrado");
                        }              
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
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
    
      public static Integer getnVagas() {
        return nVagas;
    }

}
