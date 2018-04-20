package dt.wangcy.cn.androidgriddivider;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import dt.wangcy.cn.androidgriddivider.adapter.GirdRecTestAdapter;
import dt.wangcy.cn.androidgriddivider.view.GridDivider;

public class MainActivity extends Activity implements IBaseActivity,GirdRecTestAdapter.OnItemClickListener{


    @BindView(R.id.rl_test)
    public RecyclerView mRlTest;
    @BindView(R.id.tv_title_tip)
    public TextView mTvTitleTip;
    @BindView(R.id.ll_leftback)
    public LinearLayout mBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        ButterKnife.bind(this);
        initView();
        initData();
        initWeight();
    }

    @Override
    public void initView() {
        GridLayoutManager layoutManager = new GridLayoutManager(mRlTest.getContext(),3);
        mRlTest.setLayoutManager(layoutManager);
        mRlTest.addItemDecoration(new GridDivider(mRlTest.getContext(), 2, this.getResources().getColor(R.color.theme_color)));
        mBack.setVisibility(View.GONE);
        mTvTitleTip.setText("主页");
    }

    @Override
    public void initData() {
        GirdRecTestAdapter adapter = new GirdRecTestAdapter(this);
        adapter.setOnItemClickListener(this);
        mRlTest.setAdapter(adapter);
    }

    @Override
    public void initWeight() {

    }

    @Override
    public void onClick() {

    }

    @Override
    public void onitemClick(int position) {
        Toast.makeText(this,"你点击了第"+(position+1)+"个子项",Toast.LENGTH_SHORT).show();
    }
}
