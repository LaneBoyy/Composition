package laneboy.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import laneboy.composition.R
import laneboy.composition.databinding.FragmentChooseLevelBinding
import laneboy.composition.domain.entity.Level

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClicks()
    }

    private fun setClicks() {
        with(binding) {
            buttonTestLvl.setOnClickListener {
                launchGameFragment(Level.TEST)
            }
            buttonEasyLvl.setOnClickListener {
                launchGameFragment(Level.EASY)
            }
            buttonNormalLvl.setOnClickListener {
                launchGameFragment(Level.NORMAL)
            }
            buttonHardLvl.setOnClickListener {
                launchGameFragment(Level.HARD)
            }
        }
    }

    private fun launchGameFragment(level: Level) {
        findNavController().navigate(
            ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(level)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}