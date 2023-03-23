package apps;

import java.util.Iterator;

import adts.DLLList;

public class DLLPlay {

	public static void main(String[] args) {
		DLLList<Integer> list = new DLLList<>();
		
		System.out.println("\nIs the new list empty? " + list.isEmpty());
		
        list.add(6);
        list.add(2);
        list.add(1);
        list.add(9);

        System.out.println("\nList of numbers: " + list);
        System.out.println("\nIs empty?" + list.isEmpty());
        
        list.remove(1);
        System.out.println("\nList after remove: " + list);
        System.out.println("\nSize of the list after remove: " + list.size());
        System.out.println("\nGet 2nd item: " + list.get(1));
        System.out.println("\nGet element at index 6: " + list.get(6));
        System.out.println("\nList contains 2: " + list.contains(2));
       
           
        list.setForwardIteration();
        System.out.println("\nList in order: ");
        Iterator<Integer> fwdIt = list.iterator();
        while (fwdIt.hasNext()) {
            System.out.print(fwdIt.next() + " ");
        }
        System.out.println("\n");
        
        list.setReverseIteration();
        System.out.println("List in reverse: ");
        Iterator<Integer> revIt = list.iterator();
        while (revIt.hasNext()) {
            System.out.print(revIt.next() + " ");
        }
        System.out.println("\n");
       
        list.setForwardReverseIteration();
        System.out.println("List in order, then in reverse: ");
        for (Integer item : list) {
            System.out.print(item + " ");
        


        }
	}
}
