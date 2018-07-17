/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfj.scheduling;

import java.util.ArrayList;

/**
 *
 * @author Z51
 */
public class CALCULATIONS 
{    
    boolean switcher=false;
    process temp=new process(0);
    
    public ArrayList<process> order(ArrayList<process> arr)
    {    
        for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i).arrivalTime==0)
                {
                       temp=arr.get(i);
                       arr.set(i,arr.get(0));
                       arr.set(0, temp);
                       switcher=true;
                }
            }
        if(switcher)
        {
        for(int i=1;i<arr.size();i++)
        {
            for(int j=i+1;j<arr.size();j++)
            {
                if(arr.get(i).burstTime>arr.get(j).burstTime)
                {
                    temp=arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        }
        else
        {
        for(int i=0;i<arr.size();i++)
        {
            for(int j=i+1;j<arr.size();j++)
            {
                if(arr.get(i).burstTime>arr.get(j).burstTime)
                {
                    temp=arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                    
                }
            }
        }
        }
        return arr;
    }
    public ArrayList<process> sumsAssigns(ArrayList<process> arr)
    {
        arr.get(0).waitingSum=0;
        arr.get(0).burstSum=arr.get(0).burstTime;
        arr.get(0).waitingTime=0;
        arr.get(0).turnArroundTime=arr.get(0).burstTime;
        for(int i=1;i<arr.size();i++)
            {
               arr.get(i).waitingSum= arr.get(i-1).waitingSum+arr.get(i-1).burstTime;
               arr.get(i).burstSum= arr.get(i-1).burstSum+arr.get(i).burstTime;
            }
        return arr;
    }
    public ArrayList<process> processCalculation(ArrayList<process> arr)
    {
        for(int i=1;i<arr.size();i++)
            {
               arr.get(i).waitingTime=arr.get(i).waitingSum-arr.get(i).arrivalTime;
               arr.get(i).turnArroundTime= arr.get(i).burstSum-arr.get(i).arrivalTime;
               arr.get(i).responseTime=arr.get(i).waitingSum-arr.get(i).arrivalTime;
            }
        return arr;
    }
    public float AVG_waitngTime(ArrayList<process> arr)
    {
        float sum=0;
        int count=0;
        for(int i=0;i<arr.size();i++)
        {
            sum+=arr.get(i).waitingTime;
            count++;
        }
        return sum/count;
    }
    public float AVG_turnArroundTime(ArrayList<process> arr)
    {
        float sum=0;
        int count=0;
        for(int i=0;i<arr.size();i++)
        {
            sum+=arr.get(i).turnArroundTime;
            count++;
        }
        return sum/count;
    }
    public float AVG_responseTime(ArrayList<process> arr)
    {
        float sum=0;
        int count=0;
        for(int i=0;i<arr.size();i++)
        {
            sum+=arr.get(i).responseTime;
            count++;
        }
        return sum/count;
    }
    public ArrayList<process> reconfigure(ArrayList<process> arr)
    {
        for(int i=0;i<arr.size();i++)
            {
            for(int j=i+1;j<arr.size();j++)
                {
                if(arr.get(i).id>arr.get(j).id)
                    {
                    temp=arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                    }
                }
           }
        return arr;
    }
}
