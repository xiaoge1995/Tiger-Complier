let 
   var a:=10000 
   var b:=0
   var c:=2800
   var d:=0
   var e:=0 
   type arr = array of int
   var f : arr:= arr[2801] of 0 
   var g:=0
 
   function test():int = ( d:=0; g:=c*2; g)
   function test2():int  = ( d:=d+f[b]*a; g:=g-1; f[b]:=d - d/g*g;d:=d/g;g:=g-1;b:=b-1;b )
   
   function printf(i:int) = (
   
       if (i < 1000) then printi(0);
       if (i < 100) then printi(0);
       if (i < 10) then printi(0);
       printi(i)
   )
   
in
	while (b-c)<>0  do ( f[b]:=a/5; b:=b+1 );	
	while test() do (
	    b:=c;
	    while test2() do (
	        d:=d*b
	    );
		c:=c-14;
		printf(e+d/a);
		e:=d-d/a*a
	)
end

/*
	int a = 10000;
	int b = 0;
	int c = 2800;
	int d = 0;
	int e = 0;
	int f[2801];
	int g = 0;

	for (;b-c;) f[b++] = a/5;
	for (;d=0,g=c*2; c-=14, printf("%.4d",e+d/a),e = d%a)
		for (b=c;d+=f[b]*a,f[b] = d%--g,d/=g--,--b;d*=b);
*/

/*

Answer:

31415926535897932384626433832795028841971693993751058209749445923078164062862089
98628034825342117067982148086513282306647093844609550582231725359408128481117450
28410270193852110555964462294895493038196442881097566593344612847564823378678316
52712019091456485669234603486104543266482133936072602491412737245870066063155881
74881520920962829254091715364367892590360011330530548820466521384146951941511609
43305727036575959195309218611738193261179310511854807446237996274956735188575272
48912279381830119491298336733624406566430860213949463952247371907021798609437027
70539217176293176752384674818467669405132000568127145263560827785771342757789609
17363717872146844090122495343014654958537105079227968925892354201995611212902196
08640344181598136297747713099605187072113499999983729780499510597317328160963185

*/