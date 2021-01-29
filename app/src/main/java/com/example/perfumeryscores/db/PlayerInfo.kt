package com.example.perfumeryscores.db

data class PlayerInfo(
    val name: String, // プレイヤー名
    val game: Int, // 試合数
    val win: Int, // １位になった回数
    val best: Int // ベストスコア
)
