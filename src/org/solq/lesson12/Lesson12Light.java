package org.solq.lesson12;

import org.solq.lesson12.model.Green;
import org.solq.lesson12.model.ILight;
import org.solq.lesson12.model.LightType;
import org.solq.lesson12.model.Red;
import org.solq.lesson12.model.Yellow;

public class Lesson12Light {

	public static void main(String[] args) throws InterruptedException {
		//����ӿ���д���и��ô��ǲ���Ҫ֪���������Ǹ�ʵ�ֵ����࣬����ʱ�������滻
		
		ILight[] lights = {new Green(), new Yellow(),new Red(),new Yellow()};
		
		//ģ�⽻ͨ��һ��һ�����
		while(true){
			
			//���ϵͳ��ǰʱ�� ���뵥λ
			long start = System.currentTimeMillis();
			long end  = 0L;
			LightType swType = null;
			for(ILight light : lights){
				//���л���ͬ���͵Ƶ�ʱ�� ��¼��ʼʱ��
				if(swType ==null || !light.getType().equals(swType)){
					//��¼�л���ʱ��
					start = System.currentTimeMillis();
					end  = start+ light.getExTime()*1000;
					//��¼��ǰ��ִ�еĽ�ͨ��
					swType = light.getType();
				}
 
				
				int value =1;
				//��ǰϵͳʱ��Ƚ���ʱ����
				while(System.currentTimeMillis()< end){
					System.out.println("��ǰ������ ��"+ swType + " ִ��ʱ�� ��" + value);
					Thread.sleep(1000);
					value++;
				}
				
				//�л�������ʱ������л���һ��
				swType=null;
			}
		}
	}

}
