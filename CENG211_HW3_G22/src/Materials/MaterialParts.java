package Materials;

public class MaterialParts {
    String materialCode;
    int materialCount;

    public MaterialParts(){
        materialCode=null;
        materialCount=0;
    }

    public MaterialParts(String materialCode, int materialCount){
        this.materialCode=materialCode;
        this.materialCount=materialCount;
    }

}
