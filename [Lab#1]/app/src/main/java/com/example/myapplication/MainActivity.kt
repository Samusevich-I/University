package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    /*val Apple2: ImageButton = findViewById(R.id.imageApple2);
    val Ananas1: ImageButton = findViewById(R.id.imageAnanas1);
    val Ananas2: ImageButton = findViewById(R.id.imageAnanas2);
    val Apesin1: ImageButton = findViewById(R.id.imageApesin1);
    val Apesin2: ImageButton = findViewById(R.id.imageApesin2);
    val Banan1: ImageButton = findViewById(R.id.imageBanan1);
    val Banan2: ImageButton = findViewById(R.id.imageBanan2);
    val Cherry1: ImageButton = findViewById(R.id.imageCherry1);
    val Cherry2: ImageButton = findViewById(R.id.imageCherry2);
    val Sliva1: ImageButton = findViewById(R.id.imageSliva1);
    val Sliva2: ImageButton = findViewById(R.id.imageSliva2);
    val Strawberry1: ImageButton = findViewById(R.id.imageStrawberry1);
    val Strawberry2: ImageButton = findViewById(R.id.imageStrawberry2);
    val Vinograd1: ImageButton = findViewById(R.id.imageVinograd1);
    val Vinograd2: ImageButton = findViewById(R.id.imageVinograd2);*/


    var tags = listOf<String>("Banan", "Apesin", "Vinograd", "Sliva", "Cherry", "Strawberry", "Apple", "Ananas",
        "Banan", "Apesin", "Vinograd", "Sliva", "Cherry", "Strawberry", "Apple", "Ananas")
    companion object {
        var tempId = R.id.RestartButton;
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_main)
        tags = tags.shuffle();
    }

    fun init(view: View) {
        tags = tags.shuffle();
        val Apple1: ImageButton = findViewById(R.id.imageApple1);
        Apple1.tag = tags[0]
        val Apple2: ImageButton = findViewById(R.id.imageApple2);
        Apple2.tag = tags[1]
        val Ananas1: ImageButton = findViewById(R.id.imageAnanas1);
        Ananas1.tag = tags[2]
        val Ananas2: ImageButton = findViewById(R.id.imageAnanas2);
        Ananas2.tag = tags[3]
        val Apesin1: ImageButton = findViewById(R.id.imageApesin1);
        Apesin1.tag = tags[4]
        val Apesin2: ImageButton = findViewById(R.id.imageApesin2);
        Apesin2.tag = tags[5]
        val Banan1: ImageButton = findViewById(R.id.imageBanan1);
        Banan1.tag = tags[6]
        val Banan2: ImageButton = findViewById(R.id.imageBanan2);
        Banan2.tag = tags[7]
        val Cherry1: ImageButton = findViewById(R.id.imageCherry1);
        Cherry1.tag = tags[8]
        val Cherry2: ImageButton = findViewById(R.id.imageCherry2);
        Cherry2.tag = tags[9]
        val Sliva1: ImageButton = findViewById(R.id.imageSliva1);
        Sliva1.tag = tags[10]
        val Sliva2: ImageButton = findViewById(R.id.imageSliva2);
        Sliva2.tag = tags[11]
        val Strawberry1: ImageButton = findViewById(R.id.imageStrawberry1);
        Strawberry1.tag = tags[12]
        val Strawberry2: ImageButton = findViewById(R.id.imageStrawberry2);
        Strawberry2.tag = tags[13]
        val Vinograd1: ImageButton = findViewById(R.id.imageVinograd1);
        Vinograd1.tag = tags[14]
        val Vinograd2: ImageButton = findViewById(R.id.imageVinograd2);
        Vinograd2.tag = tags[15]

    }

    fun <T> Iterable<T>.shuffle(): List<T> {
        val list = this.toMutableList().apply {  }
        Collections.shuffle(list)
        return list
    }

    fun onNewGameClick(view: View) {
        setContentView(R.layout.activity_main)
        init(view);
    }

    fun onExitClick (view: View) {
        finish();
        System.exit(0);
    }

    fun onBackClick (view: View) {
        setContentView(R.layout.menu_main)
    }

    fun onClickButton(view: View) {
        val LastButton: ImageButton = findViewById(tempId)
        val CurrentButton: ImageButton = findViewById(view.id)
        //CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_abacaxi_3316495)
        when(view.tag) {
            "Apesin" -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_laranja_3316508)
                compare(LastButton, CurrentButton, view)
            }
            "Banan" -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_banana_3316512)
                compare(LastButton, CurrentButton, view)
            }
            "Cherry" -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_cerejas_3316510)
                compare(LastButton, CurrentButton, view)
            }
            "Strawberry" -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_morango_3316501)
                compare(LastButton, CurrentButton, view)
            }
            "Apple" -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_maca_3316506)
                compare(LastButton, CurrentButton, view)
            }
            "Vinograd" -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_uvas_3316497)
                compare(LastButton, CurrentButton, view)
            }
            "Sliva" -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_ameixa_3316494)
                compare(LastButton, CurrentButton, view)
            }
            "Ananas" -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_abacaxi_3316495)
                compare(LastButton, CurrentButton, view)
            }
            /*R.id.imageApple1 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_maca_3316506)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageApple2 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_maca_3316506)
                compare(LastButton, CurrentButton, view);
            }
            R.id.imageSliva1 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_ameixa_3316494)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageSliva2 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_ameixa_3316494)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageStrawberry1 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_morango_3316501)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageStrawberry2-> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_morango_3316501)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageVinograd1 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_uvas_3316497)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageVinograd2 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_uvas_3316497)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageCherry1 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_cerejas_3316510)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageCherry2 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_cerejas_3316510)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageBanan1 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_banana_3316512)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageBanan2 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_banana_3316512)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageAnanas1 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_abacaxi_3316495)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageAnanas2 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_abacaxi_3316495)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageApesin1 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_laranja_3316508)
                compare(LastButton, CurrentButton, view)
            }
            R.id.imageApesin2 -> {
                CurrentButton.setImageResource(R.drawable.iconfinder_icon_fruit_laranja_3316508)
                compare(LastButton, CurrentButton, view)
            }*/
        }
    }


    fun compare(LastButton: ImageButton, CurrentButton: ImageButton, view: View) {
        if ( (LastButton.getTag() == CurrentButton.getTag()) && tempId != view.id )
        {
            android.os.Handler().postDelayed({
                CurrentButton.visibility = View.INVISIBLE
                LastButton.visibility = View.INVISIBLE
            }, 300)
            return
        }
        if ( tempId != R.id.RestartButton && tempId != view.id ) {
            LastButton.setImageResource(R.drawable.smilea)
        }
        tempId = view.id
    }

    fun onRestartClick (view: View) {
        setContentView(R.layout.activity_main)
        init(view)
        tempId = R.id.RestartButton
    }

}