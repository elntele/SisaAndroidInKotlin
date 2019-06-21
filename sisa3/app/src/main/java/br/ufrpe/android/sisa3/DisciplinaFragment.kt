package br.ufrpe.android.sisa3

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import java.util.ArrayList
import java.util.UUID
import br.ufrpe.android.sisa3.database.AlunoBaseHelper
import br.ufrpe.android.sisa3.database.SisaDbSchema
import br.ufrpe.android.sisa.R
class DisciplinaFragment: Fragment() {

    private var mDisciplina: Disciplina? = null
    private var mCursadaCheckBox: CheckBox? = null
    private var mNomeTextView: TextView? = null
    private var mCodigoTextView: TextView? = null
    private var mAreaTextView: TextView? = null
    private var mAluno: Aluno? = null
    private var mBotao: Button? = null
    private var mContext: Context? = null// add para o banco
    private var mDatabase: SQLiteDatabase? = null // add para o banco


    //  private FloatingActionButton mFloatingActionButton;
    private val mSalvarButton: Button? = null
    companion object {

        private val ARG_DISCIPLINA_ID = "disciplina_id"

        fun newInstance(disciplinaId: UUID): DisciplinaFragment {// adicionado o aluno

            val args = Bundle()
            args.putSerializable(ARG_DISCIPLINA_ID, disciplinaId)
            val fragment = DisciplinaFragment()
            fragment.setArguments(args)
            return fragment
        }
    }

    fun setAluno(aluno: Aluno) {
        mAluno = aluno
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val disciplinaId = getArguments()!!.getSerializable(ARG_DISCIPLINA_ID) as UUID
        mDisciplina = getActivity()?.let { DisciplinaLab.getInstance(it).getDisciplina(disciplinaId) }
    }

    override fun onPause() {
        super.onPause()
        getActivity()?.let {
            mDisciplina?.let { it1 ->
                DisciplinaLab.getInstance(it)
                    .updateDisciplina(it1)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_disciplina, container, false)

        mNomeTextView = v.findViewById<View>(R.id.nome_disciplina) as TextView
        mNomeTextView!!.text = mDisciplina!!.getNome()

        mCodigoTextView = v.findViewById<View>(R.id.codigo_disciplina) as TextView
        mCodigoTextView!!.text = mDisciplina!!.getCodigo()

        mAreaTextView = v.findViewById<View>(R.id.area_disciplina) as TextView
        mAreaTextView!!.text = mDisciplina!!.getArea()

        mCursadaCheckBox = v.findViewById<View>(R.id.is_cursada_disciplina) as CheckBox
        mCursadaCheckBox!!.isChecked = mDisciplina!!.isCursada()
        mCursadaCheckBox!!.setOnCheckedChangeListener { buttonView, isChecked ->
            val Dis: ArrayList<Disciplina>
            mDisciplina!!.setCursada(isChecked)
            if (mDisciplina!!.isCursada()) {
                Dis = mAluno!!.getCursadas()
                Dis.add(mDisciplina!!)
                mAluno!!.setCursadas(Dis)
            }
        }



        mBotao = v.findViewById<View>(R.id.salvar_button) as Button
        mBotao!!.setOnClickListener {
            inicia()
            addAluno()
            val intent = Intent(getActivity(), LoginActivity::class.java)
            startActivity(intent)
        }


        //   mFloatingActionButton = (FloatingActionButton) v.findViewById(R.id.cadastro_fab);
        // mSalvarButton = (Button) v.findViewById(R.id.salvar_button);

        return v
    }


    private fun getContentValues(aluno: Aluno): ContentValues {
        val values = ContentValues()
        values.put(SisaDbSchema.AlunoTable.Cols.ID, aluno.getId().toString())
        values.put(SisaDbSchema.AlunoTable.Cols.NOME, aluno.getNome())
        values.put(SisaDbSchema.AlunoTable.Cols.EMAIL, aluno.getEmail())
        values.put(SisaDbSchema.AlunoTable.Cols.SENHA, aluno.getSenha())
        values.put(SisaDbSchema.AlunoTable.Cols.CPF, aluno.getCpf())

        // SharedPreferences mPrefs = null; // esse null foi adaptado
        // SharedPreferences.Editor prefsEditor = mPrefs.edit();
        val gson = Gson()
        val json = gson.toJson(aluno.getCursadas())
        // prefsEditor.putString("", json);
        // prefsEditor.commit();

        values.put(SisaDbSchema.AlunoTable.Cols.CURSADAS, json)
        values.put(SisaDbSchema.AlunoTable.Cols.AREA, aluno.getArea())
        values.put(SisaDbSchema.AlunoTable.Cols.ANODEINGRESSO, aluno.getAndoDeIngresso())
        values.put(SisaDbSchema.AlunoTable.Cols.PERIODODEINGRESSO, aluno.getPeriodoDeIngresso())
        values.put(SisaDbSchema.AlunoTable.Cols.QTDDEPERIODOSTRANCADOS, aluno.getQtdDePeriodosTrancado())
        return values
    }

    fun inicia() {
        mContext = getContext()!!.getApplicationContext()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            mDatabase = AlunoBaseHelper(mContext)// adicionado para a tabela aluno
                .getWritableDatabase()
        }else {
            @Suppress("DEPRECATION")
            mDatabase = AlunoBaseHelper(mContext)// adicionado para a tabela aluno
                .getWritableDatabase()
        }
    }

    fun addAluno() {

        val values = getContentValues(mAluno!!)
        mDatabase?.let{ it ->
            it.insert(SisaDbSchema.AlunoTable.NAME, null, values)
        }

    }
}