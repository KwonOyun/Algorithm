
public class PhoneBook {
	
	Person start;
	
	public PhoneBook() {
		
	}
	public void insert(String name, String number) {
		if(start==null) {
			start = new Person(name, number, null);
		}
		else if(start.name.compareTo(name)>0) {
			Person p = new Person(name, number, start);
			start = p;	
		}
		else {
			Person p = start;
			while(p.next!=null) {
				if(p.next.name.compareTo(name)>0) break;
				p = p.next;
			}
			p.next = new Person(name, number, p.next);
		}	
	}
	public void print() {
		Person p = start;
		int index=1;
		while(p!=null) {
			System.out.println(index+" : "+p.name+" "+p.number);
			p = p.next;
			index++;
		}
	}
	
	class Person{
		
		String name;
		String number;
		Person next;
		
		public Person(String name, String number, Person next) {
			this.name = name;
			this.number = number;
			this.next = next;
		}
		
	}
}
