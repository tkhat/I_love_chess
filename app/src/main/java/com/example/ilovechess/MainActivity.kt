package com.example.ilovechess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ilovechess.chess.*
import com.example.ilovechess.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var boardAdapter: BoardAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initBoard()

    }

    fun initData(): MutableList<Spot> {
        var local = mutableListOf<Spot>()
        for (i in 0..7) {
            for (j in 0..7) {
                local.add(ChessBoardHelper.matrix[i][j])
            }
        }
        return local
    }

    private fun initBoard() {
        boardAdapter = BoardAdapter()
        binding.RecyclierViewBoard.apply {
                adapter = boardAdapter
                layoutManager = GridLayoutManager(this@MainActivity, 8)
            }
            boardAdapter.data = initData()
    }


}