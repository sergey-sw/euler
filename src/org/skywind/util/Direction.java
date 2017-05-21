package org.skywind.util;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 21/05/2017.
 */
public enum Direction {
    RIGHT(1, 0) {
        @Override
        public boolean isVertical() {
            return false;
        }
    },
    DOWN(0, 1) {
        @Override
        public boolean isHorizontal() {
            return false;
        }
    },
    LEFT(-1, 0) {
        @Override
        public boolean isVertical() {
            return false;
        }
    },
    UP(0, -1) {
        @Override
        public boolean isHorizontal() {
            return false;
        }
    };

    public final int dx;
    public final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static Direction clockWise(Direction d) {
        switch (d) {
            case UP: return RIGHT;
            case RIGHT: return DOWN;
            case DOWN: return LEFT;
            case LEFT: return UP;
            default:throw new IllegalArgumentException("Wrong direction: " + d);
        }
    }

    public boolean isHorizontal() {
        return true;
    }

    public boolean isVertical() {
        return true;
    }
}
