package fpoly.huynvph52251.asm;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import fpoly.huynvph52251.asm.adapter.NVadapter;
import fpoly.huynvph52251.asm.adapter.PBadrapter;
import fpoly.huynvph52251.asm.model.Nhanvien;
import fpoly.huynvph52251.asm.model.PhongBan1;

public class NhanVien extends AppCompatActivity {
private   ListView lvNv;
private Button themnv;
private SearchView timkiem;
private ImageView thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);
       lvNv = findViewById(R.id.lvNv);
        // data
        ArrayList<Nhanvien> dsNV = new ArrayList<>();
        dsNV.add(new Nhanvien("Ph512", "Nguyen Van Huy", "Hanh CHinh"));
        dsNV.add(new Nhanvien("Ph513", "Nguyen Van Duy", "Hanh CHinh"));
        dsNV.add(new Nhanvien("Ph514", "Nguyen Van Nam", "Dao tao"));
        dsNV.add(new Nhanvien("Ph515", "Nguyen Van Viet", "Nhan su"));
        dsNV.add(new Nhanvien("Ph516", "Nguyen Van Huan", "Hanh CHinh"));
        dsNV.add(new Nhanvien("Ph517", "Nguyen Van Hoai", "Nhan su"));

        NVadapter adrapter = new NVadapter(NhanVien.this,dsNV);
        lvNv.setAdapter(adrapter);

        themnv = findViewById(R.id.themnv);
        themnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(NhanVien.this , themNV.class);
               myLauncher.launch(intent);
            }
        });

        thoat = findViewById(R.id.thoat);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private ActivityResultLauncher<Intent> myLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            //Nơi xử lí dữ liệu trả về từ Register


                        }
                    });


}