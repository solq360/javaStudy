package org.solq.lesson10;

import java.util.HashMap;
import java.util.Map;

public class Lesson10 {

	public static void main(String[] args) {
		String item = "����";
		if (item.equals("����")) {
			System.out.println("���ĸ�����");
		} else if (item.equals("����")) {
			System.out.println("��1������");
		}else{
			System.out.println("ʲôҲ����");
		}
		
		for(int i=1;i<=1000000;i++){
			if(i==2){
				//������������
				continue;
			}
			if(i==4){
				System.out.println("��1������");
			}
			if(i==7){
				System.out.println("��2������");
			}
			if(i==8){
				System.out.println("��4������");
			}
			if(i==10){
				System.out.println("��4������");
			}
			
			if(i==20){
				//����ѭ��
				break;
			}
		}
		
		//ֻ�ܸ��ݵ�һ��״̬�������
		switch (item) {
		case "����":
			System.out.println("���ĸ�����");
			break;
		case "����":
			System.out.println("��1������");
			break;
		default:
			System.out.println("ʲôҲ����");
			break;
		}
		
		//map<����״̬��������> Ԥ�Ȱѿ��ƹ��� ��������
		Map<String, String> map = new HashMap<>();
		map.put("����", "���ĸ�����");
		map.put("����", "��1������");
		
		String text= map.get(item);
		System.out.println(text);
	}

}
