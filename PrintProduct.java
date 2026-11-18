/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reportsales1;

/**
 *
 * @author Student
 */
public class PrintProduct implements IProducts {
private int[][] salesData;
private String[] productsNames;

public PrintProduct (int[][] salesData, String[] product names){
    this.salesData = salesData;
    this.productNames = productNames;
            
}
    @Override
    public int GetTotalProductsSold() {
       int total = 0;
       for (int i =0; i < salesData.length; i++){
           for (int j =0; j < salesData[i].length; j++){
               total += salesData[i][j]
           }
       }
       return total;
    }

    @Override
    public double GetAverageProductsSold() {
        int total = GetTotalProductsSold();
        int totalElements =0;
        for (int i =0; i < salesData.length; i++){
            totalElements +=salesData[i].length;
        }
        return double total;
    }
        

    @Override
    public String GetMostPopularProduct(){
        int maxSales = -1;
        String PopoularProduct = "";
        for (int i =0; i< salesData.length; i++){
            int productTotal =0;
        }
        for (int j =0; j < salesData[j].length; j++ ){
            productTotal += salesData[i][j];
        }
        if (productTotal > maxSales ){
            popularProduct = productNames[i] + "("+ maxSales + ")";
        }
    }
    return popularProduct;
    }

    
    
}
