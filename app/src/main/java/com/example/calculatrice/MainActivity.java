package com.example.calculatrice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Déclaration de la base de données
    DBconnexion db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation de la base de données
        db = new DBconnexion(this);
    }

    public void connecter(View view) {
        EditText emailEditText = findViewById(R.id.chEmaill);
        EditText motEditText = findViewById(R.id.chMott);

        String email = emailEditText.getText().toString();
        String mot = motEditText.getText().toString();

        // Vérifier si l'utilisateur existe dans la base de données avec cet e-mail et ce mot de passe
        boolean utilisateurExiste = db.verifierUtilisateur(email, mot);

        if (utilisateurExiste) {
            // Afficher un message de connexion réussie
            Toast.makeText(this, "Connexion réussie", Toast.LENGTH_SHORT).show();

            // Redirection vers Activity3
            Intent intent = new Intent(MainActivity.this, Activity3.class);
            startActivity(intent);
        } else {
            // Afficher un message d'erreur si les informations d'identification sont incorrectes
            Toast.makeText(this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickSignup(View view) {
        // Démarrage de l'activité d'inscription
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
    }

}


