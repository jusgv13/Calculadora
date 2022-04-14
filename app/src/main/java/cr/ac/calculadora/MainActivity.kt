package cr.ac.calculadora

import android.R.attr.button
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : AppCompatActivity() {

    var textView : TextView?= null //Variable Global

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val expression = Expression("2+2")

        //Para el resultado de la calculadora se usa el calculate y los muestra en el textfield
        println("**********************" + expression.calculate())*/

        textView = findViewById(R.id.textView) //Permite Accesar al Text View y lo encuentra por el Id
    }

    //Método para pasarle el dato del botón que se presione al Text View
    fun buttonData(texto: View){

        val button = texto as Button
        val buttonfiled = button.text.toString() //Obtener valores del botón

        if(textView?.text.toString() == "0"){ //Sobreescribir el "0" con la información ingresada por los botones
            textView?.text = ""
        }

       /* if(button?.text.toString() == "X"){
            button?.text = "*"
        }*/

        var unir = textView?.text.toString() + buttonfiled // Pasarle los valores del Botón más lo que está en el text field
        textView?.text =  unir

    }

    //Método para Borrar o Reiniciar
    fun borrar(texto: View){
        textView?.text = "0"
    }

    //Método que realiza los calculos
    fun calcula(texto: View){

        var expression = Expression(textView?.text.toString())
        textView?.text = expression.calculate().toString()

    }


}