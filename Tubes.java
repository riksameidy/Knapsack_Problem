import java.util.ArrayList;


public class Tubes {

      private ArrayList<Barang> barang;
      private int kapasitas;

      public int pangkatDua(int n){
        int jum = 1;
        for(int i=1; i<=n;i++){
          jum = jum * 2;
        }
        return jum;
      }


      public int hitungSolusi(int[] solusi){
        int hasil = 0;
        int weight = 0;
        for(int i = 0;i<solusi.length;i++){
          hasil = hasil + (solusi[i] * barang.get(i).getV());
          weight = weight + (solusi[i] * barang.get(i).getW());
        }
        if(weight>kapasitas){
          hasil = 0;
        }
        return hasil;
      }


      public int[] generateSolusi(int bil , int n){
        int binary[] = new int[n];
        int idx = n-1;
        while(bil>0){
          binary[idx] = bil % 2;
          idx--;
          bil/=2;
        }

        for(int i = idx; i>=0;i--){
          binary[i] = 0;
        }
        return binary;

      }


      public Tubes(int kapasitas){
        barang = new ArrayList<>();
        this.kapasitas = kapasitas;
      }

      public void addBarang(int w , int v){
        barang.add(new Barang(w,v));
      }

      public int getKapasitas(){
        return kapasitas;
      }

      public ArrayList<Barang> getBarang(){
        return barang;
      }

      public void bruteForce(){
        int j = barang.size();
        int i = pangkatDua(j);
        int[][] solusi = new int[i][j];
        int solusiTerbaik = -1;
        int rowterbaik = 0;
        for(int k = 0;k<i;k++){
          solusi[k] = generateSolusi(k,j);
          for(int m=0;m<j;m++){
            System.out.print("" + solusi[k][m]);
            }
          int current = hitungSolusi(solusi[k]);
          System.out.print(" -> " + current);
          if(current>solusiTerbaik){
            solusiTerbaik = current;
            rowterbaik = k;
          }
          System.out.println("");
        }
        System.out.println("profit terbesar adalah " + solusiTerbaik);
        System.out.println("dengan solusi Terbaik adalah ");
        for (int p=0;p<j ;p++ ) {
          System.out.print(solusi[rowterbaik][p]);
        }
        System.out.println("");

      }

      public void backtrack(){


      }

      public void branchAndBound(){


      }
}
