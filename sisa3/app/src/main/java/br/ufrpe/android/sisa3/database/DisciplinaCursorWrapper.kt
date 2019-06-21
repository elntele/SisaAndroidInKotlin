package br.ufrpe.android.sisa3.database

import android.database.Cursor
import java.util.*


import android.database.CursorWrapper

import java.util.UUID

import br.ufrpe.android.sisa3.Disciplina

class DisciplinaCursorWrapper (cursor: Cursor): CursorWrapper(cursor) {

    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    /*
    fun DisciplinaCursorWrapper(cursor: Cursor): ??? {
        super(cursor)
    }
    */

    fun getDisciplina(): Disciplina {

        val nomestring = getString(getColumnIndex(SisaDbSchema.DisciplinaTable.Cols.NOME))
        val idstring = getString(getColumnIndex(SisaDbSchema.DisciplinaTable.Cols.ID))
        val areastring = getString(getColumnIndex(SisaDbSchema.DisciplinaTable.Cols.AREA))
        val periodostring = getString(getColumnIndex(SisaDbSchema.DisciplinaTable.Cols.PERIODO))
        val codigostring = getString(getColumnIndex(SisaDbSchema.DisciplinaTable.Cols.CODIGO))
        val semestrestring = getString(getColumnIndex(SisaDbSchema.DisciplinaTable.Cols.SEMESTRE))
        val iscursada = getInt(getColumnIndex(SisaDbSchema.DisciplinaTable.Cols.CURSADA))
        val disciplina = Disciplina(UUID.fromString(idstring))
        disciplina.setNome(nomestring)
        disciplina.setArea(areastring)
        disciplina.setPeriodo(periodostring)
        disciplina.setCodigo(codigostring)
        disciplina.setSemestre(semestrestring)
        disciplina.setCursada(iscursada != 0)
        return disciplina


    }


}