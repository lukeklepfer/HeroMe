package lukeklepfer.com.herome.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import lukeklepfer.com.herome.R;
import lukeklepfer.com.herome.fragments.BackstoryFragment;
import lukeklepfer.com.herome.fragments.MainFragment;
import lukeklepfer.com.herome.fragments.PowersFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PowersFragment.PickPowersInteractionListener, BackstoryFragment.PickBackstoryInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager =getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();//calling a .add (adds to screen) func on the fragment that is returned
        }
    }

    public void loadPowersScreen(){

        PowersFragment pickPowerFragment = new PowersFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
    }
    public void loadBackstoryScreen(){

        BackstoryFragment pickBackstoryFragment = new BackstoryFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickBackstoryFragment).addToBackStack(null).commit();
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {
        //implement in class declaration
    }

    @Override
    public void onPickPowersInteraction(Uri uri) {
        //implement in class declaration
    }
    @Override
    public void onPickBackstoryInteraction(Uri uri) {
        //implement in class declaration
    }


}
