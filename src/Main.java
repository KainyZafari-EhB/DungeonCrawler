void main() {
    boolean running;
    Scanner scanner = new Scanner(System.in);
    Player player = new Player(5, 6);
    Grid grid = new Grid(12, 12, player);

    grid.initializeGrid();
    grid.randomStart();
    grid.printGrid();

    while(true){
        System.out.println();
        System.out.println("Welcome - Press WASD to move");

        String input = scanner.next();
        grid.handleInput(input);
    }
}
