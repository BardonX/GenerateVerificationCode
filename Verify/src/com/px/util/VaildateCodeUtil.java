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
 * @Description: ��֤�����ɺ�����
 * @author: Bardon
 * @date: 2017��5��2�� ����4:04:48
 * @version1.0
 */
public class VaildateCodeUtil {

	/**
	 * ��֤�����ɺ��ķ���
	 * @Title: getVaildateCode
	 * @Author: Bardon
	 * @Time: 2017��5��2�� ����4:06:30
	 * @params: content
	 * @return: BufferedImage
	 * @throws
	 */
	public static BufferedImage getVaildateCode(String content){
		int width=120;
		int height=48;
		//����
		BufferedImage buf=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics2D gs=buf.createGraphics();
		//����һ������
		gs.setColor(getRandColor(50, 200));
		gs.fillRect(0, 0, width, height);
		
		Random random=new Random();
		//������
		for(int i=0;i<100;i++){
			gs.setColor(getRandColor(50, 200));
			//���ջ�����
			//������
			int x1=random.nextInt(120);
			int y1=random.nextInt(40);
			//���ص�
			int x2=x1+random.nextInt(50);
			int y2=y1+random.nextInt(20);
			gs.drawLine(x1, y1, x2, y2);
		}
		
		//���� Font.BOLD����Ӵ�   б���»���   25 �ֺ�
		Font font=new Font("����",Font.BOLD,25);
		gs.setFont(font);
		gs.setColor(getRandColor(20, 130));
		//����
		gs.drawString(content, 10, 33);
		return buf;
	}
	
	/**
	 * ���ɫ����
	 * @Title: getRandColor
	 * @Author: Bardon
	 * @Time: 2017��5��2�� ����4:23:23
	 * @params: @return
	 * @return: Color
	 * @throws
	 */
	public static Color getRandColor(int from,int to){
		//�������
		Random random=new Random();
		int r=from+random.nextInt(to-from);
		int g=from+random.nextInt(to-from);
		int b=from+random.nextInt(to-from);
		return new Color(r, g, b);
	}
	//����
	public static void main(String[] args) {
		BufferedImage buf=getVaildateCode("��������");
		try {
			ImageIO.write(buf, "png", new File("D:\\��֤��\\��������.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
