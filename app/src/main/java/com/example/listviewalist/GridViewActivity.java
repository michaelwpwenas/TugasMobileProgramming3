package com.example.listviewalist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.ImageDecoder;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    GridView myGridView;
    ArrayList<Mahasiswa> listMhs3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        myGridView=(GridView) findViewById(R.id.gridViewData);
        Intent intent=getIntent();
        listMhs3=intent.getParcelableArrayListExtra("datagriditem");
        if (listMhs3!=null){
            setGridViewAdapter();
        }
        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this,listMhs3.get(i).getNama(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setGridViewAdapter(){
        ArrayAdapter<Mahasiswa> adapter=new myGridAdapter();
        myGridView.setAdapter(adapter);
    }

    private class myGridAdapter extends ArrayAdapter<Mahasiswa> {

        public myGridAdapter() {
            super(GridViewActivity.this,R.layout.data_item_grid,listMhs3);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView=convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.data_item_grid,parent,false);
            }
            Mahasiswa curMhs=listMhs3.get(position);
            ImageView imvGrid=(ImageView) itemView.findViewById(R.id.imageViewGrid);
            imvGrid.setImageResource(curMhs.getFoto());
            TextView tvIDGrid=(TextView) itemView.findViewById(R.id.textViewIDGrid);
            tvIDGrid.setText(curMhs.getId().toString());
            TextView tvNamaGrid=(TextView) itemView.findViewById(R.id.textViewNamaGrid);
            tvNamaGrid.setText(curMhs.getNama().toString());
            TextView tvUmurGrid=(TextView) itemView.findViewById(R.id.textViewUmurGrid);
            tvUmurGrid.setText(String.valueOf(curMhs.getUmur()));

            return super.getView(position, convertView, parent);
        }
    }
}