import java.util.Objects;
import java.util.Random;

//TODO: fix input system lagging behind input.

public class Grid {
    private int width;
    private int height;

    private char[][] cellList;

    Player player;
    Item item;


    public Grid(int width, int height,Player player, Item item){
        cellList = new char[width][height];
        this.width = width;
        this.height = height;
        this.player = player;
        this.item = item;
    }

    ///Initializes the grid by making all the symbols '.'
    void initializeGrid(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cellList[i][j] = '.';
            }
        }
    }

    ///Prints the entire grid.
     void printGrid(){
        initializeGrid();
        player.drawEntity(cellList);
        Enemy.drawEnemies();
        item.drawItem(cellList, player);
        System.out.println();
        System.out.println("---- Grid ----");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(cellList[i][j]);
            }
            System.out.println();
        }
    }

    ///Player starts at a random X and Y level.
     void randomStart(){
        Random random = new Random();
        int randomWidth = random.nextInt(0, width);
        int randomHeight = random.nextInt(0, height);

        player.setPositions(randomWidth, randomHeight);

        player.drawEntity(cellList);
    }

    ///Handles input from user to player movement.
    void handleInput(String direction){
        int playerY = player.getPositionY();
        int playerX = player.getPositionX();

        int newX = playerX;
        int newY = playerY;

        printGrid();

            if (Objects.equals(direction, "w") || Objects.equals(direction, "W")) {
                newX = playerX - 1;
            } else if (Objects.equals(direction, "s") || Objects.equals(direction, "S")) {
                newX = playerX + 1;
            } else if (Objects.equals(direction, "a") || Objects.equals(direction, "A")) {
                newY = playerY - 1;
            } else if (Objects.equals(direction, "d") || Objects.equals(direction, "D")) {
                newY = playerY + 1;
            }
            else if (Objects.equals(direction, "exit") || Objects.equals(direction, "EXIT")) {
                System.out.println("Goodbye.");
                System.exit(0);
            }
            else if (Objects.equals(direction, "attack") || Objects.equals(direction, "ATTACK")){
                for (Enemy enemy : Enemy.enemies) {
                    if (enemy.getPositionX() == player.getPositionX() && enemy.getPositionY() == player.getPositionY()) {
                        player.attack(enemy);
                        System.out.println("You attacked the enemy! Enemy's health is now: " + enemy.getHealth());
                        if (enemy.getHealth() <= 0) {
                            System.out.println("You killed the enemy!");
                            Enemy.enemies.remove(enemy);
                            break;
                        }
                    }
                }
            }
            else {
                System.out.println("Invalid input. Please use WASD to move or type 'exit' to quit.");
            }
            if (newX >= 0 && newX < height && newY >= 0 && newY < width){
                player.setPositions(newX, newY);
            }
            else {
                System.out.println("There is a wall in that direction.");
            }
    }



    //getter height
    public int getHeight() {
        return height;
    }
    //setter height
    public void setHeight(int height) {
        this.height = height;
    }
    //getter width
    public int getWidth() {
        return width;
    }
    //setter width
    public void setWidth(int width) {
        this.width = width;
    }

    ///Sets measurements for the grid
    public void setMeasurements(int width, int height){setWidth(width); setHeight(height);}

    public char[][] getCellList() {
        return cellList;
    }
}

