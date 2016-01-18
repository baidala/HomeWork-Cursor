package dbms;

import java.util.HashMap;

public interface CursorFase {

	    public HashMap<String, String> getItem(int pos);
	    public void createItem(String[] values);
	    public void select();
	    public void update(int pos, String[] values);
	    public void delete(int pos);
	    public void insert(int pos, String[] values);
	    public boolean isLast();
	    

}
