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
