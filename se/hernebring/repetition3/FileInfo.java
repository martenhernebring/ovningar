package se.hernebring.repetition3;

public class FileInfo implements Comparable<FileInfo>{
    String name;
    long size;

    public FileInfo(String name, long size){
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Filnamn: %s Storlek:%s bytes", name, size);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) size;
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
		FileInfo other = (FileInfo) obj;
		if (size != other.size)
			return false;
		return true;
	}

    @Override
    public int compareTo(FileInfo other) {
        if (this == other)
			return 0;
		if (other == null)
            throw new NullPointerException("Cannot use compareTo on null instances");
		if (size > other.size)
            return 1;
        if (size < other.size)
		    return -1;
        else
		    return 0;
    }
    
}
