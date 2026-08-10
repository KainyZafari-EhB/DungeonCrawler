public class Player {
    int positionX;
    int positionY;


// Getters
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

// Setters
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

// Constructors

    public Player(){
        this(0, 0);
    }

    public Player(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
