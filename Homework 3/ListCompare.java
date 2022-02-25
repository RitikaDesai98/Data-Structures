import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

public class ListCompare{
    ArrayList<Integer> list = new ArrayList<Integer>();
    LinkedList<Integer> myList = new LinkedList<Integer>();
    long startTime;
    long endTime;

    public void addList()
    {
        startTime = Calendar.getInstance().getTimeInMillis();
        for(int i=0; i < 100000; i++)
            {
                list.add(i);
            }
        endTime = Calendar.getInstance().getTimeInMillis();

        System.out.println("ArrayList Add: " + (endTime - startTime));

        startTime = Calendar.getInstance().getTimeInMillis();
        for(int j=0; j < 100000; j++)
            {
                myList.add(j);
            }
        endTime = Calendar.getInstance().getTimeInMillis();

        System.out.println("LinkedList Add: " + (endTime - startTime));
    }

    public void getList()
    {
        startTime = Calendar.getInstance().getTimeInMillis();
        for(int i=0; i < list.size(); i++)
            {
                list.get(i);
            }
        endTime = Calendar.getInstance().getTimeInMillis();

        System.out.println("ArrayList Get: " + (endTime - startTime));

        startTime = Calendar.getInstance().getTimeInMillis();
        for(int j=0; j < myList.size(); j++)
            {
                myList.get(j);
            }
        endTime = Calendar.getInstance().getTimeInMillis();

        System.out.println("LinkedList Get: " + (endTime - startTime));

    }

    public void removeList()
    {
        startTime = Calendar.getInstance().getTimeInMillis();
        for(int i=0; i < list.size(); i++)
            {
                list.remove(i);
            }
        endTime = Calendar.getInstance().getTimeInMillis();

        System.out.println("ArrayList Remove: " + (endTime - startTime));

        startTime = Calendar.getInstance().getTimeInMillis();
        for(int j=0; j < myList.size(); j++)
            {
                myList.remove(j);
            }
        endTime = Calendar.getInstance().getTimeInMillis();

        System.out.println("LinkedList Remove: " + (endTime - startTime));

    }

public static void main(String[] args) {

    ListCompare lc = new ListCompare();

    lc.addList();
    lc.getList();
    lc.removeList();

    }
}
