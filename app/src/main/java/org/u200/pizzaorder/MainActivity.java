package org.u200.pizzaorder;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.RadioButton;
        import android.widget.Switch;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Pizza pizza;
    TextView total, delivery;
    double totalPrice;
    String totalOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizza = new Pizza();
        total = findViewById(R.id.total);
        delivery = findViewById(R.id.deliveryNote);
    }

    public void radioClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()){
            case R.id.smallPizzaButton:
                if (checked)
                    pizza.setPizza_size_price(9);
                break;
            case R.id.mediumPizzaButton:
                if (checked)
                    pizza.setPizza_size_price(10);
                break;
            case R.id.largePizzaButton:
                if (checked)
                    pizza.setPizza_size_price(11);
                break;

        }
        totalOrder = getString(R.string.total_price_output) + String.format("%.02f", calculateTotal());
        total.setText(totalOrder);

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked

        switch (view.getId()){
            case R.id.addMeat:
                if (checked)
                    pizza.setMeat_price(2);
                else
                    pizza.setMeat_price(0);
                break;
            case R.id.addCheese:
                if (checked)
                    pizza.setCheese_price(2);
                else
                    pizza.setCheese_price(0);
                break;
            case R.id.addVeggies:
                if (checked)
                    pizza.setVeggies_price(2);
                else
                    pizza.setVeggies_price(0);
                break;
        }

        totalOrder = getString(R.string.total_price_output) + String.format("%.02f", calculateTotal());
        total.setText(totalOrder);
    }

    private double calculateTotal() {
        totalPrice = pizza.getPizza_size_price() + pizza.getCheese_price() + pizza.getMeat_price() + pizza.getVeggies_price();
        return totalPrice;
    }

    public void onSwitchClicked(View view) {
        Switch swButton = (Switch) view;
        if(swButton.isChecked()) {
            delivery.setText(R.string.delivery_required);
        } else
            delivery.setText("");
    }
}
