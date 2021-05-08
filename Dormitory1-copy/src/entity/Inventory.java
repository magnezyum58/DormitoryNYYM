
package entity;

public class Inventory {
    private String id,name,piece;
    
    public Inventory(String id,String name,String piece){
        this.id=id;
        this.name=name;
        this.piece=piece;
    }
    
    public Inventory(String name,String piece){
        this.name=name;
        this.piece=piece;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }


    
}
