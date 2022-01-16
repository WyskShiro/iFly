package will.shiro.ifly.flight.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import will.shiro.ifly.databinding.ItemListItineraryBinding
import will.shiro.ifly.flight.domain.entity.Itinerary

class ItinerariesAdapter : ListAdapter<Itinerary, ItineraryViewHolder>(ItinerariesDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItineraryViewHolder {
        return ItineraryViewHolder(
            ItemListItineraryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItineraryViewHolder, position: Int) {
        holder.setUp(getItem(position))
    }
}

class ItinerariesDiffUtil : DiffUtil.ItemCallback<Itinerary>() {
    override fun areItemsTheSame(oldItem: Itinerary, newItem: Itinerary): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Itinerary, newItem: Itinerary): Boolean {
        return oldItem.legs.size == newItem.legs.size && oldItem.price == newItem.price
    }
}