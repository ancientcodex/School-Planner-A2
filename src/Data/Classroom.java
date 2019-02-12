package Data;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.Serializable;
import java.util.ArrayList;

public class Classroom extends Room implements Serializable, Available {
    private boolean smartBoard;
    private boolean whiteBoard;
    private ArrayList<Interval> unavailable;

    public Classroom (int number, int amountOfSeats, String location, boolean smartBoard, boolean whiteBoard) {
        super(number, amountOfSeats, location);
        this.smartBoard = smartBoard;
        this.whiteBoard = whiteBoard;
        this.unavailable = new ArrayList<>();
    }

    public boolean hasSmartBoard() {
        return smartBoard;
    }

    public boolean hasWhiteBoard() {
        return whiteBoard;
    }


    @Override
    public boolean isAvailable(DateTime at) {
        for(Interval interval: unavailable) {
            if (interval.contains(at)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void makeUnavailable(DateTime from, DateTime at) {
        this.unavailable.add(new Interval(from,at));
    }
}