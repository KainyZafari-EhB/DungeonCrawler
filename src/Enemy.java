import java.util.ArrayList;
import java.util.Random;

//TODO: make a detection system for enemies to discover the player and attack.
public class Enemy extends Entity{
    static Grid grid;

    static int enemyCounter;
    static ArrayList<Enemy> enemies = new ArrayList<>();

    public Enemy(int positionX, int positionY, Grid grid){
        setPositions(positionX, positionY);
        this.grid = grid;
        enemyCounter++;
        enemies.add(this);
        setHealth(20);
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
    static void drawEnemies(){
        for (Enemy enemy : enemies) {
            enemy.drawEntity(grid.getCellList());
        }
    }

    public void checkForPlayer(Player player){
        if (this.getPositionX() == player.getPositionX() && this.getPositionY() == player.getPositionY()){
            attack(player);
            System.out.println("Enemy attacked you! Your health is now: " + player.getHealth());
        }
    }
}
