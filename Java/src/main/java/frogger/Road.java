package frogger;

/**
 * Refactor Task 1.
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Road {
    private final boolean[] occupied;

    public Road(boolean[] occupied) {
        // this.occupied = occupied;
        this.occupied = occupied.clone();
    }

    // public boolean[] getOccupied() {
    //     return this.occupied;
    // }
    public boolean isOccupied(int position) {
        return occupied[position];
    }

    public boolean isValidPosition(int position) {
        return position >= 0 && position < occupied.length;
    }

    public boolean isMoveValid(int position) {
        return isValidPosition(position) && !isOccupied(position);
    }
}
