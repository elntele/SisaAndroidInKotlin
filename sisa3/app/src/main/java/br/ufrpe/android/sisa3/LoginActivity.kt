package br.ufrpe.android.sisa3


import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.ufrpe.android.sisa.R
import java.util.ArrayList

class LoginActivity : AppCompatActivity() {


    private var mconsuta: ConsultaAoBanco? = null
    private val mAluno: Aluno? = null
    private var mListDeAlunos = ArrayList<Aluno>()


    private var mEmail: EditText? = null
    private var mSenha: EditText? = null
    private var mBtLogar: Button? = null
    private var mBtCadastrar: Button? = null

    @TargetApi(Build.VERSION_CODES.P)
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_login)

        mEmail = findViewById<View>(R.id.email_edit_text) as EditText
        mSenha = findViewById<View>(R.id.senha_edit_text) as EditText
        mBtLogar = findViewById<View>(R.id.login_button) as Button
        mBtLogar?.let {
            it.setOnClickListener {
            // original ->mconsuta = ConsultaAoBanco.getInstance(getApplicationContext())
            mconsuta = ConsultaAoBanco(getApplicationContext()).getInstance(getApplicationContext())
            mListDeAlunos = mconsuta!!.getAlunos() as ArrayList<Aluno>
            for (A in mListDeAlunos) {
                if (A.getEmail().equals(mEmail!!.text.toString())) {
                    if (A.getSenha().equals(mSenha!!.text.toString())) {
                        val intent = Intent(this@LoginActivity, TelaInicialActivity::class.java)
                        intent.putExtra("id", A.getId())
                        startActivity(intent)
                    }
                } else {
                    Toast.makeText(
                        getApplication(), "usuário e senha inválido, insira um usuário válido ou cadastre-se ",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
            /*Toast.makeText(
                getApplication(), "usuário e senha inválido, insira um usuário válido ou cadastre-se ",
                Toast.LENGTH_SHORT
            ).show()*/
        } }

        mBtCadastrar = findViewById<View>(R.id.cadastro_button) as Button
        mBtCadastrar!!.setOnClickListener {
            //Aqui deve conter o código que quando acionar o botão cadastrar ele deverá ir para tela de cadastro.
            val intent = Intent(this@LoginActivity, CadastroAlunoActivity::class.java)
            startActivity(intent)
        }

    }
}