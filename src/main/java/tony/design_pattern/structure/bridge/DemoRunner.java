package tony.design_pattern.structure.bridge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DemoRunner {

    public static void main(String[] args){
        Set<Color> colors = new HashSet<>();
        colors.add(new Red());
        colors.add(new Blue());

        List<Bag> allbag = new ArrayList<>();
        for (Color color : colors){
            Bag handbag = new HandBag(), wallet = new Wallet();
            handbag.setColor(color);
            allbag.add(handbag);

            wallet.setColor(color);
            allbag.add(wallet);
        }

        for (Bag bag : allbag){
            System.out.println("We have: "+bag.getName());
        }
    }
}
