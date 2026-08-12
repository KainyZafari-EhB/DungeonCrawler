public class Grid {
    int width = 1;
    int height = 1;

    char[][] cellList;


    public Grid(){
        this(1, 1);
    }

    public Grid(int width, int height){
        cellList = new char[width][height];
        this.width = width;
        this.height = height;
    }

    void fillGrid(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cellList[i][j] = '.';
            }
        }
    }

    //TODO: prints only one row of .'s;
    void printGrid(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(cellList[i][j]);
            }
            System.out.println();
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
    public void setMeasurements(int width, int height){setWidth(width); setHeight(height);}
}
