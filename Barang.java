
public class Barang {
  private int w;
  private int v;
  double d;

  public Barang(int w , int v){
    this.w = w;
    this.v = v;
    if(w==0 && v==0)
      d=0;
    else
      d = (double)v/ (double) w;
  }

  public void setW(int w){
    this.w = w;
    if(w==0 && v==0)
      d=0;
    else
      d = (double)v/ (double) w;
  }

  public int getW(){
    return w;
  }

  public void setV(int v){
    this.v = v;
    if(w==0 && v==0)
      d=0;
    else
      d = (double)v/ (double) w;
  }

  public int getV(){
    return v;
  }


}
