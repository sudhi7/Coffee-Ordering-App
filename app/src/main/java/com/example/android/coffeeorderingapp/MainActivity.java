package com.example.android.coffeeorderingapp;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = getPrice();
        String message = "Quantity: "+quantity;
        message +="\nTotal: $" + (price);
        CheckBox ch = (CheckBox) findViewById(R.id.whippedCream);
        if(ch.isChecked()) {
            message += "\nWhipped Cream topping added.";
        }
        ch = (CheckBox) findViewById(R.id.Chocolate);
        if(ch.isChecked()) {
            message += "\nChocolate topping Added.";
        }
        message += "\nThank you!!";
        displayMessage(message);
    }

    private int getPrice() {
        return quantity*5;
    }

    public void incrementQuantity(View view) {
        /*TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        CharSequence co = quantityTextView.getText();
        String st = co.toString();
        int c = Integer.parseInt(st);*/
        ++quantity;
        display(quantity);
        displayPrice(quantity*5);
    }

    public void decrementQuantity(View view) {
        /*TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        CharSequence co = quantityTextView.getText();
        String st = co.toString();
        int c = Integer.parseInt(st);*/
        if(quantity!=0) {
            --quantity;
            display(quantity);
            displayPrice(quantity * 5);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String msg) {
        TextView quantityTextView = (TextView) findViewById(R.id.order_summary);
        msg+="\n";
        quantityTextView.setText(msg);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}