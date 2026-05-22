import java.util.*;

public class PathFinder {
    int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public List<PlayerCord> findPath(World world, PlayerCord start, PlayerCord end) {

        Queue<PlayerCord> queue = new LinkedList<>();
        Map<PlayerCord, PlayerCord> parent = new HashMap<>();
        Set<PlayerCord> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            PlayerCord current = queue.poll();

            if (current.equals(end)) break;

            for (int[] dir : directions) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                if (!isValid(world, newX, newY)) continue;

                PlayerCord next = new PlayerCord(newX, newY, world);

                if (visited.contains(next)) continue;

                queue.add(next);
                visited.add(next);
                parent.put(next, current);
            }
        }

        List<PlayerCord> path = new ArrayList<>();
        PlayerCord step = end;

        while (step != null && parent.containsKey(step)) {
            path.add(step);
            step = parent.get(step);
        }

        Collections.reverse(path);
        return path;
    }

    boolean isValid(World world, int x, int y) {
        if (x < 0 || y < 0 || x >= world.mapLenX || y >= world.mapLenY)
            return false;

        return world.map[y][x] != '#';
    }
}
