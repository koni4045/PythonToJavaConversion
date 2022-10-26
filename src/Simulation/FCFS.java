package Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FCFS {
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
           double curTime = (double) queue.get(0).get(0);
           for(int i=0;i<queue.size();i++){
               waitingTime += curTime - (double)queue.get(i).get(0);
               turnaroundTime += curTime - (double)queue.get(i).get(0) + (int) queue.get(i).get(1);
               curTime += (int)queue.get(i).get(1);
               processes += 1;
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
class MyComparator implements Comparator<ArrayList>{

    @Override
    public int compare(ArrayList o1, ArrayList o2) {
        int i = (int) ((double) o1.get(0) - (double) o2.get(0));
        return i;
    }
}

