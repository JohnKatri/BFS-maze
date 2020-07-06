package main.java.com.mazesolver;

import java.util.*;

public class BFSSolver {

    private TransformMaze transformMaze;
    private final static int[][] DIRECTIONS = new int[4][];
    private final static int[] UP = new int[]{0, - 1};
    private final static int[] DOWN = new int[]{0, 1};
    private final static int[] LEFT = new int[]{-1, 0};
    private final static int[] RIGHT = new int[]{1, 0};
    private Integer aa;
    {
        DIRECTIONS[0] = DOWN;
        DIRECTIONS[1] = UP;
        DIRECTIONS[2] = LEFT;
        DIRECTIONS[3] = RIGHT;
    }



    BFSSolver(TransformMaze transformMaze) {
        this.transformMaze = transformMaze;
    }

    List<Coordinates> BFS() {
        Coordinates start = transformMaze.getStart();

        LinkedList<Coordinates> cordList = new LinkedList<>();
        cordList.add(start);

        int counter = 0;
        while (cordList.size() > 0) {
            Coordinates current = cordList.remove();
            if(transformMaze.isVisited(current)) {
                continue;
            }

            if (transformMaze.isWall(current)) {
                transformMaze.setVisited(current);
                continue;
            }

            if (transformMaze.isEnd(current)) {
                return createPath(current);
            }
            exploreMaze(cordList, current);
            counter++;
        }
        return Collections.emptyList();
    }

    List<Coordinates> createPath(Coordinates coordinates){
        List<Coordinates> correctPath = new ArrayList<>();

        Coordinates current = coordinates;

        while (current.getParent() != null) {
            correctPath.add(current);
            current = current.getParent();
        }

        return correctPath;
    }

    void printSolution(List<Coordinates> correctPath){
        for (Coordinates path: correctPath) {
            this.transformMaze.getMaze()[path.getY()][path.getX()] = this.transformMaze.getMaze()[path.getY()][path.getX()].equals(" ") ? "+" : this.transformMaze.getMaze()[path.getY()][path.getX()];
        }
        Arrays.stream(this.transformMaze.getMaze()).forEach( row -> System.out.println(Arrays.toString(row).replaceAll(",", "")));
    }




    private void exploreMaze(LinkedList<Coordinates> correctPath, Coordinates currentCoordinate) {
        for (int[] direction :DIRECTIONS) {
            correctPath.add(new Coordinates(currentCoordinate.getX() + direction[0],
                    currentCoordinate.getY() + direction[1],
                    currentCoordinate));
        }
        transformMaze.setVisited(currentCoordinate);
    }


}
