public class Ball {
    public Rect rect;
    public Rect leftPaddle, rightPaddle;
    public Text leftScoreText, rightScoreText;

    /*Velocity in x and y direction*/
    private double vy = 20.0;
    private double vx = -150.0;

    public Ball(Rect rect, Rect leftPaddle, Rect rightPaddle, Text leftScoreText, Text rightScoreText) {
        this.rect = rect;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
        this.leftScoreText = leftScoreText;
        this.rightScoreText = rightScoreText;
    }

    public void update(double dt) {
        if (vx < 0.0) { /* Going left to Player*/
            if (this.rect.x <= this.leftPaddle.x + this.leftPaddle.width &&
                    this.rect.x + this.rect.width >= this.leftPaddle.x &&
                    this.rect.y >= this.leftPaddle.y &&
                    this.rect.y <= this.leftPaddle.y + this.leftPaddle.height) {
                this.vx *= -1.2;
                this.vy *= 1.2;
            }
        }
        else if (vx > 0.0) { /* Going right to AI*/
            if (this.rect.x + this.rect.width >= this.rightPaddle.x &&
                    this.rect.x <= this.rightPaddle.x + this.rightPaddle.width &&
                    this.rect.y >= this.rightPaddle.y &&
                    this.rect.y <= this.rightPaddle.y + this.rightPaddle.height) {
                this.vx *= -1.2;
                this.vy *= 1.2;
            }
        }

        /* Collision with top and bottom borders*/
        if (vy > 0.0) {
            if (this.rect.y + this.rect.height > Constants.SCREEN_HEIGHT) {
                this.vy *= -1.0;
            }
        } else if (vy < 0.0) {
            if (this.rect.y < Constants.TOOLBAR_HEIGHT) {
                this.vy *= -1.0;
            }
        }


        // position = position + velocity
        // velocity = velocity + acceleration
        this.rect.x += vx * dt;
        this.rect.y += vy * dt;

        if (this.rect.x + this.rect.width < leftPaddle.x) { /* AI scored */
            int rightScore = Integer.parseInt(rightScoreText.text);
            rightScore++;
            rightScoreText.text = "" + rightScore;
            // Reset Ball
            this.rect.x = Constants.SCREEN_WIDTH / 2.0;
            this.rect.y = Constants.SCREEN_HEIGHT / 2.0;
            this.vx = -150.0;
            this.vy = 10.0;
            if(rightScore >= Constants.WIN_SCORE) {
                System.out.println("AI wins!");
            }
        } else if (this.rect.x > rightPaddle.x + rightPaddle.width) { /* User scored */
            int leftScore = Integer.parseInt(leftScoreText.text);
            leftScore++;
            leftScoreText.text = "" + leftScore;
            // Reset Ball
            this.rect.x = Constants.SCREEN_WIDTH / 2.0;
            this.rect.y = Constants.SCREEN_HEIGHT / 2.0;
            this.vx = 150.0;
            this.vy = 10.0;
            if(leftScore >= Constants.WIN_SCORE) {
                System.out.println("Player wins!");
            }
        }
    }
}