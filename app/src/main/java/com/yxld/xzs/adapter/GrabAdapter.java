package com.yxld.xzs.adapter;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yxld.xzs.R;
import com.yxld.xzs.entity.AppOrder;
import com.yxld.xzs.entity.AppSaleList;

import java.util.List;

/**
 * Created by yishangfei on 2016/10/18 0018.
 */

public class GrabAdapter extends BaseQuickAdapter<AppOrder, BaseViewHolder> {
    private List<AppSaleList> appSaleLists;
    public GrabAdapter(List<AppOrder> list,List<AppSaleList> saleLists) {
        super(R.layout.fragment_grab_item, list);
        appSaleLists = saleLists;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, AppOrder item) {
        String name ="";//商品名称
        String amount="";//商品数量
        String total="";//商品总价
        for(int i = 0; i <appSaleLists.size(); i++){
            if(item.getDingdanBianhao().equals(appSaleLists.get(i).getSaleOrderBianhao())){
                name +=appSaleLists.get(i).getSaleShangpName()+"\n\n";
                amount +="×"+appSaleLists.get(i).getSaleNum()+"\n\n";
                total +="¥"+appSaleLists.get(i).getSaleTotalRmb()+"\n\n";
            }
        }

        String str1 = "送:　";
        String str2 =item.getDingdanDizhi();
        SpannableStringBuilder address = new SpannableStringBuilder(str1 + str2);
        address.setSpan(new ForegroundColorSpan(Color.parseColor("#73C676")),
                0, str1.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        viewHolder.setText(R.id.grab_address, address)
                .setText(R.id.grab_product,name.substring(0,name.length()-2))
                .setText(R.id.grab_amount,amount.substring(0,amount.length()-2))
                .setText(R.id.grab_total,total.substring(0,total.length()-2))
                .setText(R.id.grab_money, "¥" + item.getDingdanTotalRmb())
                .setText(R.id.grab_time, item.getDingdanXiadanTime())
                .addOnClickListener(R.id.grab_button);
    }
}
