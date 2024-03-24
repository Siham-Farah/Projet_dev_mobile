package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

public class Activity4 extends AppCompatActivity {

    EditText chVille;
    Button btnEnregistrer;
    HashMap<String, Integer> annoncesParVille; // HashMap pour stocker le nombre d'annonces par ville

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        // Initialisation de la HashMap et ajout des valeurs par défaut
        annoncesParVille = new HashMap<>();
        annoncesParVille.put("settat", 2); // Exemple : 2 annonces pour la ville de Settat

        chVille = findViewById(R.id.chVille);
        btnEnregistrer = findViewById(R.id.btnEnregistrer);

        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chercherAnnoncesParVille();
            }
        });
    }

    private void chercherAnnoncesParVille() {
        // Récupérer la valeur saisie dans le champ ville
        String ville = chVille.getText().toString().trim();

        // Vérifier si la ville existe dans la HashMap
        if (annoncesParVille.containsKey(ville)) {
            // Récupérer le nombre d'annonces pour cette ville
            int nombreAnnonces = annoncesParVille.get(ville);
            // Afficher le nombre d'annonces dans un Toast
            String message = "Le nombre d'annonces pour " + ville + " : " + nombreAnnonces;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            // Si la ville n'existe pas dans la HashMap, afficher un message d'erreur
            Toast.makeText(this, "Aucune annonce trouvée pour la ville spécifiée.", Toast.LENGTH_SHORT).show();
        }
    }
}
