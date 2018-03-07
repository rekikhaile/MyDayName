package com.rekik.mydayname;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class DayName {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate thedate;

    private String femalename;

    private String malename;

    private DayOfWeek theday; // to get enum values

    private String thezodiac;

    private String theanimal;

    public DayName() {
    }

    public DayName(String adate) {


        DateTimeFormatter dateEnteredFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        thedate = LocalDate.parse(adate, dateEnteredFormat);

        theday = thedate.getDayOfWeek();

        namesList();
    }

    public String fullDateFormat()
    {
        DateTimeFormatter myFullDate = DateTimeFormatter.ofPattern("EEEE dd MMM yyyy");
        return thedate.format(myFullDate);
    }

    private void namesList() {
        switch (theday){
            case MONDAY:
                setFemalename("Adjoa");
                setMalename("Kojo");
                break;

            case TUESDAY:
                setFemalename("Abena");
                setMalename("Kwabena");
                break;

            case WEDNESDAY:
                setFemalename("Akua");
                setMalename("Kweku");
                break;

            case THURSDAY:
                setFemalename("Yaa");
                setMalename("Yaw");
                break;

            case FRIDAY:
                setFemalename("Afua");
                setMalename("Kofi");
                break;

            case SATURDAY:
                setFemalename("Ama");
                setMalename("Kwame");
                break;

            case SUNDAY:
                setFemalename("Akosua");
                setMalename("Kwesi");
                break;
        }

    }

    public void getChineseZodiacAnimal(){
        switch(thedate.getYear()%12)
        {
            case 0:
                setTheanimal("Monkey");
                break;
            case 1:
                setTheanimal("Rooster");
                break;
            case 2:
                setTheanimal("Dog");
                break;
            case 3:
                setTheanimal("Pig");
                break;
            case 4:
                setTheanimal("Rat");

                break;
            case 5:
                setTheanimal("Ox");

                break;
            case 6:
                setTheanimal("Tiger");

                break;
            case 7:
                setTheanimal("Rabbit");

                break;
            case 8:
                setTheanimal("Dragon");
                break;
            case 9:
                setTheanimal("Snake");
                break;
            case 10:
                setTheanimal("Horse");
                break;
            case 11:
                setTheanimal("Sheep");
                break;
        }

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getThedate() {
        return thedate;
    }

    public void setThedate(LocalDate thedate) {
        this.thedate = thedate;
    }

    public String getFemalename() {
        return femalename;
    }

    public void setFemalename(String femalename) {
        this.femalename = femalename;
    }

    public String getMalename() {
        return malename;
    }

    public void setMalename(String malename) {
        this.malename = malename;
    }

    public DayOfWeek getTheday() {
        return theday;
    }

    public void setTheday(DayOfWeek theday) {
        this.theday = theday;
    }

    public String getThezodiac() {
        return thezodiac;
    }

    public void setThezodiac(String thezodiac) {
        this.thezodiac = thezodiac;
    }

    public String getTheanimal() {
        return theanimal;
    }

    public void setTheanimal(String theanimal) {
        this.theanimal = theanimal;
    }
}
