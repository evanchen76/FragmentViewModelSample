package evan.chen.tutorial.fragmentviewmodelsample.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import evan.chen.tutorial.fragmentviewmodelsample.R
import evan.chen.tutorial.fragmentviewmodelsample.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            DetailFragment()
    }

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        val viewDataBinding: DetailFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.detail_fragment, container, false
        )

        viewDataBinding.viewModel = viewModel

        return viewDataBinding.root
    }

}
