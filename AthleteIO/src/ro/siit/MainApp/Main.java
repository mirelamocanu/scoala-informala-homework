package ro.siit.MainApp;

import ro.siit.Athlete.Athlete;
import ro.siit.Athlete.AthleteRepository;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        AthleteRepository.readFromFileToList("AthleteResults.csv");

        System.out.println("----------------------------");

        AthleteRepository.calculateTime(AthleteRepository.getAthleteList());


        AthleteRepository.getWinnerAthlete(AthleteRepository.getAthleteList());


    }
}
