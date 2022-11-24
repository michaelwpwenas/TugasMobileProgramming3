package com.example.listviewalist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ArrayList<Mahasiswa> listMhs2;
    ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        myList=(ListView) findViewById(R.id.listViewData);
        Intent intent=getIntent();
        listMhs2=intent.getParcelableArrayListExtra("datalist");

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Toast.makeText(ListViewActivity.this, listMhs2.get(i).getNama(), Toast.LENGTH_SHORT).show();
            }
        });

        if(listMhs2!=null) {
            listAdapter();
        }

    }

    void listAdapter() {
        ArrayAdapter<Mahasiswa> adapter = new myListAdapter();
        myList.setAdapter(adapter);
    }

    private class myListAdapter extends ArrayAdapter<Mahasiswa>{
        public myListAdapter(){
            super(ListViewActivity.this,R.layout.data_item,listMhs2);
            }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView=convertView;
            if (itemView==null) {
                itemView = getLayoutInflater().inflate(R.layout.data_item, parent, false);
            }
            Mahasiswa curMhs=listMhs2.get(position);
            ImageView imvList=(ImageView) itemView.findViewById(R.id.imageViewListView);
            imvList.setImageResource(curMhs.getFoto());
            TextView tvListID=(TextView) itemView.findViewById((R.id.textViewListViewID));
            tvListID.setText(curMhs.getId());
            TextView tvListNama=(TextView) itemView.findViewById((R.id.textViewListViewNama));
            tvListNama.setText(curMhs.getNama());
            TextView tvListUmur=(TextView) itemView.findViewById((R.id.textViewListViewUmur));
            tvListUmur.setText(String.valueOf(curMhs.getUmur()));

            return itemView;
        }
    }
    }
