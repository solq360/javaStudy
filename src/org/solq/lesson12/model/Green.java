package org.solq.lesson12.model;
/**
 * �̵�ʵ��
 * 
 * @author solq
 */
public class Green implements ILight {

	@Override
	public int getExTime() {
		return 30;
	}

	@Override
	public LightType getType() {
		return LightType.GREEN;
	}

}
