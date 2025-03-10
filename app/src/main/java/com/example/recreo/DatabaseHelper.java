package com.example.recreo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Nombre de la base de datos y tabla
    public static final String DATABASE_NAME = "Usuarios.db";
    public static final String TABLE_NAME = "usuarios";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NOMBRE";
    public static final String COL_3 = "APELLIDO";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "CONTRASENA";
    public static final String COL_6 = "TELEFONO";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear tabla
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, APELLIDO TEXT, EMAIL TEXT, CONTRASENA TEXT, TELEFONO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Si la tabla existe, eliminarla
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Método para insertar datos
    public boolean insertarDatos(String nombre, String apellido, String email, String contrasena, String telefono) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, nombre);
        contentValues.put(COL_3, apellido);
        contentValues.put(COL_4, email);
        contentValues.put(COL_5, contrasena);
        contentValues.put(COL_6, telefono);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // Método para verificar usuario y contraseña
    public boolean verificarUsuario(String email, String contrasena) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE EMAIL=? AND CONTRASENA=?", new String[]{email, contrasena});
        return cursor.getCount() > 0;
    }
}

