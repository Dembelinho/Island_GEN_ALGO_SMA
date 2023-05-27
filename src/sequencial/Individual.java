package sequencial;

import java.util.Arrays;
import java.util.Random;

public class Individual implements Comparable{
    private char chromosomes[]=new char[GaUtils.CHROMOSOME_SIZE];
    private int fitness;

    public Individual() {
        Random rnd=new Random();
        for (int i = 0; i< GaUtils.CHROMOSOME_SIZE; i++){
            int index=rnd.nextInt(GaUtils.CHARATERS.length());
            chromosomes[i]= GaUtils.CHARATERS.charAt(index);
        }
    }

    public Individual(char[] chromosomes) {
        this.chromosomes = Arrays.copyOf(chromosomes,GaUtils.CHROMOSOME_SIZE);
    }

    public void calculateFitness(){
        fitness=0;
        for (int i=0;i<GaUtils.CHROMOSOME_SIZE;i++) {
            if(chromosomes[i]==GaUtils.SOLUTION.charAt(i))
                fitness++;
        }
    }
    public char[] getChromosomes() {
        return chromosomes;
    }

    public int getFitness() {
        return fitness;
    }

    @Override
    public int compareTo(Object o) {
        Individual individual=(Individual) o;
        if (this.fitness>individual.fitness)
            return 1;
        else if(this.fitness<individual.fitness){
            return -1;
        }else
            return 0;
    }
}
