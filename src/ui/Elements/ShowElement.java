package ui.Elements;

import models.Vendor;

public interface ShowElement<T> {
   void viewElement(T model);
   void viewTableHeader();
   void viewLine(T model);
   void viewTableName();
}
