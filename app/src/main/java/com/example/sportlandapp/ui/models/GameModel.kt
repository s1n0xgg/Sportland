package com.example.sportlandapp.ui.models

import java.util.UUID

data class GameModel(
    val Title: String,
    val Time: String,
    val City: String,
    val Space: String,
    val MaxPlayers: Int,
    val MinPlayers: Int = 0,
    val Id: UUID
)
