package se.hernebring.tenta.u3;

public class Computer implements Comparable<Computer>{
    private String namn;
    private int processorHastighetGHz;
    private int ramMinneMB;
    private int sizeHardDriveMB;

    public Computer(String namn, int processorHastighetGHz, int ramMinneMB, int sizeHardDriveMB) {
        this.namn = namn;
        this.processorHastighetGHz = processorHastighetGHz;
        this.ramMinneMB = ramMinneMB;
        this.sizeHardDriveMB = sizeHardDriveMB;
    }

    public String getNamn() {
        return namn;
    }

    public int getProcessorHastighetGHz() {
        return processorHastighetGHz;
    }

    public int getRamMinneMB() {
        return ramMinneMB;
    }

    public int getSizeHardDriveMB() {
        return sizeHardDriveMB;
    }

    @Override
    public int compareTo(Computer other) {
        if (this == other)
            return 0;
        else if (processorHastighetGHz > other.processorHastighetGHz)
            return 1;
        else if (processorHastighetGHz < other.processorHastighetGHz)
            return -1;
        else if (ramMinneMB > other.ramMinneMB)
            return 1;
        else if (ramMinneMB < other.ramMinneMB)
            return -1;
        else if (sizeHardDriveMB > other.sizeHardDriveMB)
            return 1;
        else if (sizeHardDriveMB < other.sizeHardDriveMB)
            return -1;
        return 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + processorHastighetGHz;
        result = prime * result + ramMinneMB;
        result = prime * result + sizeHardDriveMB;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Computer other = (Computer) obj;
        if (processorHastighetGHz != other.processorHastighetGHz)
            return false;
        if (ramMinneMB != other.ramMinneMB)
            return false;
        if (sizeHardDriveMB != other.sizeHardDriveMB)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Computer [namn=" + namn + ", processorHastighetGHz=" + processorHastighetGHz + ", ramMinneMB="
                + ramMinneMB + ", sizeHardDriveMB=" + sizeHardDriveMB + "]";
    }

}
