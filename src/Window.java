import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Runnable {

    Graphics2D g2;
    KL keyListener = new KL();
    Rect playerOne, ai, ball;

    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        g2 = (Graphics2D)this.getGraphics();

        playerOne = new Rect(Constants.HZ_PADDING,40,Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT,Constants.PADDLE_COLOR);
        ai = new Rect(Constants.SCREEN_WIDTH-Constants.PADDLE_WIDTH-Constants.HZ_PADDING,40,Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT,Constants.PADDLE_COLOR);
        ball = new Rect(Constants.SCREEN_WIDTH/2,Constants.SCREEN_HEIGHT/2,Constants.BALL_WIDTH,Constants.BALL_WIDTH,Constants.BALL_COLOR);
    }

    public void update(double dt) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        playerOne.draw(g2);
        ai.draw(g2);
        ball.draw(g2);

//        if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
//            System.out.println("The user is pressing the UP arrow");
//        } else if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
//            System.out.println("The user is pressing the DOWN arrow");
//        }

        /*Check fps*/
//        System.out.println(dt + "seconds passed since the last frame");
//        System.out.println(1/dt + " fps");
    }

    public void run() {
        while (true) {
            double lastFrameTime = 0.0;
            while (true) {
                double time = Time.getTime();
                double deltaTime = time - lastFrameTime;
                lastFrameTime = time;
                update(deltaTime);

                /*Check fps*/
                try{
                    Thread.sleep(30);
                } catch(Exception e) {}

            }
        }
    }
}
