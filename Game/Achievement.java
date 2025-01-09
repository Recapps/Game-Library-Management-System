package Game;

import java.util.Date;
import User.*;

public class Achievement {
    private String name;
    private String description;
    private boolean status = false;
    private Date date;

    public Achievement(String name, String description) {
        this.name = name;
        this.description = description;
        this.date = null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void unlock(Date date) {
        this.status = true;
        this.date = date;
    }
    
    public void reset() {
        this.status = false;
        this.date = null;
    }

    public Date getDate() {
        return date;
    }
    
}
