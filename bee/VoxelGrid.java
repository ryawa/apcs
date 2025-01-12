import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VoxelGrid {
    public static final double OBSTACLE_RATIO = 0.3;

    public enum Voxel {
        OBSTACLE, START, GOAL
    };

    private int w;
    private int h;
    private int d;
    private Voxel[] grid;
    private int[] next;
    private List<Integer> goals = new ArrayList<>();

    public VoxelGrid(int w, int h, int d) {
        this.w = w;
        this.h = h;
        this.d = d;
        grid = new Voxel[w * h * d];
        next = new int[w * h * d];
        for (int i = 0; i < next.length; i++) {
            next[i] = -1;
        }
    }

    public void setVoxel(int[] coords, Voxel v) {
        int index = coordsToIndex(coords);
        if (v == Voxel.GOAL) {
            goals.add(index);
        }
        grid[index] = v;
    }

    public void addObstacles() {
        int numObstacles = (int) (w * h * d * OBSTACLE_RATIO);
        while (numObstacles > 0) {
            int[] coords = {
                    (int) (Math.random() * w),
                    (int) (Math.random() * h),
                    (int) (Math.random() * d)
            };
            if (grid[coordsToIndex(coords)] == null) {
                setVoxel(coords, Voxel.OBSTACLE);
                numObstacles--;
            }
        }
    }

    private int coordsToIndex(int[] coords) {
        // z: slice
        // y: position along slice
        // x: position along line
        return coords[2] * (w * h) + coords[1] * w + coords[0];
    }

    private int[] indexToCoords(int index) {
        int x = index % w;
        index /= w;
        int y = index % h;
        index /= h;
        int z = index;
        return new int[] { x, y, z };
    }

    private boolean inBounds(int index, int dx, int dy, int dz) {
        int[] coords = indexToCoords(index);
        boolean xBound = coords[0] + dx >= 0 && coords[0] + dx < w;
        boolean yBound = coords[1] + dy >= 0 && coords[1] + dy < h;
        boolean zBound = coords[2] + dz >= 0 && coords[2] + dz < d;
        return xBound && yBound && zBound;
    }

    private List<Integer> neighbors(int index) {
        List<Integer> neighbors = new ArrayList<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    // Cannot stay in place
                    if (dx == 0 && dy == 0 && dz == 0) {
                        continue;
                    }
                    // Cannot move diagonal in all 3 axes
                    if (dx != 0 && dy != 0 && dz != 0) {
                        continue;
                    }
                    // Cannot move out of bounds
                    if (!inBounds(index, dx, dy, dz)) {
                        continue;
                    }

                    int offset = coordsToIndex(new int[] { dx, dy, dz });
                    // Cannot move to obstacle
                    if (grid[index + offset] == Voxel.OBSTACLE) {
                        continue;
                    }

                    neighbors.add(index + offset);
                }
            }
        }
        return neighbors;
    }

    public void bfs() {
        Queue<Integer> open = new LinkedList<>();
        for (int goal : goals) {
            for (int neighbor : neighbors(goal)) {
                if (!open.contains(neighbor)) {
                    open.add(neighbor);
                    next[neighbor] = goal;
                }
            }
        }

        while (!open.isEmpty()) {
            int curr = open.remove();
            for (int neighbor : neighbors(curr)) {
                if (next[neighbor] == -1) {
                    open.add(neighbor);
                    next[neighbor] = curr;
                }
            }
        }
    }

    public int[] getPathInfo(int[] startCoords) {
        int curr = coordsToIndex(startCoords);
        int dist = 0;
        while (grid[curr] != Voxel.GOAL) {
            curr = next[curr];
            dist++;
        }
        int[] coords = indexToCoords(curr);
        return new int[] { coords[0], coords[1], coords[2], dist };
    }
}
