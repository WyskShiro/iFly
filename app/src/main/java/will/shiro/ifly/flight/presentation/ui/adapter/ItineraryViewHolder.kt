package will.shiro.ifly.flight.presentation.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import will.shiro.ifly.R
import will.shiro.ifly.databinding.ItemListItineraryBinding
import will.shiro.ifly.flight.domain.entity.Itinerary

class ItineraryViewHolder constructor(
    private val binding: ItemListItineraryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setUp(itinerary: Itinerary) = with(binding) {
        val adapter = LegAdapter()
        legsRecycler.adapter = adapter
        adapter.submitList(itinerary.legs)

        priceText.text = itinerary.price
        agentUrlText.text = root.context.getString(R.string.agent_by, itinerary.agentUrl)
    }
}