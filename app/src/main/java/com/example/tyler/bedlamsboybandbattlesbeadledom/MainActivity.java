package com.example.tyler.bedlamsboybandbattlesbeadledom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static void main(String[] args) {


        //You have befriended a local spirit who seems to have a royal aura and a big sword
        Power excalibur = new Power("EXCALIBUR!", 'L', 'D', 10000);

        //Your prickly exterior has sharpened your tongue to cause actual damage.
        Power twinTail = new Power("BAKA", 'V', 'D', 50);

        //Cats are your only friends in this desolate place. Use them against your enemy
        Power nyan = new Power("Cat Scratch Fever", 'A', 'D', 10);

        //You have made a deal with a Faustian alien cat. You temporarily use the powers of a magical girl
        Power loliTransformation = new Power("Mahou Shoujo", 'T', 'D', 40);

        Hero NickSink = new Hero("Nick Sink", 50, 20, 6, 'J', twinTail, nyan, loliTransformation, excalibur);

        Power roulette = new Power("Bet on the ball", 'G', 'S', 20);

        Power allIn = new Power("Bet Everything", 'V', 'Z', 30);

        Power kissDice = new Power("Hope the dice like you", 'B', 'Y', 40);

        Power heartOfTheCards = new Power("Look deep within for the perfect card", 'C', 'J', 10);

        Enemy Gambler = new Enemy("The Gambler", 100, 150, 30, 10, roulette, allIn, kissDice, heartOfTheCards, 'C');

        MainActivity arena1 = new MainActivity();

        arena1.arena(NickSink, Gambler);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    public void arena(Hero player, Enemy badGuy){
        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        TextView tv = new TextView(this);
        tv.setText("You are battling " + badGuy.name);
        wait(500);
        ll.addView(tv);


        double playerInitiationRoll = Math.random();
        double enemyInitiationRoll = Math.random();
        double playerInitiation = player.speed + playerInitiationRoll * 10;
        tv.setText("You rolled" + playerInitiation);
        wait(500);
        double enemyInitiation = badGuy.speed + enemyInitiationRoll * 10;
        tv.setText(badGuy.name + " rolled " + enemyInitiation);
        wait(500);
        while(player.health > 0 && badGuy.health >0){
            int playerChoice;
            playerChoice = choice(player);
            int enemyChoice = choice(badGuy);

            int bHPmod;
            int pHPmod;
            bHPmod = attackCalculator(player.skillset[playerChoice], badGuy.defenseType);
            pHPmod = attackCalculator(badGuy.whatFucksYou[enemyChoice], player.defenseType);

            if(playerInitiation >  enemyInitiation){


                badGuy.health -= bHPmod;
                tv.setText(player.name + " attacked with " + player.skillset[playerChoice] + ". " + badGuy.name + " took " + bHPmod + " damage. " + badGuy.name + " now has " + badGuy.health + " remaining." );
                wait(500);
                if(badGuy.health > 0) {

                    player.health -= pHPmod;
                    tv.setText(badGuy.name + " attacked with " + badGuy.whatFucksYou[enemyChoice] + ". " + player.name + " took " + pHPmod + " damage. " + player.name + " now has " + player.health + " remaining." );
                    wait(500);
                }
            }

            else{
                player.health -= attackCalculator(badGuy.whatFucksYou[enemyChoice], player.defenseType);
                tv.setText(badGuy.name + " attacked with " + badGuy.whatFucksYou[enemyChoice] + ". " + player.name + " took " + pHPmod + " damage. " + player.name + " now has " + player.health + " remaining." );
                wait(500);
                if(player.health > 0) {
                    badGuy.health -= attackCalculator(player.skillset[playerChoice], badGuy.defenseType);
                    tv.setText(player.name + " attacked with " + player.skillset[playerChoice] + ". " + badGuy.name + " took " + bHPmod + " damage. " + badGuy.name + " now has " + badGuy.health + " remaining." );
                    wait(500);
                }
            }

        }
        if(player.health <= 0){
            //game over function
            tv.setText("YOU LOST");
        }

        if(badGuy.health <= 0){
            player.experiencePoints += badGuy.xpWon;
            tv.setText("You got lucky and won " + badGuy.xpWon + " experience points");
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
        i.putExtra("power1", player.skillset[0].name);
        i.putExtra("power2", player.skillset[1].name);
        i.putExtra("power3", player.skillset[2].name);
        i.putExtra("power4", player.skillset[3].name);
        startActivity(i);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            playerChoice = extras.getInt("playerChoice");
        }

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

    public static void wait(int milliseconds){
        try {
            Thread.sleep(milliseconds);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request it is
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                retu
            }
        }
    }*/

}



