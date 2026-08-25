import java.util.Scanner;

void main() {
    boolean running;
    Scanner scanner = new Scanner(System.in);
    Player player = new Player(5, 6);
    Grid grid = new Grid(12, 12, player);
    Enemy enemy = new Enemy(3, 4, grid);

    grid.initializeGrid();
    grid.randomStart();
    enemy.spawnEnemies(5);

    enemy.attack(player);

    grid.printGrid();
    while(true){
        System.out.println();
        System.out.println("Welcome - Press WASD to move");
        System.out.println("Player's position: " + player.getPositionX() + "|" + player.getPositionY());
        System.out.println();

        String input = scanner.next();
        grid.handleInput(input);
    }
}
