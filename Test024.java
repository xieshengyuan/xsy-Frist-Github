import java.util.Scanner;


public class Test024 {
	public static void main(String[] args) {
		String[] names = new String[4];//订餐人
		String[] dishMegs = new String[4];//餐品信息
		int[] times = new int[4];//送餐时间
		String[] addresses = new String[4];//订餐地址
		int[] states = new int[4];//订餐状态 0表示已预订  1表示已完成
		double[] sumPrices = new double[4];//总金额
		
		//初始化2条订单信息
		names[0] = "张青";
		dishMegs[0] = "红烧带鱼  一份";
		times[0] = 12;
		addresses[0] = "天成路   203号";
		states[0] = 1;
		sumPrices[0] = 38.0;
		
		names[1] = "张青";
		dishMegs[1] = "鱼香肉丝  二份";
		times[1] = 12;
		addresses[1] = "天成路   203号";
		states[1] = 0;
		sumPrices[1] = 70.0;
		
		
		//定义第二组数组用来存储餐品信息
		String[] dishNames = {"红烧带鱼","鱼香肉丝","土豆丝" };
		double[] prices = {32.0,35.0,10.0};
		int[] praiseNums = new int[3];
		
		
		Scanner input = new Scanner(System.in);
		int num = -1;//记录用户输入的数字

		do{
			System.out.println("************************");
			System.out.println("1. 我要订餐");
			System.out.println("2. 查看餐袋");
			System.out.println("3. 签收订单");
			System.out.println("4. 删除订单");
			System.out.println("5. 我要点赞");
			System.out.println("6. 退出系统");
			System.out.println("************************");
			
			System.out.print("请选择：");
			int choose = input.nextInt();
			
			
			boolean isAdd = false;//true：记录找到一个为空的位置，可以插入  false：没有找到
			switch(choose){
			case 1:
				//1.我要订餐
				System.out.println("********我要订餐*******");
				//查找需要循环的位置
				for(int i=0;i<names.length;i++){
					//如果找到为空的位置，记录下来
					if(names[i] == null){
						//执行插入操作
						isAdd = true;//记录找到一个为空的位置
						//执行插入操作
						System.out.println("序号\t餐品名\t单价\t点赞数");
						for(int j=0;j<dishNames.length;j++){
						String price = prices[j]+"元";
						String praise = praiseNums[j]+"赞";
						System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						
						}
						//要求输入所选餐品的标号以及份数
						System.out.print("请选择所订餐品序号：");
						int chooseDish = input.nextInt();
						System.out.print("请选择所定份数：");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish-1]+" "+number+"份";
						
						
						//输入订餐人信息
						System.out.print("请输入订餐人姓名：");
						String name = input.next();
						
						//输入送餐时间：
						System.out.print("请输入送餐时间（10~20点整点送餐）：");
						int time = input.nextInt();
						//如果输错了，重复输入
						while(time<10 || time>20){
							System.out.println("对不起，您的输入有误，请重新输入：");
							time = input.nextInt();
						}
						
						//输入送餐地址
						System.out.print("请输入送餐地址：");
						String address = input.next();
						
						//计算餐费
						double sumPrice = prices[chooseDish-1]*number;
						//送餐费当餐费达到50元时面送餐费
						double deliCharge = sumPrice>=50?0.0:6.0;
						
						//显示订单信息
						System.out.println("订餐成功!");
						System.out.println("您订的是："+dishMeg);
						System.out.println("订餐人："+name);
						System.out.println("送餐时间:"+time+"点");
						System.out.println("送餐地址:"+address);
						System.out.println("餐费"+sumPrice+"送餐费："+deliCharge+"元");
						System.out.println("订单总金额："+(sumPrice+deliCharge)+"元");
						
						//保存数据
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice+deliCharge;
						break;
					}
				}
				//如果没有找到为空的位置，则提示信息
				if(!isAdd){
					System.out.println("对不起，您的餐袋已满！");
				}
				break;
			case 2:
				//2.查看餐带
				System.out.println("*********查看餐袋*********");
				System.out.println("序号\t订餐人\t所订餐品信息\t送餐时间\t送餐地址\t\t总金额\t订单状态");
				//遍历数组
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time = times[i]+"点";
						String sumprice = sumPrices[i]+"元";
						String state = states[i]==0?"已预订":"已完成";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumPrices[i]+"\t"+state);
					}
				}
				break;
			case 3:
				//3.签收订单   
				System.out.println("***********签收订单************");
				System.out.print("请输入要签收的订单序号：");
				int singOrderId = input.nextInt();
				boolean isFind = false;  //记录是否找到订单
				for(int i=0;i<names.length;i++){
					if(names[i]!=null && states[i]==1 &&singOrderId==i+1){
						System.out.println("对不起，您选择的订单已经完成签收!");
						isFind = true;
						break;
					}else if(names[i]!=null && states[i]==0 &&singOrderId==i+1){
						states[i] = 1;//状态甚至该为已完成状态
						System.out.println("订单签收成功！");
						break;
					}
				}
				//条件判断，如果没有找到这条订单采取提示没有找到、
				if(!isFind){
					System.out.println("对不起，此订单不存在！");
				}
				break;
			case 4:
				//4.删除订单
				System.out.println("********删除订单*******");
				System.out.print("请输入要删除的订单序号：");
				int delId = input.nextInt();
				int delIndex = -1;//删除订单的下标
				boolean isDelFind = false;//记录是否找到此条订单ture找到
				//循环 查找这条订单
				for(int i=0;i<names.length;i++){
					if(names[i]!=null && states[i]==1 &&delId==i+1){
						delIndex = i;
						isDelFind=true;
						break;
					}else if(names[i]!=null && states[i]==0 &&delId==i+1){
						System.out.println("你选择的订单未签收，不能删除！");
						isDelFind=true;
						break;
					}
				}
				//未找到此订单
				if(!isDelFind){
					System.out.println("对不起，此条订单不存在！");
				}
				//执行删除操作
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
					
					System.out.println("订单删除成功！");
				}
				break;
			case 5:
				//5.我要点赞
				System.out.println("*******我要点赞*******");
				
				System.out.println("序号\t餐品名\t单价\t点赞数");
				for(int j=0;j<dishNames.length;j++){
				String price = prices[j]+"元";
				String praise = praiseNums[j]+"赞";
				System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
				
				System.out.print("请输入要点赞的餐品信息：");
				int dishId = input.nextInt();
				
				praiseNums[dishId-1]++;
				
				System.out.println("点赞成功！");
				
				System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"赞");
				
				break;
			case 6:
				//6.退出系统
			default:
				break;
			}
			//当用户输入的编号为1~5之外的数字 退出循环  否则将会提示输入0返回。
			if(choose<1 || choose>5){
				break;
			}else{
			//输入0返回
			System.out.print("输入0返回：");
			num = input.nextInt();
			}
		}while(num==0);
		System.out.println("谢谢使用，欢迎下次光临！");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
