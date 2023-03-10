import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;

public class Window extends JFrame implements Runnable {

    public Graphics2D g2;
    public KL keyListener = new KL();
    public Rect playerOne, ai, ballRect;
    public PlayerController playerController;
    public AIController aiController;
    public Ball ball;
    public Text leftScoreText, rightScoreText;
    public boolean isRunning = true;


    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);

        Constants.TOOLBAR_HEIGHT = this.getInsets().top;
        Constants.INSETS_BOTTOM = this.getInsets().bottom;

        leftScoreText = new Text(0, new Font("Times New Roman", Font.PLAIN,Constants.TEXT_SIZE), Constants.TEXT_X_POSITION,Constants.TEXT_Y_POSITION);
        rightScoreText = new Text(0, new Font("Times New Roman", Font.PLAIN,Constants.TEXT_SIZE), Constants.SCREEN_WIDTH-Constants.TEXT_X_POSITION-16,Constants.TEXT_Y_POSITION);

        g2 = (Graphics2D)this.getGraphics();

        playerOne = new Rect(Constants.HZ_PADDING,40,Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT,Constants.PADDLE_COLOR);
        playerController = new PlayerController(playerOne, keyListener);

        ai = new Rect(Constants.SCREEN_WIDTH-Constants.PADDLE_WIDTH-Constants.HZ_PADDING,40,Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT,Constants.PADDLE_COLOR);

        ballRect = new Rect(Constants.SCREEN_WIDTH/2,Constants.SCREEN_HEIGHT/2,Constants.BALL_WIDTH,Constants.BALL_WIDTH,Constants.BALL_COLOR);
        ball = new Ball(ballRect, playerOne, ai, leftScoreText, rightScoreText);

        aiController = new AIController(new PlayerController(ai), ballRect);
    }

    public void update(double dt) {
        /*Draw to double buffer graphics, not displayed to user*/
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        /*Swap buffers and draw image displayed to user */
        this.draw(dbg);
        g2.drawImage(dbImage, 0, 0,this);

        playerController.update(dt);
        aiController.update(dt);
        ball.update(dt);

        /*Check fps*/
//        System.out.println(dt + "seconds passed since the last frame");
//        System.out.println(1/dt + " fps");
    }

    public void draw(Graphics g) {
        /*Draws graphics to screen displayed to user*/
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        Font font = new Font("Times New Roman", Font.PLAIN, 14);

        leftScoreText.draw(g2);
        rightScoreText.draw(g2);
        playerOne.draw(g2);
        ai.draw(g2);
        ballRect.draw(g2);
    }

    public void stop() {
        isRunning = false;
    }

    public void run() {
        double lastFrameTime = 0.0;
        while (isRunning) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;
            update(deltaTime);
            /*Check fps*/
//                try{
//                    Thread.sleep(30);
//                } catch(Exception e) {}
        }
        this.dispose();
        return;
    }
}
