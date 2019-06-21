package br.ufrpe.android.sisa3.database


import android.database.Cursor
import android.database.CursorWrapper
import java.util.UUID

import br.ufrpe.android.sisa3.Aluno

//class AlunoCursorWrapper(cursor: Cursor): CursorWrapper(cursor)
class AlunoCursorWrapper(cursor: Cursor?): CursorWrapper(cursor) {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    /*

    fun AlunoCursorWrapper(cursor: Cursor) {
        this.cursor=Cursor
    }
    */


    fun getAluno(): Aluno {
        val idstring = getString(getColumnIndex(SisaDbSchema.AlunoTable.Cols.ID))
        val nomestring = getString(getColumnIndex(SisaDbSchema.AlunoTable.Cols.NOME))
        val emailstring = getString(getColumnIndex(SisaDbSchema.AlunoTable.Cols.EMAIL))
        val senhastring = getString(getColumnIndex(SisaDbSchema.AlunoTable.Cols.SENHA))
        val cpfstring = getString(getColumnIndex(SisaDbSchema.AlunoTable.Cols.CPF))
        val areastring = getString(getColumnIndex(SisaDbSchema.AlunoTable.Cols.AREA))
        val cursadasstring = getString(getColumnIndex(SisaDbSchema.AlunoTable.Cols.CURSADAS))


        val anodeingressostring = getString(getColumnIndex(SisaDbSchema.AlunoTable.Cols.ANODEINGRESSO))
        val periododeingressostring = getString(getColumnIndex(SisaDbSchema.AlunoTable.Cols.PERIODODEINGRESSO))
        val qtddeperiodostrancadosstring =
            getString(getColumnIndex(SisaDbSchema.AlunoTable.Cols.QTDDEPERIODOSTRANCADOS))
        val aluno = Aluno(UUID.fromString(idstring))//  tentadndo instanciar um aluno
        aluno.setNome(nomestring)
        aluno.setEmail(emailstring)
        aluno.setSenha(senhastring)
        aluno.setCpf(Integer.parseInt(cpfstring))
        //aluno.setCursadas(listaCursadas);
        aluno.setAndoDeIngresso(Integer.parseInt(anodeingressostring))
        aluno.setPeriodoDeIngresso(Integer.parseInt(periododeingressostring))
        aluno.setQtdDePeriodosTrancado(Integer.parseInt(qtddeperiodostrancadosstring))
        aluno.setArea(areastring)
        return aluno
    }

}