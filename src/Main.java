import java.util.Scanner;

    //TODO: win condition, lose condition, enemy AI and escape system.
void main() {
    boolean running;
    Scanner scanner = new Scanner(System.in);
    Player player = new Player(5, 6);

    Item sword = new Item("Sword", 10, Item.Effect.FIRE);
    Item bow = new Item("Bow", 5);
    Item dagger = new Item("Dagger", 3);
    Item shield = new Item("Shield", 1);

    Grid grid = new Grid(12, 12, player, sword);
    Enemy enemy = new Enemy(3, 4, grid);

    sword.chooseRandomItemPosition(grid);
    bow.chooseRandomItemPosition(grid);
    dagger.chooseRandomItemPosition(grid);
    shield.chooseRandomItemPosition(grid);

    grid.initializeGrid();
    grid.randomStart();

    enemy.spawnEnemies(5);
    enemy.checkForPlayer(player);

    //Debug for whats happening in effects
    player.items.add(sword);
    player.attack(enemy);

    grid.printGrid();

    while(true){
        player.checkForItem(sword,grid);
        System.out.println();
        System.out.println("Welcome - Press WASD to move");
        System.out.println("Player's position: " + player.getPositionX() + "|" + player.getPositionY());
        System.out.println("Player's health: " + player.getHealth() + " | Player's damage: " + player.getDamage());
        System.out.println("P = Player, X = Enemy, $ = Item");
        System.out.println();

        String input = scanner.next();
        grid.handleInput(input);
    }
}
