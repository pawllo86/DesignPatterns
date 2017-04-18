package pma.receiver;

import pma.bean.Square;

import java.util.HashMap;
import java.util.Map;

public class SquareReceiver {

    private Map<Integer, Square> squares = new HashMap<>();

    public void addSquare(int number, int length) {
        squares.put(number, new Square(number, length));
    }

    public void removeSquare(int number) {
        squares.remove(number);
    }

    public void moveSquare(int number, int x, int y) {
        if (squares.containsKey(number)) {
            Square square = squares.get(number);
            square.setX(square.getX() + x);
            square.setY(square.getY() + y);
        }
    }

    public void scaleSquare(int number, int factor) {
        if (squares.containsKey(number)) {
            Square square = squares.get(number);
            square.setLength(square.getLength() * factor);
        }
    }

    public void printSquares() {
        squares.forEach((number, square) ->
                System.out.format("Square %s: [%s, %s] - side length %s \n", number, square.getX(), square.getY(), square.getLength()));
    }

}
