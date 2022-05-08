package will.shiro.ifly.flight.presentation.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import will.shiro.ifly.R
import will.shiro.ifly.databinding.ItemListLegBinding
import will.shiro.ifly.flight.domain.entity.Leg

class LegViewHolder constructor(
    private val binding: ItemListLegBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setUp(leg: Leg) = with(binding) {
        Glide.with(root.context)
            .load(leg.airlineLogoUrl)
            .into(airlineImage)

        departureArrivalTimeText.text = "${leg.departureTime} - ${leg.arrivalTime}"
        departureArrivalNameText.text = "${leg.departureAirport}-${leg.arrivalAirport}, "
        companyNameText.text = leg.airlineName

        stopsText.text = if (leg.stops == 0) {
            root.context.getString(R.string.no_stops)
        } else {
            root.context.resources.getQuantityString(R.plurals.stops, leg.stops, leg.stops)
        }
        durationText.text = leg.duration
    }
}