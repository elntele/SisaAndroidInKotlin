package br.ufrpe.android.sisa3

import android.content.Intent.getIntent
import android.support.v4.app.Fragment
import br.ufrpe.android.sisa3.Aluno

class DisciplinaListActivity:SingleFragmentActivity() {

    private var aluno: Aluno? = null // adicionado

    protected override fun createFragment(): Fragment {
        this.aluno = getIntent().getSerializableExtra("aluno") as Aluno
        val fragment = DisciplinaListFragment()
        fragment.setAluno(this.aluno!!)
        return fragment

    }

}