package br.ufrpe.android.sisa3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import br.ufrpe.android.sisa.R

class GradeImagemActivity:AppCompatActivity() {
    private var mIv: ImageView? = null
    private val mButton: Button? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade_imagem)

        mIv = findViewById<View>(R.id.imagem_grade_view) as ImageView



    }

}