package org.solq.lesson12.model;
/**
 * �Ƶ�ʵ��
 * 
 * @author solq
 */
public class Yellow implements ILight {

	@Override
	public LightType getType() {
 		return LightType.YELLOW;
	}

	@Override
	public int getExTime() {
 		return 3;
	}

}
