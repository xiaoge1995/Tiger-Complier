/* error: definition of recursive types is interrupted */
let
	type tree ={key: int, children: treelist}
	var d:int :=0
	type treelist = {hd: tree, tl: treelist}
in
	d
end


