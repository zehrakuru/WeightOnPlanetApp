package com.example.weightonplanetapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlanetAdapter(private val mContext: Context, private val planetList: List<Planet>) : RecyclerView.Adapter<PlanetAdapter.PlanetCardDesignHolder>() {

    inner class PlanetCardDesignHolder(view : View) : RecyclerView.ViewHolder(view){
        var imageViewPlanet: ImageView
        var planetName: TextView
        var weight: TextView
        
        init {
            imageViewPlanet = view.findViewById(R.id.planet_image)
            planetName = view.findViewById(R.id.planet_name)
            weight = view.findViewById(R.id.calculatedWeight)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetCardDesignHolder {
        val design =
            LayoutInflater.from(mContext).inflate(R.layout.planet_card_design, parent, false)
        return PlanetCardDesignHolder(design)
    }

    override fun getItemCount(): Int {
        return planetList.size
    }

    override fun onBindViewHolder(holder: PlanetCardDesignHolder, position: Int) {
        val planet = planetList[position]
        holder.planetName.text = planet.planet_name
        holder.weight.text = planet.weight_text_view
        holder.imageViewPlanet.setImageResource(mContext.resources.getIdentifier(planet.planet_image_view, "drawable", mContext.packageName))
    }
}