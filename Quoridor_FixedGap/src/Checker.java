/**
 * Checker.java
 *
 * this class is piece for cell with  3 types.
 */
public class Checker {
    private CellGroup.MarkType marker;
    private String markerString;

    // default piece with no marker
    public Checker(){
        this.marker = CellGroup.MarkType.ZERO;
        markerString = "   ";
    }
    // piece with index number
    public Checker(int index){
        marker = CellGroup.MarkType.ZERO;
        markerString = String.format("%3d",index);
    }

    // get piece's type
    public CellGroup.MarkType getMarker() {
        return marker;
    }

    // set piece's type
    public void setMarker(int index, CellGroup.MarkType marker) {
        this.marker = marker;
        switch (marker){
            case ONE:
                markerString = " O ";
                break;
            case TWO:
                markerString = " X ";
                break;
            case ZERO:
                 markerString = String.format("%3d",index);
                break;
        }
    }

    // get piece's string
    public String getMarkerString() {
        return markerString;
    }

}
