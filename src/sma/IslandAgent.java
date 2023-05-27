package sma;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import sequencial.GaUtils;
import sequencial.Individual;
import sequencial.Population;

import java.util.Random;

public class IslandAgent extends Agent {

    Population population=new Population();
    Random rnd=new Random();
    DFAgentDescription dfAgentDescription=new DFAgentDescription();
    ServiceDescription serviceDescription=new ServiceDescription();

    @Override
    protected void setup() {
        dfAgentDescription=new DFAgentDescription();
        dfAgentDescription.setName(getAID());
        serviceDescription=new ServiceDescription();
        serviceDescription.setType("IslandAgent");
        serviceDescription.setName("ga");
        dfAgentDescription.addServices(serviceDescription);
//
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                try {
                    DFService.register(myAgent,dfAgentDescription);
                } catch (FIPAException e) {
                    throw new RuntimeException(e);
                }
                population.initialaizePopulation();
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
                    replay.setContent(String.valueOf(best.getChromosomes()) +":"+best.getFitness());
                    send(replay);
                    System.out.println(replay);
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
