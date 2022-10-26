package Simulation;

import Simulation.MyComparator;

import java.util.ArrayList;
import java.util.Collections;

public class RR {
    ArrayList<ArrayList> queue = new ArrayList<ArrayList>() ;
    double waitingTime = 0;
    int quantum = 0;
    int turnaroundTime = 0;
    int processes = 0;
    RR(int quant){
        quantum = quant;
    }
    void addProcess(double arrivalTime, int serviceTime){
        ArrayList tempArrSer = new ArrayList<>();
        tempArrSer.add(arrivalTime);
        tempArrSer.add(serviceTime);
        queue.add(tempArrSer);
    }
    void run(){
        if(!(queue.size()==0)){
            Collections.sort(queue,new MyComparator());
            double curTime = (double)queue.get(0).get(0);
            while(queue.size()>0){
                ArrayList temp = queue.remove(0);
                double arrivalTime = (double)temp.get(0);
                int serviceTime =(int) temp.get(1);
                waitingTime += curTime - arrivalTime;
                turnaroundTime += curTime - arrivalTime + serviceTime;
                if(serviceTime > quantum){
                    curTime += quantum;
                    temp = new ArrayList();
                    temp.add((double)curTime);
                    temp.add((int)serviceTime-quantum);
                    queue.add(temp);
                }
                else{
                    curTime += serviceTime;
                    processes += 1;
                }
            }
        }
    }
    float getAvgWaitingTime(){
        return (float) waitingTime / (float) processes;
    }
    float getAvgTurnAroundTime(){
        return (float) turnaroundTime / (float) processes;
    }
}
