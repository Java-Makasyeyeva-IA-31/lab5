package project.lab5.comparison;

public interface DoSomething {
    
    String get();
    
    default String hidden() {
        return "Hidden";
    }
}
