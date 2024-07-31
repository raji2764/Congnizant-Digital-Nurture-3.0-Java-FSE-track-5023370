class Computer {
    // Attributes
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final boolean isGraphicsCardEnabled;
    private final boolean isBluetoothEnabled;

    // Private constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Static nested Builder class
    public static class Builder {
        // Required attributes
        private final String CPU;
        private final String RAM;

        // Optional attributes
        private String storage = "500GB";
        private boolean isGraphicsCardEnabled = false;
        private boolean isBluetoothEnabled = false;

        // Constructor for required attributes
        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        // Methods to set optional attributes
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // Build method to return a Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage +
                ", Graphics Card=" + (isGraphicsCardEnabled ? "Enabled" : "Disabled") +
                ", Bluetooth=" + (isBluetoothEnabled ? "Enabled" : "Disabled") + "]";
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        // Creating a basic Computer
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();
        System.out.println("Basic Computer: " + basicComputer);

        // Creating a Computer with all optional attributes
        Computer advancedComputer = new Computer.Builder("Intel i9", "16GB")
                .setStorage("1TB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();
        System.out.println("Advanced Computer: " + advancedComputer);

        // Creating a Computer with some optional attributes
        Computer midRangeComputer = new Computer.Builder("AMD Ryzen 7", "12GB")
                .setStorage("512GB")
                .build();
        System.out.println("Mid-Range Computer: " + midRangeComputer);
    }
}
