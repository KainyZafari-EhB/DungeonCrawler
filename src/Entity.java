public class Entity {

    protected int positionX;
    protected int positionY;

    void drawEntity(char[][] cellList, char symbol){
        if (cellList != null){
            cellList[positionX][positionY] = symbol;
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

    void setPositions(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
