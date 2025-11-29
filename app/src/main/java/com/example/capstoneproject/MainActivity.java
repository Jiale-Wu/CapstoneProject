package com.example.capstoneproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements LoginScreen.LoginListener, SignupScreen.SignupListener, HomeScreen.HomeScreenListener,
        NotificationsPage.NotificationsListener, EventsPage.EventsPageListener, ChatFragment.ChatListener, ProfileSection.ProfileSectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, new LoginScreen())
                .commit();

    }

    @Override
    public void Signin() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, new HomeScreen())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void Signup() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, new SignupScreen())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void LoginMoreOptions() {

    }

    @Override
    public void SignupNext() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void toNotifications() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, new NotificationsPage())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toEvents() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, new EventsPage())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toChat() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, new ChatFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toProfile() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, new ProfileSection())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toHome() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, new HomeScreen())
                .addToBackStack(null)
                .commit();
    }
}