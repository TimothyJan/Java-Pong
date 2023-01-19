# Java-Pong
Java Pong Game

1-Creating the Window
<ul>
    <li>Create Window using JFrame methods in <code>Window.java</code>.</li>
    <li>Create <code>Constants.java</code> to hold constant values.</li>
    <li>Create thread to run window.</li>
</ul>

2-The Game Loop
<ul>
    <li>In <code>Window.java</code>, we want to call <code>update</code> method every frame of our game and we want to pass in how long it took to do the last frame.</li>
    <li>Create <code>Time.java</code> to call Java's system get nano time to get the best time measurement on the OS we are running on.</li>
    <li>Added code to <code>run</code> and <code>update</code> methods to check the frames per second(fps).</li>
    <li>Import <code>Graphics2D</code> to create Graphics <code>g2</code> in <code>Window</code> method and update g2 in <code>update</code> method.</li>
</ul>

3-Handling User Input
<ul>
    <li>Create new class <code>KL</code> to implement KeyListener. Create methods <code>keyPressed</code>, <code>keyReleased</code> and <code>isKeyPressed</code>.</li>
    <li>Create new KL <code>keyListener</code> in Window class and use using <code>this.addKeyListener(keyListener)</code> in <code>public Window</code>.</li>
    <li>Add <code>keyListener</code> to listen for <code>KeyEvents</code> in <code>update</code> method.</li>
</ul>

4-Drawing the Player
<ul>
    <li></li>
    <li></li>
    <li></li>
</ul>