package com.mathematics.abilify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CommunityPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_community_page);

        // Fix: Ensure setContentView is called before accessing views
        ImageButton homeIcon = findViewById(R.id.homeIcon);
        ImageButton communityPage = findViewById(R.id.parentCommunityForumIcon);

        homeIcon.setOnClickListener(v -> {
            startActivity(new Intent(CommunityPage.this, parent_home_page.class));
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.postCard), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize VideoView
        VideoView videoView = findViewById(R.id.videoView);

        // Set video source (Ensure video is inside res/raw/sample_video.mp4)
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.sample_video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        // Add Media Controls (Play, Pause, Seek)
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Start playing the video automatically
        videoView.start();
    }
}