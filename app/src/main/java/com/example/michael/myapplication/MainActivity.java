package com.example.michael.myapplication;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.michael.myapplication.media.AndroidMediaController;
import com.example.michael.myapplication.media.IjkVideoView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TableLayout mHudView;
    private IjkVideoView mVideoView;
    private AndroidMediaController mMediaController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConsTest consTest = new ConsTest(1);

    }

}