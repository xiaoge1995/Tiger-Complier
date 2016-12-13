package Semant;

import java.util.ArrayList;
import Absyn.*;
import Translate.*;

public class Semant {
	Env env;
	int loopNumber;
	public Semant(ErrorMsg.ErrorMsg err) {this(new Env(err));loopNumber = 0;}
	Semant(Env e) {env = e;}
	
	Types.Type INT = new Types.INT();
	Types.Type STRING = new Types.STRING();
	Types.Type NIL = new Types.NIL();
	Types.Type VOID = new Types.VOID();

	ExpTy transVar(Var e) 
	{
		if (e instanceof SimpleVar)
			return transVar((SimpleVar) e);
		if (e instanceof SubscriptVar)
			return transVar((SubscriptVar) e);
		if (e instanceof FieldVar)
			return transVar((FieldVar) e);
		return new ExpTy(null, VOID);
	}

	ExpTy transVar(SimpleVar e)
	{
		Entry exp = (Entry) env.vEnv.get(e.name);
		//env.errorMsg(e.pos,"SimpleVar"+e.name.toString()+((VarEntry)exp).ty.toString());//=================
		if ((exp == null) || !(exp instanceof VarEntry))
		{
			env.errorMsg(e.pos, "Undefined var\""+e.name+"\"! (transVar SimpleVar)");
			return new ExpTy(null, VOID);
		}
		else
			return new ExpTy(null, ((VarEntry)exp).ty);
	}

	ExpTy transVar(SubscriptVar e)
	{
		ExpTy exp = transVar(e.var);
		Types.Type typ = exp.ty;
		//if (exp.ty instanceof Types.NAME) typ = exp.ty.actual();
		if (!(exp.ty.actual() instanceof Types.ARRAY))
		{
			env.errorMsg(e.pos, "Not a Array's SubscriptVar! (transVar SubscriptVar)");
			return new ExpTy(null, VOID);
		}
		exp = transExp(e.index);
		if (!(exp.ty instanceof Types.INT))
		{
			env.errorMsg(e.pos, "SubscriptVar isn't a interger! (transVar SubscriptVar)");
			return new ExpTy(null, VOID);
		}
		return new ExpTy(null, ((Types.ARRAY)typ.actual()).element);
	}

	ExpTy transVar(FieldVar e)
	{
		ExpTy exp = transVar(e.var);
		if ((exp.ty.actual() instanceof Types.RECORD))
		{
			Types.RECORD t = (Types.RECORD) exp.ty.actual();
			for (; t != null; t = t.tail)
				if (t.fieldName.equals(e.field)) break;
			if (t == null)
			{
				env.errorMsg(e.pos, "\""+e.field+"\"doesn't exiset! (transVar FieldVar)");
				return new ExpTy(null, VOID);
			}
			else
				return new ExpTy(null, t.fieldType);
		}
		else
			env.errorMsg(e.pos, "Unknown FieldVar! (transVar FieldVar)");
		return new ExpTy(null, VOID);
	}
	
	public ExpTy transExp(Exp e) {
		if (e instanceof VarExp)
			return transExp((VarExp) e);
		if (e instanceof IntExp)
			return transExp((IntExp) e);
		if (e instanceof NilExp)
			return transExp((NilExp) e);
		if (e instanceof StringExp)
			return transExp((StringExp) e);
		if (e instanceof CallExp)
			return transExp((CallExp) e);
		if (e instanceof OpExp)
			return transExp((OpExp) e);
		if (e instanceof RecordExp)
			return transExp((RecordExp) e);
		if (e instanceof SeqExp)
			return transExp((SeqExp) e);
		if (e instanceof AssignExp)
			return transExp((AssignExp) e);
		if (e instanceof IfExp)
			return transExp((IfExp) e);
		if (e instanceof WhileExp)
			return transExp((WhileExp) e);
		if (e instanceof ForExp)
			return transExp((ForExp) e);
		if (e instanceof BreakExp)
			return transExp((BreakExp) e);
		if (e instanceof LetExp)
			return transExp((LetExp) e);
		if (e instanceof ArrayExp)
			return transExp((ArrayExp) e);
		return new ExpTy(null, VOID);
	}

	ExpTy transExp(VarExp e) {
		//env.errorMsg(e.pos, "VarExp");
		return transVar(e.var);
	}

	ExpTy transExp(IntExp e) {
		return new ExpTy(null, INT);
	}

	ExpTy transExp(StringExp e) {
		return new ExpTy(null, STRING);
	}

	ExpTy transExp(NilExp e) {
		return new ExpTy(null, NIL);
	}

	ExpTy transExp(CallExp e) {
		Entry exp = (Entry) env.vEnv.get(e.func);
		if (exp == null)
		{
			env.errorMsg(e.pos, "Function \""+e.func+"\" doesn't be found! (transExp CallExp)");
			return new ExpTy(null, VOID);
		}
		if (exp instanceof FunEntry)
		{
			//env.errorMsg(e.pos, e.func.toString()); //============================
			FunEntry fun = (FunEntry) exp;
			Types.RECORD arg1 = fun.formals;
			ExpList arg2 = e.args;
			for (; arg1 != null && arg2 != null; arg1 = arg1.tail, arg2 = arg2.tail)
			{
				ExpTy ty = transExp(arg2.head);
				if (!ty.ty.coerceTo(arg1.fieldType))
				{
					env.errorMsg(e.pos, "Functon parameter doesn't match! (transExp CallExp)");
					return new ExpTy(null, VOID);
				}
			}
			if ((arg1 != null) || (arg2 != null))
			{
				env.errorMsg(e.pos, "Functoin parameter number does't match! (transExp CallExp)");
				return new ExpTy(null, VOID);
			}
			return new ExpTy(null, fun.result);
		}
		else
		{
			env.errorMsg(e.pos, "Unknown function call! (transExp CallExp)");
			return new ExpTy(null, VOID);
		}
	}

	Exp checkInt(ExpTy e, int pos)
	{
		if (!(e.ty instanceof Types.INT))
			env.errorMsg(pos, "Not a int!");
		return null;
	}

	ExpTy transExp(OpExp e)
	{
		ExpTy left = null, right = null;
		switch (e.oper)
		{
			case OpExp.PLUS:
				checkInt(transExp(e.left), e.left.pos);
				checkInt(transExp(e.right), e.right.pos);
				return new ExpTy(null, INT);
			case OpExp.MINUS:
				checkInt(transExp(e.left), e.left.pos);
				checkInt(transExp(e.right), e.right.pos);
				return new ExpTy(null, INT);
			case OpExp.MUL:
				checkInt(transExp(e.left), e.left.pos);
				checkInt(transExp(e.right), e.right.pos);
				return new ExpTy(null, INT);
			case OpExp.DIV:
				checkInt(transExp(e.left), e.left.pos);
				checkInt(transExp(e.right), e.right.pos);
				return new ExpTy(null, INT);
			case OpExp.EQ:
				left = transExp(e.left);
				right = transExp(e.right);
				//env.errorMsg(e.pos, left.ty.toString());
				//env.errorMsg(e.pos, right.ty.toString()); //====================
				if ((left.ty.actual() instanceof Types.VOID) || (right.ty.actual() instanceof Types.VOID))
					env.errorMsg(e.pos, "Can't compare VOID!");
				if ((left.ty.actual() instanceof Types.NIL) && (right.ty.actual() instanceof Types.NIL))
					env.errorMsg(e.pos, "Can't both be NIL!");
				if (!left.ty.coerceTo(right.ty))
					if (!((left.ty.actual() instanceof Types.NIL) && (right.ty.actual() instanceof Types.RECORD)))
						if (!((left.ty.actual() instanceof Types.RECORD) && (right.ty.actual() instanceof Types.NIL)))
							env.errorMsg(e.pos, "Types does't match!");
				return new ExpTy(null, INT);
			case OpExp.NE:
				left = transExp(e.left);
				right = transExp(e.right);
				if ((left.ty instanceof Types.VOID) || (right.ty instanceof Types.VOID))
					env.errorMsg(e.pos, "Can't compare VOID!");
				if ((left.ty instanceof Types.NIL) && (right.ty instanceof Types.NIL))
					env.errorMsg(e.pos, "Can't both be NIL!");
				if (!left.ty.coerceTo(right.ty))
					if (!((left.ty instanceof Types.NIL) && (right.ty instanceof Types.RECORD)))
						if (!((left.ty instanceof Types.RECORD) && (right.ty instanceof Types.NIL)))
							env.errorMsg(e.pos, "Types does't match!");
				return new ExpTy(null, INT);
			case OpExp.LT:
				left = transExp(e.left);
				right = transExp(e.right);
				if (!((left.ty instanceof Types.INT) && (right.ty instanceof Types.INT)))
					if (!((left.ty instanceof Types.STRING) && (right.ty instanceof Types.STRING)))
						env.errorMsg(e.pos, "Types unsuitable!");
				return new ExpTy(null, INT);
			case OpExp.LE:
				left = transExp(e.left);
				right = transExp(e.right);
				if (!((left.ty instanceof Types.INT) && (right.ty instanceof Types.INT)))
					if (!((left.ty instanceof Types.STRING) && (right.ty instanceof Types.STRING)))
						env.errorMsg(e.pos, "Types unsuitable!");
				return new ExpTy(null, INT);
			case OpExp.GT:
				left = transExp(e.left);
				right = transExp(e.right);
				if (!((left.ty instanceof Types.INT) && (right.ty instanceof Types.INT)))
					if (!((left.ty instanceof Types.STRING) && (right.ty instanceof Types.STRING)))
						env.errorMsg(e.pos, "Types unsuitable!");
				return new ExpTy(null, INT);
			case OpExp.GE:
				left = transExp(e.left);
				right = transExp(e.right);
				if (!((left.ty instanceof Types.INT) && (right.ty instanceof Types.INT)))
					if (!((left.ty instanceof Types.STRING) && (right.ty instanceof Types.STRING)))
						env.errorMsg(e.pos, "Types unsuitable!");
				return new ExpTy(null, INT);
			default :
				return new ExpTy(null, VOID);
		}
	}

	ExpTy transExp(RecordExp e)
	{
		Types.Type exp = (Types.Type) env.tEnv.get(e.typ);
		if (exp == null)
		{
			env.errorMsg(e.pos, "Undefined Type \""+e.typ+"\"! (transExp RecordExp)");
			return new ExpTy(null, VOID);
		}
		if (exp.actual() instanceof Types.RECORD)
		{
			Types.RECORD r = (Types.RECORD) exp.actual();
			FieldExpList l = e.fields;
			for (; r != null && l != null; r = r.tail, l = l.tail)
			{
				if (!l.name.equals(r.fieldName))
				{
					env.errorMsg(e.pos, "undefined Field!\""+l.name+"\" (transExp RecordExp)");
					return new ExpTy(null, VOID);
				}
				Types.Type t = r.fieldType.actual();
				Types.Type t2 = transExp(l.init).ty;
				//if (r.fieldType instanceof Types.NAME)
					//t = ((Types.NAME)r.fieldType).actual();
				if (!t.coerceTo(t2))
					if (!((t instanceof Types.RECORD) && (t2 instanceof Types.NIL)))
					{
						env.errorMsg(e.pos, "Type \""+r.fieldName+"\"doesn't match! (transExp RecordExp)");
						return new ExpTy(null, VOID);
					}
			}
			if (r != null || l != null)
			{
				env.errorMsg(e.pos, "Number of Type does't macht! (transExp RecordExp)");
				return new ExpTy(null, VOID);
			}
			return new ExpTy(null, exp);
		}
		else env.errorMsg(e.pos, "Type \""+e.typ+"\"does't exiet! (transExp RecordExp)");
		return new ExpTy(null, VOID);
	}

	ExpTy transExp(SeqExp e)
	{
		if (e == null || e.list == null)
			return new ExpTy(null, VOID);
		//env.errorMsg(e.pos, "SeqExp");//==========================
		ExpTy t = null;
		for (ExpList i = e.list; i != null; i = i.tail)
			t = transExp(i.head);
		return t;
	}

	ExpTy transExp(AssignExp e)
	{
		ExpTy right = transExp(e.exp);
		ExpTy left = transVar(e.var);
		if (e.var instanceof SimpleVar)
		{
			Entry v = (Entry) env.vEnv.get(((SimpleVar) e.var).name);
			if (v instanceof LoopVarEntry)
			{
				env.errorMsg(e.pos, "Can't assign a loopvar! (transExp AssignExp)");
				return new ExpTy(null, VOID);
			}
		}
		if (right.ty.coerceTo(VOID))
			env.errorMsg(e.pos,"Can't assign a VOID! (transExp AssignExp)");
		if (!left.ty.coerceTo(right.ty))
			if (!((left.ty instanceof Types.RECORD) && (right.ty instanceof Types.NIL)))
				env.errorMsg(e.pos, "Different type between ':=' (transExp AssignExp)");
		return right;
	}

	ExpTy transExp(IfExp e)
	{
		ExpTy test = transExp(e.test);
		if (!(test.ty instanceof Types.INT))
		{
			env.errorMsg(e.pos, "If test must be a interger! (transExp IfExp)");
			return new ExpTy(null, VOID);
		}
		ExpTy thenclause = transExp(e.thenclause);
		if (e.elseclause != null)
		{
			ExpTy elseclause = transExp(e.elseclause);
			if (!(thenclause.ty.coerceTo(elseclause.ty)))
				if (!(thenclause.ty instanceof Types.NIL) && !(elseclause.ty instanceof Types.NIL))
				{
					env.errorMsg(e.pos, "Then part must be same type with else part! (transExp IfExp)");
					return new ExpTy(null, VOID);
				}
		}
		return thenclause;
	}

	ExpTy transExp(WhileExp e)
	{
		ExpTy test = transExp(e.test);
		if (!(test.ty instanceof Types.INT))
		{
			env.errorMsg(e.pos, "While test must be a interger! (transExp WhileExp)");
			return new ExpTy(null, VOID);
		}
		++loopNumber;
		transExp(e.body);
		//env.errorMsg(e.pos, "WhileExp");//==================
		--loopNumber;
		return new ExpTy(null, VOID);
	}

	ExpTy transExp(ForExp e)
	{
		++loopNumber;
		env.vEnv.beginScope();
		transDec(e.var);
		Entry exp = (Entry) env.vEnv.get(e.var.name);
		if (!(exp instanceof VarEntry))
		{
			env.errorMsg(e.pos, "For test must be a var! (transExp ForExp)");
			//return new ExpTy(null, VOID);
		}
		else
		{
			if (!(((VarEntry) exp).ty instanceof Types.INT))
				env.errorMsg(e.pos, "For test must be a interger! (transExp ForExp)");
			else env.vEnv.put(e.var.name, new LoopVarEntry(((VarEntry)exp).ty));
		}
		ExpTy end = transExp(e.hi);
		if (!(end.ty instanceof Types.INT))
			env.errorMsg(e.pos, "For end must be a interger! (transExp ForExp)");
		transExp(e.body);
		env.vEnv.endScope();
		--loopNumber;
		return new ExpTy(null, VOID);
	}

	ExpTy transExp(BreakExp e)
	{
		if (loopNumber == 0)
			env.errorMsg(e.pos, "Break should be in a Loop!");
		return new ExpTy(null, VOID);
	}

	ExpTy transExp(LetExp e)
	{
		env.tEnv.beginScope();
		env.vEnv.beginScope();
		for (DecList i = e.decs; i != null; i = i.tail)
			transDec(i.head);
		//env.errorMsg(e.pos, "let!");//===================
		ExpTy exp = transExp(e.body);
		env.vEnv.endScope();
		env.tEnv.endScope();
		return new ExpTy(null, exp.ty);
	}

	ExpTy transExp(ArrayExp e)
	{
		ExpTy size = transExp(e.size);
		if (!(size.ty instanceof Types.INT))
		{
			env.errorMsg(e.pos, "The size of array should be interger!");
			return new ExpTy(null, VOID);
		}
		Types.Type typ = (Types.Type) env.tEnv.get(e.typ);
		if (!(typ.actual() instanceof Types.ARRAY))
		{
			env.errorMsg(e.pos, "\""+e.typ+"\"is not a array!");
			return new ExpTy(null, VOID);
		}
		Types.Type exp = typ;
		if (typ instanceof Types.NAME) exp = typ.actual();
		if (exp instanceof Types.ARRAY)
			if (!(((Types.ARRAY)exp).element.coerceTo(transExp(e.init).ty)))
			{
				env.errorMsg(e.pos, "The element type dosen't match!");
				return new ExpTy(null, VOID);
			}
		return new ExpTy(null, exp);
	}

	Exp transDec(Dec e)
	{
		if (e instanceof VarDec)
			return transDec((VarDec) e);
		if (e instanceof TypeDec)
			return transDec((TypeDec) e);
		if (e instanceof FunctionDec)
			return transDec((FunctionDec) e);
		return null;
	}

	Exp transDec(VarDec e)
	{
		if (e.init == null)
		{
			env.errorMsg(e.pos, "Dec \""+e.name+"\" doesn't have a init value! (transDec VarDec)");
			return null;
		}
		ExpTy t = transExp(e.init);
		Types.Type typ = null;
		if (e.typ != null)
		{
			typ = transTy(e.typ).actual();
			//if (typ instanceof Types.NAME) typ.actual();
			if (!t.ty.coerceTo(typ))
				if (!((typ instanceof Types.RECORD) && (t.ty instanceof Types.NIL)))
				{
					env.errorMsg(e.pos, "Type not match! (transDec VarDec)");
					return null;
				}
		}
		else
			if (t.ty instanceof Types.NIL)
			{
				env.errorMsg(e.pos, "VarDec \""+e.name+"\" has a nil as init value! (transDec VarDec)");
				return null;
			}
		if (typ != null) env.vEnv.put(e.name, new VarEntry(typ));
		else env.vEnv.put(e.name, new VarEntry(t.ty));
		return null;
	}

	Exp transDec(TypeDec e)
	{
		ArrayList<String> block = new ArrayList<String>();
		for (TypeDec i = e; i != null; i = i.next)
		{
			if (block.contains(i.name.toString()))
			{
				env.errorMsg(e.pos, "Type \""+i.name+"\" has been defined already! (transDec TypeDec)");
				continue;
			}
			block.add(i.name.toString());
			env.tEnv.put(i.name, new Types.NAME(i.name));
		}
		for (TypeDec i = e; i != null; i = i.next)
			if (i.ty == null)
				((Types.NAME)env.tEnv.get(i.name)).bind(new Types.NAME(i.name));
			else
				((Types.NAME)env.tEnv.get(i.name)).bind(transTy(i.ty));
		for (TypeDec i = e; i != null; i = i.next)
		{
			Types.NAME tn = (Types.NAME)env.tEnv.get(i.name);
			if (tn.isLoop())
			{
				env.errorMsg(e.pos, "Type \""+i.name+"\" is Loop!(transDec TypeDec)");
				tn.bind(VOID);
			}
		}
		return null;
	}
	
	Types.RECORD transTypeFields(FieldList e)
	{
		if (e == null) return null;
		Types.RECORD r = new Types.RECORD(e.name, (Types.Type) env.tEnv.get(e.typ), null), t = null;
		t = r;
		for (FieldList i = e.tail; i != null; i = i.tail)
		{
			t.tail = new Types.RECORD(i.name, (Types.Type) env.tEnv.get(i.typ), null);
			t = t.tail;
		}
		return r;
	}

	Exp transDec(FunctionDec e)
	{
		ArrayList<String> block = new ArrayList<String>();
		ArrayList<String> blockp = new ArrayList<String>();
		for (FunctionDec i = e; i != null; i = i.next)
		{
			Types.RECORD formals = transTypeFields(i.params);
			Types.Type result = transTy(i.result);
			if (block.contains(i.name.toString()))
			{
				env.errorMsg(i.pos, "Function \""+i.name+"\" has been defined already! transDec FunctionDec");
				continue;
			}
			block.add(i.name.toString());
			Entry t = (Entry) env.vEnv.get(i.name);
			if ((t != null) && (t instanceof StdFuncEntry))
			{
				env.errorMsg(e.pos, "Functoin \""+i.name+"\" is a StdFuncEntry! (transDec FunctionDec)");
				continue;
			}
			else env.vEnv.put(i.name, new FunEntry(formals, result));
		}
		for (FunctionDec i = e; i != null; i = i.next)
		{
			env.vEnv.beginScope();
			blockp.clear();
			Types.Type result = transTy(i.result);
			for (FieldList j = i.params; j != null; j = j.tail)
			{
				if (blockp.contains(j.name.toString()))
				{
					env.errorMsg(i.pos, "Param \""+j.name+"\" has already been defined! (transDec FunctionDec)");
					continue;
				}
				block.add(j.name.toString());
				Types.Type pty = (Types.Type) env.tEnv.get(j.typ);
				//env.errorMsg(e.pos, j.typ.toString());
				//System.out.println(pty == null);//=============================
				if (pty == null)
					env.errorMsg(i.pos, "Undefined type \""+j.name+"\" (transDev FunctionDec)");
				else env.vEnv.put(j.name, new VarEntry(pty));
			}
			//env.errorMsg(e.pos, e.name.toString());
			//env.errorMsg(e.pos, result.toString());
			ExpTy re = transExp(i.body);
			//env.errorMsg(e.pos, re.ty.toString());
			//System.out.println("//=============");//==========================
			if (!(re.ty.coerceTo(result)))
				env.errorMsg(i.pos, "Return valiable doesn't match! (transDev FunctionDec)");
			env.vEnv.endScope();
		}
		return null;
	}

	Types.Type transTy(Ty e) 
	{
		if (e instanceof NameTy)
			return transTy((NameTy) e);
		if (e instanceof RecordTy)
			return transTy((RecordTy) e);
		if (e instanceof ArrayTy)
			return transTy((ArrayTy) e);
		return VOID;
	}

	Types.Type transTy(NameTy e)
	{
		if (e == null) return VOID;
		Types.Type t = (Types.Type) env.tEnv.get(e.name);
		if (t == null)
		{
			env.errorMsg(e.pos, "Unknown type \""+e.name+"\" (transTy NameTy)");
			return VOID;
		}
		return t;
	}

	Types.Type transTy(RecordTy e)
	{
		if (env.tEnv.get(e.fields.typ) == null)
		{
			env.errorMsg(e.pos, "Undefined type \""+e.fields.name+"\" (transTy RecordTy)");
			return VOID;
		}
		env.vEnv.beginScope();
		Types.RECORD result = null, temp = null;
		temp = result = new Types.RECORD(e.fields.name, (Types.Type) env.tEnv.get(e.fields.typ), null);
		ArrayList<String> block = new ArrayList<String>();
		block.add(e.fields.name.toString());
		for (FieldList i = e.fields.tail; i != null; i = i.tail)
		{
			if (block.contains(i.name.toString()))
			{
				env.errorMsg(e.pos, "Field \""+i.name+"\" is defined! (transTy RecordTy)");
				continue;
			}
			block.add(i.name.toString());
			Types.Type t = (Types.Type) env.tEnv.get(i.typ);
			if (t == null)
			{
				env.errorMsg(e.pos, "Type \""+i.typ+"\" doesn't exites! (transTy RecordTy)");
				continue;
			}
			env.vEnv.put(i.name, new VarEntry(t));
			temp.tail = new Types.RECORD(i.name, t, null);
			temp = temp.tail;
		}
		env.vEnv.endScope();
		return result;
	}

	Types.Type transTy(ArrayTy e)
	{
		Types.Type t = (Types.Type) env.tEnv.get(e.typ);
		if (t == null)
		{
			env.errorMsg(e.pos, "Type doesn't exist! (transTy ArrayTy)");
			return VOID;
		}
		return new Types.ARRAY(t);
	}
} // null ? afret env.errorMsg?
