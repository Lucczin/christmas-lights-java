import java.awt.*;

public class LightCircle {

    private Color color;
    private int size;
    private int intensity;

    public LightCircle(Color color, int size, int intensity){
        this.color = color;
        this.size = size;
        this.intensity = intensity;
    }

    public Color getColor() {
        return color;
    }

   public void setColor(Color color){
        this.color = color;
   }

   public int getSize(){
        return size;
   }

   public void setSize(int size){
        this.size = size;
   }

   public int getIntensity(){
        return intensity;
   }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

}