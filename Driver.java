import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
    Tubes tubes = new Tubes();
    Scanner s = new Scanner();

    boolean menu = true;
    while(menu){
      System.out.println("Kasus 0/1 Knapsack");
      System.out.println("1. Solve dengan Brute Force");
      System.out.println("2. Solve dengan Backtrack");
      System.out.println("3. Solve dengan Branch And Bound");
      int pil = s.nextInt();
      switch (pil) {
        default:
          break;
        case 1:
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          menu = false;
          break;
      }

    }

  }
}
