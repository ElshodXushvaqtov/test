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
var index = 0

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        questions.add(test("1-2", "-1", "2", "3", "4"))
        questions.add(test("2+2", "1", "2", "3", "4"))
        questions.add(test("23+3", "1", "26", "3", "4"))
        questions.add(test("3+2", "1", "2", "3", "5"))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savol(0)
        questionNumber(questions.size)
        next.setOnClickListener {
            if (index >= questions.size) {
index=0
            } else {
                index++
                savol(index)
                variantlar.clearCheck()
            }
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

    override fun onClick(p0: View?) {
        val btn = findViewById<Button>(p0!!.id)
        index = btn.tag.toString().toInt() - 1
        savol(index)
    }
}