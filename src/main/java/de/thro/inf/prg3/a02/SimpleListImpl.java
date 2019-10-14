package de.thro.inf.prg3.a02;
//import java.util.Iterator;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {

    Element head;

    private int zaehler = 0;

    class Element{
        Object item;
        Element next;

        Element(Object item, Element next){
            this.item = item;
            this.next = next;
        }
    }

    class SimpleIteratorImpl implements Iterator {

        Element current;

        public SimpleIteratorImpl() {
            current = head;
        }

        @Override
        public boolean hasNext(){

            return this.current.next != null;

        }

        public Object next(){

           Object save = this.current.item;

           current = this.current.next;

           return save;
        }
    }

    @Override
    public void add(Object o) {

        Element zeiger = head;

        Element element_o = new Element(o, null);

        if(head==null){
            head =element_o;
            this.zaehler++;
        }else{
            while(zeiger.next!=null){
                System.out.println("Element");
                zeiger = zeiger.next;
            }
            this.zaehler++;
            zeiger.next = element_o;
        }

    }

    @Override
    public int size() {
        return this.zaehler;
    }

    @Override
    /**
     * Generate a new list using the given filter instance.
     * @return a new, filtered list
     */
    public SimpleList filter(SimpleFilter filter) {

        SimpleListImpl temp_liste = new SimpleListImpl();

        for (Object o : this) {
            if (filter.include(o)) {
                temp_liste.add(o);
            }
        }
        return temp_liste;
    }

    @Override
    public boolean include(Object item) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return new SimpleIteratorImpl();
    }
    // TODO: Implement the required methods.

}
