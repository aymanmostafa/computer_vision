package learn1;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class main extends JFrame {

	JButton button,idn,neg,pow,root,log,str;
	JLabel label,label2,text,c1text,g1text,c2text,g2text,c3text;
	String path=null;
	JTextField c1,g1,c2,g2,c3;
	String c1val,c2val,c3val,g1val,g2val;

	public main() {
		super("Computer Vision project by Ayman Mostafa & Ahmed Torkey");
		button = new JButton("Browse");
		button.setBounds(480, 440, 200, 40);
		idn = new JButton("Identity");
		idn.setBounds(10, 500, 100, 40);
		neg = new JButton("Negative");
		neg.setBounds(210, 500, 100, 40);
		pow = new JButton("Power low");
		pow.setBounds(410, 500, 100, 40);
		root = new JButton("Root low");
		root.setBounds(610, 500, 100, 40);
		log = new JButton("Logarithmic");
		log.setBounds(810, 500, 120, 40);
		str = new JButton("Contrast stretching");
		str.setBounds(1010, 500, 145, 40);
		label = new JLabel();
		label2 = new JLabel();
		text=new JLabel();
		c1text=new JLabel();
		g1text=new JLabel();
		c2text=new JLabel();
		g2text=new JLabel();
		c3text=new JLabel();
		c1=new JTextField();
		c2=new JTextField();
		c3=new JTextField();
		g1=new JTextField();
		g2=new JTextField();
		label.setBounds(10, 10, 550, 400);
		label2.setBounds(600, 10, 550, 400);
		text.setBounds(700, 400, 100, 100);
		text.setText("*jpg,*png");
		c1text.setBounds(410, 510, 100, 100);
		c1text.setText("C=");
		c1.setBounds(430, 550, 50, 20);
		g1.setBounds(465, 570, 50, 20);
		c2.setBounds(630, 550, 50, 20);
		g2.setBounds(665, 570, 50, 20);
		c3.setBounds(830, 550, 50, 20);
		c1.setText("1");
		c2.setText("1");
		c3.setText("1");
		g1.setText("1");
		g2.setText("1");
		g1text.setBounds(410, 530, 100, 100);
		g1text.setText("gamma=");
		c2text.setBounds(610, 510, 100, 100);
		c2text.setText("C=");
		g2text.setBounds(610, 530, 100, 100);
		g2text.setText("gamma=");
		c3text.setBounds(810, 510, 100, 100);
		c3text.setText("C=");
		add(button);
		add(label);
		add(label2);
		add(text);
		add(c1text);
		add(g1text);
		add(c2text);
		add(g2text);
		add(c3text);
		add(idn);
		add(neg);
		add(pow);
		add(root);
		add(log);
		add(str);
		add(c1);
		add(c2);
		add(c3);
		add(g1);
		add(g2);

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System
						.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"*.Images", "jpg", "png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					path = selectedFile.getAbsolutePath();
					label.setIcon(ResizeImage(path,label,0));
					label2.setIcon(null);
				}
				else if (result == JFileChooser.CANCEL_OPTION) {
					label.setText("Invaild path...Browse an image (JPG,PNG)");
				}
			}
		});
		idn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(path==null) label.setText("Invaild path...Browse an image (JPG,PNG)");
				else	label2.setIcon(ResizeImage(path,label2,1));
			}
		});
		neg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(path==null) label.setText("Invaild path...Browse an image (JPG,PNG)");
				else	label2.setIcon(ResizeImage(path,label2,2));
			}
		});
		pow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1val=c1.getText();
				g1val=g1.getText();
				if(path==null) label.setText("Invaild path...Browse an image (JPG,PNG)");
				else	label2.setIcon(ResizeImage(path,label2,3));
			}
		});
		root.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c2val=c2.getText();
				g2val=g2.getText();
				if(path==null) label.setText("Invaild path...Browse an image (JPG,PNG)");
				else	label2.setIcon(ResizeImage(path,label2,4));
			}
		});
		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c3val=c3.getText();
				if(path==null) label.setText("Invaild path...Browse an image (JPG,PNG)");
				else	label2.setIcon(ResizeImage(path,label2,5));
			}
		});
		str.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(path==null) label.setText("Invaild path...Browse an image (JPG,PNG)");
				else	label2.setIcon(ResizeImage(path,label2,6));
			}
		});
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1180, 650);
		setVisible(true);
	}

	public ImageIcon ResizeImage(String ImagePath,JLabel label,int x) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		BufferedImage buf=null;
		if(x==0)  buf = toBufferedImage(img);
		else if(x==1)  buf = idn(toBufferedImage(img));
		else if(x==2)  buf = neg(toBufferedImage(img));
		else if(x==3)  buf = pow(toBufferedImage(img)); 
		else if(x==4) buf = root(toBufferedImage(img)); 
		else if(x==5) buf = log(toBufferedImage(img));
		else if(x==6) buf = str(toBufferedImage(img));
		Image newImg = buf.getScaledInstance(label.getWidth(),
				label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();
	    return bimage;
	}
	public BufferedImage idn(BufferedImage buf){
	    int[][] arr = new int [buf.getWidth()][buf.getHeight()];
		for(int i=0;i<buf.getWidth();i++)
            for(int j=0;j<buf.getHeight();j++)
                arr[i][j]=buf.getRGB(i, j);
		 BufferedImage buf2=new BufferedImage(buf.getWidth(), buf.getHeight(),BufferedImage.TYPE_INT_RGB);
	        for(int y=0;y<buf.getHeight();y++)
	            for(int x=0;x<buf.getWidth();x++)
	                buf2.setRGB(x, y, arr[x][y]);
		return buf2; 
	}
	public BufferedImage neg(BufferedImage buf){
	    int[][] arr = new int [buf.getWidth()][buf.getHeight()];
		for(int i=0;i<buf.getWidth();i++)
            for(int j=0;j<buf.getHeight();j++)
                arr[i][j]=buf.getRGB(i, j);
		 BufferedImage buf2=new BufferedImage(buf.getWidth(), buf.getHeight(),BufferedImage.TYPE_INT_RGB);
	        for(int y=0;y<buf.getHeight();y++)
	            for(int x=0;x<buf.getWidth();x++)
	                buf2.setRGB(x, y, 255-arr[x][y]);
		return buf2; 
	}
	public BufferedImage pow(BufferedImage buf){
	    int[][] arr = new int [buf.getWidth()][buf.getHeight()];
	    double constant=Double.valueOf(c1val),gamma=Double.valueOf(g1val);
		for(int i=0;i<buf.getWidth();i++)
            for(int j=0;j<buf.getHeight();j++)
                arr[i][j]=buf.getRGB(i, j);
		 BufferedImage buf2=new BufferedImage(buf.getWidth(), buf.getHeight(),BufferedImage.TYPE_INT_RGB);
	        for(int y=0;y<buf.getHeight();y++)
	            for(int x=0;x<buf.getWidth();x++)
	                buf2.setRGB(x, y, (int) (constant*Math.pow(arr[x][y], gamma)));
		return buf2; 
	}
	public BufferedImage root(BufferedImage buf){
	    int[][] arr = new int [buf.getWidth()][buf.getHeight()];
	    double constant=Double.valueOf(c2val),gamma=Double.valueOf(g2val);
		for(int i=0;i<buf.getWidth();i++)
            for(int j=0;j<buf.getHeight();j++)
                arr[i][j]=buf.getRGB(i, j);
		 BufferedImage buf2=new BufferedImage(buf.getWidth(), buf.getHeight(),BufferedImage.TYPE_INT_RGB);
	        for(int y=0;y<buf.getHeight();y++)
	            for(int x=0;x<buf.getWidth();x++)
	                buf2.setRGB(x, y, (int) (constant*Math.pow(arr[x][y], gamma)));
		return buf2; 
	}
	public BufferedImage log(BufferedImage buf){
	    int[][] arr = new int [buf.getWidth()][buf.getHeight()];
	    double constant=Double.valueOf(c3val);
		for(int i=0;i<buf.getWidth();i++)
            for(int j=0;j<buf.getHeight();j++)
                arr[i][j]=buf.getRGB(i, j);
		 BufferedImage buf2=new BufferedImage(buf.getWidth(), buf.getHeight(),BufferedImage.TYPE_INT_RGB);
	        for(int y=0;y<buf.getHeight();y++)
	            for(int x=0;x<buf.getWidth();x++)
	                buf2.setRGB(x, y, (int) (constant*Math.log10(arr[x][y]+1)));
		return buf2; 
	}
	public BufferedImage str(BufferedImage buf){
	    int[][] arr = new int [buf.getWidth()][buf.getHeight()];
	    int smin=0,smax=255,rmin=100000,rmax=-1;
		for(int i=0;i<buf.getWidth();i++)
            for(int j=0;j<buf.getHeight();j++)
            {
            	arr[i][j]=buf.getRGB(i, j);
            	if(arr[i][j]>rmax) rmax=arr[i][j];
            	if(arr[i][j]<rmin) rmin=arr[i][j];
            }
		 BufferedImage buf2=new BufferedImage(buf.getWidth(), buf.getHeight(),BufferedImage.TYPE_INT_RGB);
	        for(int y=0;y<buf.getHeight();y++)
	            for(int x=0;x<buf.getWidth();x++)
	                buf2.setRGB(x, y, (int) (((smax-smin)*(arr[x][y]-rmin)/(rmax-rmin))+smin));
		return buf2; 
	}
	
	public static void main(String[] args) {
		new main();
	}
}
