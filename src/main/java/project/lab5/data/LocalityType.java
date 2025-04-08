package project.lab5.data;

import java.security.InvalidParameterException;


public enum LocalityType {
    CITY("CITY"), VILLAGE("VILLAGE");
    
    private String name;
    
    LocalityType(String name) {
        this.name = name;
    }
    
    public static LocalityType getInstance(String name) {
        for (LocalityType localityType : LocalityType.values()) {
            if (localityType.name.equals(name)) {
                return localityType;
            }
        }
        
        throw new InvalidParameterException("There is no locality tipe by " + name);
    }
    
    public String getName() {
        return name;
    }
}
