package com.project.quelvymuahio.postbus;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.quelvymuahio.postbus.Adapter.ViewPagerAdapter;
import com.project.quelvymuahio.postbus.Fragment.PaymentFragment;
import com.project.quelvymuahio.postbus.Fragment.RoutesFragment;
import com.project.quelvymuahio.postbus.Fragment.ScheduledFragment;
import com.project.quelvymuahio.postbus.Fragment.SeatsFragment;
import com.project.quelvymuahio.postbus.Fragment.TicketsFragment;

public class BuyTicketActivity extends AppCompatActivity {

    private String price = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        Bundle arguments = new Bundle();
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            price = (String) bundle.get("preco");
        }

        arguments.putString("price", price);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding arguments to the Fragments
        SeatsFragment seatsFragment = new SeatsFragment();
        seatsFragment.setArguments(arguments);

        PaymentFragment paymentFragment = new PaymentFragment();
        paymentFragment.setArguments(arguments);

        //Adding the Fragments to the View
        adapter.addFragment(seatsFragment, null);
        adapter.addFragment(paymentFragment, null);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
