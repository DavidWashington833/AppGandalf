package com.gandalf.helpers;

import com.gandalf.models.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel.elmontibelle on 21/11/2017.
 */

public class CarrinhoSingletonHelper {

    private static final CarrinhoSingletonHelper INSTANCE = new CarrinhoSingletonHelper();
    private List<Produto> produto = new ArrayList<>();

    private CarrinhoSingletonHelper(){
    }

    public static CarrinhoSingletonHelper getInstance(){
        return INSTANCE;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void clearProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public void pushProduto(Produto produto) {
        this.produto.add(produto);
    }

    public void removeProduto(Produto produto) {
        for (int i = 0; i < this.produto.size(); i++){
            if(produto.getIdProduto().equals(this.produto.get(i).getIdProduto())){
                this.produto.remove(i);
                break;
            }
        }
    }
}
