package org.solq.lesson3;

public class Lesson3 {

	public static void main(String[] args) {
		//���е��������� Ҫ���� ��ȥһ������� ����ͻ����
		//�ñ�������¼���� int������ ���� 32λ
		int a = 2147483647;
		a=a+1;
		//������  16 	
		//short sa= 32768;
		//long ���� 64λ
		long l = 2147483647;
		l=l+1;
		//˫����С�� 64λ
		double d = 122.0d;
		//������ 32λ ������ʹ��
		float f = 122.0f;
		//�ı�����
		String s ="�����ı�";
		//�ڽ��ͱ���ʱ���� ��һ��������ǲ��õ�
		char c ='a';
		
		//���״̬ ������洢���� 0 ������1 ���� 
		boolean b = true;
		boolean b1 = true;
		//System.out.println(sa);

		System.out.println(a);
		System.out.println(l);
		System.out.println(s);
		System.out.println(c);
		System.out.println(b);
		
		if(b && b1){
			System.out.println("�ҽ�����");
			System.out.println("��Ҳ������");
		}
		
		
		///////////////////����1////////////////////
		System.out.println("==============����1============");
		//��¼�ͻ���������
		int recordValue = 750;
		//ϵͳ��������
		int gift = 0;
		
		if(recordValue >= 800){
			gift = 800;
		}else if(recordValue>=700){
			gift = 400;	
		}else if(recordValue>=600){
			gift = 200;	
		}else if(recordValue>=500){
			gift = 100;	
		}else{
			gift =0;
		}
		
		if(gift > 800){
			gift = 800;
		}
		
		System.out.println("ϵͳ���� ��" +gift);

	}

}
