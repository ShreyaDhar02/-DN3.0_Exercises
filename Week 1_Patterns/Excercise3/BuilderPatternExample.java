class Computer {
    private String cpu;
    private int ram;
    private int storage;
    private String gpu;
    private String os;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.os = builder.os;
    }

    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        private String gpu;
        private String os;

        public Builder withCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder withRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder withStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder withGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder withOs(String os) {
            this.os = os;
            return this;
        }

        // build() method returns an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer { cpu= "+cpu+" , ram= "+ram+" , storage= "+storage+" , gpu="+gpu+" , os= "+os+" }";
    }
}
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Create a basic computer
        Computer basicComputer = new Computer.Builder()
                .withCpu("Intel Core i3")
                .withRam(8)
                .withStorage(256)
                .withOs("Windows 10")
                .build();

        System.out.println("Basic Computer: " + basicComputer);


        Computer gamingComputer = new Computer.Builder()
                .withCpu("Intel Core i7")
                .withRam(16)
                .withStorage(512)
                .withGpu("NVIDIA GeForce GTX 1660")
                .withOs("Windows 10")
                .build();

        System.out.println("Gaming Computer: " + gamingComputer);
    }
}