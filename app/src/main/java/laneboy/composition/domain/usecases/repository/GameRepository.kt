package laneboy.composition.domain.usecases.repository

import laneboy.composition.domain.entity.GameSettings
import laneboy.composition.domain.entity.Level
import laneboy.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int,
    ): Question

    fun getGameSettings(level: Level): GameSettings
}