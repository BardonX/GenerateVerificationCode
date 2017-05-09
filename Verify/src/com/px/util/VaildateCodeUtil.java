package com.px.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 
 * @ClassName: VaildateCodeUtil
 * @Description: 验证码生成核心类
 * @author: Bardon
 * @date: 2017年5月2日 下午4:04:48
 * @version1.0
 */
public class VaildateCodeUtil {

	/**
	 * 验证码生成核心方法
	 * @Title: getVaildateCode
	 * @Author: Bardon
	 * @Time: 2017年5月2日 下午4:06:30
	 * @params: content
	 * @return: BufferedImage
	 * @throws
	 */
	public static BufferedImage getVaildateCode(String content){
		int width=120;
		int height=48;
		//画板
		BufferedImage buf=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics2D gs=buf.createGraphics();
		//绘制一个矩形
		gs.setColor(getRandColor(50, 200));
		gs.fillRect(0, 0, width, height);
		
		Random random=new Random();
		//干扰线
		for(int i=0;i<100;i++){
			gs.setColor(getRandColor(50, 200));
			//参照画板宽高
			//两个点
			int x1=random.nextInt(120);
			int y1=random.nextInt(40);
			//不重叠
			int x2=x1+random.nextInt(50);
			int y2=y1+random.nextInt(20);
			gs.drawLine(x1, y1, x2, y2);
		}
		
		//字体 Font.BOLD字体加粗   斜体下划线   25 字号
		Font font=new Font("楷体",Font.BOLD,25);
		gs.setFont(font);
		gs.setColor(getRandColor(20, 130));
		//坐标
		gs.drawString(content, 10, 33);
		return buf;
	}
	
	/**
	 * 随机色生成
	 * @Title: getRandColor
	 * @Author: Bardon
	 * @Time: 2017年5月2日 下午4:23:23
	 * @params: @return
	 * @return: Color
	 * @throws
	 */
	public static Color getRandColor(int from,int to){
		//随机对象
		Random random=new Random();
		int r=from+random.nextInt(to-from);
		int g=from+random.nextInt(to-from);
		int b=from+random.nextInt(to-from);
		return new Color(r, g, b);
	}
	//测试
	public static void main(String[] args) {
		BufferedImage buf=getVaildateCode("豪情万丈");
		try {
			ImageIO.write(buf, "png", new File("D:\\验证码\\豪情万丈.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
