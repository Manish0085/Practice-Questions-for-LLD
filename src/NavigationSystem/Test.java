package NavigationSystem;

import javax.swing.text.NavigationFilter;
import java.util.NavigableMap;

public class Test {

    public static void main(String[] args) {
        StrategyContext context = new StrategyContext();

        context.setStrategy(new ShortestDistance());
        context.navigate("Chicago", "Miami");

        context.setStrategy(new FastestPath());
        context.navigate("New York", "Los Angeles");

        context.setStrategy(new WithoutToll());
        context.navigate("San Francisco", "Seattle");
    }
}
