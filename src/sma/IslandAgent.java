package sma;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import sequencial.GaUtils;
import sequencial.Individual;

public class IslandAgent extends Agent {
    private Individual[] population =new Individual[GaUtils.POPULATION_SIZE];
    private Individual individual1;
    private  Individual individual2;

    @Override
    protected void setup() {
        DFAgentDescription dfAgentDescription=new DFAgentDescription();
        ServiceDescription serviceDescription=new ServiceDescription();

        dfAgentDescription=new DFAgentDescription();
        dfAgentDescription.setName(getAID());
        serviceDescription=new ServiceDescription();
        serviceDescription.setType("island");
        serviceDescription.setName("ga");
        dfAgentDescription.addServices(serviceDescription);
        try {
            DFService.register(this,dfAgentDescription);
        } catch (FIPAException e) {
            throw new RuntimeException(e);
        }
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                population.;
                population.calculateIndFintess();
                population.sortPopulation();
                int it=0;


                while (it<GaUtils.MAX_IT && population.getFitnessIndivd().getFitness()<GaUtils.CHROMOSOME_SIZE){
                    population.selection();
                    population.crossover();
                    population.mutation();
                    population.calculateIndFintess();
                    population.sortPopulation();
                    it++;
                }
                ACLMessage message=blockingReceive();
                if (message!= null) {
                    ACLMessage replay=new ACLMessage();
                    replay.addReceiver(message.getSender());
                    Individual best = population.getFitnessIndivd();
                    replay.setContent(String.valueOf(best.getGenes()) +":"+best.getFitness());
                    send(replay);
                }
            }
        });

    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException e) {
            throw new RuntimeException(e);
        }
    }
}
