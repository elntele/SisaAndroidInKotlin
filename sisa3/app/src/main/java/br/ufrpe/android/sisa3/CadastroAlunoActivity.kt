package br.ufrpe.android.sisa3

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import br.ufrpe.android.sisa.R
// herança
class CadastroAlunoActivity :AppCompatActivity() {


    private var mNome: EditText? = null
    private var mCPF: EditText? = null
    private var mSenha: EditText? = null
    private var mEmail: EditText? = null
    private var mAnoPeriodoIngresso: EditText? = null
    private var mAreaPreferenciaFC: CheckBox? = null
    private var mAreaPreferenciaEnsiso: CheckBox? = null
    private var mAreaPreferenciaARQ: CheckBox? = null
    private var mQtdPeriodosTrancados: EditText? = null
    private var mHorasEstudoExtraClasse: EditText? = null
    private var mEscolhaAreaDePreferencia: TextView? = null
    private var mBtProximo: Button? = null
    private var mBtFoto: Button? = null
    fun CadastroAlunoActivity(){
        // Required empty public constructor
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_aluno)

        mNome = findViewById<View>(R.id.nome_edit_text) as EditText
        mCPF = findViewById<View>(R.id.cpf_edit_text) as EditText
        mSenha = findViewById<View>(R.id.senha_edit_text) as EditText
        mEmail = findViewById<View>(R.id.email_edit_text) as EditText
        mAnoPeriodoIngresso = findViewById<View>(R.id.ano_periodo_edit_text) as EditText
        mAreaPreferenciaFC = findViewById<View>(R.id.box_fc_check_box) as CheckBox
        mAreaPreferenciaARQ = findViewById<View>(R.id.box_arq_check_box) as CheckBox
        mAreaPreferenciaEnsiso = findViewById<View>(R.id.box_ensiso_check_box) as CheckBox
        mQtdPeriodosTrancados = findViewById<View>(R.id.periodo_tracando_edit_text) as EditText
        mHorasEstudoExtraClasse = findViewById<View>(R.id.qts_h_semanal_edit_text) as EditText
        mEscolhaAreaDePreferencia = findViewById<View>(R.id.area_preferencia_text_view) as TextView
        mBtFoto = findViewById<View>(R.id.tela_foto_button) as Button

        mBtFoto!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {

                // Aqui devemos implementar a chamada para a tela de tirar foto!
                val intent = Intent(this@CadastroAlunoActivity, CapturaFotoActivity::class.java)
                startActivity(intent)
            }
        })


        mBtProximo = findViewById<View>(R.id.proximo_button) as Button
        mBtProximo!!.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View) {
                //Aqui deve conter o código que quando acionar o botão cadastrar ele deverá ir para tela de cadastro.
                if (mNome!!.equals("") || mCPF!!.equals("") ||
                    !mAreaPreferenciaARQ!!.isChecked() && !mAreaPreferenciaEnsiso!!.isChecked() && !mAreaPreferenciaFC!!.isChecked() ||
                    mAnoPeriodoIngresso!!.equals("") || mSenha!!.equals("") || mEmail!!.equals("") || mQtdPeriodosTrancados!!.equals(
                        ""
                    ) ||
                    mHorasEstudoExtraClasse!!.equals("")
                ) {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                } else {
                    val aluno = Aluno()
                    aluno.setNome(mNome!!.getText().toString())
                    try {
                        aluno.setCpf(Integer.parseInt(mCPF!!.getText().toString()))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    try {
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    try {
                        aluno.setQtdDePeriodosTrancado(Integer.parseInt(mQtdPeriodosTrancados!!.getText().toString()))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    val TextoSeparado = mAnoPeriodoIngresso!!.getText().toString().split('.')
                   // val TextoSeparado = Texto.split('.').dropLastWhile({ it.isEmpty() }).toTypedArray()
                    try {
                        aluno.setAndoDeIngresso(Integer.parseInt(TextoSeparado[0]))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    try {
                        aluno.setPeriodoDeIngresso(Integer.parseInt(TextoSeparado[1]))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    aluno.setSenha(mSenha!!.getText().toString())
                    aluno.setEmail(mEmail!!.getText().toString())
                    if (mAreaPreferenciaARQ!!.isChecked()) aluno.setArea("ARQ")
                    if (mAreaPreferenciaFC!!.isChecked()) aluno.setArea("FC")
                    if (mAreaPreferenciaEnsiso!!.isChecked()) aluno.setArea("ENSISO")
                    val intent = Intent(this@CadastroAlunoActivity, DisciplinaListActivity::class.java)
                    intent.putExtra("aluno", aluno)
                    startActivity(intent)
                }

            }
        })


    }

}