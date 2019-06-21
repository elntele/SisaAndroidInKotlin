package br.ufrpe.android.sisa3

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import br.ufrpe.android.sisa3.Aluno
import br.ufrpe.android.sisa.R

import java.util.ArrayList

class DisciplinaListFragment:Fragment() {

    private var mDisciplinaRecyclerView: RecyclerView? = null
    private var mAdapter: DisciplinaAdapter? = null
    private var mAluno: Aluno? = null
    private val mBotaoSalvar: Button? = null

    fun setAluno(aluno: Aluno) {
        mAluno = aluno
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_disciplina_list, container, false)

        mDisciplinaRecyclerView = v.findViewById(R.id.disciplina_recycler_view)
        mDisciplinaRecyclerView!!.layoutManager = LinearLayoutManager(getActivity())

        updateUI()

        return v
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    private fun updateUI() {

        val disciplinaLab = getActivity()?.let { DisciplinaLab.getInstance(it) }
        val disciplinas = disciplinaLab?.getDisciplinas()

        if (mAdapter == null) {
            mAdapter = disciplinas?.let { DisciplinaAdapter(it) }
            mDisciplinaRecyclerView!!.adapter = mAdapter
        } else {
            disciplinas?.let { mAdapter!!.setdisciplinas(it) }
            mAdapter!!.notifyDataSetChanged()
        }
    }

    private inner class DisciplinaHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_disciplina, parent, false)), View.OnClickListener {

        private val mCodigoTextView: TextView
        private val mNomeTextView: TextView
        private val mDoneImageView: ImageView
        private var mDisciplina: Disciplina? = null

        init {
            itemView.setOnClickListener(this)

            mCodigoTextView = itemView.findViewById<View>(R.id.codigo_disciplina_list) as TextView
            mNomeTextView = itemView.findViewById<View>(R.id.nome_disciplina_list) as TextView
            mDoneImageView = itemView.findViewById<View>(R.id.image_done) as ImageView

        }

        // metodo que confere se a disciplina esta tickada.
        fun bind(disciplina: Disciplina) {
            mDisciplina = disciplina
            mCodigoTextView.setText(mDisciplina!!.getCodigo())
            mNomeTextView.setText(mDisciplina!!.getNome())
            mDoneImageView.visibility = if (disciplina.isCursada()) View.VISIBLE else View.GONE

        }

        override fun onClick(v: View) {
            val intent =
                getActivity()?.let { mDisciplina!!.getId()?.let { it1 -> DisciplinaPagerActivity().newIntent(it, it1) } } //Incluído na aula 11 PagerView
            intent?.putExtra("aluno", mAluno)
            startActivity(intent)
        }


    }

    private inner class DisciplinaAdapter(disciplinas: List<Disciplina>) : RecyclerView.Adapter<DisciplinaHolder>() {

        // adicionado para pegar as disciplinas do adapter
        var disciplinas: List<Disciplina>? = null
            private set

        init {
            this.disciplinas = disciplinas
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisciplinaHolder {

            val layoutInflater = LayoutInflater.from(getActivity())
            return DisciplinaHolder(layoutInflater, parent)
        }

        override fun onBindViewHolder(holder: DisciplinaHolder, position: Int) {

            val disciplina = disciplinas!![position]
            holder.bind(disciplina)
        }

        override fun getItemCount(): Int {
            return disciplinas!!.size
        }

        fun setdisciplinas(disciplinas: List<Disciplina>) {
            this.disciplinas = disciplinas
        }
    }

}