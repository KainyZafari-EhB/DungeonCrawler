import java.util.ArrayList;
import java.util.Random;

//TODO:
// Implement a generate enemies function to mass spawn enemies,
// Give enemies health,
// Make a damage to player function,
// generate enemies on the grid;

public class Enemy extends Entity{
    Grid grid;

    static int enemyCounter;
    static ArrayList<Enemy> enemies = new ArrayList<>();

    public Enemy(int positionX, int positionY, Grid grid){
        setPositions(positionX, positionY);
        this.grid = grid;
        enemyCounter++;
        enemies.add(this);
    }

    /// Spawns a given amount of enemies on the grid at random positions.
    void spawnEnemies(int amountOfEnemies){
        Random random = new Random();
        for (int i = 0; i < amountOfEnemies; i++){
            int x = random.nextInt(0, grid.getWidth());
            int y = random.nextInt(0, grid.getHeight());
            Enemy enemy = new Enemy(x, y, grid);
        }
        drawEnemies();
    }

    ///Draws enemies based on how many items in enemies list.
    void drawEnemies(){
        for (Enemy enemy : enemies) {
            enemy.drawEntity(grid.cellList);
        }
    }

    //TODO: make a detection system for enemies to discover the player and attack.
    ///Attacks player - Takes a player parameter.
    void attackPlayer(Player player){
        player.decreaseHealth(10);
    }
}
