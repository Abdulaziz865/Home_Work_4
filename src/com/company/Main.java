package com.company;

import java.util.Random;

public class Main {
    public static int BossHP = 700;
    public static int BossDamage = 50;
    public static int[] heroesHp = {270, 260, 250, 200};
    public static int[] heroesDamage = {20, 15, 25, 0};
    public static String[] heroesName = {"Physycal", "Magic", "Kinetik","Medic"};
    public static String BossDefenseType = "";
    public static int round = 0;

    public static void main(String[] args) {
        Statistycs();
        while (!isGameOver()) {
            round();
        }

    }

    public static void Statistycs() {
        System.out.println("Round " + round);
        System.out.println("____________________________________");
        System.out.println("Boss: " + "HP = " + BossHP + ", Damage = " + BossDamage);

        for (int i = 0; i < heroesName.length; i++) {
            System.out.println("Heroes Typs: " + heroesName[i] + ": HP = " + heroesHp[i] + ", Damage = " + heroesDamage[i]);
        }
        System.out.println("____________________________________");

    }
    public static void medicHeal() {
        int r = 0;
        int help = 20;
        for (String name : heroesName) {
            if (name.equals("Medic")) {
                for (int i = 0; i < heroesHp.length; i++) {
                    if (heroesHp[i] < 100 && heroesHp[i] > 0) {
                        heroesHp[i] += help;
                        System.out.println("Medic help: " + heroesName[i]);
                        break;
                    }
                }

            }
            r++;

        }

    }

    public static boolean isGameOver() {
        if (BossHP <= 0) {
            System.out.println("Heroes WINS !!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHp.length; i++) {
            if (heroesHp[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss WIN !!!");
        }
        return allHeroesDead;
    }

    public static void round() {
        round++;
        DeffBoss();
        BossAttack();
        heroesAttack();
        Statistycs();
        medicHeal();
    }

    public static void BossAttack() {
        for (int i = 0; i < heroesHp.length; i++) {
            if (BossHP > 0) {
                if (heroesHp[i] < BossDamage) {
                    heroesHp[i] = 0;
                } else {
                    heroesHp[i] = heroesHp[i] - BossDamage;
                }
            }
        }
    }

    public static void heroesAttack() {
        for (int i = 0; i < heroesHp.length; i++) {
            if (heroesHp[i] > 0 && BossHP > 0) {
                if (BossDefenseType == heroesName[i]){
                    BossHP = BossHP + heroesDamage[i];
                }
                if (BossHP < heroesDamage[i]) {
                    BossHP = 0;
                } else {
                    BossHP = BossHP - heroesDamage[i];
                }
            }
        }

    }
    public static void DeffBoss(){
        Random random = new Random();
        int r = random.nextInt(heroesName.length);
        BossDefenseType = heroesName[r];
        System.out.println("Boss choose " + BossDefenseType);
    }
}
