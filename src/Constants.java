import java.awt.Color;

public class Constants {
    /* Screen Specifications */
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final String SCREEN_TITLE = "Pong";

    /* Paddle/Ball specifications */
    public static final double PADDLE_WIDTH = 15;
    public static final double PADDLE_HEIGHT = 100;
    public static final Color PADDLE_COLOR = Color.WHITE;
    public static final double BALL_WIDTH = 10;
    public static final Color BALL_COLOR = Color.WHITE;

    /* Paddle Locations */
    public static final double HZ_PADDING = 40;
    public static double TOOLBAR_HEIGHT;
    public static double INSETS_BOTTOM;

    /* Speeds */
    public static final double PADDLE_SPEED = 250;
    public static final double BALL_SPEED = 100;

    /* Scores */
    public static final int TEXT_Y_POSITION = 70;
    public static final int TEXT_X_POSITION = 10;
    public static final int TEXT_SIZE = 40;
    public static final int WIN_SCORE = 11;
}
