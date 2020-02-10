package com.cg.baseandroidx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.Visibility;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
/*                       _oo0oo_
/*                      o8888888o
/*                      88" . "88
/*                      (| -_- |)
/*                      0\  =  /0
/*                    ___/`---'\___
/*                  .' \\|     |// '.
/*                 / \\|||  :  |||// \
/*                / _||||| -:- |||||- \
/*               |   | \\\  -  /// |   |
/*               | \_|  ''\---/''  |_/ |
/*               \  .-\__  '-'  ___/-. /
/*             ___'. .'  /--.--\  `. .'___
/*          ."" '<  `.___\_<|>_/___.' >' "".
/*         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
/*         \  \ `_.   \_ __\ /__ _/   .-` /  /
/*     =====`-.____`.___ \_____/___.-`___.-'=====
/*                       `=---='
/*
/*     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*               佛祖保佑         永无BUG

* 功能：转场动画的使用
* 作者：cg
* 时间：2020/2/7 14:40
*/
public class tempTransitioActivity extends BaseActivity {

    private Button btn_transition;
    private Button btn_transitionSet;

    private LinearLayout linear_view;
    private View view_red;
    private View view_blue;

    Transition transition;
    Transition transitions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_transitio);

        initControls();
    }

    /**
     * 初始化控件
     */
    private void initControls() {

        transition= TransitionInflater.from(this).inflateTransition(R.transition.slide_transition);
        transitions = TransitionInflater.from(this).inflateTransition(R.transition.mulity_transition);

        btn_transition = (Button)findViewById(R.id.btn_transition);
        btn_transition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //单转场
                TransitionManager.beginDelayedTransition(linear_view, transition);
                toggleVisibility(view_red,view_blue);
            }
        });

        btn_transitionSet = (Button)findViewById(R.id.btn_transitionSet);
        btn_transitionSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(linear_view, transitions);
                toggleVisibility(view_red,view_blue);
            }
        });

        linear_view = (LinearLayout)findViewById(R.id.linear_view);
        view_red = (View)findViewById(R.id.view_red);
        view_blue = (View)findViewById(R.id.view_blue);
    }


    private void toggleVisibility(View view1,View view2)
    {
        view1.setVisibility(view1.getVisibility()==View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
        view2.setVisibility(view2.getVisibility()==View.VISIBLE ? View.GONE : View.VISIBLE);
    }

    @Override
    public void setContentView() {

    }

    @Override
    public void Jump_intent(Class<?> cla, Bundle bundle) {

    }
}
