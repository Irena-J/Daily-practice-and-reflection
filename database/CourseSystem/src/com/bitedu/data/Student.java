package com.bitedu.data;

public class Student {

    private int sno;
    private String sname;
    private int classid;


    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return sname;
    }

    public void setName(String sname) {
        this.sname = sname;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }
	public Student toString(){
		return "sno="+sno+"name="+name+"classid="+classid;
	}

}
