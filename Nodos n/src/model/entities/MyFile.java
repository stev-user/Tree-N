package model.entities;

public class MyFile {
	
	private String name;
	private String extension;
	
	public MyFile(String name, String extension) {
		this.name = name;
		this.extension = extension;
	}

	public String getName() {
		return name;
	}

	public String getExtension() {
		return extension;
	}
	
	public Object[] toVector(){
		return new Object[]{name, extension};
	}

	@Override
	public String toString() {
		return "MyFile [name=" + name + ", extension=" + extension + "]";
	}
}