package com.example.tyler.bedlamsboybandbattlesbeadledom;

/**
 * Created by Tyler on 10/25/2015.
 */
public class createPowers {

    /* L = light, D = doctor, M = medicine, P = patient, B = brain, O = office, N = nurse, V = verbal
     * T = transform, C = currency, W = work, G = game, S = shhh */

    //You have befriended a local spirit who seems to have a royal aura and a big sword.
    Power excalibur = new Power("EXCALIBUR!", 'L', 'D', 10000);

    //You are tired of being hooked up to medicine. Give them a taste of their own.
    Power ivSlash = new Power("IV Slash", 'M', 'P', 10);

    //You see crazy shit. So should they.
    Power sharedHallucination = new Power("Shared Hallucination", 'B', 'P', 20);

    //The crab spirit hands you a stapler to wreak havoc on the other harem competitors
    Power stableStaple = new Power("Crab Staple Attack", 'O', 'N', 30);

    //Your prickly exterior has sharpened your tongue to cause actual damage.
    Power twinTail = new Power("BAKA", 'V', 'D', 50);

    //Cats are your only friends in this desolate place. Use them against your enemy
    Power nyan = new Power("Cat Scratch Fever", 'A', 'D', 10);

    //Make America great again. Put other patients into debt they can't possibly pay
    Power americanMedicalInsurance = new Power("American Medical Insurance", 'C', 'P', 20);

    //You have made a deal with a Faustian alien cat. You temporarily use the powers of a magical girl.
    Power loliTransformation = new Power("Mahou Shoujo", 'T', 'D', 40);

    //You write a suicide letter for your enemy. For some reason they are obliged to follow through.
    Power patientAssistedSuicide = new Power("Suicide Letter", 'B', 'P',100);

    //You realize your enemy is in dire need of medical care. Give it immediately.
    Power lobotomize = new Power("Emergency Vegetable", 'B', 'P',70);

    //With an ends justify the means mentality, you try to balance the socioeconomic ladder.
    Power pickPocket = new Power("Slippery Fingers", 'C', 'D',150);

    //No one likes doing paperwork. You don't like being experimented on. Seems only fair they have to do paperwork.
    Power paperwork = new Power("Bureaucracy FTW", 'W', 'N',10);

}
