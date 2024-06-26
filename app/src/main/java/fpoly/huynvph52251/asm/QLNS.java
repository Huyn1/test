package fpoly.huynvph52251.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QLNS extends AppCompatActivity {
    private Button btnphongban;
    private Button btnnv;
    private Button btnthoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlns);
        btnphongban = findViewById(R.id.btnphongban);
        btnnv = findViewById(R.id.btnnv);
        btnthoat = findViewById(R.id.btnthoat);

        btnphongban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(QLNS.this,PhongBan.class));
            }
        });

        btnnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QLNS.this,NhanVien.class));
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}