package laneboy.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings(
    val maxSumValue: Int,
    val minCountOfRightAnswers: Int,
    val minPercentRightAnswers: Int,
    val gameTimeInSeconds: Int,
) : Parcelable