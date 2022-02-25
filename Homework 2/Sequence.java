import java.util.Scanner;

public class Sequence<E>{
    protected Object[] data;
    protected int size;

    public Sequence(int n) throws IllegalArgumentException{
        if(n<0){
            throw new IllegalArgumentException();}
        this.data=new Object[n];
        this.size=0;
    }

    public int size(){
        return this.size;
    }

    public void append(E element){            
        if(this.size<this.data.length){
            this.data[this.size]=element;
        }
        else{
            Object[] temp=new Object[this.size+1];
            System.arraycopy(this.data, 0, temp, 0, this.size);
            this.data=temp;
            this.data[this.size]=element;
        }
        this.size++;    
    }

    public Object get(int k) throws IndexOutOfBoundsException{
            if(k<0 || k>=this.size){
                throw new IndexOutOfBoundsException();}
            return this.data[k];
    }

	public void print(){
		System.out.print("\nCurrent Sequence: ");
		for(int i=0;i<this.size();i++){
            System.out.print(this.get(i)+" ");
        }
		System.out.println();
	}
	
    public void insert(int index, E newElement){
        Object[] temp = new Object[this.size + 1];
 
        System.arraycopy(this.data, 0, temp, 0, index);
        temp[index] = newElement;
        System.arraycopy(this.data, index, temp, index + 1, this.size - index);
        this.data = temp;
        this.size++;
    }

	public void delete(int index){
        Object[] temp = new Object[this.size - 1];
  
        for (int i = 0, k = 0; i < this.size; i++) {

            if (i == index) {
                continue;
            }

            temp[k++] = this.data[i];
        }
        this.data = temp;
        this.size--;
	}
	
    public static void main (String[] args){
        int input, index, newElement;
		Scanner in = new Scanner(System.in);
		Sequence<Integer> s = new Sequence<Integer>(5);
		s.append(1);
		s.append(2);
		s.append(3);
		s.append(4);
		s.append(5);
		s.print();
		
        while(true){
        System.out.println("Please enter 1 to insert, 2 to delete, or 3 to quit");
        input = in.nextInt();
        if(input == 1)
        {
            System.out.println("Please enter the value to be inserted");
            newElement = in.nextInt();
            System.out.println("Please enter the index to be inserted at");
            index = in.nextInt();
            s.insert(index, newElement);
            s.print();                       
        }
        else if(input == 2)
        {
            System.out.println("Please enter the index to be deleted at");
            index = in.nextInt();
            s.delete(index);
            s.print();
        }
        else if(input == 3){
            System.out.println("Goodbye");
            System.exit(0);
        }
        else{
            System.out.println("Invalid Choice");
        }  
    }
		
    }   //End main
}   //End class