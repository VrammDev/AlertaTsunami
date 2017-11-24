package com.example.toshiba.alertatsunami;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Linterna extends AppCompatActivity {
    FloatingActionButton boton;
    Button retroceder;
    Camera camera;
    boolean turnon = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linterna);
        boton = (FloatingActionButton) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!turnon) {
                    camera = Camera.open();
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    camera.startPreview();
                    turnon = true;
                }else{
                    camera.stopPreview();
                    camera.release();
                    turnon = false;
                }
            }
        });
    }

}
