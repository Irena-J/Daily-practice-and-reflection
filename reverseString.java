方法一：
    public String reverseString(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] ch = s.toCharArray();
        while(i<j){
            swap(ch,i,j);
            i++;
            j--;
        }
        return new String(ch);
    }
    public void swap(char[] ch,int i,int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
方法二：借用异或运算
  public void reverseString(char[] s) {
        for(int i = 0;i < s.length/2;i++){
            int j = s.length-i-1;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }