package main.java.com.mazesolver;

import java.io.*;
import java.util.Arrays;

class TransformMaze {

    private final File file;
    private String[][] maze;
    private Coordinates start;
    private Coordinates end;
    private boolean[][] visited;


    TransformMaze(File file) {
        this.file = file;
    }

    void transform() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.file));
            String[] mazeSize = br.readLine().split(" ");

            this.start = new Coordinates(
                    br.readLine()
                    .split(" ")
            );

            this.end = new Coordinates(
                    br.readLine()
                    .split(" ")
            );

            initializeSize(mazeSize);
            initializeMazeRows(br);
            this.initializeCoordinate(start, this.maze, "S");
            this.initializeCoordinate(end, this.maze, "E");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    private void initializeMazeRows(BufferedReader br) {
        String line;
        int counter = 0;

        try {
            while ((line = br.readLine()) != null && line.trim().length() > 0) {
                this.maze[counter] = line
                        .replaceAll("1", "#")
                        .replaceAll(" ", "")
                        .replaceAll("0", " ")
                        .split("");
                counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean isEnd(Coordinates coordinates){
        return this.maze[coordinates.getY()][coordinates.getX()].equals("E");

    }

    boolean isWall(Coordinates coordinates){
        return this.maze[coordinates.getY()][coordinates.getX()].equals("#");
    }

    Coordinates getStart() {
        return start;
    }

    Coordinates getEnd() {
        return end;
    }

    String[][] getMaze() {
        return maze;
    }

    boolean isVisited(Coordinates coordinates){

        return this.visited[coordinates.getY()][coordinates.getX()];
    }

    void setVisited(Coordinates coordinates) {
        this.visited[coordinates.getY()][coordinates.getX()] = true;
    }

    void printMaze() {
        Arrays.stream(this.maze).forEach( row -> System.out.println(Arrays.toString(row).replaceAll(",", "")));
    }

    private void initializeSize(String[] mazeSize) {
        this.maze = new String[Integer.parseInt(mazeSize[1])][Integer.parseInt(mazeSize[0])];
        this.visited= new boolean [Integer.parseInt(mazeSize[1])][Integer.parseInt(mazeSize[0])];
    }

    void initializeCoordinate(Coordinates coordinates, String[][] maze, String symbol) {
        maze[coordinates.getX()][coordinates.getY()] = symbol;
    }
}
