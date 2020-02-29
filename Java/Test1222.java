
int count = 0；
for(int i = 0; i < length; i++){
	if(arr[i] == value){
		count++;
	}else{
		arr[i-count] = arr[i];
	}
}