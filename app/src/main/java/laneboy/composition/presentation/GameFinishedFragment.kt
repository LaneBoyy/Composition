package laneboy.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import laneboy.composition.R
import laneboy.composition.databinding.FragmentGameFinishedBinding

class GameFinishedFragment : Fragment() {

    private val args by navArgs<GameFinishedFragmentArgs>()

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        bindViews()
    }

    private fun bindViews() {
        binding.gameResult = args.gameResult
        with(binding) {
            ivEmojiResult.setImageResource(getSmileResId())
//            tvRequiredAnswers.text = String.format(
//                getString(R.string.text_count_of_needs_answers),
//                args.gameResult.gameSettings.minCountOfRightAnswers
//            )
//            tvScoreAnswers.text = String.format(
//                getString(R.string.text_your_score),
//                args.gameResult.countOfRightAnswers
//            )
//            tvRequiredPercentage.text = String.format(
//                getString(R.string.text_need_percent),
//                args.gameResult.gameSettings.minPercentRightAnswers
//            )
            tvScorePercentage.text = String.format(
                getString(R.string.test_percent_of_right_answers),
                getPercentOfRightAnswers()
            )
        }
    }

    private fun getPercentOfRightAnswers() = with(args.gameResult) {
        if (countOfRightAnswers == 0) {
            0
        } else {
            ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
        }
    }

    private fun getSmileResId(): Int {
        return if (args.gameResult.winner) {
            R.drawable.ic_smiling
        } else {
            R.drawable.ic_sad
        }
    }

    private fun setupClickListeners() {
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun retryGame() {
        findNavController().popBackStack()
    }
}