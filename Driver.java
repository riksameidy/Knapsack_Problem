import java.util.Scanner;

public class Driver {
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    Tubes knapsack = new Tubes(0);

    boolean menu = true;
    while(menu){
      System.out.println("Kasus 0/1 Knapsack");
      System.out.println("1. Edit List Barang");
      System.out.println("2. Lihat List Barang");
      System.out.println("3. Solve dengan Brute Force");
      System.out.println("4. Solve dengan Backtrack");
      System.out.println("5. Solve dengan Branch And Bound");
      System.out.println("6.Exit");
      int pil = s.nextInt();
      switch (pil) {
        default:
          break;
        case 1:
          System.out.println("Masukan Kapasitas Knapsack");
          int k = s.nextInt();
          if(k<4 || k>20){
            System.out.println("Input Harus Minimal 4 dan Maksimal 20");
            break;
          }
          knapsack = new Tubes(k);
          System.out.println("Masukan Jumlah Barang");
          int jum = s.nextInt();
          for (int i=0; i<jum;i++ ) {
            System.out.println("=========== Barang " + (i+1) + "============");
            System.out.print("Masukkan Weight: ");
            int w = s.nextInt();
            System.out.print("Masukan Value: ");
            int v = s.nextInt();
            knapsack.addBarang(w,v);
            System.out.println("=============================================");
          }
          break;
        case 2:
          System.out.println("============ List Barang =====================");
          if(knapsack==null || knapsack.getBarang()==null|| knapsack.getBarang().isEmpty()){
            System.out.println("Barang Belum Ada");
            break;
          }
          int i = 1;
          for(Barang b: knapsack.getBarang()){
            System.out.println("idBarang: " + i);
            System.out.println("Value: " + b.getV());
            System.out.println("Weight: " + b.getW());
            System.out.println("===========================================");
            i++;
          }
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          menu = false;
          break;
      }

    }

  }
}
