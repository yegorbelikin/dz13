package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {


    @Test
    public void compareToFirstMoreSecond() {
        Ticket ticket1 = new Ticket("DME", "GDX", 10_000, 10, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 5_000, 1, 5);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void compareToFirstLessSecond() {
        Ticket ticket1 = new Ticket("DME", "GDX", 5_000, 10, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 15_000, 1, 5);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void compareToFirstEqSecond() {
        Ticket ticket1 = new Ticket("DME", "GDX", 5_000, 10, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 5_000, 1, 5);

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void SortToPriceFewTicket() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("DME", "GDX", 10_000, 10, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 5_000, 1, 5);
        Ticket ticket3 = new Ticket("DME", "GDX", 5_000, 12, 15);
        Ticket ticket4 = new Ticket("VVO", "AAQ", 30_000, 0, 20);
        Ticket ticket5 = new Ticket("DME", "GDX", 1_000, 21, 22);
        Ticket ticket6 = new Ticket("ROV", "SVO", 15_000, 6, 13);

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);


        Ticket[] expected = {ticket5, ticket2, ticket3, ticket1};
        Ticket[] actual = avia.search("DME", "GDX");


        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void SortToPriceOneTickt() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("DME", "GDX", 10_000, 10, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 5_000, 1, 5);
        Ticket ticket3 = new Ticket("DME", "GDX", 6_000, 12, 15);
        Ticket ticket4 = new Ticket("VVO", "AAQ", 30_000, 0, 20);
        Ticket ticket5 = new Ticket("DME", "GDX", 1_000, 21, 22);
        Ticket ticket6 = new Ticket("ROV", "SVO", 15_000, 6, 13);

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);


        Ticket[] expected = {ticket4};
        Ticket[] actual = avia.search("VVO", "AAQ");


        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void SortToPriceNoTickt() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("DME", "GDX", 10_000, 10, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 5_000, 1, 5);
        Ticket ticket3 = new Ticket("DME", "GDX", 6_000, 12, 15);
        Ticket ticket4 = new Ticket("VVO", "AAQ", 30_000, 0, 20);
        Ticket ticket5 = new Ticket("DME", "GDX", 1_000, 21, 22);
        Ticket ticket6 = new Ticket("ROV", "SVO", 15_000, 6, 13);

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);


        Ticket[] expected = {};
        Ticket[] actual = avia.search("VVZ", "AAQ");


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void comparatorFlyTimeFirstMoreSecond() {
        Ticket ticket1 = new Ticket("DME", "GDX", 2_000, 10, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 5_000, 1, 5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        int expected = 1;
        int actual = comparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void comparatorFlyTimeFirstLessSecond() {
        Ticket ticket1 = new Ticket("DME", "GDX", 10_000, 22, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 5_000, 1, 5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        int expected = -1;
        int actual = comparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void comparatorFlyTimeFirstEqSecond() {
        Ticket ticket1 = new Ticket("DME", "GDX", 10_000, 19, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 5_000, 1, 5);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        int expected = 0;
        int actual = comparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void SortToFlyTimeFewTicket() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("DME", "GDX", 10_000, 10, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 5_000, 1, 5);
        Ticket ticket3 = new Ticket("DME", "GDX", 6_000, 11, 15);
        Ticket ticket4 = new Ticket("VVO", "AAQ", 30_000, 0, 20);
        Ticket ticket5 = new Ticket("DME", "GDX", 1_000, 21, 22);
        Ticket ticket6 = new Ticket("ROV", "SVO", 15_000, 6, 13);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);


        Ticket[] expected = {ticket5, ticket2, ticket3, ticket1};
        Ticket[] actual = avia.searchAndSortBy("DME", "GDX", comparator);


        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void SortToFlyTimeOneTickt() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("DME", "GDX", 10_000, 10, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 5_000, 1, 5);
        Ticket ticket3 = new Ticket("DME", "GDX", 6_000, 12, 15);
        Ticket ticket4 = new Ticket("VVO", "AAQ", 30_000, 0, 20);
        Ticket ticket5 = new Ticket("DME", "GDX", 1_000, 21, 22);
        Ticket ticket6 = new Ticket("ROV", "SVO", 15_000, 6, 13);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);


        Ticket[] expected = {ticket4};
        Ticket[] actual = avia.searchAndSortBy("VVO", "AAQ", comparator);


        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void SortToFlyTimeNoTickt() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("DME", "GDX", 10_000, 10, 23);
        Ticket ticket2 = new Ticket("DME", "GDX", 5_000, 1, 5);
        Ticket ticket3 = new Ticket("DME", "GDX", 6_000, 12, 15);
        Ticket ticket4 = new Ticket("VVO", "AAQ", 30_000, 0, 20);
        Ticket ticket5 = new Ticket("DME", "GDX", 1_000, 21, 22);
        Ticket ticket6 = new Ticket("ROV", "SVO", 15_000, 6, 13);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);


        Ticket[] expected = {};
        Ticket[] actual = avia.searchAndSortBy("VVZ", "AAQ", comparator);


        Assertions.assertArrayEquals(expected, actual);

    }

}





