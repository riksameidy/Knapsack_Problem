import java.util.ArrayList;


public class Tubes {

      private ArrayList<Barang> barang;
      private TreeBarang treeBarang;
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

      public boolean isLayak(int hasil){
        return hasil!=0;
      }

      public boolean isLayak(Barang b){
        return b.getW() <= kapasitas;
      }

      public boolean isDone(String s){
        return s.length() == barang.size();
      }


      public Tubes(int kapasitas){
        barang = new ArrayList<>();
        this.kapasitas = kapasitas;
        treeBarang = new TreeBarang();
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

      public void backtrack(Barang knapsack , TreeBarang root, int i){

        Barang test = new Barang(0,0);

        if(i<barang.size()){

          test.setV(knapsack.getV() + barang.get(i).getV());
          test.setW(knapsack.getW() + barang.get(i).getW());
          if(isLayak(test)){
            root.left = new TreeBarang();
            root.left.solusi = root.solusi + "1";
            knapsack.setV(test.getV());
            knapsack.setW(test.getW());
            i++;
            System.out.println("Call left Child");
            backtrack(knapsack,root.left,i);
          }
          else{
            root.right = new TreeBarang();
            root.right.solusi = root.solusi + "0";
            i++;
            System.out.println("Call right Child");
            backtrack(knapsack,root.right,i);
          }

        }
        else if(i==barang.size()){
          System.out.println(root.solusi);
        }


      }

      public double rumusUpperBound(Barang b, Barang bNext){
          return ( b.getV() + ( (kapasitas - b.getW() )  *  bNext.d ) );
      }

      public void branchAndBound(TreeBarang root, int i, Barang knapsack ){
          if(i<(barang.size() - 1) ){
            double ubkiri, ubkanan;

            Barang bNext = new Barang(0,0);

            bNext.setV(knapsack.getV() + barang.get(i+1).getV());
            bNext.setW(knapsack.getW() + barang.get(i+1).getW());
            System.out.println("val: " + knapsack.getV() + "weight:" + knapsack.getW());

            if(isLayak(bNext)){

              if(i==barang.size()-2){
                ubkiri = 0;
                ubkanan = 0;
              }
              else{

                ubkiri = rumusUpperBound(bNext,barang.get(i+2));
                ubkanan = rumusUpperBound(knapsack,barang.get(i+2));
                System.out.println("ubKiri : " + ubkiri + " === ubKanan : " + ubkanan);
              }

              if(ubkiri >= ubkanan){
                root.left = new TreeBarang();
                root.left.solusi = root.solusi + "1";
                branchAndBound(root.left, i+1,bNext);
              }
              else{
                root.right = new TreeBarang();
                root.right.solusi = root.solusi + "0";
                branchAndBound(root.right, i+1 , knapsack);
              }

            }
            else{
              root.right = new TreeBarang();
              root.right.solusi = root.solusi + "0";
              System.out.println("OverWeight");

              branchAndBound(root.right, i+1, knapsack);
            }

          }
          else if(i==barang.size()-1){
            System.out.println(root.solusi);
          }


      }
}
