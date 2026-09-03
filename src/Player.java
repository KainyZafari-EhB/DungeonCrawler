import java.util.ArrayList;

public class Player extends Entity {

    private int damage = 5;


// Constructor
    public Player(int positionX, int positionY){
        setPositions(positionX, positionY);
        items = new ArrayList<>();
        setHealth(100);
    }

    public void pickUpItem(Item item){
        item.Take(this);
    }

    public void checkForItem(Item item, Grid grid){
        if (this.getPositionX() == item.getPositionX() && this.getPositionY() == item.getPositionY()){
            pickUpItem(item);
            grid.getCellList()[item.getPositionX()][item.getPositionY()] = '.';
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
