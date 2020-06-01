package ddwucom.mobile.sopt.sopt1.sopt_first_project

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val REQ_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var pref : SharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE)
        //"pref"이라는 파일 이름으로  SharedPreferences 객체 생성
        //해당 앱만 읽기, 쓰기가 가능하도록 권한 설정
        var editor : SharedPreferences.Editor = pref.edit()
        //데이터를 저장하기 위한 Editor 객체 생성

        /*button_login2.setOnClickListener {
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
        }*/

        button_login2.setOnClickListener {
            when {
                editText3.text.isNullOrBlank() -> Toast.makeText(this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show()
                editText4.text.isNullOrBlank() -> Toast.makeText(this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
                editText5.text.isNullOrBlank() -> Toast.makeText(this, "비밀번호 확인을 입력하세요.", Toast.LENGTH_SHORT).show()
                editText6.text.isNullOrBlank() -> Toast.makeText(this, "Github 닉네임을 입력하세요.", Toast.LENGTH_SHORT).show()
                else -> {
                    //Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();

                    val intent = Intent(this, LoginActivity::class.java)

                    //intent.putExtra("id", editText3.text.toString())
                    //intent.putExtra("pw", editText4.text.toString())

                    editor.putString("id", editText3.text.toString()) 
                    editor.putString("pw", editText4.text.toString())
                    //editor를 사용해서 파일에 key-value 형태로 id, pw 정보 저장
                    //저장할 수 있는 데이터 타입 boolean, int, float, long, string
                    editor.commit()
                    //데이터 저장 및 삭제 시  commit 필수

                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}