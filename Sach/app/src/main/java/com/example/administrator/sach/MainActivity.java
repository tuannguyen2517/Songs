package com.example.administrator.sach;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listItem;
    int[] hinhNen = {R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5};
    int[] hinhView = {R.drawable.eye, R.drawable.eye, R.drawable.eye, R.drawable.eye, R.drawable.eye};
    int[] hinhLike = {R.drawable.like, R.drawable.like, R.drawable.like, R.drawable.like, R.drawable.like};
    int[] hinhDisLike = {R.drawable.dislike, R.drawable.dislike, R.drawable.dislike, R.drawable.dislike, R.drawable.dislike};
    String[] tenNhac = {"Con Bướm Xuân", "Chắc ai đó sẽ về", "Con gái có quyền điệu", "Âm thầm bên em", "Tìm em"};
    String[] tenCasi = {"Hồ Quang Hiếu", "Sơn Tùng M- TP", "Hari Won", "Sơn Tùng M- TP", "Hồ Quang Hiếu"};
    String[] views = {"1234","1232", "12345", "1245", "1235"};
    String[] likes = {"1231", "1321", "102", "105", "1000"};
    String[] disLikes = {"43", "22", "10", "0", "4"};

    List<listItem> danhSachListI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItem = (ListView) findViewById(R.id.listSong);

        danhSachListI = new ArrayList<>();
        for(int i=0; i<hinhNen.length;i++)
        {
            listItem listI= new listItem();
            listI.setAnhNen(hinhNen[i]);
            listI.setAnhView(hinhView[i]);
            listI.setAnhThich(hinhLike[i]);
            listI.setAnhKoThich(hinhDisLike[i]);
            listI.setTenBH(tenNhac[i]);
            listI.setTenCS(tenCasi[i]);
            listI.setLuotViews(views[i]);
            listI.setLuotThich(likes[i]);
            listI.setLuotKoThich(disLikes[i]);
            danhSachListI.add(listI);
        }
        CustomAdapter  adapterlistItem= new CustomAdapter(this,R.layout.list_view_song,danhSachListI);
        adapterlistItem.notifyDataSetChanged();
        listItem.setAdapter(adapterlistItem);

    }

    public class CustomAdapter extends ArrayAdapter<listItem> {
        Context context;
        int resource;
        List<listItem> listitem;

        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<listItem> objects) {
            super(context, resource, objects);

            this.context = context;
            this.resource = resource;
            this.listitem = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowItem = inflater.inflate(resource, parent, false);
            ImageView anhNen= (ImageView)rowItem.findViewById(R.id.anhNhac);
            ImageView anhViews= (ImageView)rowItem.findViewById(R.id.anhEye);
            ImageView anhLike= (ImageView)rowItem.findViewById(R.id.anhLike);
            ImageView anhDisLike= (ImageView)rowItem.findViewById(R.id.anhDisLike);
            TextView tenBNhac= (TextView)rowItem.findViewById(R.id.tenNhac);
            TextView caSi= (TextView)rowItem.findViewById(R.id.caSi);
            TextView luotXem=(TextView)rowItem.findViewById(R.id.luotXem);
            TextView luotThich=(TextView)rowItem.findViewById(R.id.thich);
            TextView luotkoThich=(TextView)rowItem.findViewById(R.id.koThich);

            anhNen.setImageResource(listitem.get(position).getAnhNen());
            anhViews.setImageResource(listitem.get(position).getAnhView());
            anhLike.setImageResource(listitem.get(position).getAnhThich());
            anhDisLike.setImageResource(listitem.get(position).getAnhKoThich());
            tenBNhac.setText(listitem.get(position).getTenBH());
            caSi.setText(listitem.get(position).getTenCS());
            luotXem.setText(listitem.get(position).getLuotViews());
            luotThich.setText(listitem.get(position).getLuotThich());
            luotkoThich.setText(listitem.get(position).getLuotKoThich());

            return rowItem;
        }
    }
}