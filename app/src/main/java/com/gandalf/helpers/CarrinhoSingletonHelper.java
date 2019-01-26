package com.gandalf.helpers;

import com.gandalf.models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel.elmontibelle on 21/11/2017.
 */

public class CarrinhoSingletonHelper {

    private static final CarrinhoSingletonHelper INSTANCE = new CarrinhoSingletonHelper();
    private List<Product> product = new ArrayList<>();

    private CarrinhoSingletonHelper(){
    }

    public static CarrinhoSingletonHelper getInstance(){
        return INSTANCE;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void clearProduto(List<Product> product) {
        this.product = product;
    }

    public void pushProduto(Product product) {
        this.product.add(product);
    }

    public void removeProduto(Product product) {
        for (int i = 0; i < this.product.size(); i++){
            if(product.getIdProduto().equals(this.product.get(i).getIdProduto())){
                this.product.remove(i);
                break;
            }
        }
    }
}
