import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class Application {

    public static void main(String[] args) {
        //creation of a Warrior
        int typePlayer;
        int i = 0;
        int f = 0;
        Player WarriorList[] = new Warrior[100];
        Player MagicianList[] = new Magician[100];

        do {
            Scanner player = new Scanner(System.in);
            System.out.println("Make your choice :");
            System.out.println("1 - Create a Warrior");
            System.out.println("2 - Create a Magician");
            System.out.println("3 - Show all players created");
            System.out.println("99 - Quit the game");
            typePlayer = player.nextInt();

           if(typePlayer != 99) {
                Questions askName = new Questions();
                askName.questions("What is the Name of your player :");
                String name = askName.getInsert();

                Questions askImage = new Questions();
                askImage.questions("What is the Image of your player :");
                String image = askImage.getInsert();

                int rdmLive = 0;
                if (typePlayer == 1) {
                    rdmLive = getRandomNumberInRange(5, 10);
                    System.out.println("Your player's Live is  :" + rdmLive);
                } else if (typePlayer == 2) {
                    rdmLive = getRandomNumberInRange(3, 6);
                    System.out.println("Your player's Live is  :" + rdmLive);
                }
                int live = rdmLive;

                int rdmAttack = 0;
                if (typePlayer == 1) {
                    rdmAttack = getRandomNumberInRange(5, 10);
                    System.out.println("Your player's Attack is  :" + rdmAttack);
                } else if (typePlayer == 2) {
                    rdmAttack = getRandomNumberInRange(8, 15);
                    System.out.println("Your player's Attack is  :" + rdmAttack);
                }
                int attack = rdmAttack;

                String shield = "";
                if (typePlayer == 1) {
                    Questions askShield = new Questions();
                    askShield.questions("What is the Shield of your player :");
                    shield = askShield.getInsert();
                }

                String filter = "";
                if (typePlayer == 2) {
                    Questions askFilter = new Questions();
                    askFilter.questions("What is the Filter of your player :");
                    filter = askFilter.getInsert();
                }

                if (typePlayer == 1) {
                    Player myWarrior = new Warrior(name, image, live, attack, shield);
                    WarriorList[i] = myWarrior;
                    i++;
                }
                if (typePlayer == 2) {
                    Player myMagician = new Magician(name, image, live, attack, filter);
                    MagicianList[f] = myMagician;
                    f++;
                }
                if (typePlayer == 3) {
                    System.out.println(Arrays.toString(WarriorList));
                }
          }
//            else{
//                System.exit(1);
//            }
        } while (typePlayer != 99);

    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


}

