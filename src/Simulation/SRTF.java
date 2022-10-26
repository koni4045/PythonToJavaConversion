package Simulation;

import java.util.ArrayList;


public class SRTF {
    ArrayList<ArrayList> queue = new ArrayList<ArrayList>();
    double waitingTime = 0;
    int turnaroundTime = 0;
    int processes = 0;
    void addProcess(double arrivalTime, int serviceTime){
        ArrayList tempArrSer = new ArrayList<>();
        tempArrSer.add(arrivalTime);
        tempArrSer.add(serviceTime);
        queue.add(tempArrSer);
    }
    void run(){
        if(!(queue.size()==0)){
            double curTime = (double)queue.get(0).get(0);
            while (queue.size()>0){
                ArrayList temp = queue.remove(heapPop(queue));
                double arrivalTime = (double)temp.get(0);
                int serviceTime = (int)temp.get(1);
                waitingTime += curTime - arrivalTime;
                turnaroundTime += curTime - arrivalTime + serviceTime;
                curTime += serviceTime;
                processes += 1;
                for(int i=0;i<queue.size();i++){
                    ArrayList temp1 = queue.get(i);
                    int remainingTime = (int)temp1.get(1);
                    if (remainingTime > serviceTime){
                        ArrayList t = new ArrayList();
                        t.add((double)queue.get(i).get(0));
                        t.add((int)remainingTime - serviceTime);
                        queue.set(i,t);
                    }
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
    int heapPop(ArrayList<ArrayList> queue){
        int index = 0;
        double temp = (double)queue.get(0).get(0);
        for(int i=0;i<queue.size();i++){
            if(temp>(double)queue.get(i).get(0)){
                temp = (double)queue.get(i).get(0);
                index = i;
            }
        }
        return index;
    }
}
