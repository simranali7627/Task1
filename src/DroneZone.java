import java.util.Scanner;

public class DroneZone {
    int [][] grid;
    static int rows;
    static int col;

    public static void main(String[] args) {
        int [][] grid = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        // get the target position from the user
        Scanner input = new Scanner(System.in);
        int targetPositionX = input.nextInt();
        int targetPositionY = input.nextInt();
        System.out.println("Finding the target : ");
        findPath(grid, targetPositionX, targetPositionY);

    }

    static boolean isValid(int x, int y){
        if (x < 0 || x == rows || y < 0 || y == col){
            return false;
        }
        return true;
    }

    static int[] moveDrone(Drone drone, int[] target){
        int x = drone.posX;
        int y = drone.posY;
        int targetX = target[0];
        int targetY = target[1];
        if(x < targetX) x++;
        else if(x > targetX) x--;

        if(y < targetY) y++;
        else if(y > targetY) y--;
//        return new int[]{x, y};
//        int[][] dir = {
//                {0, 1},
//                {0, -1},
//                {1, 0},
//                {-1, 0}
//        };
//        for(int i = 0; i < dir.length; i++){
//
//            if(isValid(x + dir[i][0], y + dir[i][1])){
//                x +=  dir[i][0];
//                y += dir[i][1];
//                break;
//            }
//
//
//        }
        return new int[]{x, y};
    }

    static void findPath(int[][] grid, int targetPositionX, int targetPositionY) {
        rows = grid.length;
        col = grid[0].length;
        Drone[] drones = {
                new Drone(1, 0),
                new Drone(3, 4),
                new Drone(2, 0),
                new Drone(4, 0)
        };
        for(Drone d : drones){
            while(true){
                int[] currPosition = moveDrone(d, new int[]{targetPositionX, targetPositionY});
                if(isValid(currPosition[0], currPosition[1])){
                    System.out.println("Position " + d +  " -> " + currPosition[0] + " " + currPosition[1]);
                    if(currPosition[0] == targetPositionX && currPosition[1] == targetPositionY){
                        d.posX = currPosition[0];
                        d.posY = currPosition[1];
                        System.out.println("Reached " + d);
                        return;
                    }
                    d.posX = currPosition[0];
                    d.posY = currPosition[1];
                }
                else break;
            }
        }
    }
}

