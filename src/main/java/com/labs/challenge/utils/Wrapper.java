package com.labs.challenge.utils;

import java.util.List;

public class Wrapper {
    private MetaWrapper meta;

    private List<ProductWrapper> products;

    public MetaWrapper getMeta() {
        return meta;
    }

    public void setMeta(MetaWrapper meta) {
        this.meta = meta;
    }

    public List<ProductWrapper> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWrapper> products) {
        this.products = products;
    }
}
