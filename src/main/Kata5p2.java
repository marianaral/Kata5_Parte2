package main;

import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;
import view.MailListReaderDB;


public class Kata5p2 {
    private static List<String> mailList;
    private static Histogram<String> histogram;
    private static HistogramDisplay histoDisplay;
     
    public static void main(String[] args) {
         execute();
     }

     private static void execute() {
         input();
         process();
         output();
         histoDisplay.execute();
     }

     private static void input() {
         mailList = MailListReaderDB.read();
     }

     private static void process() {
         histogram = MailHistogramBuilder.buildString(mailList);
     }

     private static void output() {
         histoDisplay = new HistogramDisplay(histogram);
     }
}
