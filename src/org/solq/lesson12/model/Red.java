package org.solq.lesson12.model;
/**
 * ���ʵ��
 * 
 * @author solq
 */
public class Red implements ILight {

	@Override
	public LightType getType() {
 		return LightType.RED;
	}

	@Override
	public int getExTime() {
 		return 40;
	}

}
