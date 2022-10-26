package Simulation;
public class Main {
    public static void main(String[] args) {
        int choice,arrivalRate,serviceTime,quantum;
        choice = Integer.parseInt(args[0]);
        arrivalRate = Integer.parseInt(args[1]);
        serviceTime = Integer.parseInt(args[2]);
        if (choice==4){
            quantum = Integer.parseInt(args[3]);
            Simulator sim = new Simulator(choice,arrivalRate,serviceTime,quantum);
            sim.run();
        }
        else{
            Simulator sim = new Simulator(choice, arrivalRate, serviceTime);
            sim.run();
        }
    }
}
