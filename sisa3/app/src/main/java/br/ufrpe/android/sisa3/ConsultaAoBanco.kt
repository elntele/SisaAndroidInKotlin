package br.ufrpe.android.sisa3

import android.annotation.TargetApi
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import android.support.annotation.RequiresApi

import java.util.ArrayList
import java.util.UUID

import br.ufrpe.android.sisa3.database.AlunoBaseHelper
import br.ufrpe.android.sisa3.database.AlunoCursorWrapper
import br.ufrpe.android.sisa3.database.SisaDbSchema
class ConsultaAoBanco {
    private var mContext: Context// add para o banco
    private  var mDatabase: SQLiteDatabase?=null // add para o banco
    private  var sConsultaAoBanco: ConsultaAoBanco? = null

    @TargetApi(Build.VERSION_CODES.P)
    constructor(appContext: Context){
        mContext = appContext.applicationContext // add para o banco
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            mDatabase = AlunoBaseHelper(mContext)// add para o banco
                .getWritableDatabase()
  /*      }else{
            @Suppress("DEPRECATION")
            mDatabase = AlunoBaseHelper(mContext)// add para o banco
                .getWritableDatabase()
        } */
    }

    fun  getInstance(context: Context): ConsultaAoBanco {
        if (sConsultaAoBanco == null) {
            this.sConsultaAoBanco = ConsultaAoBanco(context)
        }
        return this.sConsultaAoBanco as ConsultaAoBanco
    }


    fun getAluno(id: UUID): Aluno? {
        val cursor = queryAluno(
            SisaDbSchema.AlunoTable.Cols.ID + " = ?",
            arrayOf(id.toString())
        )
        try {
            if (cursor.getCount() === 0) {
                return null
            }
            cursor.moveToFirst()
            return cursor.getAluno()
        } finally {
            cursor.close()
        }
    }


    fun getAlunos(): List<Aluno> {
        val alunos = ArrayList<Aluno>()
        val cursor = queryAluno(null, null)
        try {
            cursor.moveToFirst()

            while (!cursor.isAfterLast()) {
                var  aluno=cursor.getAluno()// apagar depois
                alunos.add(cursor.getAluno())
                cursor.moveToNext()
            }
        } finally {
            cursor.close()
        }
        return alunos
    }


    private fun queryAluno(whereClause: String?, whereArgs: Array<String>?): AlunoCursorWrapper {
        val cursor = mDatabase?.query(
            SisaDbSchema.AlunoTable.NAME, // having
            null // orderBy
            , // columns - null selects all columns
            whereClause,
            whereArgs, null, null, null
        )// groupBy
        return AlunoCursorWrapper(cursor)
    }

}