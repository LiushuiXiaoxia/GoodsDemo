package cn.mycommons.goodsdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * GoodsItemView <br/>
 * Created by xiaqiulei on 2016-11-22.
 */
public class GoodsItemView extends FrameLayout {

    private TextView tvName, tvCount, tvPrice;

    public GoodsItemView(Context context) {
        super(context);

        init();
    }

    public GoodsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public GoodsItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    public GoodsItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init();
    }

    void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.databinding, this);

        tvName = (TextView) findViewById(R.id.tvName);
        tvCount = (TextView) findViewById(R.id.tvCount);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
    }

    public void updateUI(GoodsItem goodsItem) {
        tvName.setText(goodsItem.name);
        tvCount.setText(String.format("x%s", goodsItem.count));
        tvPrice.setText(String.format("￥%s", goodsItem.price));
    }
}
