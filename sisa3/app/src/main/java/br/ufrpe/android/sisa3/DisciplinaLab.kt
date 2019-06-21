package br.ufrpe.android.sisa3

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

import java.util.ArrayList
import java.util.UUID

import br.ufrpe.android.sisa3.database.AlunoBaseHelper
import br.ufrpe.android.sisa3.database.DisciplinaBaseHelper
import br.ufrpe.android.sisa3.database.DisciplinaCursorWrapper
import br.ufrpe.android.sisa3.database.SisaDbSchema

import br.ufrpe.android.sisa3.database.SisaDbSchema.*

class DisciplinaLab {

    //private List<Disciplina> mDisciplinas; remov causa do bs
    private var mContext: Context// add para o banco
    private var mDatabase: SQLiteDatabase // add para o banco

    companion object{
        var sDisciplinaLab: DisciplinaLab? = null
        fun  getInstance(context: Context): DisciplinaLab {
            if (sDisciplinaLab == null) {
                sDisciplinaLab = DisciplinaLab(context)
            }
            return sDisciplinaLab as DisciplinaLab
        }
    }

    private fun getContentValues(disciplina: Disciplina): ContentValues {
        val values = ContentValues()
        values.put(SisaDbSchema.DisciplinaTable.Cols.ID, disciplina.getId().toString())
        values.put(SisaDbSchema.DisciplinaTable.Cols.NOME, disciplina.getNome())
        values.put(SisaDbSchema.DisciplinaTable.Cols.CODIGO, disciplina.getCodigo())
        values.put(SisaDbSchema.DisciplinaTable.Cols.CURSADA, if (disciplina.isCursada()) 1 else 0)
        values.put(SisaDbSchema.DisciplinaTable.Cols.AREA, disciplina.getArea())
        values.put(SisaDbSchema.DisciplinaTable.Cols.PERIODO, disciplina.getPeriodo())
        values.put(SisaDbSchema.DisciplinaTable.Cols.SEMESTRE, disciplina.getSemestre())
        return values
    }


    private constructor(appContext: Context) {
        mContext =  appContext.applicationContext // add para o banco
        mDatabase = DisciplinaBaseHelper(mContext)// add para o banco
            .getWritableDatabase()
        //mDatabase = new AlunoBaseHelper(mContext)// adicionado para a tabela aluno
        //     .getWritableDatabase();


        //mDisciplinas=new ArrayList<Disciplina>(); remuv causa do bd
        val d1 = Disciplina()
        d1.setNome("Cálculo 1")
        d1.setCursada(false)
        d1.setCodigo("6446")
        d1.setPeriodo("1")
        d1.setSemestre("0")
        d1.setArea("FC")
        addDisciplina(d1)

        val d2 = Disciplina()
        d2.setNome("Matemática Discreta 1")
        d2.setCursada(false)
        d2.setCodigo("14203")
        d2.setPeriodo("1")
        d2.setSemestre("0")
        d2.setArea("FC")
        addDisciplina(d2)

        val d3 = Disciplina()
        d3.setNome("Programação 1")
        d3.setCursada(false)
        d3.setCodigo("14117")
        d3.setPeriodo("1")
        d3.setSemestre("0")
        d3.setArea("Ensiso")
        addDisciplina(d3)

        val d4 = Disciplina()
        d4.setNome("Introdução à Ciência da Computaçâo")
        d4.setCursada(false)
        d4.setCodigo("14044")
        d4.setPeriodo("1")
        d4.setSemestre("0")
        d4.setArea("FC")
        addDisciplina(d4)

        val d5 = Disciplina()
        d5.setNome("Álgebra Linear")
        d5.setCursada(false)
        d5.setCodigo("6418")
        d5.setPeriodo("1")
        d5.setSemestre("0")
        d5.setArea("FC")
        addDisciplina(d5)

        val d6 = Disciplina()
        d6.setNome("Programação 2")
        d6.setCursada(false)
        d6.setCodigo("14118")
        d6.setPeriodo("2")
        d6.setSemestre("0")
        d6.setArea("Ensiso")
        addDisciplina(d6)

        val d7 = Disciplina()
        d7.setNome("Matemática Discreta 2")
        d7.setCursada(false)
        d7.setCodigo("14204")
        d7.setPeriodo("2")
        d7.setSemestre("0")
        d7.setArea("FC")
        addDisciplina(d7)

        val d8 = Disciplina()
        d8.setNome("Cáculo 2")
        d8.setCursada(false)
        d8.setCodigo("6445")
        d8.setPeriodo("2")
        d8.setSemestre("0")
        d8.setArea("FC")
        addDisciplina(d8)

        val d9 = Disciplina()
        d9.setNome("Algoritmos Estruturados de Dados")
        d9.setCursada(false)
        d9.setCodigo("3212")
        d9.setPeriodo("2")
        d9.setSemestre("0")
        d9.setArea("FC")
        addDisciplina(d9)

        val d10 = Disciplina()
        d10.setNome("Metodologia Cietífica Aplicada a Computação")
        d10.setCursada(false)
        d10.setCodigo("14112")
        d10.setPeriodo("2")
        d10.setSemestre("0")
        d10.setArea("FC")
        addDisciplina(d10)

        val d11 = Disciplina()
        d11.setNome("Projeto e Análise de Algoritmos")
        d11.setCursada(false)
        d11.setCodigo("14087")
        d11.setPeriodo("3")
        d11.setSemestre("0")
        d11.setArea("FC")
        addDisciplina(d11)

        val d12 = Disciplina()
        d12.setNome("Circuitos Digitais")
        d12.setCursada(false)
        d12.setCodigo("14087")
        d12.setPeriodo("3")
        d12.setSemestre("0")
        d12.setArea("ARQ")
        addDisciplina(d12)

        val d13 = Disciplina()
        d13.setNome("Estatística Exploratoria")
        d13.setCursada(false)
        d13.setCodigo("3235")
        d13.setPeriodo("3")
        d13.setSemestre("0")
        d13.setArea("FC")
        addDisciplina(d13)

        val d14 = Disciplina()
        d14.setNome("Teoria da Computação")
        d14.setCursada(false)
        d14.setCodigo("3219")
        d14.setPeriodo("3")
        d14.setSemestre("0")
        d14.setArea("FC")
        addDisciplina(d14)

        val d15 = Disciplina()
        d15.setNome("Fisica Aplicada a Computação")
        d15.setCursada(false)
        d15.setCodigo("3285")
        d15.setPeriodo("3")
        d15.setSemestre("0")
        d15.setArea("FC")
        addDisciplina(d15)

        val d16 = Disciplina()
        d16.setNome("Redes de Computadores ")
        d16.setCursada(false)
        d16.setCodigo("14058")
        d16.setPeriodo("4")
        d16.setSemestre("0")
        d16.setArea("ARQ")
        addDisciplina(d16)

        val d17 = Disciplina()
        d17.setNome("Banco de Dados")
        d17.setCursada(false)
        d17.setCodigo("14088")
        d17.setPeriodo("4")
        d17.setSemestre("0")
        d17.setArea("Ensiso")
        addDisciplina(d17)

        val d18 = Disciplina()
        d18.setNome("Arquitetura de Computadores")
        d18.setCursada(false)
        d18.setCodigo("14064")
        d18.setPeriodo("4")
        d18.setSemestre("0")
        d18.setArea("ARQ")
        addDisciplina(d18)

        val d19 = Disciplina()
        d19.setNome("Engenharia de Software")
        d19.setCursada(false)
        d19.setCodigo("3222")
        d19.setPeriodo("4")
        d19.setSemestre("0")
        d19.setArea("Ensiso")
        addDisciplina(d19)

        val d20 = Disciplina()
        d20.setNome("Paradigmas de Programação")
        d20.setCursada(false)
        d20.setCodigo("3242")
        d20.setPeriodo("4")
        d20.setSemestre("0")
        d20.setArea("Ensiso")
        addDisciplina(d20)

        val d21 = Disciplina()
        d21.setNome("Compiladores")
        d21.setCursada(false)
        d21.setCodigo("14090")
        d21.setPeriodo("5")
        d21.setSemestre("0")
        d21.setArea("FC")
        addDisciplina(d21)

        val d22 = Disciplina()
        d22.setNome("Inteligência Artificial")
        d22.setCursada(false)
        d22.setCodigo("14074")
        d22.setPeriodo("5")
        d22.setSemestre("0")
        d22.setArea("FC")
        addDisciplina(d22)

        val d23 = Disciplina()
        d23.setNome("Projeto e Desenvolvimento de Software")
        d23.setCursada(false)
        d23.setCodigo("3241")
        d23.setPeriodo("5")
        d23.setSemestre("0")
        d23.setArea("Ensiso")
        addDisciplina(d23)

        val d24 = Disciplina()
        d24.setNome("Sistemas Operacionais")
        d24.setCursada(false)
        d24.setCodigo("14065")
        d24.setPeriodo("5")
        d24.setSemestre("0")
        d24.setArea("ARQ")
        addDisciplina(d24)

        val d25 = Disciplina()
        d25.setNome("Sistemas Distribuídos")
        d25.setCursada(false)
        d25.setCodigo("14059")
        d25.setPeriodo("5")
        d25.setSemestre("0")
        d25.setArea("ARQ")
        addDisciplina(d25)

        val d26 = Disciplina()
        d26.setNome("Desenvolvimento de Aplicações para Web")
        d26.setCursada(false)
        d26.setCodigo("14125")
        d26.setPeriodo("0")
        d26.setSemestre("1")
        d26.setArea("Ensiso")
        addDisciplina(d26)

        val d27 = Disciplina()
        d27.setNome("Jogos Digitais")
        d27.setCursada(false)
        d27.setCodigo("14042")
        d27.setPeriodo("0")
        d27.setSemestre("1")
        d27.setArea("Ensiso")
        addDisciplina(d27)

        val d28 = Disciplina()
        d28.setNome("Teste de Software")
        d28.setCursada(false)
        d28.setCodigo("14321")
        d28.setPeriodo("0")
        d28.setSemestre("1")
        d28.setArea("Ensiso")
        addDisciplina(d28)

        val d29 = Disciplina()
        d29.setNome("Inovação em Projetos de Software")
        d29.setCursada(false)
        d29.setCodigo("14320")
        d29.setPeriodo("0")
        d29.setSemestre("1")
        d29.setArea("Ensiso")
        addDisciplina(d29)

        val d30 = Disciplina()
        d30.setNome("Redes Neurais")
        d30.setCursada(false)
        d30.setCodigo("14020")
        d30.setPeriodo("0")
        d30.setSemestre("1")
        d30.setArea("FC")
        addDisciplina(d30)

        val d31 = Disciplina()
        d31.setNome("Biologia Computacional")
        d31.setCursada(false)
        d31.setCodigo("14103")
        d31.setPeriodo("0")
        d31.setSemestre("1")
        d31.setArea("FC")
        addDisciplina(d31)

        val d32 = Disciplina()
        d32.setNome("Visão Computacional")
        d32.setCursada(false)
        d32.setCodigo("14704")
        d32.setPeriodo("0")
        d32.setSemestre("1")
        d32.setArea("FC")
        addDisciplina(d32)

        val d33 = Disciplina()
        d33.setNome("Computação Evolutiva")
        d33.setCursada(false)
        d33.setCodigo("6294")
        d33.setPeriodo("0")
        d33.setSemestre("1")
        d33.setArea("FC")
        addDisciplina(d33)

        val d34 = Disciplina()
        d34.setNome("Algoritmos em Grafo")
        d34.setCursada(false)
        d34.setCodigo("14093")
        d34.setPeriodo("0")
        d34.setSemestre("1")
        d34.setArea("FC")
        addDisciplina(d34)

        val d35 = Disciplina()
        d35.setNome("")
        d35.setCursada(false)
        d35.setPeriodo("")
        d35.setSemestre("")
        d35.setArea("")
        d35.setCodigo("")
        addDisciplina(d35)
    }

    fun addDisciplina(d: Disciplina) {
        val values = getContentValues(d)
        mDatabase?.insert(SisaDbSchema.DisciplinaTable.NAME, null, values)

    }


    fun getDisciplinas(): List<Disciplina> {
        val disciplinas = ArrayList<Disciplina>()
        val cursor = queryDisciplina(null, null)
        try {
            cursor.moveToFirst()

            while (!cursor.isAfterLast()) {
                disciplinas.add(cursor.getDisciplina())
                cursor.moveToNext()
            }
        } finally {
            cursor.close()
        }
        return disciplinas
    }

    fun getDisciplina(id: UUID): Disciplina? {
        val cursor = queryDisciplina(
            SisaDbSchema.DisciplinaTable.Cols.ID + " = ?",
            arrayOf(id.toString())
        )
        try {
            if (cursor.getCount() === 0) {
                return null
            }
            cursor.moveToFirst()
            return cursor.getDisciplina()
        } finally {
            cursor.close()
        }
    }


    fun updateDisciplina(disciplina: Disciplina) {
        val idString = disciplina.getId().toString()
        val values = getContentValues(disciplina)
        mDatabase.update(
            SisaDbSchema.DisciplinaTable.NAME, values,
            SisaDbSchema.DisciplinaTable.Cols.ID + " = ?",
            arrayOf(idString)
        )
    }


    private fun queryDisciplina(whereClause: String?, whereArgs: Array<String>?): DisciplinaCursorWrapper {
        val cursor = mDatabase.query(
            SisaDbSchema.DisciplinaTable.NAME, // having
            null // orderBy
            , // columns - null selects all columns
            whereClause,
            whereArgs, null, null, null
        )// groupBy
        return DisciplinaCursorWrapper(cursor)
    }

}