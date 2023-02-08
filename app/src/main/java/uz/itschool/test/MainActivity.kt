package uz.itschool.test
//var sharedPreferences=getSharedPreferences("users", MODE_PRIVATE)
//        var edit=sharedPreferences.edit()
//        edit.putString("username","Ali")
//        edit.apply()
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

var questions = ArrayList<test>()
var count = 0
var bool=false
var index = 0

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        questions.add(test("1-2", "-1", "2", "3", "4","-1"))
        questions.add(test("2+2", "1", "2", "3", "4","4"))
        questions.add(test("23+3", "1", "26", "3", "4","26"))
        questions.add(test("3+2", "1", "2", "3", "5","5"))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savol(0)
        questionNumber(questions.size)

        variant1.setOnClickListener {
            if(variant1.text== questions[index].javob && !bool){
                count++
                togri_soni.text= count.toString()
                bool=true
                togri.visibility=View.VISIBLE
            }
        }
        variant2.setOnClickListener {
            if(variant2.text== questions[index].javob && !bool){
                count++
                togri_soni.text= count.toString()
                bool=true
                togri.visibility=View.VISIBLE
            }
        }
        variant3.setOnClickListener {
            if(variant3.text== questions[index].javob && !bool){
                count++
                togri_soni.text= count.toString()
                bool=true
                togri.visibility=View.VISIBLE
            }
        }
        variant4.setOnClickListener {
            if(variant4.text== questions[index].javob && !bool){
                count++
                togri_soni.text= count.toString()
                bool=true
                togri.visibility=View.VISIBLE
            }
        }
        next.setOnClickListener {
next_question()
        }
    }

    fun questionNumber(n: Int) {
        for (i in 1..n) {
            var btn = Button(this)
            btn.id = i
            btn.text = "$i"
            btn.tag = "$i"
            btn.setOnClickListener(this)
            q_number.addView(btn)
        }
    }

    fun savol(index: Int) {
        var test = questions[index]
        savol.text = test.savol
        variant1.text = test.variant1
        variant2.text = test.variant2
        variant3.text = test.variant3
        variant4.text = test.variant4
    }
fun next_question(){
    if (index < questions.size-1) {
        index++
        savol(index)
        variantlar.clearCheck()
        bool=false
        togri.visibility=View.INVISIBLE
    } else {
        index=0
        savol(index)
        variantlar.clearCheck()
        bool=false
        togri.visibility=View.INVISIBLE
    }
}
    override fun onClick(p0: View?) {
        val btn = findViewById<Button>(p0!!.id)
        index = btn.tag.toString().toInt() - 1
        savol(index)
        bool=false
        togri.visibility=View.INVISIBLE
        variantlar.clearCheck()
    }
}