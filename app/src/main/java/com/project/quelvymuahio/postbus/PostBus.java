package com.project.quelvymuahio.postbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.quelvymuahio.postbus.Adapter.ViewPagerAdapter;
import com.project.quelvymuahio.postbus.Fragment.RoutesFragment;
import com.project.quelvymuahio.postbus.Fragment.ScheduledFragment;
import com.project.quelvymuahio.postbus.Fragment.TicketsFragment;
import com.squareup.picasso.Picasso;

import javax.crypto.interfaces.PBEKey;

public class PostBus extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView username, userEmail;
    private ImageView userPhoto;
    private NavigationView navigationView;
    private View headerView;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_bus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);
        username = (TextView) headerView.findViewById(R.id.user_name);
        userEmail = (TextView) headerView.findViewById(R.id.user_email);
        userPhoto = (ImageView) headerView.findViewById(R.id.user_photo);

        addFragmentsToTheView();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void updatingTheView(FirebaseUser currentUser) {

        username.setText(currentUser.getDisplayName());
        userEmail.setText(currentUser.getEmail() == null || currentUser.getEmail().isEmpty() ? "Sem email" : currentUser.getEmail());
        Picasso.with(getApplicationContext()).load(currentUser.getPhotoUrl().toString()).into(userPhoto);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null)
            backToLogIn();
        else
            updatingTheView(currentUser);

    }

    private void backToLogIn() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.post_bus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.user_guide:
                return true;

            case R.id.logout:
                mAuth.signOut();
                LoginManager.getInstance().logOut();
                backToLogIn();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }



    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_user_data) {
            // Handle the camera action
        } else if (id == R.id.nav_payments) {

        } else if (id == R.id.nav_history) {

        } else if (id == R.id.nav_definition) {

        } else if (id == R.id.nav_about_us) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void addFragmentsToTheView(){
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding the Fragments
        adapter.addFragment(new RoutesFragment(), "Rotas");
        adapter.addFragment(new ScheduledFragment(), "Agendado");
        //adapter.addFragment(new TicketsFragment(), "Bilhete");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }
}
