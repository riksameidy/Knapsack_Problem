public class Tubes {

      private ArrayList<Barang> barang;
      private int kapasitas;

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
        
      }

      public void backtrack(){


      }

      public void branchAndBound(){


      }
}
