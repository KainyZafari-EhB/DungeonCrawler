import java.util.Objects;
import java.util.Random;

public class Grid {
    int width;
    int height;

    char[][] cellList;

    Player player;


    public Grid(int width, int height,Player player){
        cellList = new char[width][height];
        this.width = width;
        this.height = height;
        this.player = player;
    }

    void initializeGrid(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cellList[i][j] = '.';
            }
        }
    }

     void printGrid(){
        System.out.println();
        System.out.println("---- Grid ----");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(cellList[i][j]);
            }
            System.out.println();
        }
    }

     void randomStart(){
        Random random = new Random();
        int randomWidth = random.nextInt(0, width);
        int randomHeight = random.nextInt(0, height);

        player.setPositions(randomWidth, randomHeight);

        player.drawEntity(cellList);
    }

//    void drawPlayer(){
//        int playerX = player.getPositionX();
//        int playerY = player.getPositionY();
//        cellList[playerX][playerY] = 'X';
//    }
//    void drawPlayer(int valueX, int valueY){
//        player.setPositions(valueX, valueY);
//        cellList[valueX][valueY] = 'X';
//    }

    void handleInput(String direction){
        int playerY = player.getPositionY();
        int playerX = player.getPositionX();

        int newX = playerX;
        int newY = playerY;

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
                System.exit(0);
            }
            if (newX >= 0 && newX < height && newY >= 0 && newY < width){
                player.setPositions(newX, newY);
            }
            else {
                System.out.println("There is a wall in that direction.");
            }

        initializeGrid();
        player.drawEntity(cellList);
        printGrid();
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
    public void setMeasurements(int width, int height){setWidth(width); setHeight(height);}
}

