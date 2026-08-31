import java.util.ArrayList;

//TODO:
// add damage to player's damage,
// choose 1 item from list to be displayed in the grid,
// have items have special effects,
// draw item in the grid.

public class Item implements ITakeable{
    private int positionX;
    private int positionY;

    boolean isPickedUp = false;

    String name;
    private final int damage;

    static ArrayList<Item> itemsList = new ArrayList<>();

    public Item(String name, int damage){
        this.name = name;
        this.damage = damage;
        itemsList.add(this);
    }

    @Override
    public void Take(Player player) {
        player.items.add(this);
        System.out.println("You picked up: " + this.name);
        isPickedUp = true;
        player.setDamage(player.getDamage() + this.damage);
    }

    void drawItem(char[][] cellList, Player player){
        if (!isPickedUp) {
            cellList[positionX][positionY] = '$';
        } else if(isPickedUp && player.getPositionX() == positionX && player.getPositionY() == positionY){
            cellList[positionX][positionY] = 'P';
        }
        else {
            cellList[positionX][positionY] = '.';
        }
    }

    ///Chooses a random position for the item on the grid.
    public void chooseRandomItemPosition(Grid grid){
        int randomX = (int) (Math.random() * grid.getWidth());
        int randomY = (int) (Math.random() * grid.getHeight());
        setPosition(randomX, randomY);
    }

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
