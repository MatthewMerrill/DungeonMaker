package xyz.suplexstars.dungeonmaker.util;

public class Location {
    
    public final double row;
    public final double column;
    
    public Location(double row, double column) {
        this.row = row;
        this.column = column;
    }
    
    public Location add(Vector displacement) {
        return new Location(
                row + displacement.getRowComponent(),
                column +displacement.getColComponent());
    }
    
    public Vector displacement(Location to) {
        return Vector.fromRowCol(to.row - row, to.column - column);
    }
    
}
