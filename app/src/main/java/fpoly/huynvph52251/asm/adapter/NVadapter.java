package fpoly.huynvph52251.asm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import fpoly.huynvph52251.asm.R;
import fpoly.huynvph52251.asm.model.Nhanvien;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;



import java.util.ArrayList;
public class NVadapter extends BaseAdapter {
    private  TextView txtManv;
    private  TextView txtNhanvien;
    private   TextView txtpb;
    private  ImageView btnsua;
    private ImageView btnxoa;
    private Context context;
    private ArrayList<Nhanvien> listnv;

    public NVadapter(Context context, ArrayList<Nhanvien> listnv) {
        this.context = context;
        this.listnv = listnv;
    }

    @Override
    public int getCount() {
        return listnv.size();
    }

    @Override
    public Object getItem(int position) {
        return listnv.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater minflater = ((Activity)context).getLayoutInflater();
        View view = minflater.inflate(R.layout.item_nhanvien,parent, false);
         txtManv = view.findViewById(R.id.txtManv);
         txtNhanvien = view.findViewById(R.id.txtNhanvien);
         txtpb = view.findViewById(R.id.txtpb);
         btnsua = view.findViewById(R.id.btnsua);
         btnxoa = view.findViewById(R.id.btnxoa);

         txtManv.setText(listnv.get(position).getManv());
        txtNhanvien.setText(listnv.get(position).getTennv());
        txtpb.setText(listnv.get(position).getTenpb());


        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Confimdelete(position);

            }
        });
        return view;




    }
    void Confimdelete(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Bạn có đồng ý xóa không ?");
        builder.setTitle("thông báo");
        //nut bam xoa
        builder.setPositiveButton("đồng ý xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listnv.remove(i);
                notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("không xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
