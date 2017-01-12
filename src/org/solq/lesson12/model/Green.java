package org.solq.lesson12.model;
/**
 * ÂÌµÆÊµÏÖ
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
