package com.krizotto.day16;

import com.krizotto.utils.Input;
import com.krizotto.utils.Solution;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class day16 extends Solution {
   private final List<String> input = Input.getLineInput(path);

   @Override
   public Object part1() {
      Validator ticketValidator = prepareValidator();
//      Ticket myTicket = getMyTicket();
      List<Ticket> nearbyTickets = getNearbyTickets();
      ticketValidator.validatePart1(nearbyTickets);

      return ticketValidator.getScanningErrorRate();
   }

   @Override
   public Object part2() {
      return null;
   }

   private Validator prepareValidator() {
      Validator v = new Validator();
      v.getTicketClass().addAll(getRange("class"));
      v.getTicketRow().addAll(getRange("row"));
      v.getTicketSeat().addAll(getRange("seat"));
      v.getTicketDepartureLocation().addAll(getRange("departure location"));
      v.getTicketDepartureStation().addAll(getRange("departure station"));
      v.getTicketDeparturePlatform().addAll(getRange("departure platform"));
      v.getTicketDepartureTrack().addAll(getRange("departure track"));
      v.getTicketDepartureDate().addAll(getRange("departure date"));
      v.getTicketDepartureTime().addAll(getRange("departure time"));
      v.getTicketArrivalLocation().addAll(getRange("arrival location"));
      v.getTicketArrivalStation().addAll(getRange("arrival station"));
      v.getTicketArrivalPlatform().addAll(getRange("arrival platform"));
      v.getTicketArrivalTrack().addAll(getRange("arrival track"));
      v.getTicketDuration().addAll(getRange("duration"));
      v.getTicketPrice().addAll(getRange("price"));
      v.getTicketRoute().addAll(getRange("route"));
      v.getTicketTrain().addAll(getRange("train"));
      v.getTicketType().addAll(getRange("type"));
      v.getTicketWagon().addAll(getRange("wagon"));
      v.getTicketZone().addAll(getRange("zone"));
      return v;
   }

   private Set<Integer> getRange(String parameterName) {
      Set<Integer> outputSet = new LinkedHashSet<>();
      for (String s : input) {
         final String[] split = s.split(":");
         if (split[0].equals(parameterName)) {
            final String[] ranges = split[1].split(" ");
            for (String range : ranges) {
               if (!range.equals("or") && !range.equals("")) {
                  final String[] numbers = range.split("-");
                  int left = Integer.parseInt(numbers[0]);
                  int right = Integer.parseInt(numbers[1]);
                  outputSet.addAll(IntStream.range(left, right + 1).boxed().collect(Collectors.toSet()));
               }
            }
            break;
         }
      }
      return outputSet;
   }


   private Ticket getMyTicket() {
      Ticket ticket = new Ticket();
      for (int i = 0; i < input.size(); i++) {
         if (input.get(i).equals("your ticket:")) {
            List<Integer> numbers = new ArrayList<>();
            for (String s : input.get(i + 1).split(",")) {
               numbers.add(Integer.parseInt(s));
            }
            ticket.getTicketNumbers().addAll(numbers);
         }
      }
      return ticket;
   }


   private List<Ticket> getNearbyTickets() {
      List<Ticket> ticketList = new ArrayList<>();
      for (int i = 0; i < input.size(); i++) {
         if (input.get(i).equals("nearby tickets:")) {
            for (int j = i + 1; j < input.size(); j++) {
               Ticket ticket = new Ticket();
               List<Integer> numbers = new ArrayList<>();
               for (String s : input.get(j).split(",")) {
                  numbers.add(Integer.parseInt(s));
               }
               ticket.getTicketNumbers().addAll(numbers);
               ticketList.add(ticket);
            }
         }
      }
      return ticketList;
   }

}
