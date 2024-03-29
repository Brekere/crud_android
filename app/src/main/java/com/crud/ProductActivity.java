package com.crud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    private Bundle extras;
    private int store_id = -1;
    private String store_name = "";
    private EditText editTextProductName, editTextProductPrice, editTextProductDescription;
    private Button btnProductCreate, btnProductUpdate, btnProductDelete;
    private int productSelectedId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

// Referencias
        editTextProductName = (EditText) findViewById(R.id.editTextProductName);
        editTextProductPrice = (EditText) findViewById(R.id.editTextProductPrice);
        editTextProductDescription = (EditText) findViewById(R.id.editTextProductDescription);
        btnProductCreate = (Button) findViewById(R.id.btnProductCreate);
        btnProductUpdate = (Button) findViewById(R.id.btnProductUpdate);
        btnProductDelete = (Button) findViewById(R.id.btnProductDelete);

// Oculta el boton de actualizar por defecto
        btnProductUpdate.setVisibility(View.GONE);
        btnProductDelete.setVisibility(View.GONE);

        // Extras
        extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getString("name") != null) {
                btnProductUpdate.setVisibility(View.VISIBLE);
                btnProductDelete.setVisibility(View.VISIBLE);
                btnProductCreate.setVisibility(View.GONE);
            }


            editTextProductName.setText(extras.getString("name"));
            editTextProductPrice.setText("" + extras.getDouble("price", 0.0));
            editTextProductDescription.setText(extras.getString("description"));
            productSelectedId = extras.getInt("_id", 0);

            store_id = extras.getInt("store_id", 0);
            store_name = extras.getString("store_name");
        }

        getSupportActionBar().setTitle("Producto de: " + this.store_name);
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
