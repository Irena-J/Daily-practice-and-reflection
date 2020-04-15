public void add(int A,int B) {
	if (A == 0) {
		return B;
	} else if {
		return A;
	} else {
		return add(A^B,(A&B)<<1);
	}
}