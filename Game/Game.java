package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import User.*;

public class Game {
    private String title;
    private String genre;
    private double price;
    private List<Review> reviews;
    private List<Achievement> achievements;
    private double gameTime;

    public Game(String title, String genre, double price) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.reviews = new ArrayList<>();
        this.achievements = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public String getTitle() {
        return title;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Price: $" + price);
        System.out.println("Achievements:");
        for (Achievement achievement : achievements) {
            System.out.println("- " + achievement.getName() + ": " + achievement.getDescription());
        }
        System.out.println("Reviews:");
        for (Review review : reviews) {
            System.out.println("- " + review.getDetails());
        }
    }

    Random random = new Random();

    public void playGame() {
        double time = random.nextInt(24) + 1;
        if (time == 1) {
            System.out.println("You Played " + title + " for " + time + " hour.");
        }
        else {
            System.out.println("You Played " + title + " for " + time + " hours.");
        }
        gameTime += time;
    }

    public void playGame(User user) {
        double time = random.nextInt(24) + 1;
        if (time == 1) {
            System.out.println(user.getName() + " Played " + title + " for " + time + " hour.");
        }
        else {
            System.out.println(user.getName() + " Played " + title + " for " + time + " hours.");
        }
        user.setPlayTime(time);
        gameTime += time;
    }

    public double getGameTime() {
        return gameTime;
    }
}
