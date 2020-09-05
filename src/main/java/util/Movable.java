package util;

public interface Movable<N> {
    boolean hasNextX();

    boolean hasNextY();

    boolean hasPreviousX();

    boolean hasPreviousY();

    N nextX();

    N nextY();

    N previousX();

    N previousY();
}
