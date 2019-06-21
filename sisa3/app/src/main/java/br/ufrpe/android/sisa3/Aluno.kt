package br.ufrpe.android.sisa3

import java.io.Serializable
import java.util.ArrayList
import java.util.UUID
import java.util.UUID.randomUUID as randomUUID1
// implementação de interfaces
class Aluno : Serializable  {
    private var mId: UUID? = null
    private var mNome: String? = null
    private var Email: String? = null
    private var mSenha: String? = null
    private var mCpf: Int = 0
    private var mCursadas = ArrayList<Disciplina>()
    private var qtdDePeriodosTrancado: Int = 0
    private var mAndoDeIngresso: Int = 0
    private var mPeriodoDeIngresso: Int = 0
    private val mHorasDeEstudoExtraClasse: Int = 0
    private var mArea: String? = null

    constructor() {
       this.mId=(UUID.randomUUID())
    }

    constructor(id: UUID) {
        mId = id

    }


    fun getId(): UUID? {
        return mId
    }

    fun setId(id: UUID) {
        mId = id
    }

    fun getNome(): String? {
        return mNome
    }

    fun setNome(nome: String) {
        mNome = nome
    }

    fun getEmail(): String? {
        return Email
    }

    fun setEmail(email: String) {
        Email = email
    }

    fun getSenha(): String? {
        return mSenha
    }

    fun setSenha(senha: String) {
        mSenha = senha
    }

    fun getCpf(): Int {
        return mCpf
    }

    fun setCpf(cpf: Int) {
        mCpf = cpf
    }

    fun getCursadas(): ArrayList<Disciplina> {
        return mCursadas
    }

    fun setCursadas(cursadas: ArrayList<Disciplina>) {
        mCursadas = cursadas
    }

    fun getQtdDePeriodosTrancado(): Int {
        return qtdDePeriodosTrancado
    }

    fun setQtdDePeriodosTrancado(qtdDePeriodosTrancado: Int) {
        this.qtdDePeriodosTrancado = qtdDePeriodosTrancado
    }

    fun getAndoDeIngresso(): Int {
        return mAndoDeIngresso
    }

    fun setAndoDeIngresso(andoDeIngresso: Int) {
        mAndoDeIngresso = andoDeIngresso
    }

    fun getPeriodoDeIngresso(): Int {
        return mPeriodoDeIngresso
    }

    fun setPeriodoDeIngresso(periodoDeIngresso: Int) {
        mPeriodoDeIngresso = periodoDeIngresso
    }

    fun getArea(): String? {
        return mArea
    }

    fun setArea(area: String) {
        mArea = area
    }
}