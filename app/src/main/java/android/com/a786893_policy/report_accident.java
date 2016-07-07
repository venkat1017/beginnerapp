package android.com.a786893_policy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by venkatesh on 29-06-2016.
 */
public class report_accident extends Activity {
    private ImageView imageHolder;
    private final int requestCode = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reportaccident);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        imageHolder = (ImageView) findViewById(R.id.captured_photo);
        Button capturedImageButton = (Button) findViewById(R.id.photo_button);
        capturedImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, requestCode);
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(this.requestCode == requestCode && resultCode == RESULT_OK){
                Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                imageHolder.setImageBitmap(bitmap);
            }
        }


}
