package com.example.tyler.bedlamsboybandbattlesbeadledom;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity{

   /* public static void main(String[] args) {


        //You have befriended a local spirit who seems to have a royal aura and a big sword
        Power excalibur = new Power("EXCALIBUR!", 'L', 'D', 10000);

        //Your prickly exterior has sharpened your tongue to cause actual damage.
        Power twinTail = new Power("BAKA", 'V', 'D', 50);

        //Cats are your only friends in this desolate place. Use them against your enemy
        Power nyan = new Power("Cat Scratch Fever", 'A', 'D', 10);

        //You have made a deal with a Faustian alien cat. You temporarily use the powers of a magical girl
        Power loliTransformation = new Power("Mahou Shoujo", 'T', 'D', 40);

        Hero NickSink = new Hero("Nick Sink", 200, 20, 6, 'J', twinTail, nyan, loliTransformation, excalibur);

        Power roulette = new Power("Bet on the ball", 'G', 'S', 20);

        Power allIn = new Power("Bet Everything", 'V', 'Z', 30);

        Power kissDice = new Power("Hope the dice like you", 'B', 'Y', 40);

        Power heartOfTheCards = new Power("Look deep within for the perfect card", 'C', 'J', 10);

        Enemy Gambler = new Enemy("The Gambler", 100, 150, 30, 10, roulette, allIn, kissDice, heartOfTheCards, 'C');

        MainActivity arena1 = new MainActivity();

        arena1.arena(NickSink, Gambler);

    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //You have befriended a local spirit who seems to have a royal aura and a big sword
       Power excalibur = new Power("EXCALIBUR!", 'L', 'D', 10000);

        //Your prickly exterior has sharpened your tongue to cause actual damage.
        Power twinTail = new Power("BAKA", 'V', 'D', 50);

        //Cats are your only friends in this desolate place. Use them against your enemy
        Power nyan = new Power("Cat Scratch Fever", 'A', 'D', 10);

        //You have made a deal with a Faustian alien cat. You temporarily use the powers of a magical girl
        Power loliTransformation = new Power("Mahou Shoujo", 'T', 'D', 40);

        Hero NickSink = new Hero("Nick Sink", 200, 20, 6, 'J', twinTail, nyan, loliTransformation, excalibur);//*/

        Power roulette = new Power("Bet on the ball", 'G', 'S', 20);

        Power allIn = new Power("Bet Everything", 'V', 'Z', 30);

        Power kissDice = new Power("Hope the dice like you", 'B', 'Y', 40);

        Power heartOfTheCards = new Power("Look deep within for the perfect card", 'C', 'J', 10);

        Enemy Gambler = new Enemy("The Gambler", 100, 150, 30, 10, roulette, allIn, kissDice, heartOfTheCards, 'C');

        arena(NickSink, Gambler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void arena(Hero player, Enemy badGuy) {

        ((TextView) findViewById(R.id.textView)).setText("You are battling " + badGuy.name);


        boolean playerInitGreater = false;
        playerInitGreater = initiationCheck(player.speed, badGuy.speed, player.name, badGuy.name, (TextView) findViewById(R.id.textView));

        while (player.health > 0 && badGuy.health > 0) {

            int playerChoice;
            waitForTouch(player, badGuy, playerChoice);
            Bundle extras = getIntent().getExtras();

            playerChoice = extras.getInt("playerChoice");


            if (player.health <= 0) {
                //game over function
                ((TextView) findViewById(R.id.textView)).setText("YOU LOST");
            }

            if (badGuy.health <= 0) {
                player.experiencePoints += badGuy.xpWon;
                ((TextView) findViewById(R.id.textView)).setText("You got lucky and won " + badGuy.xpWon + " experience points");
            }
        }
    }

    public void waitForTouch(final Hero player, final Enemy badGuy, int choice) {
        Button button=(Button)findViewById(R.id.battleButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent i = new Intent(getApplicationContext(), selectPower.class);
                i.putExtra("power1", player.skillset[0].name);
                i.putExtra("power2", player.skillset[1].name);
                i.putExtra("power3", player.skillset[2].name);
                i.putExtra("power4", player.skillset[3].name);
                MainActivity.this.startActivity(i);
                continueArena(player, badGuy);
            }
        });
    }

    public void continueArena(Hero player, Enemy badGuy){
        int enemyChoice = choice(badGuy);

        int bHPmod;
        int pHPmod;
        bHPmod = attackCalculator(player.skillset[playerChoice], badGuy.defenseType);
        pHPmod = attackCalculator(badGuy.whatFucksYou[enemyChoice], player.defenseType);



        if(playerInitGreater){


            badGuy.health -= bHPmod;
            combatText(player.name, badGuy.name, player.skillset[playerChoice].name, bHPmod, badGuy.health, (TextView)findViewById (R.id.textView));
            if(badGuy.health > 0) {

                player.health -= pHPmod;
                combatText(badGuy.name, player.name, badGuy.whatFucksYou[enemyChoice].name, pHPmod, player.health, (TextView)findViewById (R.id.textView));
            }
        }

        else{
            player.health -= attackCalculator(badGuy.whatFucksYou[enemyChoice], player.defenseType);
            combatText(badGuy.name, player.name, badGuy.whatFucksYou[enemyChoice].name, pHPmod, player.health, (TextView) findViewById(R.id.textView));
            if(player.health > 0) {
                badGuy.health -= attackCalculator(player.skillset[playerChoice], badGuy.defenseType);
                combatText(player.name, badGuy.name, player.skillset[playerChoice].name, bHPmod, badGuy.health, (TextView)findViewById (R.id.textView));
            }
        }

    }
    }

    public int choice(Enemy badGuy) {
        int enemyChoice;
        double attackChoice = Math.random();
        if(attackChoice < .24){
            enemyChoice = 0;
        }
        else if (attackChoice < .49){
            enemyChoice = 1;
        }
        else if (attackChoice < .74){
            enemyChoice = 2;
        }
        else{ enemyChoice = 3;}
        return enemyChoice;
    }

    public int choice(Hero player) {
        int playerChoice =0;
        Intent i = new Intent(getApplicationContext(), selectPower.class);

        startActivity(i);


        return playerChoice;
    }

    public int attackCalculator(Power attack, char defend){
        double healthModification = attack.damage;
        double rng = Math.random();

        //test if attack is resisted
        if(attack.type == defend){
            healthModification *= .5;
        }

        //test if attack does bonus
        if(attack.bonusType == defend){
            healthModification *= 1.5;
        }

        //crit like a boss
        if(rng > .89){
            healthModification *= 2;
        }

        return (int) healthModification;
    }



    //@Override
   /* public void onClick(View v) {
        my_button.setBackgroundResource(R.drawable.icon);

        // Execute some code after 2 seconds have passed
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                my_button.setBackgroundResource(R.drawable.defaultcard);
            }
        }, 2000);
    }*/

    public void combatText(String attacker, String defender, String attack, int hpChange, int newHealth, TextView log) {
        log.setText(attacker + " attacked with " + attack + ". " + defender + " took " + hpChange + " damage. " + defender + " now has " + newHealth + " remaining." );

    }

    public boolean initiationCheck(double playerSpeed, double enemySpeed, String playerName, String enemyName, TextView log){
        double playerInitiationRoll = Math.random();
        double enemyInitiationRoll = Math.random();
        double playerInitiation = playerSpeed + playerInitiationRoll * 10;
        log.setText(playerName + " rolled " + playerInitiation);

        double enemyInitiation = enemySpeed + enemyInitiationRoll * 10;
        log.setText(enemyName + " rolled " + enemyInitiation);

        if(playerInitiationRoll > enemyInitiationRoll) {
            return true;
        }
        else{
            return false;
        }
    }

}



