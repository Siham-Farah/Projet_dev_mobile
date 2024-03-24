package com.example.calculatrice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void Suivant(View view) {
        EditText titleEditText = findViewById(R.id.editTextTitle);
        EditText categorieEditText = findViewById(R.id.editCategorie);
        EditText sectorEditText = findViewById(R.id.editSecteur);
        EditText typeEditText = findViewById(R.id.editContrat);
        EditText DescriptioneditText = findViewById(R.id.editTextDescription);
        EditText VilleeditText = findViewById(R.id.editTextVille);

        String Titre = titleEditText.getText().toString();
        String Categorie = categorieEditText.getText().toString();
        String Secteur = sectorEditText.getText().toString();
        String Contrat_type = typeEditText.getText().toString();
        String Description = typeEditText.getText().toString();
        String Ville = typeEditText.getText().toString();

        // Vérifier si tous les champs sont remplis
        if (Titre.isEmpty() && Categorie.isEmpty()  && Description.isEmpty() && Ville.isEmpty()) {

            // Afficher un message d'erreur si les champs ne sont pas tous remplis
            Toast.makeText(this, "Veuillez remplir tous les champs obligatoire", Toast.LENGTH_SHORT).show();
        } else {
        Toast.makeText(this, "Enregistrement effectué avec succès", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Activity3.this, Activity4.class);
        startActivity(intent);

    }}}
