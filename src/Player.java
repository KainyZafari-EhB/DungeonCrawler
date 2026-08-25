import java.util.ArrayList;

public class Player extends Entity {

    ArrayList<Item> items;

// Constructor
    public Player(int positionX, int positionY){
        setPositions(positionX, positionY);
        items = new ArrayList<>();
    }
}
