package org.solq.lesson12.demo.model;

public interface CallBack<ID,T  extends IData> {

	T run(ID id);

}
