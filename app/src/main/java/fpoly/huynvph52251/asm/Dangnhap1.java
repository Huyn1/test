package fpoly.huynvph52251.asm;



import android.content.Intent;
import android.content.SharedPreferences;
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

public class Dangnhap1 extends AppCompatActivity {
    private String userRegister = "", passRegister = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dangnhap1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            //ánh xạ
            TextInputEditText edtUser = findViewById(R.id.edtUser);
            TextInputLayout txtUser = findViewById(R.id.txtUser);
            TextInputEditText edtPass = findViewById(R.id.edtPass);
            TextInputLayout txtPass = findViewById(R.id.txtPass);
            Button btnLogin = findViewById(R.id.btnLogin);
            Button btnRegister = findViewById(R.id.btnRegister);
            CheckBox chkRemember = findViewById(R.id.chkRemember);

            //Kiểm tra thông tin đăng nhập, người dùng có lưu lại hay không?
            SharedPreferences sharedPreferences = getSharedPreferences("INFO", MODE_PRIVATE);
            boolean isRemember = sharedPreferences.getBoolean("isRemember", false);
            if(isRemember){
                String user = sharedPreferences.getString("userLogin", "");
                String pass = sharedPreferences.getString("passLogin", "");
                edtUser.setText(user);
                edtPass.setText(pass);
                chkRemember.setChecked(isRemember);
                userRegister = user;
                passRegister = pass;
            }

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String userLogin = edtUser.getText().toString();
                    String passLogin = edtPass.getText().toString();
                    if(userLogin.equals(userRegister) && passLogin.equals(passRegister)){
                        //check remember me
                        if(chkRemember.isChecked()){ //chkRemember = true
                            SharedPreferences preferences = getSharedPreferences("INFO", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("userLogin", userLogin);
                            editor.putString("passLogin", passLogin);
                            editor.putBoolean("isRemember", chkRemember.isChecked());
                            editor.apply();
                        }else{
                            SharedPreferences preferences = getSharedPreferences("INFO", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.clear();
                            editor.apply();
                        }
                        Toast.makeText(Dangnhap1.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Dangnhap1.this, QLNS.class));
                    }else{
                        Toast.makeText(Dangnhap1.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }


                }
            });
            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Dangnhap1.this, Dangky.class);
                    myLauncher.launch(intent);
                }
            });
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private ActivityResultLauncher<Intent> myLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            //Nơi xử lí dữ liệu trả về từ Register
                            if(result.getResultCode() == 1){
                                Intent intent = result.getData();
                                userRegister =  intent.getStringExtra("user");
                                passRegister = intent.getStringExtra("pass");
                            }
                        }
                    });
    

}