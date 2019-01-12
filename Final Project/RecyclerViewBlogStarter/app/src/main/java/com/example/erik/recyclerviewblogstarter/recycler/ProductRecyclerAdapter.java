package com.example.erik.recyclerviewblogstarter.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.erik.recyclerviewblogstarter.R;
import com.example.erik.recyclerviewblogstarter.model.Product;

import java.util.List;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> products;
    private ICheckBoxListener iCheckBoxListener;

    public ProductRecyclerAdapter(Context context, List<Product> products, ICheckBoxListener iCheckBoxListener){
        this.context = context;
        this.products = products;
        this.iCheckBoxListener = iCheckBoxListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View recListView = layoutInflater.inflate(R.layout.rec_list, null);
        return new ProductViewHolder(recListView, iCheckBoxListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        productViewHolder.productNameTextView.setText(products.get(i).getName());
        productViewHolder.productDescriptionTextView.setText(products.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        protected TextView productNameTextView;
        protected TextView productDescriptionTextView;
        protected CheckBox checkBox;
        private final ICheckBoxListener iCheckBoxListener;

        public ProductViewHolder(@NonNull View itemView, final ICheckBoxListener iCheckBoxListener) {
            super(itemView);
            this.productNameTextView = itemView.findViewById(R.id.tv_product);
            this.productDescriptionTextView = itemView.findViewById(R.id.tv_desc);
            this.checkBox = itemView.findViewById(R.id.checkbox);
            this.iCheckBoxListener = iCheckBoxListener;

            this.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iCheckBoxListener.onClick(productDescriptionTextView, getAdapterPosition());
                }
            });
        }
    }

    public interface ICheckBoxListener{
        void onClick(TextView textView, Integer position);
    }
}
