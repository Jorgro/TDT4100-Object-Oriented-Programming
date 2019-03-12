package App;

public interface FileManager {
    public void writeToFile(String text) throws Exception;
    public String readFromFile() throws Exception;

}