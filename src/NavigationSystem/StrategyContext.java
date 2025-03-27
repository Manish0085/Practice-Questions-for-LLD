package NavigationSystem;

public class StrategyContext {

    private RouteStrategy route;

    public void setStrategy(RouteStrategy route){
        this.route = route;
    }


    public void navigate(String source, String destination){
        if (route == null){
            throw new IllegalStateException("No route strategy is set");
        }
        route.findPath(source, destination);
    }
}
