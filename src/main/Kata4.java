package main;

import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;


public class Kata4 {
    private static String fileName;
    private static List<Mail> mailList;
    private static Histogram<String> histogram;
    private static HistogramDisplay histoDisplay;
     
    public static void main(String[] args) {
         fileName = "email.txt";
         execute();
     }

     private static void execute() {
         input();
         process();
         output();
         histoDisplay.execute();
     }

     private static void input() {
         mailList = MailListReader.read(fileName);
     }

     private static void process() {
         histogram = MailHistogramBuilder.build(mailList);
     }

     private static void output() {
         histoDisplay = new HistogramDisplay(histogram);
     }
}
