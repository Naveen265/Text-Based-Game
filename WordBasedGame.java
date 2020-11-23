import java.util.*;
class WordBasedGame{
    public static void main(String[] args){
        //System objects
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        //Game variables
        String[] enemies = {"Skeleton","Zombie","Warrior","Assassin"};
        int maxEnemyHealth = 75;
        int enemyAtackDamage = 25;

        //Player Variables
        int health = 100;
        int attackDamage = 50;
        int numberofHealthPotion = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 75; //percentage

        Boolean running = true;

        System.out.println("\n\tWelcome to the Game!");
        System.out.println("\t 1. !! START !!");
        System.out.println("\t 2. ^^ EXIT ^^");
        String input1 = scan.nextLine();
    if(input1.equals("1")){
        Game:
        while(running){
            System.out.println("\t--------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# "+ enemy + " has appeared! #\n");

            while(enemyHealth > 0){
                System.out.println("\n\tYour HP: " + health);
                System.out.println("\t"+ enemy +"'s HP:" + enemyHealth);
                System.out.println("\tYou have "+ numberofHealthPotion + " Health Potions ");
                System.out.println("\n\tWhat Would You Like To Do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.println("\t3. Run!");


               String input = scan.nextLine();
               if(input.equals("1")){
                  int damageDealt = rand.nextInt(attackDamage);
                  int damageTaken = rand.nextInt(enemyAtackDamage);

                  enemyHealth -= damageDealt;
                  health -= damageTaken;   
                  System.out.println("\t> You Strike the " + enemy + " for " + damageDealt + " damage.");
                  System.out.println("\t> You Recieve " + damageTaken + " in Battle! ");
                if(health < 1){
                    System.out.println("\t> You have Taken too much Damage, you are too weak to continue!");
                    break;
                }  

               }
               else if(input.equals("2")){
                   if(numberofHealthPotion > 0){
                    if(health == 100){
                        System.out.println("\tYour health is Full$$");
                      }
                    else if(health != 100){  
                      health = 100;
                      numberofHealthPotion--;
                      System.out.println("\t> You drunk a Health Potion, Healing yourself for " + healthPotionHealAmount + "." 
                                         + "\n\t You now have "+ health + " HP: "
                                         + "You have "+ numberofHealthPotion +" health Potions Left. \n");
                      }
                      
                    }
                    else{
                        System.out.println("\t> You have no Health Potions Left! Defeat an enemies for a chance to get one!\n");
                    }
               }
               else if(input.equals("3")){
                   System.out.println("\t> You run away from the " + enemy + "!");
                   continue Game;
               }
               else{
                System.out.println("\t> Invalid Command!");
               }

            }

            if(health < 1){
                System.out.println("\t> You Limp out of the Arena, Weak from the battle");
                break;
            }

            System.out.println("--------------------");
            System.out.println("> " + enemy + " Was Defeated! ");
            System.out.println("> You Have "+ health + " HP Left!");
            if(rand.nextInt(100) < healthPotionDropChance){
                numberofHealthPotion++;
                System.out.println("> The " + enemy + " dropped a health potion!");
                System.out.println("> You now have " + numberofHealthPotion + " health potion(s).");
            }
             System.out.println("--------------------");
             System.out.println("What would you like to do?");
             System.out.println("1. Continue Fighting");
             System.out.println("2. Exit Arena");

             String input = scan.nextLine();

             while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid Command");
                input = scan.nextLine();
             }
             
             if(input.equals("1")){
                System.out.println("You continue on your adventure!");

             }
             else if(input.equals("2")){
                System.out.println("You exit the arena, best of luck for your adventure!");
                break;
            }


        }  
        System.out.println("\n#######################");
        System.out.println("# THANKS FOR PLAYING! #");
        System.out.println("#######################");
    }
    else if(input1.equals("2")){
      System.out.println("\tSee you Again Soooon");
    }
  }

}
