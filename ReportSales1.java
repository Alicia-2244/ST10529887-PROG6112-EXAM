/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reportsales1;

/**
 *
 * @author Student
 */
public class ReportSales1 {

    public static void main(String[] args) {
        
        //the company's top three performing products over the three months
        String[] products = {
            "Cozy Nights Monarch", 
            "Restonic Barbados", 
            "Sealy Phuket"
        };

        // the number of sales of the three products for the three months
        int[][] salesData = {
            {25, 18, 20}, 
            {15, 10, 12}, 
            {18, 15, 20} 
        };

        int totalSales = 0;
        int totalElements = 0;
        int maxProductSales = -1;
        String mostPopularProduct = "";

        // Loop through the 2D array to calculate totals and find the top product
        for (int i = 0; i < salesData.length; i++) {
            int currentProductTotal = 0;
            
            for (int j = 0; j < salesData[i].length; j++) {
                currentProductTotal += salesData[i][j];
                totalSales += salesData[i][j];
                totalElements++;
            }

            // Determining the most popular product based on highest total sales
            if (currentProductTotal > maxProductSales) {
                maxProductSales = currentProductTotal;
                mostPopularProduct = products[i] + " (" + maxProductSales + ")";
            }
        }

        // Calculation of the average sales
        double averageSales = (double) totalSales / totalElements;

        
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("*************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + totalSales);
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(averageSales));
        System.out.println("MOST POPULAR PRODUCT: " + mostPopularProduct);
    }
}

