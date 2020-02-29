public boolean equals(Object obj){
    if(this == obj){
        return true;
    }
    //为了提高健壮性
    //先判断以下，该对象是否是该类的：对象名 instanceof 类名
    if(! (obj instanceof)Student)){
        return false;
    }
    Student s = (Student) obj;
    return this.name.equals(s.name) && this.age == a.age;
} 