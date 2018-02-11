
public class ArrayQueue implements Queue {

	Object queue[];  //queue에 사용할 배열
	int size;   //queue에 저장된 원소의 개수
	int queueSize;  //queue의 초기 크기

	public ArrayQueue(int queueSize) {
		this.queue = new Object[queueSize];
		this.queueSize = queueSize;
	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		queue[size++] = object;
		System.out.print("ADD      "+object+"  |  ");
		print();
		if(size==queueSize) {
			System.out.println("Queue is Full! RESIZE");
			resize();
		}

	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return queue[0];
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		size--;
		if(size==0) {
			System.out.println("REMOVE   "+queue[0]+"  |  ");
		}
		else if(size<0) {
			System.out.println("Queue is Empty");
			size++;
		}
		else {
			System.out.print("REMOVE   "+queue[0]+"  |  ");
			for(int i=0; i<size; i++) {
				queue[i] = queue[i+1];
			}
			print();
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print(queue[0]);
		for(int i=1; i<size; i++) {
			System.out.print("<--"+queue[i]);
		}
		System.out.println();
	}

	@Override
	public void resize() {
		// TODO Auto-generated method stub
		Object resizequeue[] = new Object[queueSize];
		for(int i=0; i<queueSize; i++) {
			resizequeue[i] = queue[i];
		}
		queue = new Object[2*queueSize];
		System.arraycopy(resizequeue, 0, queue, 0, queueSize);
	}

}
