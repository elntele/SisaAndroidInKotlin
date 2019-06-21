package br.ufrpe.android.sisa3


import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.GridView

import java.security.PrivateKey
import java.util.ArrayList
import java.util.UUID

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import br.ufrpe.android.sisa3.ConsultaAoBanco
import java.util.*
import br.ufrpe.android.sisa.R

class TelaInicialActivity: AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener {


        private var mconsuta: ConsultaAoBanco? = null
        private var mBtBoasVindas: Button? = null
        private var mAluno: Aluno? = null
        private var mListDeAlunos = ArrayList<Aluno>()
        private var mUUID: UUID? = null

        @TargetApi(Build.VERSION_CODES.P)
        protected override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_tela_inicial)
            val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
            setSupportActionBar(toolbar)
            // mDisciplina = DisciplinaLab.getInstance(getActivity()).getDisciplina(disciplinaId);

            val tl = TableLayout(this)
            val lp = TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            tl.layoutParams = lp
            val tr = TableRow(this)
            tl.addView(tr)
            var tv: TextView

            tv = findViewById<View>(R.id.grade_curso_text_view) as TextView
            tv.setOnClickListener {
                //Aqui deve conter o código que quando acionar o botão cadastrar ele deverá ir para tela de cadastro.
                val intent = Intent(this@TelaInicialActivity, GradeImagemActivity::class.java)
                startActivity(intent)
            }

            tv = findViewById<View>(R.id.gerar_recomendcoes_text_view) as TextView
            tv.setOnClickListener {
                val intent = Intent(this@TelaInicialActivity, PreGerarRecomendacoesActivity::class.java)
                startActivity(intent)
            }


            val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
            val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
            )
            //  drawer.setDrawerListener(toggle);
            drawer.addDrawerListener(toggle)
            toggle.syncState()

            val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
            navigationView.setNavigationItemSelectedListener(this)
            // original -> mconsuta = ConsultaAoBanco.getInstance(getApplicationContext())
            mconsuta = ConsultaAoBanco(getApplicationContext()).getInstance(getApplicationContext())// muito mudado ter atenção neste trecho ass jorge 01.06.19
            mListDeAlunos = mconsuta!!.getAlunos() as ArrayList<Aluno>
            mUUID = getIntent().getSerializableExtra("id") as UUID?
            // mAluno=mListDeAlunos.get(0);
            mAluno = mUUID?.let { mconsuta!!.getAluno(it) }
            mBtBoasVindas = findViewById<View>(R.id.boas_vindas_button) as Button
            mBtBoasVindas!!.setText(mAluno!!.getNome() + " seja bem vindo")
            mBtBoasVindas!!.isEnabled = false


        }

        override fun onBackPressed() {
            val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.tela_inicial, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            val id = item.itemId


            return if (id == R.id.action_settings) {
                true
            } else super.onOptionsItemSelected(item)

        }

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            // Handle navigation view item clicks here.
            val id = item.itemId

            if (id == R.id.nav_mensagens) {
                // Handle the camera action
            } else if (id == R.id.nav_alterar_dados) {

            } else if (id == R.id.nav_fale_conosco) {

            } else if (id == R.id.nav_perguntas_frequentes) {

            }

            val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
            drawer.closeDrawer(GravityCompat.START)
            return true
        }


    }