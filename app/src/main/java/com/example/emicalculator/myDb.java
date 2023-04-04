package com.example.emicalculator;

import static java.sql.Types.NULL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class myDb extends SQLiteOpenHelper {
private static final String Dbname = "credit_debit ";
    private static final int Dbversion = 1;
    private static final int Dbfactory = 1;
    public myDb(@Nullable Context context) {
        super(context, Dbname, null, Dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("     CREATE TABLE USER (\n" +
        "                userId INT PRIMARY KEY AUTOINCREMENT,\n" +
        "                firstName VARCHAR(50) NOT NULL,\n" +
        "                lastName VARCHAR(50) NOT NULL,\n" +
        "                email VARCHAR(50) UNIQUE NOT NULL,\n" +
        "                password VARCHAR(255) NOT NULL\n" +
        "        );" +

        "        CREATE TABLE ACCOUNT (\n" +
        "                accountId INT PRIMARY KEY AUTO_INCREMENT,\n" +
        "                userId INT NOT NULL,\n" +
        "                accountType VARCHAR(50) NOT NULL,\n" +
        "                balance DECIMAL(10,2) NOT NULL DEFAULT 0,\n" +
        "                FOREIGN KEY (userId) REFERENCES USER(userId)\n" +
        "        );\n" +
        "\n" +
        "        CREATE TABLE TRANSACTION (\n" +
        "                transactionId INT PRIMARY KEY AUTO_INCREMENT,\n" +
        "                accountId INT NOT NULL,\n" +
        "                amount DECIMAL(10,2) NOT NULL,\n" +
        "                transactionType ENUM('debit', 'credit') NOT NULL,\n" +
        "                date DATE NOT NULL,\n" +
        "                FOREIGN KEY (accountId) REFERENCES ACCOUNT(accountId)\n" +
        "        );");

SQLiteDatabase database = this.getReadableDatabase();
        database.close();




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void adduser(String first_name ,String Last_name )
    {

        SQLiteDatabase db = this.getWritableDatabase();
       // db.insert();
    }
}
