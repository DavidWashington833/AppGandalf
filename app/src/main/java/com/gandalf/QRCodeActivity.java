package com.gandalf;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.Toast;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeActivity extends AppCompatActivity {

    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scannerView = new ZXingScannerView(QRCodeActivity.this);
        setContentView(scannerView);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                Toast toast = Toast.makeText(QRCodeActivity.this, "Não é possível utilizar a aplicação sem a permissão de acesso à câmera. Saindo.", Toast.LENGTH_LONG);
                toast.show();
                finish();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        scannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
            @Override
            public void handleResult(com.google.zxing.Result result) {
                final ZXingScannerView.ResultHandler rh = this;
                String resultado = result.getText();

                if (URLUtil.isValidUrl(String.valueOf(resultado))) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(resultado));
                    startActivity(browserIntent);
                } else {
                }

                Intent returnIntent = new Intent();
                returnIntent.putExtra("qrcode", resultado);
                setResult(RESULT_OK, returnIntent);
                finish();
            }

        });
        scannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }
}


