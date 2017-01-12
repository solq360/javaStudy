package org.solq.lesson12.model;

/**
 * 交通灯接口
 * 
 * @author solq
 */
public interface ILight extends ICtx {
	/**
	 * 获得交通灯类型
	 * **/
	public LightType getType();
}
