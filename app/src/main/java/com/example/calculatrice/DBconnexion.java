package com.example.calculatrice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBconnexion extends SQLiteOpenHelper {

    // Noms des colonnes de la table user
    public static final String EMAIL_COLUMN = "Email";
    public static final String VILLE_COLUMN = "Ville";
    public static final String MOT_COLUMN = "Mot";

    // Noms des colonnes de la table annonce
    public static final String TITRE_COLUMN = "Titre";
    public static final String CATEGORIE_COLUMN = "Categorie";
    public static final String SECTEUR_COLUMN = "Secteur";
    public static final String CONTRAT_TYPE_COLUMN = "Contrat_type";
    public static final String VILLEA_COLUMN = "Ville";

    // Nom de la base de données
    private static final String DATABASE_NAME = "Personnes.db";
    private static final int DATABASE_VERSION = 1;

    // Requête de création de la table user
    private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS user (" +
            EMAIL_COLUMN + " TEXT PRIMARY KEY," +
            VILLE_COLUMN + " TEXT," +
            MOT_COLUMN + " TEXT)";

    // Requête de création de la table annonce
    private static final String CREATE_ANNOUNCE_TABLE = "CREATE TABLE IF NOT EXISTS annonce (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            TITRE_COLUMN + " TEXT," +
            CATEGORIE_COLUMN + " TEXT," +
            SECTEUR_COLUMN + " TEXT," +
            CONTRAT_TYPE_COLUMN + " TEXT," +
            VILLEA_COLUMN + " TEXT)";

    public DBconnexion(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_ANNOUNCE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS annonce");
        onCreate(db);
    }

    public void insertNewUser(String email, String city, String password) {
        SQLiteDatabase wDB = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(EMAIL_COLUMN, email);
        contentValue.put(VILLE_COLUMN, city);
        contentValue.put(MOT_COLUMN, password);

        wDB.insert("user", null, contentValue);
    }

    public void insertNewAnnounce(String titre, String categorie, String secteur, String contratType) {
        SQLiteDatabase wDB = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(TITRE_COLUMN, titre);
        contentValue.put(CATEGORIE_COLUMN, categorie);
        contentValue.put(SECTEUR_COLUMN, secteur);
        contentValue.put(CONTRAT_TYPE_COLUMN, contratType);
        contentValue.put(VILLEA_COLUMN, contratType);

        wDB.insert("annonce", null, contentValue);
    }

    public boolean verifierUtilisateur(String email, String motDePasse) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {EMAIL_COLUMN};
        String selection = EMAIL_COLUMN + " = ?" + " AND " + MOT_COLUMN + " = ?";
        String[] selectionArgs = {email, motDePasse};

        Cursor cursor = db.query("user", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }
}