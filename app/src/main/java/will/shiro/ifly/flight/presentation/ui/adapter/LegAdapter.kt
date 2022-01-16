package will.shiro.ifly.flight.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import will.shiro.ifly.databinding.ItemListLegBinding
import will.shiro.ifly.flight.domain.entity.Leg

class LegAdapter : ListAdapter<Leg, LegViewHolder>(LegDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegViewHolder {
        return LegViewHolder(
            ItemListLegBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LegViewHolder, position: Int) {
        holder.setUp(getItem(position))
    }
}

class LegDiffUtil : DiffUtil.ItemCallback<Leg>() {
    override fun areItemsTheSame(oldItem: Leg, newItem: Leg): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Leg, newItem: Leg): Boolean {
        return oldItem == newItem
    }
}