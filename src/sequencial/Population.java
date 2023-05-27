package sequencial;

import java.util.*;

public class Population {

    List<Individual> individuals=new ArrayList<>();
    Individual firstFitness;
    Individual secondFitness;
    Random rnd=new Random();
    public List<Individual> getIndividuals() {
        return individuals;
    }
    public void sortPopulation(){
        Collections.sort(individuals,Collections.reverseOrder());
    }
    public Individual getFitnessIndivd(){
        return individuals.get(0);
    }
    public void initialaizePopulation(){
        for (int i=0;i<GaUtils.POPULATION_SIZE;i++){
            individuals.add(new Individual());
        }
    }
    public void calculateIndFintess(){
        for (int i=0;i<GaUtils.POPULATION_SIZE;i++){
            individuals.get(i).calculateFitness();
        }
    }
    public void selection(){
        firstFitness=individuals.get(0);
        secondFitness=individuals.get(1);
    }
    public void crossover(){

        int point_de_Croisment=rnd.nextInt(5);
        point_de_Croisment++;
        Individual individual1=new Individual();
        Individual individual2=new Individual();
        for (int i = 0; i<individual1.getChromosomes().length; i++) {
            individual1.getChromosomes()[i]=firstFitness.getChromosomes()[i];
            individual2.getChromosomes()[i]=secondFitness.getChromosomes()[i];
        }
        for (int i=0;i<point_de_Croisment;i++) {
            individual1.getChromosomes()[i]=secondFitness.getChromosomes()[i];
            individual2.getChromosomes()[i]=firstFitness.getChromosomes()[i];
        }

        individuals.set(individuals.size()-2,individual1);
        individuals.set(individuals.size()-1,individual2);
    }
    public void mutation(){
        int index=rnd.nextInt(GaUtils.CHROMOSOME_SIZE);
        if (rnd.nextDouble()<GaUtils.MUTATION_PROB){
            individuals.get(individuals.size()-2).getChromosomes()[index]=GaUtils.CHARATERS.charAt(rnd.nextInt(GaUtils.CHARATERS.length()));
        }
        index=rnd.nextInt(GaUtils.CHROMOSOME_SIZE);
        if (rnd.nextDouble()<GaUtils.MUTATION_PROB){
            individuals.get(individuals.size()-1).getChromosomes()[index]=GaUtils.CHARATERS.charAt(rnd.nextInt(GaUtils.CHARATERS.length()));
        }

    }

}
