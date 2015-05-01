package main;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class ScreenCaptureTest implements ActionListener {
	final static String FILENAME = "ScreenCapture";
	static short CAPNUM = 0;
	public static void main(String[] args) {
		new ScreenCaptureTest();

		while(true){

		}
	}

	ScreenCaptureTest(){
		Timer timer;
		timer = new Timer(43200, this);

		System.out.println("timer start");
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		CAPNUM++;

		System.out.println("doCaptureメソッド呼び出し");
		doCapture();
	}

	private static void doCapture(){
		BufferedImage image;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(FILENAME + CAPNUM + ".png"));
		} catch (HeadlessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
