import java.util.Random;

//TODO:
// Implement a generate enemies function to mass spawn enemies,
// Give enemies health,
// Make a damage to player function,
// generate enemies on the grid;

public class Enemy extends Entity{

    int positionX;
    int positionY;

    Grid grid;
    char[][] cellList = grid.cellList;

    public Enemy(int positionX, int positionY, Grid grid){
        this.positionX = positionX;
        this.positionY = positionY;
        this.grid = grid;
    }

    ///draws an enemy at a random coordinate;
    public void drawEnemy(){
        Random randomNumbers = new Random();

        int randomX = randomNumbers.nextInt(0, grid.getWidth());
        int randomY = randomNumbers.nextInt(0, grid.getHeight());
        setPositionX(randomX);
        setPositionY(randomY);

        if (cellList != null){
            cellList[randomX][randomY] = 'O';
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

    /// set Coordinates of both X and Y for the enemy
    public void setMeasurements(int positionX, int positionY) {
        setPositionX(positionX);
        setPositionY(positionY);
    }
}
