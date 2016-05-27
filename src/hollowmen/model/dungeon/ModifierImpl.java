package hollowmen.model.dungeon;

import java.util.function.BinaryOperator;

import hollowmen.model.Modifier;
import hollowmen.model.Parameter;

public class ModifierImpl implements Modifier{

	private Parameter targetParam;
	private BinaryOperator<Double> op;
	private BinaryOperator<Double> revOp;
	
	
	public ModifierImpl(String targetParam, double value, Operation op) {
		this.targetParam = new ParamImpl(new InfoImpl(targetParam), value);
		this.op = op.getOp();
		if(this.op.equals(Modifier.Operation.ADD)) {
			this.revOp = (x, y) -> x - y;
		}
		if(this.op.equals(Modifier.Operation.MUL)) {
			this.revOp = (x, y) -> x * (1/y);
		}
		if(this.op == null) {
			this.op = (x, y) -> x;
			this.revOp = (x, y) -> x;
		}
	}

	@Override
	public Parameter getParameter() {
		return this.targetParam;
	}

	@Override
	public BinaryOperator<Double> getOperation() {
		return this.op;
	}

	@Override
	public BinaryOperator<Double> getReverseOperation() {
		return this.revOp;
	}
	
}