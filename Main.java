import User.*;
import Game.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Library library = new Library();
        Vault vault = new Vault();
        User currentuser = null;
        
        Game[] games = {
            new Game("Elden Ring", "Action RPG", 59.99),
            new Game("The Witcher 3", "RPG", 39.99),
            new Game("God of War", "Action-Adventure", 49.99),
            new Game("Horizon Zero Dawn", "Action RPG", 39.99),
            new Game("Minecraft", "Sandbox", 26.95),
            new Game("Stardew Valley", "Simulation", 14.99),
            new Game("Dark Souls III", "Action RPG", 39.99),
            new Game("Final Fantasy VII Remake", "RPG", 59.99),
            new Game("Cyberpunk 2077", "Action RPG", 29.99),
            new Game("Eternum", "Visual Novel", 0.00)
        };

        for (Game game : games) {
            library.addGame(game);
        }

        Achievement[][] achievements = new Achievement[10][2];

        // Elden Ring
        achievements[0][0] = new Achievement("First Boss", "Defeat the first boss.");
        achievements[0][1] = new Achievement("Explorer", "Discover 100 locations.");

        // The Witcher 3
        achievements[1][0] = new Achievement("Monster Slayer", "Defeat 50 monsters.");
        achievements[1][1] = new Achievement("Storyteller", "Complete the main story.");

        // God of War
        achievements[2][0] = new Achievement("God of War", "Complete the game on any difficulty.");
        achievements[2][1] = new Achievement("Collector", "Collect all artifacts.");

        // Horizon Zero Dawn
        achievements[3][0] = new Achievement("Explorer", "Discover all regions.");
        achievements[3][1] = new Achievement("Craftsman", "Craft 100 items.");

        // Minecraft
        achievements[4][0] = new Achievement("Builder", "Build a house.");
        achievements[4][1] = new Achievement("Survivor", "Survive for 100 days.");

        // Stardew Valley
        achievements[5][0] = new Achievement("Farmer", "Grow 100 crops.");
        achievements[5][1] = new Achievement("Friend", "Max out friendship with 5 villagers.");

        // Dark Souls III
        achievements[6][0] = new Achievement("Dark Soul", "Complete the game.");
        achievements[6][1] = new Achievement("Master", "Defeat all bosses.");

        // Final Fantasy VII Remake
        achievements[7][0] = new Achievement("Hero", "Complete Chapter 1.");
        achievements[7][1] = new Achievement("Collector", "Collect all Materia.");

        // Cyberpunk 2077
        achievements[8][0] = new Achievement("Street Kid", "Complete the Street Kid storyline.");
        achievements[8][1] = new Achievement("Techie", "Craft 50 items.");

        // Eternum
        achievements[9][0] = new Achievement("Play Boy", "Get Along with every Girl");
        achievements[9][1] = new Achievement("END?", "Get shot and die");

        // adding achievements to each game
        for (int i = 0; i < games.length; i++) {
            for (int j = 0; j < achievements[i].length; j++) {
                games[i].addAchievement(achievements[i][j]);
            }
        }

        Scanner input = new Scanner(System.in);

        // boolean global variables for the loop
        boolean mainLoop = true;
        boolean loggedin = false;

        while (mainLoop) {

            System.out.println("-------------------------------");
            System.out.println("Welcome to Chussire Game Port!");
            System.out.println("One Library, Endless Adventures");
            System.out.println("-------------------------------");

            String[] options = {"Home", "Game Library", "Login", "Wishlist", "About"};

            // printing options
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + " - " + options[i]);
            }
            System.out.println("0 - Exit");

            System.out.print("\nPlease Enter Index Number to proceed: ");
            
            // variable that takes user input as option index
            int index = input.nextInt();

             // use of nextLine to prevent from line consuption
            input.nextLine();

            // switch for each different option
            switch (index) {

                // Home option
                case 1:
                    
                    System.out.println("Welcome to the Home Page! Explore our options.");
                    break;

                // Game Library Option
                case 2:

                    // boolean variable to keep the loop runnning
                    boolean libraryLoop = true;

                    while (libraryLoop) {
                        System.out.println("-------------------------------");
                        System.out.println("         Game Library ");
                        System.out.println("-------------------------------");
                        library.printNames();
                        System.out.println("0 - Back");
                        System.out.print("\nPlease Enter Index Number to proceed: ");
                    
                        int libraryIndex = input.nextInt();

                        if (libraryIndex == 0) {
                            libraryLoop = false;
                        } 
                        else if (libraryIndex <= games.length) {
                    
                            boolean gameloop = true;
                            while (gameloop) {
                                library.displayGame(libraryIndex - 1);
                                System.out.println("1 - Play Game");
                                System.out.println("2 - Check Total Game Time");
                                System.out.println("3 - Add to Wishlist");
                                System.out.println("0 - Back");
                                System.out.print("\nPlease Enter Index Number to proceed: ");
                                int gameindex = input.nextInt();

                                if (gameindex == 1) {
                                    if (loggedin == true) {
                                        games[libraryIndex-1].playGame(currentuser);
                                    }
                                    else {
                                        games[libraryIndex-1].playGame();
                                    }
                                }
                                else if (gameindex == 2) {
                                    System.out.println("You've played " + games[libraryIndex-1].getTitle() + " for " + games[libraryIndex-1].getGameTime() + " hours.");
                                }
                                else if (gameindex == 3) {
                                    if (loggedin == true) {
                                        currentuser.addToWishlist(games[libraryIndex-1]);
                                    }
                                    else {
                                        System.out.println("To wishlist this game please Login first.");
                                    }
                                }
                                else if (gameindex == 0) {
                                    gameloop = false;
                                }
                                else {
                                    System.out.println("Invalid Index Option!");
                                }
                            }
                        }
                        else {
                            System.out.println("Invalid Index Option!");
                        }
                    }
                    break;
                
                // Login option
                case 3:
                    
                    boolean loginLoop = true;
                    
                    while (loginLoop) {
                        System.out.println("-------------------------------");
                        System.out.println("            Login ");
                        System.out.println("-------------------------------");
                        System.out.println("1 - Login as User");
                        System.out.println("2 - Login as Admin");
                        System.out.println("0 - Back");
                        System.out.print("\nPlease Enter Index Number to proceed: ");
                        int loginIndex = input.nextInt();
                        input.nextLine(); // Consume newline

                        switch (loginIndex) {
                            
                            // User Login option
                            case 1:
                                System.out.print("Enter Username: ");
                                String username = input.nextLine();

                                System.out.print("Enter Email: ");
                                String email = input.nextLine();

                                currentuser = new User(username, email);
                                vault.addUser(currentuser);
                                System.out.println("User logged in successfully!");
                                loggedin = true;
                                break;

                            // Admin Login
                            case 2:
                                System.out.print("Enter Username: ");
                                String adminUsername = input.nextLine();

                                System.out.print("Enter Email: ");
                                String adminEmail = input.nextLine();

                                System.out.print("Enter Password: ");
                                int password = input.nextInt();
                                input.nextLine(); // Consume newline

                                AdminUser admin = new AdminUser(adminUsername, adminEmail, password);


                                if (admin.getStatus()) {
                                   
                                    boolean adminLoop = true;
                                    while (adminLoop) {
                                        System.out.println("-------------------------------");
                                        System.out.println("        Admin Commands ");
                                        System.out.println("-------------------------------");
                                        System.out.println("1 - Add User");
                                        System.out.println("2 - List Users");
                                        System.out.println("3 - Clear User List");
                                        System.out.println("0 - log out!");
                                        System.out.print("\nPlease Enter Index Number to proceed: ");
                                        int adminOption = input.nextInt();
                                        
                                        // line consumption prevention
                                        input.nextLine();

                                        switch (adminOption) {
                                   
                                            // Add User option
                                            case 1:
                                                System.out.print("Enter Username: ");
                                                String newUser = input.nextLine();

                                                System.out.print("Enter Email: ");
                                                String newUserEmail = input.nextLine();

                                                admin.addUser(new User(newUser, newUserEmail));
                                                break;

                                            // List Users option
                                            case 2:
                                                admin.listUsers();
                                                break;

                                            // Clear User List option
                                            case 3:
                                                admin.clearUsers();
                                                break;

                                            // Back option
                                            case 0:
                                                adminLoop = false;
                                                break;

                                            // default case if the user enters invalid input
                                            default:
                                                System.out.println("Invalid option! Please try again.");
                                        }
                                    }
                                }
                                break;

                            // Back option
                            case 0:
                                loginLoop = false;
                                break;

                            // defaut case if the user enters invalid input
                            default:
                                System.out.println("Invalid option! Please try again.");
                        }
                    }
                    break;
                
                // wishlist option
                case 4:
                    
                    System.out.println("-------------------------------");
                    System.out.println("           Wishlist ");
                    System.out.println("-------------------------------");
                    
                    if (loggedin == true) {
                        currentuser.displayWishlist();
                        System.out.println("1 - Clear Wishlist");
                    }
                    else {
                        System.out.println("Please Login to check your Wishlist");
                    }
                    
                    System.out.println("0 - Exit");
                    System.out.print("\nPlease Enter Index Number to proceed: ");

                    int wishlistindex = input.nextInt();

                    if (wishlistindex == 0) {
                        break;
                    }
                    else if (wishlistindex == 1) {
                        if (loggedin == true) {
                        currentuser.clearWishlist();
                        System.out.println("Wishlist has been cleared!");
                        }
                        else {
                            System.out.println("Invalid Index Number!");
                        }
                    }
                    else {
                        System.out.println("Invalid Index Number!");
                    }
                    break;
                
                // About option
                case 5:
                    System.out.println("-------------------------------");
                    System.out.println("           About Us ");
                    System.out.println("-------------------------------");
                    System.out.println("Chussire, your ultimate game library management system designed for gamers and game enthusiasts alike!\n" +
                                       "At Chussire, we believe that every gamer deserves a seamless and enjoyable experience when managing their game collections.");
                    System.out.println("-------------------------------");
                    System.out.println("          Our Mission");
                    System.out.println("-------------------------------");
                    System.out.println("We envision a world where gamers can effortlessly manage their collections and connect with others who share their interests.\n" +
                                       "We are committed to continuously improving our platform and adding new features based on user feedback.");
                    break;

                // Exit option
                case 0:
                    System.out.println("Thanks for Visiting, See you next time 😊");
                    mainLoop = false;
                    break;

                // default case if the user enter invalid input
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        // closing scanner
        input.close();
    }
}
