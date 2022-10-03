package corredores;

public class Corredor implements Competidor {
    private String nome;
    private int velocidade;
    private int distanciaPercorrida;
    private int distanciaDaCorrida;
    private boolean estaCorrendo;

    public Corredor(String nome, int velocidade) {
        this.nome = nome;
        this.velocidade = velocidade;
        distanciaPercorrida = 0;
        distanciaDaCorrida = 0;
        estaCorrendo = false;
    }

    public int getDistanciaDaCorrida() {
        return distanciaDaCorrida;
    }

    @Override
    public boolean estaCorrendo() {
        return estaCorrendo;
    }

    @Override
    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public void prepararParaNovaCorrida(int distanciaDaCorrida) {
        this.distanciaDaCorrida = distanciaDaCorrida;
        estaCorrendo = false;
        distanciaPercorrida = 0;
    }

    @Override
    public void run() {
        estaCorrendo = true;
        int tempoNecessario = (1000 / velocidade);
        while(distanciaPercorrida < distanciaDaCorrida) {
            try {
                distanciaPercorrida += 1;
                Thread.sleep(tempoNecessario);
            } catch (InterruptedException ex) {
                System.out.println("Execução da tarefa interrompida!");
            }
        }
        estaCorrendo = false;
    }
    
}
