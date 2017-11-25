package com.storegandalf.david.gandalf;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

                String resultado = result.getText();
                resultado = resultado.replace("G", "");
                Intent intent = new Intent(QRCodeActivity.this, MainActivity.class);
                intent.putExtra("idProduto", resultado);
                setResult(RESULT_OK,intent);
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


