package jvtest;

public class Solutions {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        try {
            if (flowerbed.length == 0) {
                throw new IllegalArgumentException("Flowerbed array cannot be empty");
            }
            for (int value : flowerbed) {
                if (value != 0 && value != 1) {
                    throw new IllegalArgumentException("Flowerbed array can only contain 0 or 1");
                }
            }
            int count = 0;
            int length = flowerbed.length;

            for (int i = 0; i < length; i++){
                if (flowerbed[i]==0) {
                    //check left and right sides
                    boolean leftEmpty = (i==0 || flowerbed[i-1]==0);
                    boolean rightEmpty = (i==length-1 || flowerbed[i+1]==0);
                    if (leftEmpty && rightEmpty) {
                        flowerbed[i] = 1; //plant flower
                        count++;

                        if (count >= n){
                            return true;
                        }
                    }
                }
            }

            return count >= n;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
