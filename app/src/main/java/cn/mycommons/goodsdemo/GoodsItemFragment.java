package cn.mycommons.goodsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * GoodsItemFragment <br/>
 * Created by xiaqiulei on 2016-11-22.
 */
public class GoodsItemFragment extends Fragment {

    static final String EXTRA_GOODS_ITEM = "goods_item";

    public static GoodsItemFragment newFragment(GoodsItem goodsItem) {
        GoodsItemFragment fragment = new GoodsItemFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_GOODS_ITEM, goodsItem);
        fragment.setArguments(args);
        return fragment;
    }


    private TextView tvName, tvCount, tvPrice;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.databinding, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvName = (TextView) view.findViewById(R.id.tvName);
        tvCount = (TextView) view.findViewById(R.id.tvCount);
        tvPrice = (TextView) view.findViewById(R.id.tvPrice);

        GoodsItem goodsItem = (GoodsItem) getArguments().getSerializable(EXTRA_GOODS_ITEM);
        if (goodsItem != null) {
            tvName.setText(goodsItem.name);
            tvCount.setText(String.format("x%s", goodsItem.count));
            tvPrice.setText(String.format("￥%s", goodsItem.price));
        }
    }
}