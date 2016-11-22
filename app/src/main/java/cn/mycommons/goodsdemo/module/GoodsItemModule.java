package cn.mycommons.goodsdemo.module;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import cn.mycommons.goodsdemo.GoodsItem;
import cn.mycommons.goodsdemo.R;

/**
 * GoodsItemModule <br/>
 * Created by xiaqiulei on 2016-11-22.
 */
public class GoodsItemModule implements IModule {

    @NonNull
    private final View rootView;

    private TextView tvName, tvCount, tvPrice;

    public GoodsItemModule(@NonNull View rootView) {
        this.rootView = rootView;
    }

    @Override
    public void create() {
        tvName = (TextView) rootView.findViewById(R.id.tvName);
        tvCount = (TextView) rootView.findViewById(R.id.tvCount);
        tvPrice = (TextView) rootView.findViewById(R.id.tvPrice);
    }

    public void updateUI(GoodsItem goodsItem) {
        tvName.setText(goodsItem.name);
        tvCount.setText(String.format("x%s", goodsItem.count));
        tvPrice.setText(String.format("￥%s", goodsItem.price));
    }

    @Override
    public void destroy() {
        tvName = null;
        tvCount = null;
        tvPrice = null;
    }
}