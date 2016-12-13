package Semant;

import Symbol.Table;
import Symbol.Symbol;

public class Env {
	Table vEnv;
	Table tEnv;
	ErrorMsg.ErrorMsg errorMsg;

	public Env(ErrorMsg.ErrorMsg err) {
		errorMsg = err;

		tEnv = new Table();
		tEnv.put(Symbol.symbol("int"),new Types.INT());
		tEnv.put(Symbol.symbol("string"), new Types.STRING());

		vEnv = new Table();
		Types.RECORD formals = null;
		Types.Type result = null;
		
		formals = new Types.RECORD(Symbol.symbol("s"), (Types.Type) tEnv.get(Symbol.symbol("string")), null);
		result = new Types.VOID();
		vEnv.put(Symbol.symbol("print"), new StdFuncEntry(formals, result));
		vEnv.beginScope();
		vEnv.put(Symbol.symbol("s"), new VarEntry((Types.Type) tEnv.get(Symbol.symbol("string"))));
		vEnv.endScope();

		formals = new Types.RECORD(Symbol.symbol("i"), (Types.Type) tEnv.get(Symbol.symbol("int")), null);
		result = new Types.VOID();
		vEnv.put(Symbol.symbol("printi"), new StdFuncEntry(formals, result));
		vEnv.beginScope();
		vEnv.put(Symbol.symbol("i"), new VarEntry((Types.Type) tEnv.get(Symbol.symbol("int"))));
		vEnv.endScope();
		
		formals = null;
		result = new Types.VOID();
		vEnv.put(Symbol.symbol("flush"), new StdFuncEntry(formals, result));

		formals = null;
		result = new Types.STRING();
		vEnv.put(Symbol.symbol("getchar"), new StdFuncEntry(formals, result));

		formals = new Types.RECORD(Symbol.symbol("s"), (Types.Type) tEnv.get(Symbol.symbol("string")), null);
		result = new Types.INT();
		vEnv.put(Symbol.symbol("ord"), new StdFuncEntry(formals, result));
		vEnv.beginScope();
		vEnv.put(Symbol.symbol("s"), new VarEntry((Types.Type) tEnv.get(Symbol.symbol("string"))));
		vEnv.endScope();

		formals = new Types.RECORD(Symbol.symbol("i"), (Types.Type) tEnv.get(Symbol.symbol("int")), null);
		result = new Types.STRING();
		vEnv.put(Symbol.symbol("chr"), new StdFuncEntry(formals, result));
		vEnv.beginScope();
		vEnv.put(Symbol.symbol("i"),  new VarEntry((Types.Type) tEnv.get(Symbol.symbol("int"))));
		vEnv.endScope();

		formals = new Types.RECORD(Symbol.symbol("s"), (Types.Type) tEnv.get(Symbol.symbol("string")), null);
		result = new Types.INT();
		vEnv.put(Symbol.symbol("size"), new StdFuncEntry(formals, result));
		vEnv.beginScope();
		vEnv.put(Symbol.symbol("s"), new VarEntry((Types.Type) tEnv.get(Symbol.symbol("string"))));
		vEnv.endScope();

		formals = new Types.RECORD(Symbol.symbol("n"), (Types.Type) tEnv.get(Symbol.symbol("int")), null);
		formals.tail = new Types.RECORD(Symbol.symbol("f"), (Types.Type) tEnv.get(Symbol.symbol("int")), null);
		formals.tail.tail = new Types.RECORD(Symbol.symbol("s"), (Types.Type) tEnv.get(Symbol.symbol("string")), null);
		result = new Types.STRING();
		vEnv.put(Symbol.symbol("substring"), new StdFuncEntry(formals, result));
		vEnv.beginScope();
		vEnv.put(Symbol.symbol("n"), new VarEntry((Types.Type) tEnv.get(Symbol.symbol("int"))));
		vEnv.put(Symbol.symbol("f"), new VarEntry((Types.Type) tEnv.get(Symbol.symbol("int"))));
		vEnv.put(Symbol.symbol("s"), new VarEntry((Types.Type) tEnv.get(Symbol.symbol("string"))));
		vEnv.endScope();
		
		formals = new Types.RECORD(Symbol.symbol("s2"), (Types.Type) tEnv.get(Symbol.symbol("string")), null);
		formals.tail = new Types.RECORD(Symbol.symbol("s1"), (Types.Type) tEnv.get(Symbol.symbol("string")), null);
		result = new Types.STRING();
		vEnv.put(Symbol.symbol("concat"), new StdFuncEntry(formals, result));
		vEnv.beginScope();
		vEnv.put(Symbol.symbol("s2"), new VarEntry((Types.Type) tEnv.get(Symbol.symbol("string"))));
		vEnv.put(Symbol.symbol("s1"), new VarEntry((Types.Type) tEnv.get(Symbol.symbol("string"))));
		vEnv.endScope();

		formals = new Types.RECORD(Symbol.symbol("i"), (Types.Type) tEnv.get(Symbol.symbol("int")), null);
		result = new Types.INT();
		vEnv.put(Symbol.symbol("not"), new StdFuncEntry(formals, result));
		vEnv.beginScope();
		vEnv.put(Symbol.symbol("i"), new VarEntry((Types.Type) tEnv.get(Symbol.symbol("int"))));
		vEnv.endScope();

		formals = new Types.RECORD(Symbol.symbol("i"), (Types.Type) tEnv.get(Symbol.symbol("int")), null);
		result = new Types.VOID();
		vEnv.put(Symbol.symbol("exit"), new StdFuncEntry(formals, result));
		vEnv.beginScope();
		vEnv.put(Symbol.symbol("i"), new VarEntry((Types.Type) tEnv.get(Symbol.symbol("int"))));
		vEnv.endScope();
	}

	public void errorMsg(int pos, String err)
	{
		System.out.println(pos);
		errorMsg.error(pos, err);
	}

	public static int getLine(int pos, String t)
	{
		if (pos <= 0) return 1;
		int line = 1;
		for (int i = 0; i < t.length(); i++)
		{
			if (i >= pos) break;
			if (t.charAt(i) == '\n') ++line;
		}
		return line;
	}
}
