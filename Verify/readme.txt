应用名称：验证码生成系统
验证码生成核心类：src--com.px.util--VaildateCodeUtil.java

VaildateCodeUtil.java

public static BufferedImage getVaildateCode(String content)
功能：生成验证码图片
输入：String content 验证码的内容
输出：BufferedImage buf  验证码图片

public static Color getRandColor(int from,int to)
功能：生成随机色
输入：int from,int to  随机色取色范围
输出：Color new Color(r, g, b)  Color对象

WebRoot--
 index.jsp ------------主页，提交验证码
 valiCode.jsp----------生成验证码，提交给index.jsp
 val.jsp---------------提交验证后，验证是否输入正确
