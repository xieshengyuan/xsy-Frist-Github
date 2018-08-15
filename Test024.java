import java.util.Scanner;


public class Test024 {
	public static void main(String[] args) {
		String[] names = new String[4];//������
		String[] dishMegs = new String[4];//��Ʒ��Ϣ
		int[] times = new int[4];//�Ͳ�ʱ��
		String[] addresses = new String[4];//���͵�ַ
		int[] states = new int[4];//����״̬ 0��ʾ��Ԥ��  1��ʾ�����
		double[] sumPrices = new double[4];//�ܽ��
		
		//��ʼ��2��������Ϣ
		names[0] = "����";
		dishMegs[0] = "���մ���  һ��";
		times[0] = 12;
		addresses[0] = "���·   203��";
		states[0] = 1;
		sumPrices[0] = 38.0;
		
		names[1] = "����";
		dishMegs[1] = "������˿  ����";
		times[1] = 12;
		addresses[1] = "���·   203��";
		states[1] = 0;
		sumPrices[1] = 70.0;
		
		
		//����ڶ������������洢��Ʒ��Ϣ
		String[] dishNames = {"���մ���","������˿","����˿" };
		double[] prices = {32.0,35.0,10.0};
		int[] praiseNums = new int[3];
		
		
		Scanner input = new Scanner(System.in);
		int num = -1;//��¼�û����������

		do{
			System.out.println("************************");
			System.out.println("1. ��Ҫ����");
			System.out.println("2. �鿴�ʹ�");
			System.out.println("3. ǩ�ն���");
			System.out.println("4. ɾ������");
			System.out.println("5. ��Ҫ����");
			System.out.println("6. �˳�ϵͳ");
			System.out.println("************************");
			
			System.out.print("��ѡ��");
			int choose = input.nextInt();
			
			
			boolean isAdd = false;//true����¼�ҵ�һ��Ϊ�յ�λ�ã����Բ���  false��û���ҵ�
			switch(choose){
			case 1:
				//1.��Ҫ����
				System.out.println("********��Ҫ����*******");
				//������Ҫѭ����λ��
				for(int i=0;i<names.length;i++){
					//����ҵ�Ϊ�յ�λ�ã���¼����
					if(names[i] == null){
						//ִ�в������
						isAdd = true;//��¼�ҵ�һ��Ϊ�յ�λ��
						//ִ�в������
						System.out.println("���\t��Ʒ��\t����\t������");
						for(int j=0;j<dishNames.length;j++){
						String price = prices[j]+"Ԫ";
						String praise = praiseNums[j]+"��";
						System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						
						}
						//Ҫ��������ѡ��Ʒ�ı���Լ�����
						System.out.print("��ѡ��������Ʒ��ţ�");
						int chooseDish = input.nextInt();
						System.out.print("��ѡ������������");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish-1]+" "+number+"��";
						
						
						//���붩������Ϣ
						System.out.print("�����붩����������");
						String name = input.next();
						
						//�����Ͳ�ʱ�䣺
						System.out.print("�������Ͳ�ʱ�䣨10~20�������Ͳͣ���");
						int time = input.nextInt();
						//�������ˣ��ظ�����
						while(time<10 || time>20){
							System.out.println("�Բ������������������������룺");
							time = input.nextInt();
						}
						
						//�����Ͳ͵�ַ
						System.out.print("�������Ͳ͵�ַ��");
						String address = input.next();
						
						//����ͷ�
						double sumPrice = prices[chooseDish-1]*number;
						//�Ͳͷѵ��ͷѴﵽ50Ԫʱ���Ͳͷ�
						double deliCharge = sumPrice>=50?0.0:6.0;
						
						//��ʾ������Ϣ
						System.out.println("���ͳɹ�!");
						System.out.println("�������ǣ�"+dishMeg);
						System.out.println("�����ˣ�"+name);
						System.out.println("�Ͳ�ʱ��:"+time+"��");
						System.out.println("�Ͳ͵�ַ:"+address);
						System.out.println("�ͷ�"+sumPrice+"�Ͳͷѣ�"+deliCharge+"Ԫ");
						System.out.println("�����ܽ�"+(sumPrice+deliCharge)+"Ԫ");
						
						//��������
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice+deliCharge;
						break;
					}
				}
				//���û���ҵ�Ϊ�յ�λ�ã�����ʾ��Ϣ
				if(!isAdd){
					System.out.println("�Բ������Ĳʹ�������");
				}
				break;
			case 2:
				//2.�鿴�ʹ�
				System.out.println("*********�鿴�ʹ�*********");
				System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t����״̬");
				//��������
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time = times[i]+"��";
						String sumprice = sumPrices[i]+"Ԫ";
						String state = states[i]==0?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumPrices[i]+"\t"+state);
					}
				}
				break;
			case 3:
				//3.ǩ�ն���   
				System.out.println("***********ǩ�ն���************");
				System.out.print("������Ҫǩ�յĶ�����ţ�");
				int singOrderId = input.nextInt();
				boolean isFind = false;  //��¼�Ƿ��ҵ�����
				for(int i=0;i<names.length;i++){
					if(names[i]!=null && states[i]==1 &&singOrderId==i+1){
						System.out.println("�Բ�����ѡ��Ķ����Ѿ����ǩ��!");
						isFind = true;
						break;
					}else if(names[i]!=null && states[i]==0 &&singOrderId==i+1){
						states[i] = 1;//״̬������Ϊ�����״̬
						System.out.println("����ǩ�ճɹ���");
						break;
					}
				}
				//�����жϣ����û���ҵ�����������ȡ��ʾû���ҵ���
				if(!isFind){
					System.out.println("�Բ��𣬴˶��������ڣ�");
				}
				break;
			case 4:
				//4.ɾ������
				System.out.println("********ɾ������*******");
				System.out.print("������Ҫɾ���Ķ�����ţ�");
				int delId = input.nextInt();
				int delIndex = -1;//ɾ���������±�
				boolean isDelFind = false;//��¼�Ƿ��ҵ���������ture�ҵ�
				//ѭ�� ������������
				for(int i=0;i<names.length;i++){
					if(names[i]!=null && states[i]==1 &&delId==i+1){
						delIndex = i;
						isDelFind=true;
						break;
					}else if(names[i]!=null && states[i]==0 &&delId==i+1){
						System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
						isDelFind=true;
						break;
					}
				}
				//δ�ҵ��˶���
				if(!isDelFind){
					System.out.println("�Բ��𣬴������������ڣ�");
				}
				//ִ��ɾ������
				if(delIndex!=-1){
					for(int i=delIndex+1;i<=names.length-1;i++){
						names[i-1] = names[i];
						dishMegs[i-1] = dishMegs[i];
						times[i-1] = times[i];
						addresses[i-1] =addresses[i];
						states[i-1] = states[i];
					}
					
					names[names.length-1] = null;
					dishMegs[names.length-1] = null;
					times[names.length-1] = 0;
					addresses[names.length-1] = null;
					states[names.length-1] = 0;
					
					System.out.println("����ɾ���ɹ���");
				}
				break;
			case 5:
				//5.��Ҫ����
				System.out.println("*******��Ҫ����*******");
				
				System.out.println("���\t��Ʒ��\t����\t������");
				for(int j=0;j<dishNames.length;j++){
				String price = prices[j]+"Ԫ";
				String praise = praiseNums[j]+"��";
				System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
				
				System.out.print("������Ҫ���޵Ĳ�Ʒ��Ϣ��");
				int dishId = input.nextInt();
				
				praiseNums[dishId-1]++;
				
				System.out.println("���޳ɹ���");
				
				System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"��");
				
				break;
			case 6:
				//6.�˳�ϵͳ
			default:
				break;
			}
			//���û�����ı��Ϊ1~5֮������� �˳�ѭ��  ���򽫻���ʾ����0���ء�
			if(choose<1 || choose>5){
				break;
			}else{
			//����0����
			System.out.print("����0���أ�");
			num = input.nextInt();
			}
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
