import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class Application {

    public static void main(String[] args) {

        /*We will start de variables for our method   */
        int typePlayer;
        int myPlayer;
        int idPlayer;
        int changePlayer;
        int rdmLive = 0;
        int rdmAttack = 0;
        Spell spell = new Spell("blur", 5);
        String filter = "";
        Weapon weapon = new Weapon("blade", 8);
        String shield = "";


        ArrayList<Player> PlayersList = new ArrayList<Player>();

        do {
            typePlayer = intQuestions("Make your choice : " + "\n1 - Create a Player" + "\n2 - Edit a Player" + "\n3 - Remove a Player" + "\n4 - Create Board Game" + "\n99 - Quit the game");

            /*If we create a player, we must choose between Warrior or Magician  */
            if (typePlayer == 1) {
                myPlayer = intQuestions("Make your choice :" + "\n1 - Warrior" + "\n2 - Magician");

                if (myPlayer == 1 || myPlayer == 2) {
                    String name = strQuestions("What is the Name of your player :");
                    String image = strQuestions("What is the Image of your player :");

                    if (myPlayer == 1) {
                        rdmLive = getRandomNumberInRange(5, 10);
                        System.out.println("Your player's Live is  :" + rdmLive);
                    } else {
                        rdmLive = getRandomNumberInRange(3, 6);
                        System.out.println("Your player's Live is  :" + rdmLive);
                    }
                    int live = rdmLive;

                    if (myPlayer == 1) {
                        rdmAttack = getRandomNumberInRange(5, 10);
                        System.out.println("Your player's Attack is  :" + rdmAttack);
                    } else {
                        rdmAttack = getRandomNumberInRange(8, 15);
                        System.out.println("Your player's Attack is  :" + rdmAttack);
                    }
                    int attack = rdmAttack;

                    if (myPlayer == 1) {
                        //Creation of our weapon
                        String weaponName = strQuestions("What is name of your weapon :");
                        int attackLevel = intQuestions("What is the level of your weapon :");
                        weapon = new Weapon(weaponName, attackLevel);
                        //Creation of our shield
                        shield = strQuestions("What is the Shield of your player :");
                    } else {
                        //Creation of our weapon
                        String spellName = strQuestions("What is name of your spell :");
                        int spellLevel = intQuestions("What is the level of your weapon :");
                        spell = new Spell(spellName, spellLevel);
                        filter = strQuestions("What is the Filter of your player :");
                    }

                    /*We will add the new player to our Array of players  */

                    if (myPlayer == 1) {
                        Player myWarrior = new Warrior(name, image, live, attack, weapon, shield);
                        PlayersList.add(myWarrior);
                        System.out.println(myWarrior);
                    } else {
                        Player myMagician = new Magician(name, image, live, attack, spell, filter);
                        PlayersList.add(myMagician);
                        System.out.println(PlayersList);
                    }
                }

                //We will edit a property of our player, we must choose a player and after choose a property to edit
            } else if (typePlayer == 2) {
//                for (Player ourPlayer: PlayersList) {
//                    System.out.println(ourPlayer.getName());
//                }
                Scanner editPlayer = new Scanner(System.in);
                System.out.println("What player you want to edit (write a number from the list) :");
                for (int i = 0; i < PlayersList.size(); i++) {
                    System.out.println(i + " - " + PlayersList.get(i).getName());
                }
                idPlayer = editPlayer.nextInt();
                System.out.println("You want to edit " + idPlayer + " - " + PlayersList.get(idPlayer).getName());
                changePlayer = intQuestions("What do you want to edit ? :" + "\n1 - Name" + "\n2 - Image" + "\n3 - Live" + "\n4 - Attack" + "\n5 - " + PlayersList.get(idPlayer).getType());

                switch (changePlayer) {
                    case 1:
                        String newName = strQuestions("Choose a new name :");
                        PlayersList.get(idPlayer).setName(newName);
                        break;
                    case 2:
                        String newImage = strQuestions("Choose a new image :");
                        PlayersList.get(idPlayer).setImage(newImage);
                        break;
                    case 3:
                        int newLive = intQuestions("Choose a new live between 5 and 10 :");
                        PlayersList.get(idPlayer).setLive(newLive);
                        break;
                    case 4:
                        int newAttack = intQuestions("Choose a new attack between 5 and 10 :");
                        PlayersList.get(idPlayer).setAttack(newAttack);
                        break;
                    case 5:
                        String newArm = strQuestions("Choose a new " + PlayersList.get(idPlayer).getType() + " :");
                        if (PlayersList.get(idPlayer) instanceof Warrior) {
                            ((Warrior) PlayersList.get(idPlayer)).setShield(newArm);
                        } else {
                            ((Magician) PlayersList.get(idPlayer)).setFilter(newArm);
                        }
                        break;
                }

//                //If we write another number that isn't in our list, we will show a error message
            } else if (typePlayer == 3) {
                for (int i = 0; i < PlayersList.size(); i++) {
                    System.out.println(i + " - " + PlayersList.get(i).getName());
                }
                int rmvPlayer = intQuestions("What player you want to remove (write a number from the list) :");
                PlayersList.remove(rmvPlayer);


            } else if (typePlayer == 4) {
                System.out.println(boardGame());

            } else if (typePlayer != 1 && typePlayer != 2 && typePlayer != 3 && typePlayer != 4 && typePlayer != 99) {
                System.out.println("Please, try to choose one option for the list");
            }


        }
        while (typePlayer != 99);

    }

    private static int intQuestions(String asking) {
        Scanner question = new Scanner(System.in);
        System.out.println(asking);
        return question.nextInt();
    }

    private static String strQuestions(String asking) {
        Scanner question = new Scanner(System.in);
        System.out.println(asking);
        return question.nextLine();
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static ArrayList<String> boardGame() {
        ArrayList<String> boardGame = new ArrayList<String>();
        Scanner size = new Scanner(System.in);
        System.out.println("What is your board game's size :");
        int boardGameSize = size.nextInt();
        for (int r = 0; r < boardGameSize; r++) {
            int dice = getRandomNumberInRange(0, 10);
            if (dice < 3) {
                boardGame.add("Bonus !!");
            } else if (dice > 3 && dice < 6) {
                boardGame.add("null");
            } else {
                boardGame.add("Enemyyyyyy!!!");
            }
        }
        return boardGame;
    }


}

