package com.hencoder.hencoderpracticedraw1.model;
/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/4/11
       Time     :  21:45
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */

public class PieChartData{
    
    
    private int color;
    private String name;
    private float number;
    
    
    public PieChartData(int color, String name, float number){
        this.color=color;
        this.name=name;
        this.number=number;
    }
    
    public int getColor(){
        return color;
    }
    
    public void setColor(int color){
        this.color=color;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public float getNumber(){
        return number;
    }
    
    public void setNumber(float number){
        this.number=number;
    }
    

}
