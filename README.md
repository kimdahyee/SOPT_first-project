
# SOPT_first-project

SOPT 1차 세미나 과제

## [ 기본 과제 1 ] ConstraintLayout 심화 학습
> ConstraintDimentionRatio 이용해서 이미지 1:1 비율로, Guideline 이용해보기

 1. ImageView에서 ConstraintDimentionRatio 설정

	    <ImageView  
		  app:layout_constraintDimensionRatio="1"  />

   
   * dimensionRatio : 뷰의 가로/세로 **비율** 결정
   
   2. TextView 3개 만들고 그 중 2개는 chain을 걸어 나란히 정렬해주고 나머지 1개의 TextView에는 Guideline 설정

		  <androidx.constraintlayout.widget.Guideline  
			  android:id="@+id/guide_line_1"  
			  android:layout_width="wrap_content"  
			  android:layout_height="wrap_content"  
			  android:orientation="vertical"  
			  app:layout_constraintBottom_toBottomOf="parent"  
			  app:layout_constraintGuide_end="140dp"  
			  app:layout_constraintStart_toStartOf="parent"  
			  app:layout_constraintTop_toTopOf="parent" />

		    <TextView  
			  app:layout_constraintEnd_toStartOf="@+id/guide_line_1"  />

* Guidelines: 뷰를 배치하기 위해 뷰그룹 내에 설정할 수 있는 일종의 기준선
-> android:orientation="vertical(또는 horizontal)을 통해 가로/세로로 적용 가능
-> layout_constraintGuide_begin과 layout_constraintGuide_end를 사용해서 위치를 수치로 지정 가능 
-> layout_constraintGuidePercent를 사용해서 위치를 퍼센트로 지정 가능

* AnroidX : Android 팀이 Jetpack 내에서 라이브러리를 개발, 테스트, 패키지화, 버전 및 릴리스 하기 위해 사용하는 오픈 소스 프로젝트 
-> androidX 태그 주의하기 ! !
 


## [ 기본 과제 2 ] 회원가입 및 로그인 기능 구현하기

> 회원가입 완료시 LoginActivity로 돌아오고, 회원가입 성공한 id와 pass word가 입력되어 있도록 구현

 1. 프로젝트 실행 시 제일 먼저 MainActivity가 실행되고 MainActivity에서 startActivity()를 사용해 **로그인하러 가기** 클릭 시 LoginActivity가 실행되도록 구현
 

        button_go.setOnClickListener {  
    	  val intent1 = Intent(this, LoginActivity::class.java)  
         startActivity(intent1) 
         }
  

 2. LoginActivity에서 startActivityForResult()를 사용해 **회원가입하기** 클릭 시 RegisterActivity가 실행되도록 구현
 

	    textView2.setOnClickListener {  
    	     val intent = Intent(this, RegisterActivity::class.java)  
    	    startActivityForResult(intent, 100)  
	    }

* **그렇다면 여기서 잠깐 ! !**

	 2번에서 startActivity가 아닌 startActivityForResult를 사용한 이유가 무엇일까 ?

	회원가입 완료시 RegisterActivity에서 다시 LoginActivity로 돌아오면서 회원가입시 작성한 id와 pass word 정보를 가지고 돌아오기 위해서 2번에서는 startActivity가 아닌 startActivityForResult를 사용
	   
* **그렇다면 어떻게 id와 pass word 정보를 가지고 돌아올 수 있을까 ?**

	A. 일단 id와 pass word 정보를 담아올 공간인 Intent가 필요
	* Intent: 안드로이드의 4가지 구성요소인 Activity, Service, Broadcast Receiver, Content Provide 사이 메세지를 주고 받기 위한 매개체
	 
	B.  LoginActivity에서 startActivityForResult 사용해서 요청을 구별하기 위한 requestCode와 함께 intent를 전달
	

	    textView2.setOnClickListener {  
		  val intent = Intent(this, RegisterActivity::class.java)  
		    **startActivityForResult(intent, 100)**  
		}
	
	C.  RegisterActivity에서 전달받은 intent에  putExtra를 사용해서 id와 pass word 정보를 담고 setResult를 사용해서 결과 코드와 결과가 담긴 intent를 세팅하고 finish() 실행

	    val resultIntent = Intent()  
		resultIntent.putExtra("id", editText3.text.toString())  
		resultIntent.putExtra("pw", editText4.text.toString())  
		setResult(Activity.RESULT_OK, resultIntent)  
		finish()
		
	D. LoginActivity에서 getStringExtra를 사용해서 RegisterActivity로부터 전달 받은 intent 안에 담긴 결과를 꺼내 editText에 입력 

	    if (requestCode == REQ_CODE && resultCode == Activity.RESULT_OK) {  
		    editText1.setText(data!!.getStringExtra("id"))  
		    editText2.setText(data!!.getStringExtra("pw"))  
		}

	* 변수!!의 의미:  null이여도 null이 아니라고 강제 형변환, null 일 수 있음을 암시
