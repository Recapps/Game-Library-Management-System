package Game;

import java.util.ArrayList;
import java.util.List;
import User.*;

public class Library {
    private List<Game> games;
    private List<String> names;

    public Library() {
        games = new ArrayList<>();
        names = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
        names.add(game.getTitle());
    }

    public void displayGame(int index) {
        if (index >= 0 && index < games.size()) {
            System.out.println("Game Details at Index " + (index+1) + ":");
            games.get(index).displayDetails();
        }
        else {
            System.out.println("Invalid Index. Please Enter a number between 0 and " + (games.size() -1) + ".");
        }
    }

    public void printNames() {
        for (int counter = 0; counter < names.size(); counter++) {
            System.out.println((counter+1) + " - " + names.get(counter));
        }
    }

    public void resetLibrary() {
        this.games.clear();
    }

    public void refundGame(String gamename) {
        for (Game game : games) {
            if (game.getTitle().equalsIgnoreCase(gamename)) {
                if (game.getGameTime() <= 60) {
                    System.out.println("Your game has been refunded!");
                    games.remove(game);
                    return;
                }
                else {
                    System.out.println("Refund not applicable. Game time exceeds 60 minutes.");
                    return;
                }
            }
        }
        System.out.println("Game not found in the library.");
    }
}
