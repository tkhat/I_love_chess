package com.example.ilovechess

import com.example.ilovechess.chess.*
import java.lang.IllegalArgumentException


object ChessBoardHelper {


    var matrix = mutableListOf(
        mutableListOf(
            Spot(Rook(PieceColor.WHITE, Coordinate(0,0)), 1),
            Spot(Knight(PieceColor.WHITE, Coordinate(0,1)), 2),
            Spot(Bishop(PieceColor.WHITE, Coordinate(0,2)), 3),
            Spot(Queen(PieceColor.WHITE, Coordinate(0,3)), 4),
            Spot(King(PieceColor.WHITE, Coordinate(0,4)), 5),
            Spot(Bishop(PieceColor.WHITE, Coordinate(0,5)), 6),
            Spot(Knight(PieceColor.WHITE, Coordinate(0,6)), 7),
            Spot(Rook(PieceColor.WHITE, Coordinate(0,7)), 8)
        ),
        mutableListOf(
            Spot(Pawn(PieceColor.WHITE, Coordinate(1,0)), 9),
            Spot(Pawn(PieceColor.WHITE, Coordinate(1,1)), 10),
            Spot(Pawn(PieceColor.WHITE, Coordinate(1,2)), 11),
            Spot(Pawn(PieceColor.WHITE, Coordinate(1,3)), 12),
            Spot(Pawn(PieceColor.WHITE, Coordinate(1,4)), 13),
            Spot(Pawn(PieceColor.WHITE, Coordinate(1,5)), 14),
            Spot(Pawn(PieceColor.WHITE, Coordinate(1,6)), 15),
            Spot(Pawn(PieceColor.WHITE, Coordinate(1,7)), 16)
        ),
        mutableListOf(
            Spot(null, 17),
            Spot(null, 18),
            Spot(null, 19),
            Spot(null, 20),
            Spot(null, 21),
            Spot(null, 22),
            Spot(null, 23),
            Spot(null, 24)
        ),
        mutableListOf(
            Spot(null, 25),
            Spot(null, 26),
            Spot(null, 27),
            Spot(null, 28),
            Spot(null, 29),
            Spot(null, 30),
            Spot(null, 31),
            Spot(null, 32)
        ),
        mutableListOf(
            Spot(null, 33),
            Spot(null, 34),
            Spot(null, 35),
            Spot(null, 36),
            Spot(null, 37),
            Spot(null, 38),
            Spot(null, 39),
            Spot(null, 40)
        ),
        mutableListOf(
            Spot(null,41),
            Spot(null,42),
            Spot(null, 43),
            Spot(null,44),
            Spot(null, 45),
            Spot(null, 46),
            Spot(null, 47),
            Spot(null   , 48)
        ),
        mutableListOf(
            Spot(Pawn(PieceColor.BLACK, Coordinate(6,0)), 49),
            Spot(Pawn(PieceColor.BLACK, Coordinate(6,1)), 50),
            Spot(Pawn(PieceColor.BLACK, Coordinate(6,2)), 51),
            Spot(Pawn(PieceColor.BLACK, Coordinate(6,3)), 52),
            Spot(Pawn(PieceColor.BLACK, Coordinate(6,4)), 53),
            Spot(Pawn(PieceColor.BLACK, Coordinate(6,5)), 54),
            Spot(Pawn(PieceColor.BLACK, Coordinate(6,6)), 55),
            Spot(Pawn(PieceColor.BLACK, Coordinate(6,7)), 56)
        ),
        mutableListOf(
            Spot(Rook(PieceColor.BLACK, Coordinate(7,0)), 57),
            Spot(Knight(PieceColor.BLACK, Coordinate(7,1)), 58),
            Spot(Bishop(PieceColor.BLACK, Coordinate(7,2)), 59),
            Spot(Queen(PieceColor.BLACK, Coordinate(7,3)), 60),
            Spot(King(PieceColor.BLACK, Coordinate(7,4)), 61),
            Spot(Bishop(PieceColor.BLACK, Coordinate(7,5)), 62),
            Spot(Knight(PieceColor.BLACK, Coordinate(7,6)), 63),
            Spot(Rook(PieceColor.BLACK, Coordinate(7,7)), 64)
        ),
    )

    fun positionHelper(position: Int): Int {
        for (i in 0..7) {
            for (j in 0..7) {
                if (matrix[i][j].position == position) {
                    return i
                }
            }
        }
        return throw IllegalArgumentException("Item not found Exc Temo!!!!")
    }

    fun spotNumberHelper(position: Int): Int? {
        for (i in 7 downTo 0) {
            if (matrix[i][0].position == position) {
                return i + 1
            }
        }
        return null
    }
}


data class Spot(
    var piece: Piece?,
    var position: Int,
    var spotState: SpotState? = null
)



enum class SpotState {
    OWNCLICK,
    AIMCLICK,
    SPOTCLICK
}














