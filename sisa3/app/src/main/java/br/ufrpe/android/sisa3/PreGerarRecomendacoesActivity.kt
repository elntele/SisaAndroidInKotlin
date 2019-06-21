package br.ufrpe.android.sisa3


import android.support.v7.app.AppCompatActivity
import android.widget.QuickContactBadge
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import br.ufrpe.android.sisa.R

class PreGerarRecomendacoesActivity: AppCompatActivity() {


    //   private QuickContactBadge mQuickContactBadge;
    private var mProgressBar: ProgressBar? = null
    private var mMensagemTextView: TextView? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_gerar_recomendacoes)

        //   mQuickContactBadge = (QuickContactBadge) findViewById(R.id.sisa_quickContactBadge);
        mProgressBar = findViewById<View>(R.id.sisa_progressBar) as ProgressBar
        mMensagemTextView = findViewById<View>(R.id.mensagem_textView) as TextView
    }
}