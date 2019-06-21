package br.ufrpe.android.sisa3
/*
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.ActivityCompat
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
*/

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import br.ufrpe.android.sisa.R

import java.io.File
import java.io.FileNotFoundException
import java.io.IOException


class CapturaFotoActivity: AppCompatActivity () {

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_captura_foto)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            /*    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show(); */
            getPermissions()
        }
    }

    internal val REQUEST_IMAGE_CAPTURE = 1
    internal val REQUEST_TAKE_PHOTO = 1
    internal var mCurrentPhotoPath: String =""// eu add string vazia por causa do compilador questava pedindo inicalização

    /*Método responsável por verificar se as permissões aos recursos do Android foram habilitados no arquivo
    AndroidManifest.xml*/
    private fun getPermissions() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ),
                1
            )
        } else
            dispatchTakePictureIntent()
    }

    /*Verifica se o usuário permitiu acesso aos recursos de câmera antes da câmera ser acionada*/
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {

        when (requestCode) {
            1 -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent()
                } else {
                    Toast.makeText(this, "Não vai funcionar!!!", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    /*Método responsável por invocar a câmera do dispositivo e salvar a foto no cartão SD*/
    private fun dispatchTakePictureIntent() {

        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            var photofile: File? = null
            try {
                val storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                photofile = File.createTempFile("PHOTOAPP", ".jpg", storageDir)
                mCurrentPhotoPath = "file:" + photofile!!.absolutePath
            } catch (ioex: IOException) {

                Toast.makeText(getApplicationContext(), "Erro ao tirar a foto", Toast.LENGTH_SHORT).show()
            }

            if (photofile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photofile))
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
            }
        }
    }

    /*Método chamado automaticamente, responsável por recuperar a foto tirada e exibi-lá no ImageView */
    protected override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            try {
                val imagem = findViewById(R.id.imageView) as ImageView
                val bm1 = BitmapFactory.decodeStream(getContentResolver().openInputStream(Uri.parse(mCurrentPhotoPath)))
                imagem.setImageBitmap(bm1)
            } catch (fnex: FileNotFoundException) {
                //isso foi modificado comentado é o correto
                //Toast.makeText(getApplicationContext(), "Foto não encontrada!", Toast.LENGTH_LONG).show()
                Toast.makeText(getApplicationContext(), "Prossiga com o cadastro!", Toast.LENGTH_LONG).show()
            }

        }
    }

}