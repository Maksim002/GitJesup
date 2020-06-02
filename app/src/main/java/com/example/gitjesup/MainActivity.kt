package com.example.gitjesup
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val url = "http://itimm.ksmu.kg/sample-page/"
    private val listNew = mutableListOf<NewModel>()
    private lateinit var adapters: NewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapters = NewAdapter()
        recyclerView.adapter = adapters

        GlobalScope.launch {
            getData()
        }
    }

    private fun getData() {
        try {
            val document = Jsoup.connect(url).get()
            val element = document.select("div[class = elementor-widget-container]")

            for (i in 0 until element.size){

                val title = element.select("div[class = elementor-image-box-content]")
                    .select("p")
                    .eq(i)
                    .text()

                val image = document.baseUri() + element.select("figure[class = elementor-image-box-img")
                    .select("img")
                    .eq(i)
                    .attr("src")

                listNew.add(NewModel(title, "", image))
            }
            GlobalScope.launch(Dispatchers.Main) {
                adapters.set(listNew)
            }
        }catch (e: IOException){

        }
    }
}