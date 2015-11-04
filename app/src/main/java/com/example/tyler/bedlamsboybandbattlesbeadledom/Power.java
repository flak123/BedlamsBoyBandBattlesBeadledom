package com.example.tyler.bedlamsboybandbattlesbeadledom;

/**
 * Created by Tyler on 10/25/2015.
 */
public class Power {
    String name;
    char type;
    char bonusType;
    double damage;

    public Power(String name, char type, char bonusType, double damage){
        this.name = name;
        this.type = type;
        this.bonusType = bonusType;
        this.damage = damage;
    }

    public Power(Power pass){
        this.name = pass.name;
        this.type = pass.type;
        this.bonusType = pass.bonusType;
        this.damage = pass.damage;
    }

}
