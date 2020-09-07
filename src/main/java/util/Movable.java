package util;

public interface Movable<N> {
    boolean hasNextJ();

    boolean hasNextI();

    boolean hasPreviousJ();

    boolean hasPreviousI();

    //[0][0] --> [0][1]
    N nextJ();

    //[0][0] --> [1][0]
    N nextI();

    //[1][1] --> [1][0]
    N previousJ();

    //[1][1] --> [0][1]
    N previousI();
}
