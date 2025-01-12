import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static final int NUM_BEES = 15;
    public static final int BEEHIVE_SIZE = 15;

    private static Scanner s;

    public static void main(String[] args) throws FileNotFoundException {
        s = new Scanner(new File(args[0]));
        s.useDelimiter(",|\r\n");
        s.nextInt();

        int w = s.nextInt();
        int h = s.nextInt();
        int d = s.nextInt();

        VoxelGrid grid = new VoxelGrid(w, h, d);
        int[][] starts = new int[NUM_BEES][w * h * d];

        for (int i = 0; i < BEEHIVE_SIZE; i++) {
            grid.setVoxel(getCoords(), VoxelGrid.Voxel.GOAL);
        }

        for (int i = 0; i < NUM_BEES; i++) {
            starts[i] = getCoords();
            grid.setVoxel(starts[i], VoxelGrid.Voxel.START);
        }

        s.close();

        grid.addObstacles();
        grid.bfs();

        int totalCost = 0;
        for (int i = 0; i < NUM_BEES; i++) {
            int[] pathInfo = grid.getPathInfo(starts[i]);
            System.out.print("Bee " + i + ": " + pathInfo[3] + " moves to ");
            printCoords(pathInfo);
            totalCost += pathInfo[3];
        }
        System.out.println("Total moves: " + totalCost);
    }

    private static int[] getCoords() {
        int x = s.nextInt();
        int y = s.nextInt();
        int z = s.nextInt();
        return new int[] { x, y, z };
    }

    private static void printCoords(int[] coords) {
        System.out.println(coords[0] + " " + coords[1] + " " + coords[2]);
    }
}
