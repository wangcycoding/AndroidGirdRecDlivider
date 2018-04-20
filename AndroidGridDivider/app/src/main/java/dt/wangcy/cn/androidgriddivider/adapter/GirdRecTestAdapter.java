package dt.wangcy.cn.androidgriddivider.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import dt.wangcy.cn.androidgriddivider.R;


/**
 * Created by wangcy on 2017/11/23.
 * 名称:
 */

public class GirdRecTestAdapter extends RecyclerView.Adapter<GirdRecTestAdapter.MyViewHolder> {
    private Context mContext;
    public OnItemClickListener mOnItemClickListener = null;
    private String[] mDatas = new String[]{"白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"};
    //    private String[] mDatas = new String[]{"系统消息","选修课程","我的等级","我的提问","联系我们","推荐书单","分享亿林","关于我们"};
    private int[] mDrawable = new int[]{R.drawable.baiyang, R.drawable.jinniu, R.drawable.shuangzi, R.drawable.juxie,
            R.drawable.shizi, R.drawable.chunv, R.drawable.tianping, R.drawable.tianxie, R.drawable.sheshou,
            R.drawable.mojie, R.drawable.shuiping, R.drawable.shuangyu};

    //    private int[] mDrawable = new int[]{R.drawable.item_0,R.drawable.item_1,R.drawable.item_2,R.drawable.item_3,
//            R.drawable.item_4,R.drawable.item_5,R.drawable.item_6,R.drawable.item_7};
    public GirdRecTestAdapter(Context context) {
        mContext = context;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onitemClick(int position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.me_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.item_title.setText(mDatas[position]);
        holder.item_image.setImageResource(mDrawable[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onitemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item_title;
        ImageView item_image;

        public MyViewHolder(View view) {
            super(view);
            item_title = (TextView) view.findViewById(R.id.item_title);
            item_image = (ImageView) view.findViewById(R.id.item_image);
        }
    }


}
