import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.lang.Object;


public class Application {

    public static void main(String[] args) {

        /*We will start de variables for our method   */
        int typePlayer;
        int myPlayer;
        int idPlayer;
        int changePlayer;
        ArrayList<Player> PlayersList = new ArrayList<Player>();
        //Player playersList[] = new Player[14];

        do {
            Scanner player = new Scanner(System.in);
            System.out.println("Make your choice :");
            System.out.println("1 - Create a Player");
            System.out.println("2 - Edit a Player");
            System.out.println("3 - Remove a Player");
            System.out.println("99 - Quit the game");
            typePlayer = player.nextInt();


            /*If we create a player, we must choose between Warrior or Magician  */
            if (typePlayer == 1) {
                Scanner kindPlayer = new Scanner(System.in);
                System.out.println("Make your choice :");
                System.out.println("1 - Warrior");
                System.out.println("2 - Magician");
                myPlayer = kindPlayer.nextInt();

                if (myPlayer == 1 || myPlayer == 2) {
                    Questions askName = new Questions();
                    askName.questions("What is the Name of your player :");
                    String name = askName.getInsert();

                    Questions askImage = new Questions();
                    askImage.questions("What is the Image of your player :");
                    String image = askImage.getInsert();

                    int rdmLive = 0;
                    if (myPlayer == 1) {
                        rdmLive = getRandomNumberInRange(5, 10);
                        System.out.println("Your player's Live is  :" + rdmLive);
                    } else if (myPlayer == 2) {
                        rdmLive = getRandomNumberInRange(3, 6);
                        System.out.println("Your player's Live is  :" + rdmLive);
                    }
                    int live = rdmLive;

                    int rdmAttack = 0;
                    if (myPlayer == 1) {
                        rdmAttack = getRandomNumberInRange(5, 10);
                        System.out.println("Your player's Attack is  :" + rdmAttack);
                    } else if (myPlayer == 2) {
                        rdmAttack = getRandomNumberInRange(8, 15);
                        System.out.println("Your player's Attack is  :" + rdmAttack);
                    }
                    int attack = rdmAttack;

                    String shield = "";
                    if (myPlayer == 1) {
                        Questions askShield = new Questions();
                        askShield.questions("What is the Shield of your player :");
                        shield = askShield.getInsert();
                    }

                    String filter = "";
                    if (myPlayer == 2) {
                        Questions askFilter = new Questions();
                        askFilter.questions("What is the Filter of your player :");
                        filter = askFilter.getInsert();
                    }

                    /*We will add the new player to our Array of players  */

                    if (myPlayer == 1) {
                        Player myWarrior = new Warrior(name, image, live, attack, shield);
                        PlayersList.add(myWarrior);
                        System.out.println(PlayersList);
                    }
                    if (myPlayer == 2) {
                        Player myMagician = new Magician(name, image, live, attack, filter);
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
                for(int i = 0; i < PlayersList.size(); i++) {
                    System.out.println(i + " - " + PlayersList.get(i).getName());
                }
                idPlayer = editPlayer.nextInt();
                System.out.println("You want to edit " + idPlayer + " - " + PlayersList.get(idPlayer).getName());
                Scanner whatEdit = new Scanner(System.in);
                System.out.println("What do you want to edit ? :");
                System.out.println("1 - Name");
                System.out.println("2 - Image");
                System.out.println("3 - Live");
                System.out.println("4 - Attack");
                System.out.println("5 - " + PlayersList.get(idPlayer).getType());
                changePlayer = whatEdit.nextInt();
                switch (changePlayer) {
                    case 1:
                        Scanner editName = new Scanner(System.in);
                        System.out.println("Choose a new name :");
                        String newName = editName.nextLine();
                        PlayersList.get(idPlayer).setName(newName);
                        break;
                    case 2:
                        Scanner editImage = new Scanner(System.in);
                        System.out.println("Choose a new image :");
                        String newImage = editImage.nextLine();
                        PlayersList.get(idPlayer).setImage(newImage);
                        break;
                    case 3:
                        Scanner editLive = new Scanner(System.in);
                        System.out.println("Choose a new live between 5 and 10 :");
                        int newLive = editLive.nextInt();
                        PlayersList.get(idPlayer).setLive(newLive);
                        break;
                    case 4:
                        Scanner editAttack = new Scanner(System.in);
                        System.out.println("Choose a new attack between 5 and 10 :");
                        int newAttack = editAttack.nextInt();
                        PlayersList.get(idPlayer).setAttack(newAttack);
                        break;
                    case 5:
                        Scanner editArmType = new Scanner(System.in);
                        System.out.println("Choose a new " + PlayersList.get(idPlayer).getType() + " :");
                        String newArm = editArmType.nextLine();
                        if(PlayersList.get(idPlayer) instanceof Warrior){
                            ((Warrior) PlayersList.get(idPlayer)).setShield(newArm);
                        }else{
                            ((Magician) PlayersList.get(idPlayer)).setFilter(newArm);
                        }
                        break;
                }

//                //If we write another number that isn't in our list, we will show a error message
            } else if (typePlayer == 3) {
                for(int i = 0; i < PlayersList.size(); i++) {
                    System.out.println(i + " - " + PlayersList.get(i).getName());
                }
                Scanner removePlayer = new Scanner(System.in);
                System.out.println("What player you want to remove (write a number from the list) :");
                int rmvPlayer = removePlayer.nextInt();
                PlayersList.remove(rmvPlayer);
                //playersList = ArrayUtils.removeElement(playersList, rmvPlayer);


            } else if (typePlayer != 1 && typePlayer != 2 && typePlayer != 3 && typePlayer != 99) {
                System.out.println("Please, try to choose one option for the list");
            }


        }
        while (typePlayer != 99);

    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


}

