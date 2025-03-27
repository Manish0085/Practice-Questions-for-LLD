package NavigationSystem;

public class WithoutToll implements RouteStrategy{

    @Override
    public void findPath(String source, String destination) {
        System.out.println("without toll route from "+source+" to "+destination);
    }
}
