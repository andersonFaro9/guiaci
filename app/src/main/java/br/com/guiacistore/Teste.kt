//package br.com.guiacistore
//
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.net.Uri
//import android.os.Build
//import android.os.Bundle
//import android.support.design.widget.FloatingActionButton
//import android.support.v4.app.ActivityCompat
//import android.support.v4.content.ContextCompat
//import android.support.v7.app.AppCompatActivity
//import android.view.View
//
//class MainActivity : AppCompatActivity() {
//
//    internal var call: FloatingActionButton
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        call = findViewById(R.id.fab) as FloatingActionButton
//
//        call.setOnClickListener {
//            //----------------------when the call button is pressed-----------------------------
//            val REQUEST_PHONE_CALL = 1
//            val callIntent = Intent(Intent.ACTION_CALL)
//            callIntent.data = Uri.parse("tel:1234567890")
//            //-----------------checks for permission before placing the call--------------------
//            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL)
//                } else {
//                    //-------------------------------places the call-----------------------------------
//                    startActivity(callIntent)
//                }
//            }
//        }
//    }
//}