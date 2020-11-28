package se.hernebring.tenta.u3;

import java.util.Comparator;

public class HardDriveComparator implements Comparator<Computer>{

    @Override
    public int compare(Computer computer1, Computer computer2) {
        if(computer1.getSizeHardDriveMB() < computer2.getSizeHardDriveMB())
            return -1;
        else if(computer1.getSizeHardDriveMB() > computer2.getSizeHardDriveMB())
            return 1;
        else
            return 0;
    }
    
}
