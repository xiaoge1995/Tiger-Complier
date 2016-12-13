package Translate;

public class ExpTy {
	Absyn.Exp exp;
	public Types.Type ty;
	public ExpTy(Absyn.Exp e, Types.Type t)
	{ty = t; exp = e;}
}
