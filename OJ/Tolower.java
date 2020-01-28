class Tolower {
    public String toLowerCase(String str) {
        int len = str.length();
        if(len == 0){
            return null;
        }
        StringBuffer str1 = new StringBuffer();
        for(int i = 0;i < len;i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                str1.append((char)(str.charAt(i) + 32));
            }else{
                 str1.append(str.charAt(i));
            }
           
        }
        String str2 = str1.toString();
        return str2;
    }
}