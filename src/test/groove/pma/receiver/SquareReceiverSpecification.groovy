package pma.receiver

import pma.bean.Square
import spock.lang.Specification

class SquareReceiverSpecification extends Specification {

    def receiver = new SquareReceiver()

    def "create new square"() {
        when:
            receiver.addSquare(1, 10)
        then:
            notThrown(NullPointerException)
            receiver.getSquares().size() == 1
            Square square = receiver.getSquares().get(1)
            square != null
            square.getLength() == 10
    }

    def "remove square"() {
        when:
            receiver.addSquare(1, 10)
            receiver.removeSquare(1)
        then:
            notThrown(NullPointerException)
            receiver.getSquares().isEmpty()
    }

    def "move square"() {
        when:
            receiver.addSquare(2, 20)
            receiver.moveSquare(2, 10, 10)
        then:
            Square square = receiver.getSquares().get(2)
            square.getX() == 110
            square.getY() == 110
    }

    def "scale square"() {
        when:
            receiver.addSquare(3, 100)
            receiver.scaleSquare(3, 2)
        then:
            Square square = receiver.getSquares().get(3)
            square.getLength() == 200
    }
}
