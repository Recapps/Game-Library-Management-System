package Game;

import java.util.Random;
import User.*;

public class Review {
    private User user;
    private Game game;
    private int rating;
    private String comment;

    Random random = new Random();

    public Review(User user, Game game, int rating, String comment) {
        this.user = user;
        this.game = game;
        this.rating = rating;
        this.comment = comment;
    }

    public String getDetails() {
        return user.getName() + " rated " + rating + "/5: " + comment;
    }

    public void removeReview() {
        this.user = null;
        this.game = null;
        this.rating = 0;
        this.comment = null;
    }

    public void randomReview(User user, Game game) {
        this.user = user;
        this.game = game;
        this.rating = random.nextInt(5) + 1;
        this.comment = "Randomly Generated Review!";
    }
}
