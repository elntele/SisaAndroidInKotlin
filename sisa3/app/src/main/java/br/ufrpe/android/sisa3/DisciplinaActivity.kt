package br.ufrpe.android.sisa3

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import br.ufrpe.android.sisa3.SingleFragmentActivity
import java.util.*
import br.ufrpe.android.sisa.R

class DisciplinaActivity: SingleFragmentActivity() {

    private var mAluno: Aluno? = null
    private val EXTRA_DISCIPLINA_ID = "br.ufrpe.android.sisa.disciplina_id"

    fun setAluno(aluno: Aluno) {
        mAluno = aluno
    }

    fun newIntent(packageContext: Context, disciplinaId: UUID): Intent {
        val intent = Intent(packageContext, DisciplinaActivity::class.java)
        intent.putExtra(EXTRA_DISCIPLINA_ID, disciplinaId)



        return intent
    }


    protected override fun createFragment(): Fragment {
        mAluno = getIntent().getSerializableExtra("aluno") as Aluno?
        val disciplinaId = getIntent().getSerializableExtra(EXTRA_DISCIPLINA_ID) as UUID
        val disciplinaFragment = DisciplinaFragment.newInstance(disciplinaId)
        mAluno?.let { disciplinaFragment.setAluno(it) }
        return disciplinaFragment
    }
}