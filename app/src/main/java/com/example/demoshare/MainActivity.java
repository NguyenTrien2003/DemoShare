package com.example.demoshare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demoshare.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button shareButton = findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareOnFacebook();
            }
        });
    }

    private void shareOnFacebook() {
        String urlToShare = "https://www.youtube.com/watch?v=sqEOWX0lbP4&t=9809s&ab_channel=MixiGaming"; // Thay đổi URL theo nhu cầu của bạn
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, urlToShare);

        // Kiểm tra xem Facebook có cài đặt trên thiết bị không
        intent.setPackage("com.facebook.katana");

        // Nếu Facebook không có cài đặt, mở trình duyệt
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/sharer/sharer.php?u=" + Uri.encode(urlToShare)));
            startActivity(webIntent);
        }
    }
}
