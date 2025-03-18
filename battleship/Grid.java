public class Grid {
    public static final int SHIP = 1 << 0;
    public static final int HIT = 1 << 1;

    private int[][] grid;

    public Grid(int size) {
        grid = new int[size][size];
    }

    public int get(int x, int y) {
        return grid[x][y];
    }

    public void set(int x, int y, int value) {
        grid[x][y] = value;
    }

    public int size() {
        return grid.length;
    }

    public boolean inBounds(int x, int y) {
        return x >= 0 && x < size() && y >= 0 && y < size();
    }
}
