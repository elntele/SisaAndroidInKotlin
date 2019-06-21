package br.ufrpe.android.sisa3

import java.util.*

class Disciplina  {

    private var mId: UUID? = null
    private var mNome: String? = null
    private var mCodigo: String? = null
    private var mPeriodo: String? = null
    private var mSemestre: String? = null
    private var mArea: String? = null
    private var mSegunda: String? = null
    private var mTerca: String? = null
    private var mQuarta: String? = null
    private var mQuinta: String? = null
    private var mSexta: String? = null
    private val mDiaHora = arrayOfNulls<String>(5)
    private var mCursada: Boolean? = null

    constructor(
        id: UUID, nome: String, codigo: String, periodo: String, semestre: String, area: String,
        segunda: String, terca: String, quarta: String, quinta: String, sexta: String, cursada: Boolean?
    ) : this() {
        mId = id
        mNome = nome
        mCodigo = codigo
        mPeriodo = periodo
        mSemestre = semestre
        mArea = area
        mSegunda = segunda
        mTerca = terca
        mQuarta = quarta
        mQuinta = quinta
        mSexta = sexta
        mCursada = cursada
    }





    constructor() {
       this. mId =(UUID.randomUUID())
    }

    constructor(id: UUID) :this()  {
        this.mId = id

    }


    override fun toString(): String {
        return mNome.toString()
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

    fun getCodigo(): String? {
        return mCodigo
    }

    fun setCodigo(codigo: String) {
        mCodigo = codigo
    }

    fun getPeriodo(): String? {
        return mPeriodo
    }

    fun setPeriodo(periodo: String) {
        mPeriodo = periodo
    }

    fun getSemestre(): String? {
        return mSemestre
    }

    fun setSemestre(semestre: String) {
        mSemestre = semestre
    }

    fun getArea(): String? {
        return mArea
    }

    fun setArea(area: String) {
        mArea = area
    }

    fun getSegunda(): String? {
        return mSegunda
    }

    fun setSegunda(segunda: String) {
        mSegunda = segunda
    }

    fun getTerca(): String? {
        return mTerca
    }

    fun setTerca(terca: String) {
        mTerca = terca
    }

    fun getQuarta(): String? {
        return mQuarta
    }

    fun setQuarta(quarta: String) {
        mQuarta = quarta
    }

    fun getQuinta(): String? {
        return mQuinta
    }

    fun setQuinta(quinta: String) {
        mQuinta = quinta
    }

    fun getSexta(): String? {
        return mSexta
    }

    fun setSexta(sexta: String) {
        mSexta = sexta
    }

    fun setDiaHora() {
        this.mDiaHora[0] = this.mSegunda
        this.mDiaHora[1] = this.mTerca
        this.mDiaHora[2] = this.mQuarta
        this.mDiaHora[3] = this.mQuinta
        this.mDiaHora[4] = this.mSexta
    }

    fun isCursada(): Boolean {

        return mCursada!!
    }

    fun setCursada(cursada: Boolean) {
        this.mCursada = cursada
    }


}