package com.krizotto.day12;

public class Ship {
    private static final char NORTH = 'N';
    private static final char SOUTH = 'S';
    private static final char EAST = 'E';
    private static final char WEST = 'W';
    private static final char RIGHT_TURN = 'R';
    private static final char LEFT_TURN = 'L';
    private static final char FORWARD = 'F';
    private int x;
    private int y;
    private int angle;
    private int waypointX;
    private int waypointY;

    public Ship() {
        this.x = 0;
        this.y = 0;
        this.angle = 90;
        this.waypointX = 10;
        this.waypointY = 1;
    }

    // related to part 1
    private void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    private void turn(char side, int angle) {
        if (side == RIGHT_TURN) {
            this.angle += angle;
            if (this.angle >= 360) {
                this.angle = this.angle % 360;
            }
        } else if (side == LEFT_TURN) {
            this.angle -= angle;
            if (this.angle < 0) {
                this.angle = 360 + this.angle % 360;
            }
        }
    }

    public void processMovement(String s) {
        char move = s.charAt(0);
        int value = Integer.parseInt(s.substring(1));

        switch (move) {
            case NORTH:
                this.move(value, 0);
                break;
            case SOUTH:
                this.move(-value, 0);
                break;
            case EAST:
                this.move(0, value);
                break;
            case WEST:
                this.move(0, -value);
                break;
            case RIGHT_TURN:
                this.turn(RIGHT_TURN, value);
                break;
            case LEFT_TURN:
                this.turn(LEFT_TURN, value);
                break;
            case FORWARD:
                this.moveForward(value);
                break;
            default:
                System.out.println("inappropiate movement");
                break;
        }
    }

    private void moveForward(int value) {
        switch (this.angle) {
            case 0:
                this.move(value, 0);
                break;
            case 90:
                this.move(0, value);
                break;
            case 180:
                this.move(-value, 0);
                break;
            case 270:
                this.move(0, -value);
                break;
            default:
                System.out.println("Incorrect angle");
                break;
        }
    }

    //related to part 2:

    private void moveShip(int value) {
        this.move(value * this.waypointX, value * this.waypointY);
    }

    private void moveWaypoint(int x, int y) {
        this.waypointX += x;
        this.waypointY += y;
    }

    public void processMovement2(String s) {
        char move = s.charAt(0);
        int value = Integer.parseInt(s.substring(1));

        switch (move) {
            case NORTH:
                this.moveWaypoint(0, value);
                break;
            case SOUTH:
                this.moveWaypoint(0, -value);
                break;
            case EAST:
                this.moveWaypoint(value, 0);
                break;
            case WEST:
                this.moveWaypoint(-value, 0);
                break;
            case RIGHT_TURN:
                this.turnWaypoint(RIGHT_TURN, value);
                break;
            case LEFT_TURN:
                this.turnWaypoint(LEFT_TURN, value);
                break;
            case FORWARD:
                this.moveShip(value);
                break;
            default:
                System.out.println("inappropiate movement");
                break;
        }
    }

    private void turnWaypoint(char side, int value) {
        //assume that every turn is clockwise
        int ang = value;

        //if counter-clockwise
        if (side == LEFT_TURN) {
            ang = 360 - value;
        }

        int tempX = this.waypointX;
        int tempY = this.waypointY;

        switch (ang) {
            case 0:
                break;
            case 90:
                this.waypointX = tempY;
                this.waypointY = -tempX;
                break;
            case 180:
                this.waypointX = -tempX;
                this.waypointY = -tempY;
                break;
            case 270:
                this.waypointX = -tempY;
                this.waypointY = tempX;
                break;
            default:
                System.out.println("Invalid turn ang");
                break;
        }
    }

    //printing answer
    public int getManhattanDistance() {
        return Math.abs(this.x) + Math.abs(this.y);
    }

}
