package kr.co.tjeit.mobileshopper.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kr.co.tjeit.mobileshopper.R;
import kr.co.tjeit.mobileshopper.data.ProductData;

/**
 * Created by the on 2017-08-01.
 */

public class ProductAdapter extends ArrayAdapter<ProductData>{
    private Context mContext;
    private List<ProductData> mList;
    LayoutInflater inf;

    public ProductAdapter(Context context, List<ProductData> list) {
        super(context, R.layout.product_list_item, list);

        this.mContext = context;
        this.mList = list;
        this.inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null) {
            row = inf.inflate(R.layout.product_list_item, null);
        }

        ProductData myProductData = mList.get(position);

        TextView prouctTxt = (TextView) row.findViewById(R.id.prouctTxt);
        prouctTxt.setText(myProductData.getName());

        TextView priceTxt = (TextView) row.findViewById(R.id.priceTxt);
        priceTxt.setText(myProductData.getPrice() + "원");

        EditText countTxt = (EditText) row.findViewById(R.id.countTxt);
        countTxt.setText(myProductData.getCount() + "개");

        ImageView productImg = (ImageView) row.findViewById(R.id.productImg);

        productImg.setImageResource(myProductData.getImgNum());

        return row;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
