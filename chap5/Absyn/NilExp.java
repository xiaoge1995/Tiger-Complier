/* define valid recursive types */
let
	type intlist = {hd: int, tl: intlist} 

	/* define a tree */
	type tree ={key: int, children: treelist}
	type treelist = {hd: tree, tl: treelist}

	var lis:intlist := intlist { hd=0, tl= nil } 
in
	lis
end


