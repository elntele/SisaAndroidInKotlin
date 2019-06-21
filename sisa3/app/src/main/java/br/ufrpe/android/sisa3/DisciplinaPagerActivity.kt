package br.ufrpe.android.sisa3


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.ufrpe.android.sisa3.Aluno
import br.ufrpe.android.sisa3.Disciplina
import java.util.UUID
import br.ufrpe.android.sisa.R

class DisciplinaPagerActivity: AppCompatActivity() {

    private val EXTRA_DISCIPLINA_ID = "br.ufrpe.android.sisa.disciplina_id"
    private var mViewPager: ViewPager? = null
    private var mDisciplinas: List<Disciplina>? = null
    private var mAluno: Aluno? = null // adicionado para recuperar aluno

    fun newIntent(packageContext: Context, disciplinaId: UUID): Intent {

        val intent = Intent(packageContext, DisciplinaPagerActivity::class.java)
        intent.putExtra(EXTRA_DISCIPLINA_ID, disciplinaId)
        return intent
    }

    override fun onCreate(savedInstaceState: Bundle?) {
        super.onCreate(savedInstaceState)
        setContentView(R.layout.activity_disciplina_pager)

        this.mAluno = getIntent().getSerializableExtra("aluno") as Aluno// adicionado para recuperar aluno

        val disciplinaId = getIntent().getSerializableExtra(EXTRA_DISCIPLINA_ID) as UUID

        mViewPager = findViewById<View>(R.id.disciplina_view_pager) as ViewPager
        mDisciplinas = DisciplinaLab.getInstance(this).getDisciplinas()
        val fragmentManager = getSupportFragmentManager()
        mViewPager!!.adapter = object : FragmentStatePagerAdapter(fragmentManager) {
            // muito mudado, adicionado coisas pra acessar o métodos que não fazem sentido, ter cuidado jorge 01/06/19
            override fun getItem(position: Int): Fragment {
                val disciplina = mDisciplinas!![position]
                val fra = disciplina.getId()?.let { DisciplinaFragment.newInstance(it) }   // add para o aluno
                fra?.setAluno(aluno = mAluno!!)
                return fra!!// adicionado o aluno
            }

            override fun getCount(): Int {
                return mDisciplinas!!.size
            }
        }

        for (i in mDisciplinas!!.indices) {
            if (mDisciplinas!![i].getId()!!.equals(disciplinaId)) {
                mViewPager!!.currentItem = i
                break
            }
        }
    }


}