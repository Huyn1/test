package fpoly.huynvph52251.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



import java.util.ArrayList;

import fpoly.huynvph52251.asm.model.PhongBan1;

public class Sua extends AppCompatActivity {

    private String tenpb = "";
    private EditText edtManV,edtTennV;
    private Spinner spnTenPB;
    private Button btnSuaNV,btnTroVef;
    private ArrayList<PhongBan1> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        edtManV = findViewById(R.id.edtMaNV);
        edtTennV = findViewById(R.id.edtTenNV);
        spnTenPB = findViewById(R.id.spnTenPB);
        btnSuaNV = findViewById(R.id.btnSuaNV);
        btnTroVef = findViewById(R.id.btnTrovee);

        btnTroVef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


//
    }
}