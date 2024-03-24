package com.example.calculatrice;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void Enregistrer(View view) {
        EditText emailEditText = findViewById(R.id.chEmail);
        EditText villeEditText = findViewById(R.id.chVille);
        EditText motEditText = findViewById(R.id.chMot);
        EditText cmotEditText = findViewById(R.id.chCMot);

        String email = emailEditText.getText().toString();
        String ville = villeEditText.getText().toString();
        String mot = motEditText.getText().toString();
        String cmot = cmotEditText.getText().toString();

        // Vérifier si tous les champs sont remplis
        if (email.isEmpty() || ville.isEmpty() || mot.isEmpty() || cmot.isEmpty()) {
            // Afficher un message d'erreur si les champs ne sont pas tous remplis
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return; // Sortir de la méthode si un champ est vide
        }

        // Vérification de la présence de "@" dans l'email
        if (!email.contains("@")) {
            Toast.makeText(this, "Veuillez saisir une adresse e-mail valide", Toast.LENGTH_SHORT).show();
            return; // Sortir de la méthode si "@" n'est pas présent dans l'email
        }

        // Vérification de la longueur minimale du mot de passe
        if (mot.length() < 6) {
            Toast.makeText(this, "Le mot de passe doit contenir au moins 6 caractères", Toast.LENGTH_SHORT).show();
            return; // Sortir de la méthode si la longueur du mot de passe est insuffisante
        }

        // Vérifier si les mots de passe correspondent
        if (!mot.equals(cmot)) {
            Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
            return; // Sortir de la méthode si les mots de passe ne correspondent pas
        }

        // Si toutes les vérifications réussissent, procéder à l'insertion dans la base de données
        DBconnexion db = new DBconnexion(this);
        db.insertNewUser(email, ville, mot);

        // Effacer les champs après l'enregistrement
        emailEditText.setText("");
        villeEditText.setText("");
        motEditText.setText("");
        cmotEditText.setText("");

        // Afficher un message de succès
        Toast.makeText(this, "Enregistrement effectué avec succès", Toast.LENGTH_SHORT).show();
    }

}
