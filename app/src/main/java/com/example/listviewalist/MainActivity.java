package com.example.listviewalist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int idFoto;
    EditText etID,etNama,etUmur;
    Spinner spFoto;
    ImageView ivFoto;
    Button btSimpan,btHasil,btViewGrid;

    String isiSP[]={"Gambar1","Gambar2","Gambar3","Gambar4","Gambar5","Gambar6"};

    ArrayList<Mahasiswa> listMhs=new ArrayList<Mahasiswa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,isiSP);

        etID=(EditText) findViewById(R.id.editTextID);
        etNama=(EditText) findViewById(R.id.editTextNama);
        etUmur=(EditText) findViewById(R.id.editTextUmur);
        spFoto=(Spinner) findViewById(R.id.spinnerFoto);
        ivFoto=(ImageView) findViewById(R.id.imageViewFoto);
        btSimpan=(Button) findViewById(R.id.buttonSimpan);
        btHasil=(Button) findViewById(R.id.buttonHasil);
        btViewGrid=(Button) findViewById(R.id.buttonLihat);

        idFoto=R.drawable.gambar1;

        spFoto.setAdapter(adapter);

        ivFoto.setImageResource(R.drawable.gambar1);

        spFoto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, adapter.getItem(i), Toast.LENGTH_SHORT).show();
                switch (adapter.getItem(i)){
                    case "Gambar1" :
                        idFoto=R.drawable.gambar1;
                        ivFoto.setImageResource(R.drawable.gambar1);
                        break;
                    case "Gambar2" :
                        idFoto=R.drawable.gambar2;
                        ivFoto.setImageResource(R.drawable.gambar2);
                        break;
                    case "Gambar3" :
                        idFoto=R.drawable.gambar3;
                        ivFoto.setImageResource(R.drawable.gambar3);
                        break;
                    case "Gambar4" :
                        idFoto=R.drawable.gambar4;
                        ivFoto.setImageResource(R.drawable.gambar4);
                        break;
                    case "Gambar5" :
                        idFoto=R.drawable.gambar5;
                        ivFoto.setImageResource(R.drawable.gambar5);
                        break;
                    case "Gambar6" :
                        idFoto=R.drawable.gambar6;
                        ivFoto.setImageResource(R.drawable.gambar6);
                        break;
                    case "Gambar7" :
                        idFoto=R.drawable.gambar7;
                        ivFoto.setImageResource(R.drawable.gambar7);
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Mahasiswa mhs=new Mahasiswa();
            mhs.setId(etID.getText().toString());
            mhs.setNama(etNama.getText().toString());
            mhs.setUmur(Integer.parseInt(etUmur.getText().toString()));
            mhs.foto=idFoto;
            listMhs.add(mhs);
            clearComponent();
            }
        });

        btHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ListViewActivity.class);
                intent.putParcelableArrayListExtra("datalist",listMhs);
                startActivity(intent);
            }
        });

        btViewGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, GridViewActivity.class);
                intent.putParcelableArrayListExtra("datagriditem",listMhs);
                startActivity(intent);
            }
        });

    }

    void clearComponent() {
        etUmur.setText("");
        etNama.setText("");
        etID.setText("");
        spFoto.setSelection(0);
        ivFoto.setImageResource(R.drawable.gambar1);
    }
}