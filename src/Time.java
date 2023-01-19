public class Time {
    public static double timeStarted = System.nanoTime();
    public static double getTime() {
        /*System.nanoTime() return in int value, convert timeStarted to nanoseconds*/
        return (System.nanoTime() - timeStarted) * 1E-9;
    }
}
