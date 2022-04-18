import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) {
        int qtdExemplos = 25, qtdExemplosTrens = 5;
        ArrayList<Locomotiva> locomotivas = geraLocomotivasExemplo(qtdExemplos);
        ArrayList<Vagao> vagoes = geraVagoesExemplo(qtdExemplos);
        ArrayList<Composicao> trens = new ArrayList<Composicao>();

        


    }

    public static ArrayList<Locomotiva> geraLocomotivasExemplo(int qtdExemplos) {
        int minQtdVagoes = 2, maxQtdVagoes = 10;
        double minQtdPeso = 10.0, maxQtdPeso = 30.0;
        ArrayList<Locomotiva> locomotivas = new ArrayList<Locomotiva>();

        for (int i = 0; i < qtdExemplos; i++) {
            int qtdMaxVagoes = ThreadLocalRandom.current().nextInt(minQtdVagoes, maxQtdVagoes + 1);
            double qtdMaxPeso = ThreadLocalRandom.current().nextDouble(minQtdPeso, maxQtdPeso + 1);       
            locomotivas.add(new Locomotiva(i, qtdMaxPeso, qtdMaxVagoes));
        }
        return locomotivas;
    }

    public static ArrayList<Vagao> geraVagoesExemplo(int qtdExemplos) {
        int minCapacidadeCarga = 1, maxCapacidadeCarga = 15;
        ArrayList<Vagao> vagoes = new ArrayList<Vagao>();

        for (int i = 0; i < qtdExemplos; i++) {
            int capacidadeCarga = ThreadLocalRandom.current().nextInt(minCapacidadeCarga, maxCapacidadeCarga + 1);
            vagoes.add(new Vagao(i, capacidadeCarga));
        }
        return vagoes;
    }

}