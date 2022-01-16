package will.shiro.ifly.flight.presentation.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import will.shiro.ifly.databinding.ItemListItineraryBinding
import will.shiro.ifly.flight.domain.entity.Itinerary

class ItineraryViewHolder constructor(
    private val binding: ItemListItineraryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setUp(itinerary: Itinerary) = with(binding) {
        val leg = itinerary.legs.first()
        Glide.with(root.context)
            .load(leg.airlineLogoUrl)
            .into(airlineImage)

        departureArrivalTimeText.text = "${leg.departureTime} - ${leg.arrivalTime}"
        departureArrivalNameText.text = "${leg.departureAirport} - ${leg.arrivalAirport}, "
        companyNameText.text = leg.airlineName
        stopsText.text = if (leg.stops == 0) "Direct" else "${leg.stops} stops"
        durationText.text = leg.duration

        priceText.text = itinerary.price
        agentUrlText.text = "via ${itinerary.agentUrl}"
    }
}