package com.ismailhakkiaydin.listviewbaseadapter;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class TekSatir{

    String ulke;
    String tanim;
    int bayrak;

    TekSatir(String u, String t, int b){
        this.ulke=u;
        this.tanim=t;
        this.bayrak=b;
    }
}

class ViewYerTutucu{
    ImageView img;
    TextView ulke;
    TextView tanim;

    ViewYerTutucu(View v){
        img= (ImageView) v.findViewById(R.id.iVBayrak);
        ulke= (TextView) v.findViewById(R.id.tvUlke);
        tanim= (TextView) v.findViewById(R.id.tvTanim);

    }

}


public class CustomAdapter extends BaseAdapter {

    ArrayList liste;
    Context context;

    CustomAdapter(Context c){
        context=c;

        liste=new ArrayList();

        Resources kaynaklar=c.getResources();
        String[] ulkeAdlari=kaynaklar.getStringArray(R.array.ulkeAdlari);
        String[] ulkeTanimlari=kaynaklar.getStringArray(R.array.ulke_tanimlari);
        int[] bayrakResimleri={R.drawable.ulke1, R.drawable.ulke2, R.drawable.ulke3, R.drawable.ulke4,
                R.drawable.ulke5, R.drawable.ulke6, R.drawable.ulke7, R.drawable.ulke8,
                R.drawable.ulke9, R.drawable.ulke10, R.drawable.ulke10, R.drawable.ulke11,
                R.drawable.ulke12, R.drawable.ulke13, R.drawable.ulke14, R.drawable.ulke15,
                R.drawable.ulke16, R.drawable.ulke17, R.drawable.ulke18,
                R.drawable.ulke19, R.drawable.ulke20};

        for (int i=0; i<20; i++)
        {
            /*TekSatir t=new TekSatir(ulkeAdlari[i],ulkeTanimlari[i], bayrakResimleri[i]);
            liste.add(t);*/

            liste.add(new TekSatir(ulkeAdlari[i],ulkeTanimlari[i], bayrakResimleri[i]));

        }

    }



    @Override
    public int getCount() {
        return liste.size();
    }

    @Override
    public Object getItem(int position) {
        return liste.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View satir=convertView;
        ViewYerTutucu yerTutucu=null;
        if(satir==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            satir=inflater.inflate(R.layout.tek_satir,parent,false);
            yerTutucu=new ViewYerTutucu(satir);
            satir.setTag(yerTutucu);
        }
        else{

            yerTutucu= (ViewYerTutucu) satir.getTag();
        }


        TekSatir gecici= (TekSatir) liste.get(position);
        yerTutucu.img.setImageResource(gecici.bayrak);
        yerTutucu.ulke.setText(gecici.ulke);
        yerTutucu.tanim.setText(gecici.tanim);

        return satir;
    }
}