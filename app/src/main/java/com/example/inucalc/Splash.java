package com.example.inucalc;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 2000); // 2초 후에 hd handler 실행

    }

    private class splashhandler implements Runnable{
        public void run(){
            SharedPreferences checkstart = getSharedPreferences("ckeckstart",MODE_PRIVATE);
            Boolean C = checkstart.getBoolean("startpage",false);
            if(C==false)
            {

                startActivity(new Intent(getApplication(), StartActivity.class)); //로딩이 끝난 후, ChoiceFunction 이동
            }
            else
            {
                startActivity(new Intent(getApplication(), MainActivity.class));

            }
            Splash.this.finish(); // 로딩페이지 Activity stack에서 제거
        }
    }

    @Override
    public void onBackPressed() {
        //초반 플래시 화면에서 넘어갈때 뒤로가기 버튼 못누르게 함
    }


}
