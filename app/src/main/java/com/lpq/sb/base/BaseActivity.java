package com.lpq.sb.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * 基类的activity封装 <br/>
 * Created by lipanquan on 2017/3/24.<br />
 * phoneNumber:18500214652
 *
 * @author lipanquan   2017/3/24
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 当前界面是否是浸没状态栏
     */
    private boolean isImmersionStatusBar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (isFullScreen()) {
            this.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
        }
        super.onCreate(savedInstanceState);
        if (!isFullScreen() && getStatusFlag() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 处理4.4 -5.0以及5.0以上沉浸式状态栏
            isImmersionStatusBar = true;
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //  设置状态栏是否透明
            //  getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(getResources().getColor(getStatusBarColor()));
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Window window = getWindow();
                // Translucent status bar
                window.setFlags(
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }

    /**
     * 是否是全屏无状态栏显示
     *
     * @return true为全屏
     */
    protected boolean isFullScreen() {
        return false;
    }

    /**
     * 设置是否是浸没状态栏
     *
     * @return true 为实现浸没状态栏
     */
    protected boolean getStatusFlag() {
        return false;
    }

    /**
     * 设置状态栏的颜色
     *
     * @return 如R.color.black
     */
    protected abstract int getStatusBarColor();


    /**
     * 获取是否是浸没状态栏
     *
     * @return 是否是浸没状态栏
     */
    public boolean isImmersionStatusBar() {
        return isImmersionStatusBar;
    }
}
