package jagu7_2018;

public class Simulation {

	static int numServers;
	static int numClients;
	static int meanServiceTime;
	static int meanInterarrivalTime;
	static SimServer[] servers;
	static Client[] clients;
	static Queue queue = new SLinkedQueue();
	static java.util.Random randomArrival;
	static java.util.Random randomService;
	static int[] exectimes;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init(args);

		// ������ 6.3 ����
		run(); // ���� �ؾ� �� ��.
	}

	static void init(String[] args) {
		if(args.length < 4) {
			System.out.println("Usage : java Simulation <numServers> "  
					+ "<numClients> <meanServiceTime> <meanInterarrivalTime> ");
			System.out.println(" e.g.: java Simulation 3 100 12 4");
			System.exit(0);
		}

		numServers = Integer.parseInt(args[0]);
		numClients = Integer.parseInt(args[1]);
		meanServiceTime = Integer.parseInt(args[2]);
		meanInterarrivalTime = Integer.parseInt(args[3]);

		servers = new SimServer[numServers];
		clients = new Client[numClients];
		exectimes = new int[numClients];
		randomService = new ExponentialRandom(meanServiceTime);
		randomArrival = new ExponentialRandom(meanInterarrivalTime);
		queue = new SLinkedQueue();

		for(int j=0; j<numServers; j++) {
			servers[j] = new SimServer(j, randomService.nextInt());		
		}

		System.out.println("	Number of servers = " + numServers);
		System.out.println("	Number of clients = " + numClients);
		System.out.println("	Mean service time = " + meanServiceTime);
		System.out.println("	Mean interarrival time = " + meanInterarrivalTime);

		for(int j=0; j<numServers; j++) {		
			System.out.println("Mean service time for " + servers[j] + "=" + servers[j].getMeanServiceTime());
		}
	}

	static void run() {
		int i=0;
		int execindex=0;  //실행시간 배열의 인덱스
		int nextArrivalTime = randomArrival.nextInt();  //시작시간
		for(int t=0; ;t++) {

			if(t==nextArrivalTime && i<numClients) {
				Client client = clients[i] = new SimClient(i, t);  //클라이언트 생성
				i++;  //인덱스 증가
				queue.add(client);  //큐에 추가
				nextArrivalTime = t+randomArrival.nextInt();  //다음 도착 값 설정
			}
			
			for(int j=0; j<numServers; j++) {  //각 서버의 상태를 체크
				Server server = servers[j];  
				if(t==server.getStopTime()) server.stopServing(t);  //종료시간이 같으면 서버 종료
				if(server.isIdle() && !queue.empty()) {  //서버가 유후상태일 경우 클라이언트 입력
					Client client = (SimClient)queue.remove();  //큐에서 클라이언트 제거
					server.startServing(client, t);  //서버의 클라이언트에 대한 서비스 시작
					exectimes[execindex++] = server.GetExecutionTime();  //실행시간들의 배열에 클라이언트의 실행시간 입력
				}
			}
			int count =0;
			for(int j=0; j<numServers; j++) {   //각 서버의 상태 체크
				Server server = servers[j];
				if(server.isIdle()) count++; //모든 서버가 유후상태일 경우를 체크
			}
			if(t>nextArrivalTime && count==numServers) break;  //모든 클라이언트의 서비스가 끝났을 경우 break;
		}
		int sum=0;
		for(int a=0; a<execindex; a++) {  //평균계산
			sum +=exectimes[a];
		}
		System.out.println(sum/execindex); //실행시간 평균 출력
	}
}
