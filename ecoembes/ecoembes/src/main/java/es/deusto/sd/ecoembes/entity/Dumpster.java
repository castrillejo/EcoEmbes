package es.deusto.sd.ecoembes.entity;

public class Dumpster {
    private String id;
    private String location;
    private int containerCount;
    private FillLevelStatus fillLevel;

    public Dumpster(String id, String location, int containerCount, FillLevelStatus fillLevel) {
        this.id = id;
        this.location = location;
        this.containerCount = containerCount;
        this.fillLevel = fillLevel;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getContainerCount() {
		return containerCount;
	}

	public void setContainerCount(int containerCount) {
		this.containerCount = containerCount;
	}

	public FillLevelStatus getFillLevel() {
		return fillLevel;
	}

	public void setFillLevel(FillLevelStatus fillLevel) {
		this.fillLevel = fillLevel;
	}

}
