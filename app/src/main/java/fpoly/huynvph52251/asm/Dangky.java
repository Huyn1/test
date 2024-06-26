package fpoly.huynvph52251.asm;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Dangky extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangky);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            TextInputEditText edtUser = findViewById(R.id.edtUser);
            TextInputLayout txtUser = findViewById(R.id.txtUser);
            TextInputEditText edtPass = findViewById(R.id.edtPass);
            TextInputLayout txtPass = findViewById(R.id.txtPass);
            TextInputEditText edtRePass = findViewById(R.id.edtRePass);
            TextInputLayout txtRePass = findViewById(R.id.txtRePass);
            Button btnRegister = findViewById(R.id.btnRegister);
            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String user = edtUser.getText().toString();
                    String pass = edtPass.getText().toString();
                    String rePass = edtRePass.getText().toString();

                    //validate
                    if(user.equals("") || pass.equals("") || rePass.equals("")){
//                        Toast.makeText(Dangky.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                        if(user.equals("")){
                            txtUser.setError("Vui lòng nhập username");
                        }else{
                            txtUser.setError(null);
                        }
                        if(pass.equals("")){
                            txtPass.setError("Vui lòng nhập password");
                        }else{
                            txtPass.setError(null);
                        }
                        if(rePass.equals("")){
                            txtRePass.setError("Vui lòng nhập lại password");
                        }else{
                            txtRePass.setError(null);
                        }
                    }else if(!pass.equals(rePass)){Toast.makeText(Dangky.this, "Nhập mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent();
                        intent.putExtra("user", user);
                        intent.putExtra("pass", pass);
                        setResult(1, intent);
                        finish();
                    }
                }
            });
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}