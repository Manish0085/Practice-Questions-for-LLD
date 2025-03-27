package NavigationSystem;

public class ShortestDistance implements RouteStrategy{

    @Override
    public void findPath(String source, String destination) {
        System.out.println("the shortest path from"+source+" to "+destination);
    }
}
