package bingoyo.com.mangalfabs.dashboard.addproduct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.theartofdev.edmodo.cropper.CropImageView;

import bingoyo.com.mangalfabs.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddProductActivityBackup extends AppCompatActivity {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.take)
    Button take;
    @BindView(R.id.cropImageView)
    CropImageView cropImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.take)
    public void onViewClicked() {

        // start picker to get image for cropping and then use the image in cropping activity
//        CropImage.activity()
//                .setGuidelines(CropImageView.Guidelines.ON)
//                .setMinCropResultSize(800,800)
//                .setMaxCropResultSize(1000,1000)
//                .start(this);


        Intent imageDownload = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        imageDownload.putExtra("crop", "true");
        imageDownload.putExtra("aspectX", 3);
        imageDownload.putExtra("aspectY", 3);
        imageDownload.putExtra("outputX", 800);
        imageDownload.putExtra("outputY", 800);
        imageDownload.putExtra("return-data", true);

        imageDownload.putExtra("scale", true);
        imageDownload.putExtra("scaleUpIfNeeded", true);
        startActivityForResult(imageDownload, 2);

//
//
//// aspectX aspectY
//        intent.putExtra("aspectX", 2);
//        intent.putExtra("aspectY", 3);
////        outputX,outputY
//        intent.putExtra("outputX", 800);
//        intent.putExtra("outputY", 1200);
//        intent.putExtra("scale", true);
//        intent.putExtra("scaleUpIfNeeded", true);



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
//            CropImage.ActivityResult result = CropImage.getActivityResult(data);
//            if (resultCode == RESULT_OK) {
//                Uri resultUri = result.getUri();
//
//                image.setImageURI(resultUri);
//
//            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
//                Exception error = result.getError();
//            }
//        }

        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            Bitmap image1 = extras.getParcelable("data");
            image.setImageBitmap(image1);
        }
    }

}
