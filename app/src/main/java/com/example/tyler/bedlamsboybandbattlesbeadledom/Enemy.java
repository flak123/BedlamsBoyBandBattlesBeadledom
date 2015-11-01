package com.example.tyler.bedlamsboybandbattlesbeadledom;

/**
 * Created by Tyler on 10/25/2015.
 */
public class Enemy {
    public String name;
    public int xpWon;
    public int health;
    public int mana;
    public double speed;
    public Power[] whatFucksYou;
    public char defenseType;

    // public artificialIntelligence brain;

    public Enemy (String name, int xpWon, int health, int mana, double speed, Power first, Power second, Power third, Power fourth, char defenseType){
        this.name = name;
        this.xpWon = xpWon;
        this.health = health;
        this.mana = mana;
        this.speed = speed;
        whatFucksYou[0] = first;
        whatFucksYou[1] = second;
        whatFucksYou[2] = third;
        whatFucksYou[3] = fourth;
        this.defenseType = defenseType;
    }

}
