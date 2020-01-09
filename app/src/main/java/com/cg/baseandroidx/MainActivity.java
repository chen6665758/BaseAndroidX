package com.cg.baseandroidx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private Button btn_tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        initControls();
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    /**
     * 初始化控件
     */
    private void initControls()
    {
        btn_tempFragment = (Button)findViewById(R.id.btn_tempFragment);
        btn_tempFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jump_intent(tempFragmentActivity.class,null);
            }
        });
    }

    @Override
    public void Jump_intent(Class<?> cla, Bundle bundle) {
        if(mContext !=null)
        {
            Intent intent = new Intent(mContext, cla);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            startActivity(intent);
            //overridePendingTransition(0, 0);
        }
    }
}
