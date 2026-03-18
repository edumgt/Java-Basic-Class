package PolymorphismEXERCISES.Calculator;

import java.util.List;

public abstract class Operation {
    protected List<Integer> operands;
    protected int result;

    public abstract void addOperand(int operand);

    public boolean isCompleted() {
        return this.operands.size() == 2;
    }

    public int getResult() {
        return this.result;
    }
}
