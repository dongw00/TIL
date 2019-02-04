public class ArrayList {
	final static int MAX_SIZE = 100;
	private int[] data;
	int length;

	public ArrayList() {
		super();
		this.length = 0;
		data = new int[MAX_SIZE];
	}

	public ArrayList(int size) {
		this.length = 0;
		data = new int[size];
	}

	/* add element */
	public void add(int data) {
		int size = this.data.length;

		if (this.length == size)
			copyArray(data, size);
		else
			this.data[this.length] = data;
		this.length++;
	}

	public void remove() {
		if (this.length == 0)
			throw new ArrayIndexOutOfBoundsException();
		this.data[this.length - 1] = 0;
		this.length--;
	}

	public void copyArray(int data, int size) {
		System.out.println("Expand array size");
		int newSize = size * 2;
		int[] newArray = new int[newSize];

		newArray[newSize / 2] = data;

		for (int i = 0; i < size; i++)
			newArray[i] = this.data[i];

		this.data = new int[newSize];

		for (int i = 0; i < newArray.length; i++)
			this.data[i] = newArray[i];
	}
}
