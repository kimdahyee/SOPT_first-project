package ddwucom.mobile.sopt.sopt1.sopt_first_project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        button_login2.setOnClickListener {
            if (editText3.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show()
            } else if (editText4.text.isNullOrBlank()) {
                Toast.makeText(this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
            } else if (editText5.text.isNullOrBlank()) {
                Toast.makeText(this, "비밀번호 확인을 입력하세요.", Toast.LENGTH_SHORT).show()
            } else if (editText6.text.isNullOrBlank()) {
                Toast.makeText(this, "Github 닉네임을 입력하세요.", Toast.LENGTH_SHORT).show()
            } else {
                val resultIntent = Intent()
                resultIntent.putExtra("id", editText3.text.toString())
                resultIntent.putExtra("pw", editText4.text.toString())
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}