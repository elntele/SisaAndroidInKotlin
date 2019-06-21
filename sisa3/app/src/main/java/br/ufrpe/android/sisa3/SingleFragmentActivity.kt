package br.ufrpe.android.sisa3


import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity


import android.os.Bundle
import android.support.v4.app.Fragment
import br.ufrpe.android.sisa.R

abstract class SingleFragmentActivity: AppCompatActivity() {

    protected abstract fun createFragment(): Fragment

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fm = getSupportFragmentManager()
        var fragment = fm.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            fragment = createFragment()
            fm.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }


}