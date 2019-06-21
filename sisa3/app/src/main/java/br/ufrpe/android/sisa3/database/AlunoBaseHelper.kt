package br.ufrpe.android.sisa3.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.os.Parcel
import android.support.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.P)// adicionado por causa da versão minima 19, a ide reclamou, falou que tinha que se só a 28
class AlunoBaseHelper(context: Context?) :// nem sei se vai funcionar, em  java não tinha
    SQLiteOpenHelper(context,  "alunoBase.db", null, 1 ) {                                                    // esses parametros de construção da classe

// era o construtor antigo em java
/*    private val VERSION = 1
    private val DATABASE_NAME = "alunoBase.db"
     fun AlunoBaseHelper(context:Context):??? {
super(context, DATABASE_NAME, null, VERSION)
}
*/

    override fun onCreate(db:SQLiteDatabase) {


db.execSQL(
    "create table " + SisaDbSchema.AlunoTable.NAME + "(" +
    "_id integer primary key autoincrement, " +
    SisaDbSchema.AlunoTable.Cols.ID + ", " +
    SisaDbSchema.AlunoTable.Cols.NOME + ", " +
    SisaDbSchema.AlunoTable.Cols.CPF + ", " +
    SisaDbSchema.AlunoTable.Cols.EMAIL + ", " +
    SisaDbSchema.AlunoTable.Cols.SENHA + ", " +
    SisaDbSchema.AlunoTable.Cols.AREA + ", " +
    SisaDbSchema.AlunoTable.Cols.CURSADAS + "," +
    SisaDbSchema.AlunoTable.Cols.ANODEINGRESSO + ", " +
    SisaDbSchema.AlunoTable.Cols.PERIODODEINGRESSO + "," +
    SisaDbSchema.AlunoTable.Cols.QTDDEPERIODOSTRANCADOS +

    ")"
)
}

    override fun onUpgrade(db:SQLiteDatabase, oldVersion:Int, newVersion:Int) {

}


}