package NavigationSystem;

import java.util.Scanner;

public class FastestPath implements RouteStrategy{

    @Override
    public void findPath(String source, String destination) {
        System.out.println("the fastest path from "+source+" to "+destination);
    }
}
