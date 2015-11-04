package com.example.tyler.bedlamsboybandbattlesbeadledom;

/**
 * Created by Tyler on 10/25/2015.
 */
public class Hero {
    public String name;
    public int experiencePoints;
    public int level;
    public int health;
    public int mana;
    public double speed;
    public char defenseType;
    Power[] skillset = new Power[4];

    public Hero(String name, int hp, int mp, double speed, char defend, Power howYouAreCool, Power howYouKickAss, Power howYouWillWin, Power howYouBecomeVictorious){
        this.name = name;
        this.experiencePoints = 0;
        this.level = 0;
        this.health = hp;
        this.mana = mp;
        this.speed = speed;
        this.defenseType = defend;
        skillset[1] = new Power(howYouAreCool);
        skillset[2] = new Power(howYouKickAss);
        skillset[3] = new Power(howYouWillWin);
        skillset[4] = new Power(howYouBecomeVictorious);
    }
}
