package pt.ipt.dam2023.rollerdices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener{
            lancaDados()
        }
    }

    private fun lancaDados() {

        //'ponteiro' para a TextView
        val txt = findViewById<TextView>(R.id.textView)

        //gerar um número aleatório, entre 1 e 6
        var novoNumAleatorios = 1 * Random().nextInt(6) + 1;

        //avisar o utilizador que o número gerado é igual ao que existia
        if(txt.text == novoNumAleatorios.toString()){
            Toast.makeText(this, "O número gerado é igual ao anterior", Toast.LENGTH_SHORT).show()
        }

        //alterar o texto da TextView com esse valor
        txt.text = novoNumAleatorios.toString()

        //alterar a imagem do dado, para refletir esta alteração
        //  - criar o ponteiro para a imageView
        val img = findViewById<ImageView>(R.id.imageView)
        //  - determinar a imagem (recurso) a associar a ImageView
        var recursoAMostrarNoDado = when(novoNumAleatorios){
          1 -> R.drawable.dice_1
          2 -> R.drawable.dice_2
          3 -> R.drawable.dice_3
          4 -> R.drawable.dice_4
          5 -> R.drawable.dice_5
          6 -> R.drawable.dice_6
          else -> R.drawable.empty_dice
        }
        // associar o recurso à ImageView
        img.setImageResource(recursoAMostrarNoDado)
    }
}