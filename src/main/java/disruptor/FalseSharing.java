package disruptor;

public class FalseSharing {
    public volatile long value = 0L;
    public long p1, p2, p3, p4, p5, p6; // comment out
}
