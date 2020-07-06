package main.java.com.mazesolver;

import java.io.*;
import java.util.List;

public class MazeCreator {

    public static void main(String[] args) {

        File file = new File("src/main/java/com/mazesolver/small.txt");
        TransformMaze transformMaze = new TransformMaze(file);
        transformMaze.transform();
        transformMaze.printMaze();
        BFSSolver BFSSolver = new BFSSolver(transformMaze);

        List<Coordinates> solution = BFSSolver.BFS();
        if (!solution.isEmpty()) {
            BFSSolver.printSolution(solution);
        } else {
            System.out.println("No Path found");
        }


    }
}
