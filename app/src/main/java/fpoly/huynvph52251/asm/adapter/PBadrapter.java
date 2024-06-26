package fpoly.huynvph52251.asm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import fpoly.huynvph52251.asm.R;
import fpoly.huynvph52251.asm.model.PhongBan1;

public class PBadrapter extends BaseAdapter {
private TextView txtTenpb;
    private Context context;
    private ArrayList<PhongBan1> dsPB;

    public PBadrapter(Context context, ArrayList<PhongBan1>dsPB) {
        this.context = context;

        this.dsPB = dsPB;
    }

    @Override
    public int getCount() {
        return dsPB.size();
    }

    @Override
    public Object getItem(int position) {
        return dsPB.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater minflater = ((Activity)context).getLayoutInflater();
        View view = minflater.inflate(R.layout.item_phongban,parent, false);
        txtTenpb = view.findViewById(R.id.txtTenPb);
    String data = dsPB.get(position).getMapb() + "-" +dsPB.get(position).getTenpb();
    txtTenpb.setText(data);
        return view;
    }
}
