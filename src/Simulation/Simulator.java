package Simulation;
import java.util.Random;

public class Simulator {
    int schedulerValue;
    int arrivalRate;
    int serviceTime;
    int quantum;
    public Simulator(int sc, int at, int st, int q){
        schedulerValue = sc;
        arrivalRate = at;
        serviceTime = st;
        quantum = q;
    }
    public Simulator(int sc, int at, int st) {
        schedulerValue = sc;
        arrivalRate = at;
        serviceTime = st;
    }
    public void run(){
        float avgWaitingTime,avgTurnaroundTime,cpuUtilization;
        Random random = new Random();
        if (schedulerValue == 1) {
            FCFS scheduler = new FCFS();
            double curTime = 0;
            double arrivalTime;
            while (curTime < 10000) {
                if (curTime < 10000) {
                    arrivalTime = random.nextExponential();
                    curTime += arrivalTime;
                }
                scheduler.addProcess( curTime, serviceTime);
                scheduler.run();
            }
            avgWaitingTime = scheduler.getAvgWaitingTime();
            avgTurnaroundTime = scheduler.getAvgTurnAroundTime();
            cpuUtilization = (float) (10000 - avgWaitingTime) /(float) 10000;
        }
         else if (schedulerValue == 2) {
            SRTF scheduler = new SRTF();
            double curTime = 0;
            double arrivalTime;
            while (curTime < 10000) {
                if (curTime < 10000) {
                    arrivalTime = random.nextExponential();
                    curTime += arrivalTime;
                }
                scheduler.addProcess( curTime, serviceTime);
                scheduler.run();
            }
            avgWaitingTime = scheduler.getAvgWaitingTime();
            avgTurnaroundTime = scheduler.getAvgTurnAroundTime();
            cpuUtilization = (float) (10000 - avgWaitingTime) /(float) 10000;
        } else if (schedulerValue == 3){
            HRRN scheduler = new HRRN();
            double curTime = 0;
            double arrivalTime;
            while (curTime < 10000) {
                if (curTime < 10000) {
                    arrivalTime = random.nextExponential();
                    curTime += arrivalTime;
                }
                scheduler.addProcess(curTime, serviceTime);
                scheduler.run();
            }
            avgWaitingTime = scheduler.getAvgWaitingTime();
            avgTurnaroundTime = scheduler.getAvgTurnAroundTime();
            cpuUtilization = (float) (10000 - avgWaitingTime) /(float) 10000;
         }
        else if (schedulerValue == 4){
            RR scheduler = new RR(quantum);
            double curTime = 0;
            double arrivalTime;
            while (curTime < 10000) {
                if (curTime < 10000) {
                    arrivalTime = random.nextExponential();
                    curTime += arrivalTime;
                }
                scheduler.addProcess( curTime, serviceTime);
                scheduler.run();
            }
            avgWaitingTime = scheduler.getAvgWaitingTime();
            avgTurnaroundTime = scheduler.getAvgTurnAroundTime();
            cpuUtilization = (float) (10000 - avgWaitingTime) /(float) 10000;
        }
        else{
            System.out.println("Invalid scheduler");
            return;
        }
        System.out.println("Average waiting time: "+avgWaitingTime);
        System.out.println("Average turnaround time: "+avgTurnaroundTime);
        System.out.println("CPU utilization: "+cpuUtilization);
        }
    }
