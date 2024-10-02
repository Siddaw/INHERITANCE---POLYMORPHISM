// Base Class: FarmTool
class FarmTool {
    String name;
    String function;

    // Constructor
    public FarmTool(String name, String function) {
        this.name = name;
        this.function = function;
    }

    // Method to describe the farm tool
    public void describeTool() {
        System.out.println("This is a general farm tool used for " + function + ".");
    }

    // Method to simulate operating the tool
    public void operate() {
        System.out.println("Operating the farm tool...");
    }
}

// Single Inheritance: Plow extends FarmTool
class Plow extends FarmTool {
    boolean isManual;

    // Constructor
    public Plow(String name, String function, boolean isManual) {
        super(name, function); // Call the parent class constructor
        this.isManual = isManual;
    }

    // Overriding the describe method
    @Override
    public void describeTool() {
        System.out.println("This is a plow named " + name + ", used for " + function + ".");
        System.out.println("Is it manual? " + isManual);
    }

    // Method to show if the plow is manual or automatic
    public void showType() {
        System.out.println("Manual Plow: " + isManual);
    }
}

// Multilevel Inheritance: Tractor extends Plow
class Tractor extends Plow {
    int horsepower;

    // Constructor
    public Tractor(String name, String function, boolean isManual, int horsepower) {
        super(name, function, isManual); // Call the parent class constructor
        this.horsepower = horsepower;
    }

    // New method specific to Tractor
    public void plowField() {
        System.out.println(name + " tractor is plowing the field with " + horsepower + " horsepower.");
    }

    // Overriding the describe method
    @Override
    public void describeTool() {
        System.out.println("This is a tractor named " + name + ", used for " + function + " with " + horsepower + " HP.");
    }
}

// Hierarchical Inheritance: Sprayer extends FarmTool
class Sprayer extends FarmTool {
    boolean isAutomatic;

    // Constructor
    public Sprayer(String name, String function, boolean isAutomatic) {
        super(name, function); // Call the parent class constructor
        this.isAutomatic = isAutomatic;
    }

    // Overriding the describe method
    @Override
    public void describeTool() {
        System.out.println("This is a sprayer named " + name + ", used for " + function + ".");
        System.out.println("Is it automatic? " + isAutomatic);
    }

    // New method specific to Sprayer
    public void spray() {
        if (isAutomatic) {
            System.out.println(name + " sprayer is spraying automatically.");
        } else {
            System.out.println(name + " sprayer is manual.");
        }
    }
}

// Main class
public class FarmToollists {
    public static void main(String[] args) {
        // Create an instance of the Plow class (Single Inheritance)
        Plow plow = new Plow("Old Plow", "plowing the soil", true);
        plow.describeTool(); // Calls overridden method
        plow.showType();
        plow.operate(); // Calls method from FarmTool class

        // Create an instance of the Tractor class (Multilevel Inheritance)
        Tractor tractor = new Tractor("John Deere", "heavy-duty plowing", false, 150);
        tractor.describeTool(); // Calls overridden method in Tractor class
        tractor.showType(); // Calls method from Plow class
        tractor.plowField(); // Calls method from Tractor class
        tractor.operate(); // Inherits method from FarmTool class

        // Create an instance of the Sprayer class (Hierarchical Inheritance)
        Sprayer sprayer = new Sprayer("CropMaster", "spraying crops", true);
        sprayer.describeTool(); // Calls overridden method in Sprayer class
        sprayer.spray(); // Calls method from Sprayer class
        sprayer.operate(); // Inherits method from FarmTool class
    }
}
