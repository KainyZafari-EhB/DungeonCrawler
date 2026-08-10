void main() {
    Player player = new Player(5, 6);
    Grid grid = new Grid(3, 3);

    System.out.println("Player is at: " + player.getPositionX() + ", " + player.getPositionY());

    player.setPositionX(3);
    player.setPositionY(3);

    System.out.println("Player is at: " + player.getPositionX() + ", " + player.getPositionY());

    grid.fillGrid();
    grid.printGrid();
}
