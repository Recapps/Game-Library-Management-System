package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import Game.*;

public class User {
    private String name;
    private String email;
    private List<Game> wishlist;
    private List<Achievement> unlockedAchievements;
    private static double PlayTime;
    private Date date;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.wishlist = new ArrayList<>();
        this.unlockedAchievements = new ArrayList<>();
        System.out.println("Login Succesful!");
    }

    public void addToWishlist(Game game) {
        wishlist.add(game);
        System.out.println(game.getTitle() + " added to " + name + "'s wishlist. \n");
    }

    public void unlockAchievement(Game game, Achievement achievement) {
        
        if (game.getAchievements().contains(achievement)) {
            unlockedAchievements.add(achievement);
            System.out.println(name + " unlocked achievement: " + achievement.getName() + " in " + game.getTitle());
            achievement.unlock(date);
        } 
        else {
            System.out.println("Achievement not found in the specified game.");
        }

    }

    public void displayWishlist() {
        System.out.println(name + "'s Wishlist:");
        for (Game game : wishlist) {
            System.out.println("- " + game.getTitle());
        }
    }

    public void clearWishlist() {
        this.wishlist.clear();
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return email;
    }
    public void setPlayTime(double counter) {
        this.PlayTime += counter;
    }

    public double getPlayTime() {
        return PlayTime;
    }

}
