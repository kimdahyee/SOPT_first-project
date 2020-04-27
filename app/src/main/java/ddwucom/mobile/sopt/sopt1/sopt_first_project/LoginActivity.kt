package ddwucom.mobile.sopt.sopt1.sopt_first_project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_c.*

class LoginActivity : AppCompatActivity() {

    val REQ_CODE = 100;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_c)

        button_login.setOnClickListener {
            if (editText1.text.isNullOrBlank() || editText2.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        textView2.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CODE && resultCode == Activity.RESULT_OK) {
            editText1.setText(data!!.getStringExtra("id"))
            editText2.setText(data!!.getStringExtra("pw"))
        }
    }
}