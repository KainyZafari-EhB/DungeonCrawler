public class Item implements ITakeable{
    int positionX;
    int positionY;

    String name;
    //it has no reference --> will cause NullPointerException;
    Player player;

    public Item(String name){
        this.name = name;
    }

    @Override
    public void Take() {
        player.items.add(this);
    }
}
