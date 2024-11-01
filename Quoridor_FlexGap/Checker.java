/**
 * Checker.java
 *
 * this class is piece for cell with  3 types.
 */
public class Checker {
    private CellGroup.MarkType marker;
    private String markerString;
    private int positionLength;

  // piece with index number
    public Checker(int index, int length) {
    marker = CellGroup.MarkType.ZERO;
    positionLength = length;
    String prompt = "%" + positionLength + "d";
    markerString = String.format(prompt, index);
  }
    // default piece with no marker
    public Checker(){
        this.marker = CellGroup.MarkType.ZERO;
        markerString = "  ";
    }
    // piece with index number
    public Checker(int index){
        marker = CellGroup.MarkType.ZERO;
        markerString = String.format("%2d",index);
    }

    // get piece's type
    public CellGroup.MarkType getMarker() {
        return marker;
    }

    // set piece's type
    public void setMarker(int index, CellGroup.MarkType marker) {
        this.marker = marker;
        String prompt;
        switch (marker){
            case ONE:
                prompt = "%" + positionLength + "s";
                markerString = String.format(prompt, "O");
                break;
            case TWO:
                prompt = "%" + positionLength + "s";
                markerString = String.format(prompt, "X");
                break;
            case ZERO:
                prompt = "%" + positionLength + "d";
                 markerString = String.format(prompt, index);
                break;
        }
    }

    // get piece's string
    public String getMarkerString() {
        return markerString;
    }

}
