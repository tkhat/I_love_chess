package com.example.ilovechess

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ilovechess.chess.*
import com.example.ilovechess.databinding.SpotItemBinding
import com.example.ilovechess.extensions.dp

class BoardAdapter :
    RecyclerView.Adapter<BoardAdapter.ViewHolder>() {



    var data = mutableListOf<Spot>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SpotItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    fun fixSize(v: View, doExpand: Boolean){
        val normalSize = 35.dp
        val expandSize = 45.dp
        val layoutParams: ViewGroup.LayoutParams = v.layoutParams

        if (doExpand) {
            layoutParams.height = expandSize
            layoutParams.width = expandSize
            v.layoutParams = layoutParams
        } else {
            layoutParams.height = normalSize
            layoutParams.width = normalSize
            v.layoutParams = layoutParams
        }
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(private val binding: SpotItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val currentItem = data[adapterPosition]
            drawBoard(adapterPosition, binding)
            drawPieces(binding,currentItem)
            drawSpotState(binding, adapterPosition)


        }

    }



    fun drawSpotState(binding: SpotItemBinding, adapterPosition: Int) {
        binding.directionDrawable.visibility = View.VISIBLE
        when (data[adapterPosition].spotState) {
            SpotState.SPOTCLICK -> {
            binding.directionDrawable.setImageResource(R.drawable.free_direction)
                fixSize(binding.directionDrawable,false)
            }
            SpotState.AIMCLICK -> {
                binding.directionDrawable.setImageResource(R.drawable.capture_aim)
                fixSize(binding.directionDrawable,true)
            }
            SpotState.OWNCLICK -> {
                binding.directionDrawable.setImageResource(R.drawable.tag_color)
                fixSize(binding.directionDrawable,true)

            }
            else -> {
                binding.apply {
                    directionDrawable.visibility = View.GONE
                }

            }
        }
    }

    fun drawPieces(binding: SpotItemBinding, currentItem: Spot) {
        binding.chessPieceImgView.visibility = View.VISIBLE
        when (currentItem.piece) {
            is Queen -> {
                when ((currentItem.piece as Queen).pieceColor) {
                    PieceColor.BLACK -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.black_queen)
                    }
                    PieceColor.WHITE -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.white_queen)
                    }

                }
            }
            is Pawn -> {
                when ((currentItem.piece as Pawn).pieceColor) {
                    PieceColor.BLACK -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.pawn_black)
                    }
                    PieceColor.WHITE -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.pawn_white)
                    }

                }
            }
            is Rook -> {
                when ((currentItem.piece as Rook).pieceColor) {
                    PieceColor.BLACK -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.black_rook)
                    }
                    PieceColor.WHITE -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.white_rook)
                    }

                }
            }
            is Knight -> {
                when ((currentItem.piece as Knight).pieceColor) {
                    PieceColor.BLACK -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.black_knight)
                    }
                    PieceColor.WHITE -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.white_knight)
                    }

                }
            }
            is Bishop -> {
                when ((currentItem.piece as Bishop).pieceColor) {
                    PieceColor.BLACK -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.black_bishop)
                    }
                    PieceColor.WHITE -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.white_bishop)
                    }

                }
            }
            is King -> {
                when ((currentItem.piece as King).pieceColor) {
                    PieceColor.BLACK -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.black_king)
                    }
                    PieceColor.WHITE -> {
                        binding.chessPieceImgView.setImageResource(R.drawable.white_king)
                    }

                }
            }
            else -> {
                binding.chessPieceImgView.visibility = View.GONE
            }
        }
    }

    fun drawBoard(adapterPosition: Int, binding: SpotItemBinding) {
        val row = ChessBoardHelper.positionHelper(data[adapterPosition].position)
        if (row % 2 == 0) {
            if (data[adapterPosition].position % 2 == 0) {
                binding.root.setBackgroundResource(R.drawable.black_spot)
            } else {
                binding.root.setBackgroundResource(R.drawable.white_spot)
            }
        } else {
            if (data[adapterPosition].position % 2 != 0) {
                binding.root.setBackgroundResource(R.drawable.black_spot)
            } else {
                binding.root.setBackgroundResource(R.drawable.white_spot)
            }
        }
        val spotNumber = ChessBoardHelper.spotNumberHelper(data[adapterPosition].position)
        if (spotNumber != null) {
            binding.spotNumberTxtId.apply {
                text = spotNumber.toString()
                visibility = View.VISIBLE
            }
        } else {
            binding.spotNumberTxtId.apply {
                visibility = View.GONE
            }
        }
        when (data[adapterPosition].position) {
            57 -> {
                binding.spotNameTxtId.text = "A"
            }
            58 -> {
                binding.spotNameTxtId.text = "B"

            }
            59 -> {
                binding.spotNameTxtId.text = "C"
            }
            60 -> {
                binding.spotNameTxtId.text = "D"
            }
            61 -> {
                binding.spotNameTxtId.text = "E"
            }
            62 -> {
                binding.spotNameTxtId.text = "F"
            }
            63 -> {
                binding.spotNameTxtId.text = "G"
            }
            64 -> {
                binding.spotNameTxtId.text = "H"
            }

        }
    }
}
