package sierra.com.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import sierra.com.domain.model.Beer
import sierra.com.presentation.R
import sierra.com.presentation.databinding.ItemBeerBinding

class BeerListAdapter : RecyclerView.Adapter<BeerListAdapter.ViewHolder>() {

    private lateinit var list: List<Beer>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemBeerBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_beer,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return if (::list.isInitialized) list.size else 0
    }

    fun updateList(newList: List<Beer>) {
        this.list = newList
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ItemBeerBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = BeerViewModel()

        fun bind(beer: Beer) {
            viewModel.bind(beer)
            binding.viewModel = viewModel
        }
    }
}