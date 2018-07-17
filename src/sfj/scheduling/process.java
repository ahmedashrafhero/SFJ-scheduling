/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfj.scheduling;

/**
 *
 * @author Z51
 */
public class process {

    /**
     * @param args the command line arguments
     */
    int id;
    float arrivalTime;
    int burstTime;
    float turnArroundTime;
    float waitingTime;
    float responseTime;
    int waitingSum;
    int burstSum;
    process(int id)
    {
        this.id=id;
    }
    }

