package com.example.ayedis_ecommerce.Model;

public class Products
{
    private String Category, ProductName, ProductDiscount, ProductPrice, date, image, pid, time;

    public Products()
    {

    }

    public Products(String category, String productName, String productDiscount, String productPrice, String date, String image, String pid, String time) {
        Category = category;
        ProductName = productName;
        ProductDiscount = productDiscount;
        ProductPrice = productPrice;
        this.date = date;
        this.image = image;
        this.pid = pid;
        this.time = time;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDiscount() {
        return ProductDiscount;
    }

    public void setProductDiscount(String productDiscount) {
        ProductDiscount = productDiscount;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
