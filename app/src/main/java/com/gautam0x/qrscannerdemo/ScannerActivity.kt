package com.gautam0x.qrscannerdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ScannerActivity : Activity(),ZXingScannerView.ResultHandler {

    // initialize new view to read QR
    var cameraView:ZXingScannerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Display Camera View Instead Of Static Page
        cameraView = ZXingScannerView(this)
        setContentView(cameraView)

        //Start Camera And Perform Action In backGround
        cameraView!!.setResultHandler(this)
        cameraView!!.startCamera()
    }


    // When QR Found Handle The Result
    override fun handleResult(rawResult: Result?) {
        cameraView!!.stopCamera()

        //create new Intent
        val resultIntent = Intent()
        resultIntent.putExtra("QRCode",rawResult?.text)
        setResult(2,resultIntent)
        println("OK Done"+rawResult.toString())

        finish()
    }
}
