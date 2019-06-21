package br.ufrpe.android.sisa3.database

class SisaDbSchema {

    object DisciplinaTable {
        val NAME = "disciplina"

        object Cols {
            val NOME = "nome"
            val ID = "id"
            val CODIGO = "codigo"
            val PERIODO = "periodo"
            val SEMESTRE = "qtd"
            val CURSADA = "cursada"
            val AREA = "area"

        }
    }

    object AlunoTable {
        val NAME = "aluno"

        object Cols {
            val ID = "id"
            val NOME = "nome"
            val EMAIL = "email"
            val SENHA = "senha"
            val CPF = "cpf"
            val CURSADAS = "cursadas"
            val QTDDEPERIODOSTRANCADOS = "qtddeperiodostrancados"
            val ANODEINGRESSO = "anodeingresso"
            val PERIODODEINGRESSO = "periododeingresso"
            val AREA = "area"

        }
    }
}