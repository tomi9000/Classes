package com.example.classexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.classexample.Datos.DatosIngresados
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var txtCartel : TextView
    lateinit var edtTextUser : EditText
    lateinit var edtTextPassword : EditText
    lateinit var btnIngresar : Button
    lateinit var rootLayout : ConstraintLayout

    lateinit var misDatos:DatosIngresados
    var user : MutableList<DatosIngresados> = ArrayList<DatosIngresados>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCartel= findViewById(R.id.txt_cartel)
        edtTextUser= findViewById(R.id.edit_txt_user)
        edtTextPassword= findViewById(R.id.edit_txt_password)
        btnIngresar= findViewById(R.id.btn_ingresar)
        rootLayout= findViewById(R.id.root_layout)


        misDatos= DatosIngresados("tomipine04@gmail.com", "bienvenido", "Tomas", 45751161  )
        user.add(DatosIngresados("eituhei@gmail.com","bokita","Eitan",45210453))



        btnIngresar.setOnClickListener{
            val perfil = (findViewById(R.id.edit_txt_user)as EditText).text.toString()
            val clave = (findViewById(R.id.edit_txt_password)as EditText).text.toString()

            if(perfil.equals(misDatos.User)&& clave.equals(misDatos.password)||perfil.equals(user[0].User)&& clave.equals(user[0].password))
            {
                Snackbar.make(rootLayout,"Ingresando....",Snackbar.LENGTH_SHORT).show()
            }

            else
            {
                if (perfil.length==0 && clave.length==0)
                {
                    Snackbar.make(rootLayout,"No se ha ingresado ningún dato", Snackbar.LENGTH_SHORT).show()
                }
                else
                {
                    Snackbar.make(rootLayout,"Usuario o clave incorrecto", Snackbar.LENGTH_SHORT).show()
                }

            }

        }



    }
}