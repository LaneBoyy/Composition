package laneboy.composition.domain.usecases

import laneboy.composition.domain.entity.GameSettings
import laneboy.composition.domain.entity.Level
import laneboy.composition.domain.usecases.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}