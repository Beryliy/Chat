package com.portfolio.flogiston.chat.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.portfolio.flogiston.chat.R;
import com.portfolio.flogiston.chat.ui.chat_tab.ChatFragment;
import com.portfolio.flogiston.chat.ui.profile_tab.ProfileFragment;
import com.portfolio.flogiston.chat.ui.settings_tab.SettingsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.navigation) BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        switchToProfile();
                        return true;
                    case R.id.navigation_chat:
                        switchToChat();
                        return true;
                    case R.id.navigation_settings:
                        switchToSettings();
                        return true;
                }
                return false;
            }
        };
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void switchToProfile(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment profileFrgment = new ProfileFragment();
        transaction.replace(R.id.work_zone, profileFrgment);
        //TODO: add transaction to backstack
        transaction.commit();
    }

    private void switchToChat(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment chatFragment = new ChatFragment();
        transaction.replace(R.id.work_zone, chatFragment);
        //TODO: add transaction to backstack
        transaction.commit();
    }

    private void switchToSettings(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment settingsFrgment = new SettingsFragment();
        transaction.replace(R.id.work_zone, settingsFrgment);
        //TODO: add transaction to backstack
        transaction.commit();
    }

}
