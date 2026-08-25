import java.util.ArrayList;

public class Item implements ITakeable{
    private int positionX;
    private int positionY;

    String name;
    private final int damage;

    public Item(String name, int damage){
        this.name = name;
        this.damage = damage;
    }

    @Override
    public void Take(Player player) {
        player.items.add(this);
        System.out.println("You picked up: " + this.name);
    }

    void drawItem(char[][] cellList){
        cellList[positionX][positionY] = '$';
    }
    //Make a list of all available items to pick from later.
    ArrayList<Item> itemsList = new ArrayList<>();

    ///Sets position of item
    public void setPosition(int positionX, int positionY){
        setPositionX(positionX); setPositionY(positionY);
    };

    public int getDamage() {
        return damage;
    }

    public int getPositionX() {
        return positionX;
    }

    private void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    private void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
