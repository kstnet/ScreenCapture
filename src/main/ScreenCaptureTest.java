package main;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class ScreenCaptureTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new CaptureTask(), 1000, 43200000);
		System.out.println("timer start");
	}
}

class CaptureTask extends TimerTask {
	final static String FILENAME = "ScreenCapture";
	static short CAPNUM = 0;

	public void run(){
		BufferedImage image;

		CAPNUM++;
//		System.out.println("画面キャプチャ実行");

		try {
			System.out.println("画面キャプチャ実行");
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
