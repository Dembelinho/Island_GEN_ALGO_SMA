package sequencial;

import java.util.Random;

public class Individual implements Comparable{
    private char genes[]=new char[GaUtils.CHROMOSOME_SIZE];
    private int fitness;
    public Individual() {
        Random rnd=new Random();
        for (int i=0;i<genes.length;i++){
            genes[i]= GaUtils.CHARATERS.charAt(rnd.nextInt(GaUtils.CHARATERS.length()));
        }
    }
    public char[] getGenes() {
        return genes;
    }

    public void calculateFitness(){
        fitness=0;
        for (int i=0;i<GaUtils.CHROMOSOME_SIZE;i++) {
            if(genes[i]==GaUtils.SOLUTION.charAt(i))
                fitness+=1;
        }
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
