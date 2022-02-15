package uz.ilhomjon.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.ilhomjon.mvc.databinding.ActivityMainBinding
import uz.ilhomjon.mvc.model_mvc.MyModel
import java.util.*


//MainActivity - controller
//ActivityMain - View
//MyModel - model
class MainActivity : AppCompatActivity(), Observer {
    lateinit var binding: ActivityMainBinding
    var myModel : MyModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myModel = MyModel()
        myModel?.addObserver(this)

        binding.apply {
            button.setOnClickListener { myModel?.setValueIndex(0) }
            button2.setOnClickListener { myModel?.setValueIndex(1) }
            button3.setOnClickListener { myModel?.setValueIndex(2) }
        }
    }

    override fun update(p0: Observable?, p1: Any?) {
        binding.button.text = "Count: " + myModel?.getValueIndex(0)
        binding.button2.text = "Count: " + myModel?.getValueIndex(1)
        binding.button3.text = "Count: " + myModel?.getValueIndex(2)
    }
}