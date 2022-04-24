package com.example.ilovechess.chess

import com.example.ilovechess.ChessBoardHelper
import com.example.ilovechess.SpotState

abstract class Piece {
    abstract val pieceColor: PieceColor
    abstract var coordinates: Coordinate

    abstract fun updatePositions(position: Coordinate)
    abstract fun defineDirections(): List<Coordinate>



}

class Rook(
    override val pieceColor: PieceColor,
    override var coordinates: Coordinate,
) : Piece() {


    override fun updatePositions(position: Coordinate) {
        TODO("Not yet implemented")
    }

    override fun defineDirections(): List<Coordinate> {
        TODO("Not yet implemented")
    }




}

class Queen(
    override val pieceColor: PieceColor,
    override var coordinates: Coordinate,


    ) : Piece() {
    override fun updatePositions(position: Coordinate) {
        TODO("Not yet implemented")
    }

    override fun defineDirections(): List<Coordinate> {
        TODO("Not yet implemented")
    }



}

enum class PieceColor {
    WHITE,
    BLACK
}


class Pawn(
    override val pieceColor: PieceColor,
    override var coordinates: Coordinate,


    ) : Piece() {


    override fun updatePositions(position: Coordinate) {
        coordinates = position
    }

    override fun defineDirections(): List<Coordinate> {
        val mutableList = mutableListOf<Coordinate>()
        when (pieceColor) {
            PieceColor.WHITE -> {
                if (coordinates.y != 7) {
                    if (ChessBoardHelper.matrix[coordinates.x+1][coordinates.y+1].piece?.pieceColor != null && ChessBoardHelper.matrix[coordinates.x+1][coordinates.y+1].piece?.pieceColor != PieceColor.WHITE) {
                        ChessBoardHelper.matrix[coordinates.x+1][coordinates.y+1].spotState = SpotState.AIMCLICK
                        mutableList.add(Coordinate(coordinates.x+1,coordinates.y+1))
                    }
                }
                if (coordinates.y != 0) {
                    if (ChessBoardHelper.matrix[coordinates.x+1][coordinates.y-1].piece?.pieceColor != null && ChessBoardHelper.matrix[coordinates.x+1][coordinates.y-1].piece?.pieceColor != PieceColor.WHITE) {
                        mutableList.add(Coordinate(coordinates.x+1,coordinates.y-1))
                        ChessBoardHelper.matrix[coordinates.x+1][coordinates.y-1].spotState = SpotState.AIMCLICK
                    }
                }
                if (ChessBoardHelper.matrix[coordinates.x+1][coordinates.y].piece == null) {
                    mutableList.add(Coordinate(coordinates.x+1,coordinates.y))
                    ChessBoardHelper.matrix[coordinates.x+1][coordinates.y].spotState = SpotState.SPOTCLICK
                    if (coordinates.x == 1) {
                        if (ChessBoardHelper.matrix[coordinates.x+2][coordinates.y].piece?.pieceColor ==  null){
                            ChessBoardHelper.matrix[coordinates.x+2][coordinates.y].spotState = SpotState.SPOTCLICK
                            mutableList.add(Coordinate(coordinates.x+2,coordinates.y))
                        }
                    }
                }
            }
            PieceColor.BLACK -> {
                if (coordinates.y != 7) {
                    if (ChessBoardHelper.matrix[coordinates.x-1][coordinates.y+1].piece?.pieceColor != null && ChessBoardHelper.matrix[coordinates.x-1][coordinates.y+1].piece?.pieceColor != PieceColor.BLACK) {
                        ChessBoardHelper.matrix[coordinates.x-1][coordinates.y+1].spotState = SpotState.AIMCLICK
                        mutableList.add(Coordinate(coordinates.x-1,coordinates.y+1))
                    }
                }
                if (coordinates.y != 0) {
                    if (ChessBoardHelper.matrix[coordinates.x-1][coordinates.y-1].piece?.pieceColor != null && ChessBoardHelper.matrix[coordinates.x-1][coordinates.y-1].piece?.pieceColor != PieceColor.BLACK) {
                        ChessBoardHelper.matrix[coordinates.x-1][coordinates.y-1].spotState = SpotState.AIMCLICK
                        mutableList.add(Coordinate(coordinates.x-1,coordinates.y-1))
                    }
                }
                if (ChessBoardHelper.matrix[coordinates.x-1][coordinates.y].piece == null) {
                    mutableList.add(Coordinate(coordinates.x-1,coordinates.y))
                    ChessBoardHelper.matrix[coordinates.x-1][coordinates.y].spotState = SpotState.SPOTCLICK
                    if (coordinates.x == 6) {
                        if (ChessBoardHelper.matrix[coordinates.x-2][coordinates.y].piece?.pieceColor == null){
                            ChessBoardHelper.matrix[coordinates.x-2][coordinates.y].spotState = SpotState.SPOTCLICK
                            mutableList.add(Coordinate(coordinates.x-2,coordinates.y))
                        }
                    }
                }

            }
        }
        ChessBoardHelper.matrix[coordinates.x][coordinates.y].spotState = SpotState.OWNCLICK
        mutableList.add((Coordinate(coordinates.x,coordinates.y)))
        return mutableList
    }



}

class Knight(
    override val pieceColor: PieceColor,
    override var coordinates: Coordinate,


    ) : Piece() {
    override fun updatePositions(position: Coordinate) {
        TODO("Not yet implemented")
    }

    override fun defineDirections(): List<Coordinate> {
        TODO("Not yet implemented")
    }


}

class King(
    override val pieceColor: PieceColor,
    override var coordinates: Coordinate,


    ) : Piece() {
    override fun updatePositions(position: Coordinate) {
        TODO("Not yet implemented")
    }

    override fun defineDirections(): List<Coordinate> {
        TODO("Not yet implemented")
    }




}

class Bishop(
    override val pieceColor: PieceColor,
    override var coordinates: Coordinate,

    ) : Piece() {
    override fun updatePositions(position: Coordinate) {
        TODO("Not yet implemented")
    }

    override fun defineDirections(): List<Coordinate> {
        TODO("Not yet implemented")
    }

}