package evan.chen.tutorial.fragmentviewmodelsample.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import evan.chen.tutorial.fragmentviewmodelsample.R
import evan.chen.tutorial.fragmentviewmodelsample.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var adapter: MainAdapter
    private lateinit var viewDataBinding: MainFragmentBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewDataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment, container, false
        )

        viewDataBinding.viewModel = viewModel

        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = MainAdapter(viewModel)
        viewDataBinding.recyclerView.adapter = adapter

        viewModel.listLiveData.observe(viewLifecycleOwner,
            Observer<List<Item>> {
                adapter.notifyDataSetChanged()
            })

        viewModel.openItemEvent.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, DetailFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        })

    }

}
