package com.example.kpweek4task1_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, MainFragment.newInstance()).addToBackStack(MainFragment.class.getName()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mainfragment:
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, MainFragment.newInstance()).addToBackStack(MainFragment.class.getName()).commit();
                showMassage(getString(R.string.mainfragment));
                break;
            case R.id.search:
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, SearchFragment.newInstance()).addToBackStack(MainFragment.class.getName()).commit();
                showMassage(getString(R.string.search));
                break;
            case R.id.options:
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, OptionsSearchFragment.newInstance()).addToBackStack(MainFragment.class.getName()).commit();
                showMassage(getString(R.string.options));
                break;
            case R.id.exit:
                finish();
                showMassage(getString(R.string.exit));
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() == 1){
            finish();
        }
        else {
            fragmentManager.popBackStack();
        }

    }

    private void showMassage(String string){
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }


}
