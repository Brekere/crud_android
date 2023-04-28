package com.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StoreActivity extends AppCompatActivity {
    private EditText editTextName, editTextAddress;
    private Bundle extras;
    private Button btnCreate, btnUpdate, btnDelete;
    private int storeSelectedId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

// Referencia de los objetos gráficos
        this.editTextName = (EditText) findViewById(R.id.editTextName);
        this.editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        this.btnCreate = (Button) findViewById(R.id.btnCreate);
        this.btnUpdate = (Button) findViewById(R.id.btnUpdate);
        this.btnDelete = (Button) findViewById(R.id.btnDelete);

// Oculta el boton de actualizar por defecto
        btnUpdate.setVisibility(View.GONE);
        this.btnDelete.setVisibility(View.GONE);

        //Extras
        extras = getIntent().getExtras();
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.btnUpdate.setVisibility(View.VISIBLE);
            this.btnDelete.setVisibility(View.VISIBLE);
            this.btnCreate.setVisibility(View.GONE);

            this.editTextName.setText(extras.getString("name"));
            this.editTextAddress.setText(extras.getString("address"));
            this.storeSelectedId = extras.getInt("_id", 0);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tienda");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish(); // Destruye la actividad actual
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onCreate(View view) {

    }

    public void onUpdate(View view) {

    }

    public void onDelete(View view) {

    }
}

