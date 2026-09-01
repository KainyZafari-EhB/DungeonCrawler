import java.util.ArrayList;

//TODO: have items have special effects and have the effect show in battle,

public class Item implements ITakeable{
    private int positionX;
    private int positionY;

    boolean isPickedUp = false;

    String name;
    private final int damage;

    static ArrayList<Item> itemsList = new ArrayList<>();
    private final Effect itemEffect;

    enum Effect{
        BLEED, POISON, FIRE, ICE
    }

    public void applyEffect(Effect effect){
        if (itemEffect != null){
            switch (itemEffect){
                case BLEED -> System.out.println("You are bleeding!");
                case POISON -> System.out.println("You are poisoned!");
                case FIRE -> System.out.println("You are on fire!");
                case ICE -> System.out.println("You are frozen!");
            }
        }
    }

    public Item(String name, int damage){
        this.name = name;
        this.damage = damage;
        itemsList.add(this);
        this.itemEffect = null;
    }

    public Item(String name, int damage, Effect itemEffect){
        this.name = name;
        this.damage = damage;
        itemsList.add(this);
        this.itemEffect = itemEffect;
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

    public Effect getItemEffect() {
        return itemEffect;
    }
}
