package ddwucom.mobile.sopt.sopt1.sopt_first_project

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_c.*

class LoginActivity : AppCompatActivity() {

    val REQ_CODE = 100;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_c)

        autoLogin()

        button_login.setOnClickListener {
            if (editText1.text.isNullOrBlank() || editText2.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        textView2.setOnClickListener { //회원가입하기 버튼 클릭
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, REQ_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CODE && resultCode == Activity.RESULT_OK) {
            //editText1.setText(data!!.getStringExtra("id"))
            //editText2.setText(data!!.getStringExtra("pw"))
            finish()
        }
    }

    fun autoLogin() {
        var pref: SharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE)

        if (!(pref.getString("id", null).isNullOrBlank() || pref.getString("pw", null).isNullOrBlank())) {
            val id = pref.getString("id", null).toString()

            if (!id.isNullOrBlank()) {
                Toast.makeText(this, "${id}님이 자동로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                val intent = Intent(this, MainActivity::class.java)
                startActivityForResult(intent, REQ_CODE)
            }
        }
    }
}