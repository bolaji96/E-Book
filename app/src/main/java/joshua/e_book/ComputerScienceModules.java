package joshua.e_book;

/**
 * Created by OLUWASONA on 30/12/2016.
 */
public class ComputerScienceModules {

    private String moduleName;
    private int moduleImage;

    public ComputerScienceModules() {
    }

    public ComputerScienceModules(String moduleName, int moduleImage) {
        this.moduleName = moduleName;
        this.moduleImage = moduleImage;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getModuleImage() {
        return moduleImage;
    }

    public void setModuleImage(int moduleImage) {
        this.moduleImage = moduleImage;
    }
}
