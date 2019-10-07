sturct A
{
    int a;
    int *pa;
};
struct B
{
    int b;
    struct A*pstuA;
};
int main()
{
    struct B BB;
    BB.b;
    BB.pstuA;   //取决于.或者指向符前面是指针还是变量
    BB.pstuA—>a;
    BB.pstuA—>pa;
};
return 0;