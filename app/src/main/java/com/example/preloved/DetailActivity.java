package com.example.preloved;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<Preloved> list = new ArrayList<>();
    private String title = "Mode List";

    public static final String EXTRA_JUDUL = "judul";
    public static final String EXTRA_KATEGORI = "kategori";
    public static final String EXTRA_PHOTO = "foto";
    public static final String EXTRA_DESC = "desc";
    public static final String EXTRA_SIZE = "size";
    public static final String EXTRA_WARNA = "warna";
    public static final String EXTRA_HARGA = "harga";

    TextView moveKimora;
    TextView moveLace;
    ImageView moveClassic;
    TextView moveTribal;
    TextView moveSize;
    TextView moveWarna;
    TextView moveHarga;

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_detail);

        moveKimora = findViewById(R.id.activity_move_kimora);
        //setActionBarTitle("Circle");
        moveLace = findViewById(R.id.ktgr);
        moveClassic = findViewById(R.id.profile_image);
        moveTribal = findViewById(R.id.hal);
        moveSize = findViewById(R.id.size);
        moveWarna = findViewById(R.id.warna);
        moveHarga = findViewById(R.id.harga);


        String kimora = getIntent().getStringExtra("kimora");
        String lace = getIntent().getStringExtra("lace");
        String classic = getIntent().getStringExtra("classic");
        String tribal = getIntent().getStringExtra("tribal");
        String size = getIntent().getStringExtra("size");
        String warna = getIntent().getStringExtra("warna");
        String harga = getIntent().getStringExtra("harga");

        moveKimora.setText(kimora);
        moveLace.setText(lace);
//      moveClassic.setText(classic);
        moveTribal.setText(tribal);
        moveSize.setText(size);
        moveWarna.setText(warna);
        moveHarga.setText(harga);

        Glide.with(this)
                .load(classic)
                .apply(new RequestOptions().override(350, 550))
                .into(moveClassic);

        ///tombol back
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
        ///
    }
}