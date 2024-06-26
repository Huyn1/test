package fpoly.huynvph52251.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class themNV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);
        EditText edma = findViewById(R.id.edma);
        EditText ename = findViewById(R.id.ename);
        Spinner pb = findViewById(R.id.pb);
        Button them = findViewById(R.id.them);
        Button btnve = findViewById(R.id.btnve);
    }
}