package com.krizotto.day16;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Validator {
   private final Set<Integer> ticketDepartureLocation = new LinkedHashSet<>();
   private final Set<Integer> ticketDepartureStation = new LinkedHashSet<>();
   private final Set<Integer> ticketDeparturePlatform = new LinkedHashSet<>();
   private final Set<Integer> ticketDepartureTrack = new LinkedHashSet<>();
   private final Set<Integer> ticketDepartureDate = new LinkedHashSet<>();
   private final Set<Integer> ticketDepartureTime = new LinkedHashSet<>();
   private final Set<Integer> ticketArrivalLocation = new LinkedHashSet<>();
   private final Set<Integer> ticketArrivalStation = new LinkedHashSet<>();
   private final Set<Integer> ticketArrivalPlatform = new LinkedHashSet<>();
   private final Set<Integer> ticketArrivalTrack = new LinkedHashSet<>();
   private final Set<Integer> ticketClass = new LinkedHashSet<>();
   private final Set<Integer> ticketDuration = new LinkedHashSet<>();
   private final Set<Integer> ticketPrice = new LinkedHashSet<>();
   private final Set<Integer> ticketRoute = new LinkedHashSet<>();
   private final Set<Integer> ticketRow = new LinkedHashSet<>();
   private final Set<Integer> ticketSeat = new LinkedHashSet<>();
   private final Set<Integer> ticketTrain = new LinkedHashSet<>();
   private final Set<Integer> ticketType = new LinkedHashSet<>();
   private final Set<Integer> ticketWagon = new LinkedHashSet<>();
   private final Set<Integer> ticketZone = new LinkedHashSet<>();
   private final String[] properties = new String[20];

   private int invalidTickets = 0;
   private int scanningErrorRate = 0;

   public void validatePart2() {
      /*
      Plan:
      - get every n-th number to Set
      - for every property check if all of the numbers matches the range
      - save property to corresponding place in List
       */
   }

   public void validatePart1(List<Ticket> ticketList) {
      for (Ticket ticket : ticketList) {
         validatePart1(ticket);
      }
   }

   //easyValidate
   public void validatePart1(Ticket t) {
      boolean isValid = true;
      Set<Integer> common = new LinkedHashSet<>();
      common.addAll(ticketDepartureLocation);
      common.addAll(ticketDepartureStation);
      common.addAll(ticketDeparturePlatform);
      common.addAll(ticketDepartureTrack);
      common.addAll(ticketDepartureDate);
      common.addAll(ticketDepartureTime);
      common.addAll(ticketArrivalLocation);
      common.addAll(ticketArrivalStation);
      common.addAll(ticketArrivalPlatform);
      common.addAll(ticketArrivalTrack);
      common.addAll(ticketClass);
      common.addAll(ticketDuration);
      common.addAll(ticketPrice);
      common.addAll(ticketRoute);
      common.addAll(ticketRow);
      common.addAll(ticketSeat);
      common.addAll(ticketTrain);
      common.addAll(ticketType);
      common.addAll(ticketWagon);
      common.addAll(ticketZone);
      for (Integer num : t.getTicketNumbers()) {
         if (!common.contains(num)) {
            isValid = false;
            scanningErrorRate += num;
            break;
         }
      }
      if (!isValid) {
         invalidTickets++;

      }
      t.setValid(isValid);
   }

   //Getters
   public Set<Integer> getTicketClass() {
      return ticketClass;
   }

   public Set<Integer> getTicketRow() {
      return ticketRow;
   }

   public Set<Integer> getTicketSeat() {
      return ticketSeat;
   }

   public int getInvalidTickets() {
      return invalidTickets;
   }

   public int getScanningErrorRate() {
      return scanningErrorRate;
   }

   public Set<Integer> getTicketDepartureLocation() {
      return ticketDepartureLocation;
   }

   public Set<Integer> getTicketDepartureStation() {
      return ticketDepartureStation;
   }

   public Set<Integer> getTicketDeparturePlatform() {
      return ticketDeparturePlatform;
   }

   public Set<Integer> getTicketDepartureTrack() {
      return ticketDepartureTrack;
   }

   public Set<Integer> getTicketDepartureDate() {
      return ticketDepartureDate;
   }

   public Set<Integer> getTicketDepartureTime() {
      return ticketDepartureTime;
   }

   public Set<Integer> getTicketArrivalLocation() {
      return ticketArrivalLocation;
   }

   public Set<Integer> getTicketArrivalStation() {
      return ticketArrivalStation;
   }

   public Set<Integer> getTicketArrivalPlatform() {
      return ticketArrivalPlatform;
   }

   public Set<Integer> getTicketArrivalTrack() {
      return ticketArrivalTrack;
   }

   public Set<Integer> getTicketDuration() {
      return ticketDuration;
   }

   public Set<Integer> getTicketPrice() {
      return ticketPrice;
   }

   public Set<Integer> getTicketRoute() {
      return ticketRoute;
   }

   public Set<Integer> getTicketTrain() {
      return ticketTrain;
   }

   public Set<Integer> getTicketType() {
      return ticketType;
   }

   public Set<Integer> getTicketWagon() {
      return ticketWagon;
   }

   public Set<Integer> getTicketZone() {
      return ticketZone;
   }
}
