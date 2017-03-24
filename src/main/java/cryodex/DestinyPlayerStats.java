package cryodex;

/**
 *
 * @author DestinyCCG
 */
public class DestinyPlayer {
    
    // This will store the downloaded (local) copy of the player data obtained from DestinyCCG.com.
    // It it used to verify a player is registered with DestinyCCG.com.
    
    private final String firstName;
    private final String lastName;
    private final String email;
    private final int points;
    private final int events;
    private final String state;
    
    public DestinyPlayer(String f, String l, String e, int p, int ev, String s) {
        
        firstName = f;
        lastName = l;
        email = e;
        points = p;
        events = ev;
        state = s;
        
    }
    
    public String getFirst() {
        return firstName;
    }
    
    public String getLast() {
        return lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getState() {
        return state;
    }
    
    public Integer getPoints() {
        return points;
    }
    
    public Integer getEvents() {
        return events;
    }
    
}
