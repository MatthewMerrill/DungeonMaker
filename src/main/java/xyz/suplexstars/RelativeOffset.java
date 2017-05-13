package xyz.suplexstars;

/**
 * Created by merrillm on 5/12/17.
 */
public class RelativeOffset {
    
    public final int dr;
    public final int dc;
    
    public RelativeOffset(int dr, int dc) {
        this.dr = dr;
        this.dc = dc;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RelativeOffset))
            return false;
        
        RelativeOffset other = (RelativeOffset) obj;
        return other.dr == this.dr && other.dc == this.dc;
    }
    
    @Override
    public int hashCode() {
        return (dr<<16) ^ dc;
    }
}
