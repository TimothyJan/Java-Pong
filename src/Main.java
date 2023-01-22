public class Main {
    public static int state = 0;
    public static Thread mainThread;
    public static MainMenu menu;
    public static Window gameWindow;
    public static void main(String[] args) {
        menu = new MainMenu();

        mainThread = new Thread(menu);
        mainThread.start();
    }

    public static void changeState(int newState) {
        /* Change state between GameWindow and MainMenu */
        if (newState == 1 && state == 0){
            menu.stop();
            gameWindow = new Window();
            mainThread = new Thread(gameWindow);
            mainThread.start();
        } else if (newState == 0 && state == 1) {
            gameWindow.stop();
            menu = new MainMenu();
            mainThread = new Thread(menu);
            mainThread.start();
        } else if (newState == 2){
            /* Kill all threads */
            if (gameWindow != null)
                gameWindow.stop();
            if (menu != null)
                menu.stop();
        }
        state = newState;
    }
}