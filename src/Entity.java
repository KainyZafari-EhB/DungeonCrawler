import java.util.ArrayList;

public abstract class Entity {

    protected int positionX;
    protected int positionY;

    private int health;

    ArrayList<Item> items;

    void drawEntity(char[][] cellList){
        if (cellList != null){
            if (this instanceof Player) {
                cellList[this.positionX][this.positionY] = 'P';
            }
            if (this instanceof Enemy) {
                cellList[this.positionX][this.positionY] = 'X';
            }
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    ///Sets positions for entity - takes X and Y position parameter.
    void setPositions(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }
    //Health related getters and setters
    int getHealth(){return health;}
    void setHealth(int amount){health = amount;}

    //Damage related methods
    //TODO: make this method more flexible for when items are added.
    void decreaseHealth(){
        setHealth(health -= 10);
    }
    void decreaseHealth(Item item){
        setHealth(health -= item.getDamage());
    }
    void attack(Entity target){
        if (target instanceof Player){
            target.decreaseHealth();
        }
        checkForEffect();
        target.decreaseHealth();
    }
    public void checkForEffect(){
        for (Item item : items) {
            if (item != null) {
                item.applyEffect(item.getItemEffect());
            }
        }
    }
}
