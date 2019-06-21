package br.ufrpe.android.sisa3.database


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import br.ufrpe.android.sisa3.Disciplina
import br.ufrpe.android.sisa3.database.SisaDbSchema.DisciplinaTable


class DisciplinaBaseHelper(context: Context):SQLiteOpenHelper(context, "disciplinaBase", null, 1) {

     private val VERSION = 1
    private val DATABASE_NAME = "disciplinaBase.db"

   /*  fun DisciplinaBaseHelper(context: Context):??? {
super(context, DATABASE_NAME, null, VERSION)
}
*/
    override fun onCreate(db: SQLiteDatabase) {
db.execSQL(
    "create table " + DisciplinaTable.NAME + "(" +
    "_id integer primary key autoincrement, " +
    DisciplinaTable.Cols.ID + ", " +
    DisciplinaTable.Cols.AREA + ", " +
    DisciplinaTable.Cols.CODIGO + ", " +
    DisciplinaTable.Cols.PERIODO + ", " +
    DisciplinaTable.Cols.SEMESTRE + ", " +
    DisciplinaTable.Cols.CURSADA + ", " +
    DisciplinaTable.Cols.NOME +
    ")"

)




}

    override fun onUpgrade(db: SQLiteDatabase, oldVersion:Int, newVersion:Int) {

}

}