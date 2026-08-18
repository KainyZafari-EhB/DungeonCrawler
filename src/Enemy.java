public class Enemy {

    int positionX;
    int positionY;

    public Enemy(){this(0,0);}

    public Enemy(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
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

    public void setMeasurements(int positionX, int positionY) {
        setPositionX(positionX);
        setPositionY(positionY);
    }
}
