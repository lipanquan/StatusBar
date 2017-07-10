package com.lpq.sb;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lpq.sb.base.BaseActivity;

/**
 * 第二个测试界面 <br/>
 * Created by lipanquan on 2017/5/23.<br />
 * phoneNumber:18500214652 <br />
 * email:lipq@jingzhengu.com <br />
 *
 * @author lipanquan   2017/5/23
 */
public class SecondActivity extends BaseActivity {

    private ViewPager mPager;
    private ScalePagerAdapter mAdapter;

    private View titleContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        titleContent = findViewById(R.id.titleContent);
        mPager = (ViewPager) findViewById(R.id.viewPager);
        mAdapter = new ScalePagerAdapter();
        mPager.setAdapter(mAdapter);
    }

    int alpha = 0;

    public void changeStatusBarColor(View v) {
        alpha += 10;
        if (alpha > 255)
            alpha = 0;
        titleContent.setBackgroundColor(Color.argb(alpha, 0, 0, 255));
    }

    @Override
    protected boolean getStatusFlag() {
        return true;
    }

    @Override
    protected int getStatusBarColor() {
        return android.R.color.transparent;
    }

    private class ScalePagerAdapter extends PagerAdapter {

        private int resIds[] = new int[]{R.drawable.dx1, R.drawable.dx2, R.drawable.dx3};

        private ImageView[] imageViews = new ImageView[resIds.length];

        @Override
        public int getCount() {
            return resIds.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews[position]);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView scaleView = new ImageView(getApplicationContext());
            scaleView.setImageResource(resIds[position]);
            imageViews[position] = scaleView;
            container.addView(scaleView);
            return scaleView;
        }

    }
}
