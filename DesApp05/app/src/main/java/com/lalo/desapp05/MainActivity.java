package com.lalo.desapp05;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;


import com.lalo.desapp05.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Bitmap takenPhotoBitMap;

    private ActivityResultLauncher<Intent> cameraLauncher =
            registerForActivityResult(
              new ActivityResultContracts.StartActivityForResult(),
              result ->{
                  if(result.getResultCode() == RESULT_OK) {
                      Intent data = result.getData();
                      if (data != null ){
                          takenPhotoBitMap = (Bitmap) data.getExtras().get("data");
                          binding.bookImage.setImageBitmap(takenPhotoBitMap);
                      } else {
                          Toast.makeText(this, "Error taking photo", Toast.LENGTH_SHORT).show();
                      }
                  }
              }
            );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.saveBtn.setOnClickListener(v -> {
            openDetailsActivity(
                    binding.bookTitle.getText().toString(),
                    binding.bookAuthors.getText().toString(),
                    binding.bookComment.getText().toString(),
                    binding.ratingBook.getNumStars()
            );
        });

        binding.bookImage.setOnClickListener(v -> {
            Log.d("Noabre", "No abre segunda vez");
            openCamera();
        });
    }

    private void openCamera () {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraLauncher.launch(cameraIntent);
    }

    private void openDetailsActivity (String title, String author, String comment, float rating) {
        Book book  = new Book (title, author, comment, rating);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.BOOK_kEY, book);
        intent.putExtra(DetailActivity.BITMAP_KEY, takenPhotoBitMap);
        startActivity(intent);

    }

}