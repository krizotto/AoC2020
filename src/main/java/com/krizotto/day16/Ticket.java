package com.krizotto.day16;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
   private final List<Integer> ticketNumbers = new ArrayList<>();
   private boolean isValid;

   public Ticket() {
      this(true);
   }

   private Ticket(boolean isValid) {
      this.isValid = isValid;
   }

   public List<Integer> getTicketNumbers() {
      return ticketNumbers;
   }

   public boolean isValid() {
      return isValid;
   }

   public void setValid(boolean valid) {
      isValid = valid;
   }
}
