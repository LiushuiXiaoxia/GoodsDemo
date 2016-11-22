package cn.mycommons.goodsdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cn.mycommons.goodsdemo.databinding.ActivityMainBinding;
import cn.mycommons.goodsdemo.module.GoodsItemModule;

public class MainActivity extends AppCompatActivity {

    private GoodsItemModule goodsItemModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        GoodsItem goodsItem = new GoodsItem();
        goodsItem.name = "可口可乐";
        goodsItem.count = 123;
        goodsItem.price = 321;

        // normal
        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvCount = (TextView) findViewById(R.id.tvCount);
        TextView tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvName.setText(goodsItem.name);
        tvCount.setText(String.format("x%s", goodsItem.count));
        tvPrice.setText(String.format("￥%s", goodsItem.price));

        // databind
        binding.includeDatabinding.tvName.setText(goodsItem.name);
        binding.includeDatabinding.tvCount.setText(String.format("x%s", goodsItem.count));
        binding.includeDatabinding.tvPrice.setText(String.format("￥%s", goodsItem.price));

        // databind with param
        binding.includeDatabindingWithParam.setGood(goodsItem);

        // custom view
        GoodsItemView goodsItemView = (GoodsItemView) findViewById(R.id.goodsItemView);
        goodsItemView.updateUI(goodsItem);

        // module
        goodsItemModule = new GoodsItemModule(findViewById(R.id.includeModule));
        goodsItemModule.create();
        goodsItemModule.updateUI(goodsItem);

        // fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(binding.fragmentContainer.getId(), GoodsItemFragment.newFragment(goodsItem))
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        goodsItemModule.destroy();
    }
}