/* error : field not in record type */

let 
	type rectype = {name : string , id : int}
	var rec1 := rectype {name="Name", id=0}
in
	rec1.nam := "asd"
end
