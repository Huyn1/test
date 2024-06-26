package fpoly.huynvph52251.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import fpoly.huynvph52251.asm.adapter.PBadrapter;
import fpoly.huynvph52251.asm.model.PhongBan1;

public class PhongBan extends AppCompatActivity {
private ListView lvphongban;
private SearchView svphongban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_ban);
        //giao dien
            //gd chuaws listview
        lvphongban = findViewById(R.id.lvphongban);
            //gd chua item hien thi
        //data
      ArrayList<PhongBan1> dsPB = new ArrayList<>();
      dsPB.add(new PhongBan1("pb01", " Nhan su"));
        dsPB.add(new PhongBan1("pb02", " Hanh chinh"));
        dsPB.add(new PhongBan1("pb03", " Dao tao"));


        //adrap
        PBadrapter adrapter;
        adrapter = new PBadrapter(PhongBan.this,dsPB);
        lvphongban.setAdapter(adrapter);
        loadData(dsPB);

        // xu ly sreachview
        svphongban = findViewById(R.id.svphongban);
        svphongban.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // thuc hien hd
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // khi query thay doi
                ArrayList<PhongBan1> listphonban = new ArrayList<>();
                for (PhongBan1 phongBan1 : dsPB ){
                    if (phongBan1.getTenpb().toLowerCase().contains(newText.toLowerCase())){
                        listphonban.add(phongBan1);
                    }
                }
                loadData(listphonban);
                return false;
            }
        });

    }
    private void loadData(ArrayList<PhongBan1>list1){
        PBadrapter adrapter;
        adrapter = new PBadrapter(PhongBan.this,list1);
        lvphongban.setAdapter(adrapter);

    }

}