package pro.vinyard.dofus.map.helper.model;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;

import pro.vinyard.dofus.map.helper.Hint;

public class IndicesModel extends DefaultListModel<Hint> {

	private static final long serialVersionUID = 1L;

	private Vector<Hint> delegate = new Vector<Hint>();
	
	public void setIndices(List<Hint> indices) {
		this.delegate = new Vector<Hint>(indices);
		this.fireContentsChanged(this, 0, indices.size());
	}
	
	@Override
    public int getSize() {
        return delegate.size();
    }

    @Override
    public Hint getElementAt(int index) {
        return delegate.elementAt(index);
    }

    @Override
    public void copyInto(Object anArray[]) {
        delegate.copyInto(anArray);
    }

    @Override
    public void trimToSize() {
        delegate.trimToSize();
    }

    @Override
    public void ensureCapacity(int minCapacity) {
        delegate.ensureCapacity(minCapacity);
    }

    @Override
    public void setSize(int newSize) {
        int oldSize = delegate.size();
        delegate.setSize(newSize);
        if (oldSize > newSize) {
            fireIntervalRemoved(this, newSize, oldSize-1);
        }
        else if (oldSize < newSize) {
            fireIntervalAdded(this, oldSize, newSize-1);
        }
    }

    @Override
    public int capacity() {
        return delegate.capacity();
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public Enumeration<Hint> elements() {
        return delegate.elements();
    }

    @Override
    public boolean contains(Object elem) {
        return delegate.contains(elem);
    }

    @Override
    public int indexOf(Object elem) {
        return delegate.indexOf(elem);
    }

    @Override
     public int indexOf(Object elem, int index) {
        return delegate.indexOf(elem, index);
    }

     @Override
    public int lastIndexOf(Object elem) {
        return delegate.lastIndexOf(elem);
    }

    @Override
    public int lastIndexOf(Object elem, int index) {
        return delegate.lastIndexOf(elem, index);
    }

    @Override
    public Hint elementAt(int index) {
        return delegate.elementAt(index);
    }

    @Override
    public Hint firstElement() {
        return delegate.firstElement();
    }

    @Override
    public Hint lastElement() {
        return delegate.lastElement();
    }

    @Override
    public void setElementAt(Hint element, int index) {
        delegate.setElementAt(element, index);
        fireContentsChanged(this, index, index);
    }

    @Override
    public void removeElementAt(int index) {
        delegate.removeElementAt(index);
        fireIntervalRemoved(this, index, index);
    }

    @Override
    public void insertElementAt(Hint element, int index) {
        delegate.insertElementAt(element, index);
        fireIntervalAdded(this, index, index);
    }

    @Override
    public void addElement(Hint element) {
        int index = delegate.size();
        delegate.addElement(element);
        fireIntervalAdded(this, index, index);
    }

    @Override
    public boolean removeElement(Object obj) {
        int index = indexOf(obj);
        boolean rv = delegate.removeElement(obj);
        if (index >= 0) {
            fireIntervalRemoved(this, index, index);
        }
        return rv;
    }


    @Override
    public void removeAllElements() {
        int index1 = delegate.size()-1;
        delegate.removeAllElements();
        if (index1 >= 0) {
            fireIntervalRemoved(this, 0, index1);
        }
    }


    @Override
   public String toString() {
        return delegate.toString();
    }


    @Override
    public Object[] toArray() {
        Object[] rv = new Object[delegate.size()];
        delegate.copyInto(rv);
        return rv;
    }

    @Override
    public Hint get(int index) {
        return delegate.elementAt(index);
    }

    @Override
    public Hint set(int index, Hint element) {
    	Hint rv = delegate.elementAt(index);
        delegate.setElementAt(element, index);
        fireContentsChanged(this, index, index);
        return rv;
    }

    @Override
    public void add(int index, Hint element) {
        delegate.insertElementAt(element, index);
        fireIntervalAdded(this, index, index);
    }

    @Override
    public Hint remove(int index) {
    	Hint rv = delegate.elementAt(index);
        delegate.removeElementAt(index);
        fireIntervalRemoved(this, index, index);
        return rv;
    }

    @Override
    public void clear() {
        int index1 = delegate.size()-1;
        delegate.removeAllElements();
        if (index1 >= 0) {
            fireIntervalRemoved(this, 0, index1);
        }
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex must be <= toIndex");
        }
        for(int i = toIndex; i >= fromIndex; i--) {
            delegate.removeElementAt(i);
        }
        fireIntervalRemoved(this, fromIndex, toIndex);
    }

    /*
    public void addAll(Collection c) {
    }

    public void addAll(int index, Collection c) {
    }
    */
	
}
