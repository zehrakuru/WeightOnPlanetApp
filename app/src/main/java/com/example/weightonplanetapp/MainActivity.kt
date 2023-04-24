package com.example.weightonplanetapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weightonplanetapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var planetsArrayList: ArrayList<Planet>
    private lateinit var adapter: PlanetAdapter
    private lateinit var weight: String
    private lateinit var weightJupyter: String
    private lateinit var weightMars: String
    private lateinit var weightMercury : String
    private lateinit var weightNeptune : String
    private lateinit var weightSaturn : String
    private lateinit var weightUranus : String
    private lateinit var weightVenus : String
    private lateinit var weightSun : String
    private lateinit var weightMoon : String
    val MARS = 0.38
    val VENUS = 0.91
    val MERCURY = 0.38
    val JUPYTER = 2.34
    val SATURN = 1.064
    val SUN = 27.01
    val MOON = 0.166
    val NEPTUNE = 1.19
    val URANUS = 0.92

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            val view = root
            setContentView(view)
            weight = "- kg"

            button.setOnClickListener {
                var weightNum = editTextWeight.text.toString()
                weight = "$weightNum kg"
                weightJupyter = (weightNum.toInt() * JUPYTER).toString() + " kg"
                weightMars = (weightNum.toInt() * MARS).toString() + " kg"
                weightMercury = (weightNum.toInt() * MERCURY).toString() + " kg"
                weightNeptune = (weightNum.toInt() * NEPTUNE).toString() + " kg"
                weightSaturn = (weightNum.toInt() * SATURN).toString() + " kg"
                weightUranus = (weightNum.toInt() * URANUS).toString() + " kg"
                weightVenus = (weightNum.toInt() * VENUS).toString() + " kg"
                weightSun = (weightNum.toInt() * SUN).toString() + " kg"
                weightMoon = (weightNum.toInt() * MOON).toString() + " kg"

                recyclerView.layoutManager =
                    LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

                val p1 = Planet("Earth", "earth_icon", weight)
                val p2 = Planet("Jupyter", "jupiter_icon", weightJupyter)
                val p3 = Planet("Mars", "mars_icon", weightMars)
                val p4 = Planet("Mercury", "mercury_icon", weightMercury)
                val p5 = Planet("Neptune", "neptune_icon", weightNeptune)
                val p6 = Planet("Saturn", "saturn_icon", weightSaturn)
                val p7 = Planet("Uranus", "uranus_icon", weightUranus)
                val p8 = Planet("Venus", "venus_icon", weightVenus)
                val p9 = Planet("Sun", "sun", weightSun)
                val p10 = Planet("Moon", "moon_icon", weightMoon)

                planetsArrayList = ArrayList<Planet>()
                planetsArrayList.add(p1)
                planetsArrayList.add(p2)
                planetsArrayList.add(p3)
                planetsArrayList.add(p4)
                planetsArrayList.add(p5)
                planetsArrayList.add(p6)
                planetsArrayList.add(p7)
                planetsArrayList.add(p8)
                planetsArrayList.add(p9)
                planetsArrayList.add(p10)

                adapter = PlanetAdapter(applicationContext, planetsArrayList)
                recyclerView.adapter = adapter
            }
        }
    }
}