package com.project.quelvymuahio.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.quelvymuahio.myapplication.Adapter.ViewPagerAdapter;
import com.project.quelvymuahio.myapplication.Fragment.PaymentFragment;
import com.project.quelvymuahio.myapplication.Fragment.RoutesFragment;
import com.project.quelvymuahio.myapplication.Fragment.ScheduledFragment;
import com.project.quelvymuahio.myapplication.Fragment.SeatsFragment;
import com.project.quelvymuahio.myapplication.Fragment.TicketsFragment;

public class BuyTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding the Fragments
        adapter.addFragment(new SeatsFragment(), null);
        adapter.addFragment(new PaymentFragment(), null);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
