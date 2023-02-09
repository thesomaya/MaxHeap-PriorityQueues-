class Patient {
	private int priority;
	private String name;
	private String diagnose;
	
	public Patient(int priority, String name, String diagnose) {
		super();
		this.priority = priority;
		this.name = name;
		this.diagnose = diagnose;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	@Override
	public String toString() {
		return "Patient [priority=" + priority + ", name=" + name + ", diagnose=" + diagnose + "]";
	}
	
}

class heap {
	private static Patient arr[];
	private static int size;
	
	public heap (int n) {
		arr = new Patient [n];
		size = 0;
	}
	
	public void insert (int priority, String name, String diagnose) {
		if (size == 100)
			return;
		arr[size] = new Patient (priority,name,diagnose);
		size++;
		heapUp(size-1);
	}
	
	public void heapUp (int i) {
		if (i == 0)
			return;
		int p = (i-1) / 2; //parent node
		if (arr[i].getPriority() > arr[p].getPriority()) {
			Patient temp = arr[i];
			arr[i] = arr[p];
			arr[p] = temp;
			heapUp(p);
		}
		
	}
	
	public Patient delete() {
		Patient temp = arr[0];
		arr[0] = arr[size-1];
		size--;
		heapDown(0);
		return temp;
	}
	
	public void heapDown (int i) {
		int max = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < size && arr[l].getPriority() > arr[max].getPriority())
			max = l;
		if (r < size && arr[r].getPriority() > arr[max].getPriority())
			max = r;
		if (max != i) {
			Patient temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			heapDown(max);
		}
	}
	
	public void print() {
		for (int i = 0; i < size; i++)
			System.out.println(arr[i]);
	}
}

public class Main {
	public static void main (String args[]) {
		heap h = new heap(10);
		h.delete();
		h.insert(10, "a", "accident");
		h.insert(8, "m", "flu");
		h.insert(4, "y", "cold");
		h.insert(5, "r", "stomach ache");
		h.insert(20, "m", "skin rash");
		h.print();
	}
}
