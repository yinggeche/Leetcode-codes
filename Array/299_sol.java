class Solution {
    public String getHint(String secret, String guess) {
        int A = 0, B = 0;
        int lens = secret.length();
        // 用来计数
        int[] count_A = new int[10];
        int[] count_B = new int[10];
        // 计数A
        for (int i = 0; i < lens; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                A++;
            }
            else{
                System.out.print(secret.charAt(i)-48);//减去ASCII的‘0’
                System.out.println(guess.charAt(i)-'0');
                count_A[secret.charAt(i) - 48]++; //这里用的ASCII码
                count_B[guess.charAt(i) - 48]++;
            }
        }
        for (int i =0; i < 10; i++){
            B += Math.min(count_A[i], count_B[i]);
            // B = B + Math.min(c_a[i],c_b[i]); 一样的
            // 如果一个数secret有,guess没有，就取最小的
            // 如果一个数guess有，secret没有，取最小的
            // 如果两个都有，取min
        }
        return A + "A" + B + "B";
    }
}
