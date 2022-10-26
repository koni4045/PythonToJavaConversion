package Simulation;

import Simulation.MyComparator;

import java.util.ArrayList;
import java.util.Collections;

public class HRRN {
    ArrayList<ArrayList> queue = new ArrayList<ArrayList>() ;
    double waitingTime = 0;
    int turnaroundTime = 0;
    int processes = 0;
    void addProcess(double arrivalTime, int serviceTime){
        //int[] tempArrSer = {arrivalTime,serviceTime};
        ArrayList tempArrSer = new ArrayList<>();
        tempArrSer.add(arrivalTime);
        tempArrSer.add(serviceTime);
        queue.add(tempArrSer);
    }
    void run(){
        if(!(queue.size()==0)){
            Collections.sort(queue,new MyComparator());
            double curTime = (double)queue.get(0).get(0);
            while (queue.size()>0){
                int bestProcess = 0;
                float bestResponseRatio = -1;
                for(int i=0;i<queue.size();i++){
                    double arrivalTime = (double)queue.get(i).get(0);
                    int serviceTime = (int)queue.get(i).get(1);
                    float responseRatio = (float) (curTime - arrivalTime + serviceTime) / (float) serviceTime;
                    if(responseRatio > bestResponseRatio){
                        bestProcess = i;
                        bestResponseRatio = responseRatio;
                    }
                }
                ArrayList temp = queue.remove(bestProcess);
                double arrivalTime = (double)temp.get(0);
                int serviceTime = (int)temp.get(1);
                waitingTime += curTime - arrivalTime;
                turnaroundTime += curTime - arrivalTime + serviceTime;
                curTime += serviceTime;
                processes =+ 1;
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



