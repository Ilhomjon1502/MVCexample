package uz.ilhomjon.mvc.model_mvc

import java.lang.IndexOutOfBoundsException
import java.util.*
import kotlin.collections.ArrayList

class MyModel : Observable() {

    //ma'lumot saqlash uchun. list o'rnida api dan ma'lumot olib kelish va boshqa narsalar bo'lishi mumkin
    val list:MutableList<Int>

    init {
        list = ArrayList(3)
        list.add(0)
        list.add(0)
        list.add(0)
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getValueIndex(index:Int):Int{
        return list[index]
    }

    @Throws(IndexOutOfBoundsException::class)
    fun setValueIndex(index:Int){
        list[index] +=1
        setChanged() //o'zgarishni saqlash
        notifyObservers() //o'zgarishni yetkazib berish
    }
}