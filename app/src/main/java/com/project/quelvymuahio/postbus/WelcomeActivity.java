package com.project.quelvymuahio.postbus;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.quelvymuahio.postbus.Adapter.SlideAdapter;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private Button mNextBtn;
    private Button mbackBtn;

    private int mCurrentPage;

    private final int LAST_PAGE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.linearLayout);

        mbackBtn = findViewById(R.id.backBtn);
        mNextBtn = findViewById(R.id.nextBtn);

        SlideAdapter slideAdapter = new SlideAdapter(this);

        mSlideViewPager.setAdapter(slideAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        mbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentPage + 1 == LAST_PAGE){
                    Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                }

            }
        });

    }

    public void addDotsIndicator(int position){

        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i=0; i < mDots.length; i++ ){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }

    }

    final ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;

            if (position == 0){
                mNextBtn.setEnabled(true);
                mbackBtn.setEnabled(false);
                mbackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("Próximo");
                mbackBtn.setText("");
            }else if(position == mDots.length - 1){
                mNextBtn.setEnabled(true);
                mbackBtn.setEnabled(true);
                mbackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Terminar");
                mbackBtn.setText("Voltar");
            }else{
                mNextBtn.setEnabled(true);
                mbackBtn.setEnabled(true);
                mbackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Próximo");
                mbackBtn.setText("Voltar");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
