package rnd;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ArrayOperation {
    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\Users\\partha.das\\OneDrive - Asset Vantage Systems Pvt Ltd\\Pictures\\myPic.PNG");
        BufferedImage bi=ImageIO.read(f1);
        int imageHeight=bi.getHeight();
        int imageWidth=bi.getWidth();

        for(int i=0;i<imageHeight;i++){
            for(int j=0;j<imageWidth;j++){
                System.out.println(bi.getRGB(i, j));
            }
        }
    }
}

class Container {

}