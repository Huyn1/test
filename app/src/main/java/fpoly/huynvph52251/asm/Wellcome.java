package fpoly.huynvph52251.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class Wellcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        new CountDownTimer(2000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                // trong vong bao nhieu s thi thuc hien cong vc
            }

            @Override
            public void onFinish() {
                Intent mItent = new Intent(Wellcome.this,
                        Dangnhap1.class);
                startActivity(mItent);
            }
        }.start();
    }
}