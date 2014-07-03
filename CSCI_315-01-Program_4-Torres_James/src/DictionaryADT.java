//************************************************************
//  DictionaryADT.java      Author: Kathryn Sanders
//
//
//************************************************************

public interface DictionaryADT {
   public void insert (String key, Destination value);
   public boolean delete (String key);
   public Destination find (String key);
   public boolean isEmpty();
   public int size();
   public String toString();
 }
